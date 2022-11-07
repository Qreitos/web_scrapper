package com.main.homework.controllers;

import com.main.homework.models.DTOs.HomeResponseDTO;
import com.main.homework.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {

  private final ItemService itemService;

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ResponseEntity<HomeResponseDTO> getHomePage(@RequestParam(name = "page") int page) {

    HomeResponseDTO homeResponseDTO = new HomeResponseDTO();
    homeResponseDTO.addItems(itemService.getItemsFromWeb(page));
    return ResponseEntity.ok().body(homeResponseDTO);
  }
}
