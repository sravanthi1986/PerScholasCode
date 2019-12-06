package com.perscholas.bean;

import java.time.LocalDateTime;
import java.util.Date;

public class Book {
	private Integer bookId;
	private String title;
	private String synopsis;
	private String author;
	private LocalDateTime publicationDate;
	private Integer memberId;
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public  LocalDateTime getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDateTime publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

}
