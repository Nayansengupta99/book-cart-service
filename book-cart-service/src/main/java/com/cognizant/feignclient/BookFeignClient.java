package com.cognizant.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.BookModel;

@FeignClient(name="book-api-service")
public interface BookFeignClient {

	@GetMapping("api/books/detail")
	public List<BookModel> getBookDetails();
	
	@GetMapping("api/books/{id}")
	public BookModel findByBookId(@PathVariable Long id);
	
	









}
