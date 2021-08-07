package com.example.demo.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.models.Book;
import com.example.demo.models.CatalogItem;
import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResources {

	// from bean in tha main function
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	@RequestMapping("/{userId}")
	public CatalogItem getCatalog(@PathVariable("userId") String userId) {
		Rating rating = restTemplate.getForObject("http://rating-data-service/ratingdata/512",Rating.class);
		Book book =restTemplate.getForObject("http://book-info-service/books/512",Book.class);
		
		//Rating rating = restTemplate.getForObject("http://rating-data-service/ratingdata/foo",Rating.class);
		return new CatalogItem(book.getTitle(), "life", rating.getRating());
		
	}
	
	
	public CatalogItem getFallbackCatalog(@PathVariable("userId") String userId) {
		
		return new CatalogItem("no books", " ", 0);
	}
	
  
}
//things to refer
/* public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

UserRating userRating = restTemplate.getForObject("http://localhost/ratingsdata/user/" + userId, UserRating.class);

return userRating.getUserRating().stream()
        .map(rating -> {
            Book movie = restTemplate.getForObject("http://localhost/books/" + rating.getBookId(), Book.class);
            return new CatalogItem(movie.getName(), "desv", rating.getRating());
        })
        .collect(Collectors.toList());

}*/



/*
 * @RequestMapping("/{userId}") public CatalogItem
 * getCatalog(@PathVariable("userId") String userId){
 * 
 * 
 * UserRating userRating
 * =restTemplate.getForObject("http://localhost:8083/ratingdata/users/foo",
 * UserRating.class);
 * 
 * //if are accepting in the from of List. but it is complicated
 * 
 * List<Rating> ratings =
 * restTemplate.getForObject("http://localhost:8083/ratingdata/users/foo",
 * ParameterizedType<List<Rating>>);
 * 
 * //using resttemplate //here we are using webclientbuilder not instaed of
 * resttemplate.
 * 
 * return (CatalogItem) userRating.getUserRating().stream() .map(rating -> {
 * Book book
 * =restTemplate.getForObject("http://localhost:8082/books/foo",Book.class);
 * return new CatalogItem(book.getName(), "life", rating.getRating());
 * 
 * }) .collect(Collectors.toList()); //why we cant use 2 rest template object
 * ???? //how to get objets from 2 MS into this class,?? //Book
 * book=restTemplate.getForObject("http://localhost:8082/books/foo"
 * ,Book.class);
 * 
 * //using web client we are communicating with othor MS
 * 
 * Rating rating2 =webClientBuilder.build() .get()
 * .uri("http://localhost:8083/ratingdata/foo") .retrieve().bod
 * yToMono(Rating.class).block();
 * 
 * 
 * //return new CatalogItem(book.getName(), "life", rating.getRating());
 * 
 * //return Collections.singletonList( //return new
 * CatalogItem("rich dad poor dad","life",4);
 * 
 * }
 */