package com.vogelsang.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vogelsang.model.GroceryList;
import com.vogelsang.repository.GroceryListDao;

@Service
public class GroceryListService {
  @Autowired
  private GroceryListDao gldao;

  public List<GroceryList> getAllLists() {
    return gldao.findAll();
  }

  public GroceryList getById(int id) {
    return gldao.findById(id).get();
  }

  public GroceryList addList(GroceryList gl) {
    return gldao.save(gl);
  }

  public String delete(GroceryList gl) {
    int id = gl.getListId();
    gldao.delete(gl);
    return "List " + id + " was deleted";
  }

}
