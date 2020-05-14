package com.vogelsang.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.vogelsang.model.GroceryItem;

@Repository
public interface GroceryItemDao extends JpaRepository<GroceryItem, Integer> {
  

  @Query("select i from GroceryItem i where i.list.listId = ?1")
  public List<GroceryItem> getItemsByListId(int listId);

}
