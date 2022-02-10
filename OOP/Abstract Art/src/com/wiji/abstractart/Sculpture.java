package com.wiji.abstractart;

public class Sculpture extends Art {
	
	private String material;
	
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;

	}
	
	@Override
	void viewArt() {
		System.out.printf("%s %s %s %s \n", this.getAuthor(),this.getDescription(), this.getTitle(), this.material );

	}



	public String getMaterial() {
		return material;
	}



	public void setMaterial(String material) {
		this.material = material;
	}

}
