package com.vogelsang.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vogelsang.model.GroceryItem;
import com.vogelsang.repository.GroceryItemDao;

@Service
public class GroceryItemService {
  @Autowired
  private GroceryItemDao gidao;

  public List<GroceryItem> findAllItems() {
    return gidao.findAll();
  }

  public GroceryItem addItem(GroceryItem gi) {
    return gidao.save(gi);
  }
  
  public List<GroceryItem> findByListId(int id){
    return gidao.getItemsByListId(id);
  }

  public String deleteById(int id) {
    gidao.deleteById(id);
    return "Item " + id + " was deleted";
  }

}
