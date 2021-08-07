package com.example.demo.models;

public class BookSummery {
	
	private String original_title;
	private String original_language;
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public BookSummery(String original_title, String original_language) {
		super();
		this.original_title = original_title;
		this.original_language = original_language;
	}
	
	public BookSummery() {
		
	}
	
}
