package com.example.demo.models;

public class Book {
	
	private String bookId;
	private String title;
	private String overview;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public Book(String bookId, String title, String overview) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.overview = overview;
	}
	
	public Book() {
		
	}
	

}
