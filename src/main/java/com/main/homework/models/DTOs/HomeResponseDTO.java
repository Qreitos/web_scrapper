package com.main.homework.models.DTOs;

import com.main.homework.models.entities.Item;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HomeResponseDTO {

  private List<Item> items = new ArrayList<>();

  public void addItems(List<Item> itemList) {
    for (Item item: itemList) {
      items.add(item);
    }
  }
}
