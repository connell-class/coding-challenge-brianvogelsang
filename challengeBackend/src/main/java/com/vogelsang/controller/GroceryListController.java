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
import com.vogelsang.model.GroceryList;
import com.vogelsang.service.GroceryListService;

@RestController
@RequestMapping("/grocery-lists")
@CrossOrigin
public class GroceryListController {
  @Autowired
  private GroceryListService ls;

  @GetMapping
  public List<GroceryList> getAllLists() {
    return ls.getAllLists();
  }

  @GetMapping("/{id}")
  public GroceryList getListById(@PathVariable("id") int id) {
    return ls.getById(id);
  }

  @PostMapping
  public GroceryList addList(@RequestBody GroceryList gl) {
    return ls.addList(gl);
  }

  @DeleteMapping
  public String deleteList(@RequestBody GroceryList gl) {
    return ls.delete(gl);
  }

  @DeleteMapping("/{id}")
  public String deleteListWithParam(@PathVariable("id") int id) {
    return ls.delete(ls.getById(id));
  }

}
