package com.wiji.abstractart;

public abstract class Art {
	private String title, author, description;
	
	
	public Art(String title, String author, String description) {
		this.title = title;
		this.author = author;
		this.description = description;
	}
	
	abstract void viewArt();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
