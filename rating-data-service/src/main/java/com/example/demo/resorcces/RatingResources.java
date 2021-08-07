package com.example.demo.resorcces;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.models.Rating;
import com.example.demo.models.UserRating;


@RestController
@RequestMapping("/ratingdata")
public class RatingResources {
	
	@RequestMapping("/{bookId}")
	public Rating getRating(@PathVariable("bookId") String bookId) {
		return new Rating("b11",4);
		
	}
	

	@RequestMapping("users/{userId}")
	public UserRating getRating1(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(
				new Rating("b12",3),
				new Rating("b34", 02)
				);
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
		
	}
	
}
