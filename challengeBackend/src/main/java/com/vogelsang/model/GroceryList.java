package com.vogelsang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "list")
public class GroceryList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "list_id")
  private int listId;
  @Column(name = "list_name")
  @Size(max = 64, message = "Max 64 characters")
  private String listName;

  public GroceryList() {
    super();
    // TODO Auto-generated constructor stub
  }

  public GroceryList(int listId, String listName) {
    super();
    this.listId = listId;
    this.listName = listName;
  }

  public int getListId() {
    return listId;
  }

  public void setListId(int listId) {
    this.listId = listId;
  }

  public String getListName() {
    return listName;
  }

  public void setListName(String listName) {
    this.listName = listName;
  }

  @Override
  public String toString() {
    return "GroceryList [listId=" + listId + ", listName=" + listName + "]";
  }



}
