package com.vogelsang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "item")
public class GroceryItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_id")
  private int itemId;

  @OneToOne
  @JoinColumn(name = "item_list", referencedColumnName = "list_id", nullable = false)
  private GroceryList list;

  @Column(name = "item_name")
  @Size(max = 64, message = "Max 64 characters")
  private String itemName;

  @Column(name = "item_type")
  @Size(max = 64, message = "Max 64 characters")
  private String itemType;

  public GroceryItem() {
    super();
    // TODO Auto-generated constructor stub
  }

  public GroceryItem(int itemId, GroceryList list, String itemName, String itemType) {
    super();
    this.itemId = itemId;
    this.list = list;
    this.itemName = itemName;
    this.itemType = itemType;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public GroceryList getList() {
    return list;
  }

  public void setList(GroceryList list) {
    this.list = list;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public String getItemType() {
    return itemType;
  }

  public void setItemType(String itemType) {
    this.itemType = itemType;
  }

  @Override
  public String toString() {
    return "GroceryItem [itemId=" + itemId + ", list=" + list + ", itemName=" + itemName
        + ", itemType=" + itemType + "]";
  }



}
