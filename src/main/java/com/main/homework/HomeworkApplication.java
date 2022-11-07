package com.main.homework;

import com.main.homework.models.entities.Item;
import com.main.homework.repositories.ItemRepository;
import com.main.homework.services.ItemService;
import com.main.homework.services.ItemServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class HomeworkApplication implements CommandLineRunner {

  private final ItemService itemService;

  public static void main(String[] args) {
    SpringApplication.run(HomeworkApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

  }
}
