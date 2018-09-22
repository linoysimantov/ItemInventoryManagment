package com.linoy.inventoryWebApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.linoy.inventoryWebApp.model.Item;

@CrossOrigin(origins = "http://localhost:4200")
public interface ItemRepository extends JpaRepository<Item, Long>{

}
