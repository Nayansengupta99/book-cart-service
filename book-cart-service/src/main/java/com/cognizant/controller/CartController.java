package com.cognizant.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.feignclient.BookFeignClient;
import com.cognizant.model.BookModel;
import com.cognizant.model.CartModel;
import com.cognizant.repository.CartRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("user")
public class CartController {

    @Autowired
	private BookFeignClient bookClient;
    
    @Autowired
    private CartRepository cartRepo;
    
    
    @GetMapping("/books")
    public List getBookDeatils() {
    	return bookClient.getBookDetails();
    }
    
    @PostMapping("/cart/{userid}/{bookid}")
    public void addToCart(@PathVariable("userid") Long userId,@PathVariable("bookid") Long bookId) {
    	
    	
    	cartRepo.insertCartItems(userId, bookId);
    	
  }
    @GetMapping("/cart/{userId}")
    public List<BookModel> viewCartItems(@PathVariable("userId") Long userid,CartModel cart) throws JsonProcessingException {
    	
        List<BookModel> bookItems=bookClient.getBookDetails();
    	List<BookModel> cartItems=new ArrayList<BookModel>();
        
        for(BookModel i:bookItems) {
        	if (cartRepo.findById(userid).getBookId()==i.getId()){
        		
        	cartItems.add(i);
        	
        	}
        
        }
       return cartItems;
    
    
    }
    




}
