package com.main.homework.services;

import com.main.homework.models.entities.Item;
import com.main.homework.repositories.ItemRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

  private final ItemRepository itemRepository;

  @Override
  public List<Item> getItems() {
    return itemRepository.findAll();
  }

  @Override
  public void saveItem(Item item) {
    itemRepository.save(item);
  }

  @Override
  public List<Item> getItemsFromWeb(int page) {

    final String url;

    if (page == 1) {
      url = "https://pc.bazos.sk/";
    } else {
      int number = page * 20 - 20;
      url = "https://pc.bazos.sk/" + number + "/";
    }

    Set<String> titles = new LinkedHashSet<>();
    Set<String> descriptions = new LinkedHashSet<>();
    List<String> prices = new ArrayList<>();

    try {
      final Document document = Jsoup.connect(url).get();

      for (Element row : document.select("div.maincontent div")) {

        if (row.select(".nadpis").text().equals("")) {
          continue;
        }
        titles.add(row.select(".nadpis").text());

        if (row.select(".popis").text().equals("")) {
          continue;
        }
        descriptions.add(row.select(".popis").text());

        if (row.select(".inzeratycena").text().equals("")) {
          continue;
        }
        prices.add(row.select(".inzeratycena").text());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    List<String> titlesList = titles.stream().toList();
    List<String> descriptionsList = descriptions.stream().toList();

    List<Item> returnList = new ArrayList<>();

    for (int i = 0; i < titlesList.size() - 1; i++) {
      Item item = new Item();
      item.setTitle(titlesList.get(i));
      item.setDescription(descriptionsList.get(i));
      item.setPrice(prices.get(i));
      if (itemRepository.findItemByTitle(item.getTitle()) == null) {
        itemRepository.save(item);
      }
      item.setItemId(itemRepository.findItemByTitle(item.getTitle()).getItemId());
      returnList.add(item);
    }
    return returnList;
  }
}
