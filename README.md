# web_scrapper
Basic web scrapper for bazos.sk

With GET "/home" request app will respond with insertions from bazos web page.  
Endpoint requests parameter with page you want to show.

```java
  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public ResponseEntity<HomeResponseDTO> getHomePage(@RequestParam(name = "page") int page) {

    HomeResponseDTO homeResponseDTO = new HomeResponseDTO();
    homeResponseDTO.addItems(itemService.getItemsFromWeb(page));
    return ResponseEntity.ok().body(homeResponseDTO);
  }
  ```
