package com.main.homework.repositories;

import com.main.homework.models.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
  Item findItemByTitle(String title);
}
