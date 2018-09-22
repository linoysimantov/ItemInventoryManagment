package com.linoy.inventoryWebApp.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.linoy.inventoryWebApp.dao.ItemRepository;
import com.linoy.inventoryWebApp.exception.ItemException;
import com.linoy.inventoryWebApp.model.Item;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="ItemControllerApi", produces= MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController 
	{

	
		
		@Autowired
		ItemRepository itemRepo;
		  
		@GetMapping("/items")
		@ApiOperation("Get All the items in the stock")
		@ApiResponses(value= {@ApiResponse(code=200, message="OK", response= Item.class)})
		@ResponseBody
		public List<Item> getAllItems() {
			return itemRepo.findAll();
		}
		
		@GetMapping("/items/{id}/details")
		@ApiOperation("Get the details of specific item")
		@ApiResponses(value= {@ApiResponse(code=200, message="OK", response= Item.class)})
		@ResponseBody
		public Item retrieveItem(@PathVariable long id) throws ItemException {
			Optional<Item> item = itemRepo.findById(id);

			if (!item.isPresent())
				throw new ItemException("There is no item Id " + id);

			return item.get();
		}
		
		@DeleteMapping("/items/{id}")
		@ApiOperation("Delete spesific item from stock")
		@ApiResponses(value= {@ApiResponse(code=200, message="OK", response= Item.class)})
		
		public  ResponseEntity<Object> deleteItem(@PathVariable long id) {
			Optional<Item> item = itemRepo.findById(id);
			if(item != null) {
			itemRepo.deleteById(id);
			}
			return ResponseEntity.noContent().build();

		}
		
		@PostMapping("/items")
		@ApiOperation("Add new item to the stock")
		@ApiResponses(value= {@ApiResponse(code=200, message="OK", response= Item.class)})
		
		@ResponseBody
		public ResponseEntity<Object> createItem(@RequestBody Item item) {
			Item savedItem = itemRepo.save(item);
			
			java.net.URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(savedItem.getId()).toUri();

			return ResponseEntity.created(location).build();

		}
		
		
		@PutMapping("/items/{id}/deposit/{depositNum}")
		@ApiOperation("Deposit quantity of a specific item from the stock")
		@ApiResponses(value= {@ApiResponse(code=200, message="OK", response= Item.class)})
		public ResponseEntity<Object> DepositItem( @PathVariable String depositNum, @PathVariable long id) {
			 int deposit = Integer.parseInt(depositNum);

			Optional<Item> itemOptional = itemRepo.findById(id);
			
			if(itemOptional.isPresent() ) {
			Item item = itemOptional.get();
			item.setId(id);
			int newAmount = item.getAmount() + deposit;
			item.setAmount(newAmount);
			itemRepo.save(item);
			
			return ResponseEntity.noContent().build();
			}
			else {
				
				return ResponseEntity.notFound().build();
			}		
		}


		
		@PutMapping("/items/{id}/withdrawal/{withdrawalNum}")
		@ApiOperation("Withdrawal quantity of a specific item to the stock")
		@ApiResponses(value= {@ApiResponse(code=200, message="OK", response= Item.class)})
		
		public ResponseEntity<Object> WithdrawalItem( @PathVariable String withdrawalNum, @PathVariable long id) {
			 int withdrawal = Integer.parseInt(withdrawalNum);

			Optional<Item> itemOptional = itemRepo.findById(id);
			
			if(itemOptional.isPresent() ) {
			Item item = itemOptional.get();
			item.setId(id);
			int newAmount = item.getAmount() - withdrawal;
			item.setAmount(newAmount);
			itemRepo.save(item);
			
			return ResponseEntity.noContent().build();
			}
			else {
				
				return ResponseEntity.notFound().build();
			}		
		}
}
