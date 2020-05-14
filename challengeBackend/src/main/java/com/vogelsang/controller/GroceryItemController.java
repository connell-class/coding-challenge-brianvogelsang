package com.vogelsang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vogelsang.model.GroceryItem;
import com.vogelsang.model.GroceryList;
import com.vogelsang.service.GroceryItemService;
import com.vogelsang.service.GroceryListService;

@RestController
@RequestMapping("/grocery-lists/items")
@CrossOrigin
public class GroceryItemController {
  @Autowired
  private GroceryItemService gs;
  @Autowired
  private GroceryListService ls;

  @GetMapping
  public List<GroceryItem> getAllItems() {
    return gs.findAllItems();
  }

  @GetMapping("/lists/{id}")
  public List<GroceryItem> getAllItemsByListId(@PathVariable("id") int id) {
    return gs.findByListId(id);
  }

  @PostMapping
  public GroceryItem addItem(@RequestBody GroceryItem gi) {
    GroceryList mylist = ls.getById(gi.getList().getListId());
    gi.setList(mylist);
    System.out.println(gi);
    return gs.addItem(gi);
  }
  
  @PostMapping("/{id}")
  public GroceryItem addItemWithInt(@RequestBody GroceryItem gi, @PathVariable("id") int id) {
    GroceryList mylist = ls.getById(id);
    gi.setList(mylist);
    gi.setItemId(0);
    System.out.println(gi);
    return gs.addItem(gi);
  }
  @DeleteMapping("/{id}")
  public String deleteItemById(@PathVariable("id") int id) {
    return gs.deleteById(id);
  }
}
