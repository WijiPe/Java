package com.wiji.abstractart;

public class Painting extends Art {
	
	private String paintType;
	
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}
	
	void viewArt() {
		System.out.printf("%s %s %s %s\n", this.getAuthor(),this.getDescription(), this.getTitle(), this.paintType);

	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	

}
