package com.main.homework.services;

import com.main.homework.models.entities.Item;
import java.util.List;

public interface ItemService {

  List<Item> getItems();
  void saveItem(Item item);
  List<Item> getItemsFromWeb(int page);
}
