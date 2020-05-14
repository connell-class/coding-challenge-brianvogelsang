package com.vogelsang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vogelsang.model.GroceryList;

@Repository
public interface GroceryListDao extends JpaRepository<GroceryList, Integer> {

}
