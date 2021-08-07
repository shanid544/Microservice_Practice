package com.example.demo.models;

public class Rating {
	
	private String bookId;
	private int rating;
	
	
	public Rating(String bookId, int rating) {
		super();
		this.bookId = bookId;
		this.rating = rating;
	}
	public Rating() {
		
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	

}
