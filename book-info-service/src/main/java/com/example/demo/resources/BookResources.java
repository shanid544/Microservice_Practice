package com.example.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Book;
import com.example.demo.models.BookSummery;



@RestController
@RequestMapping("/books")
public class BookResources {
	
	@Value("$(api.key)")
	private String apiKey;
	
	@Autowired
	private RestTemplate restTemplate; 
	
	@RequestMapping("/{bookId}")
	public Book getBookInfo(@PathVariable("bookId") String bookId) {
		
		BookSummery bookSummery =restTemplate.getForObject(
			"https://api.themoviedb.org/3/movie/550?api_key=32ca1ca844c3e9d35b0bb255f116b5f9",
			BookSummery.class); 
		
		return new Book(bookId,bookSummery.getOriginal_title(),bookSummery.getOriginal_language());
		
	}
	

}
