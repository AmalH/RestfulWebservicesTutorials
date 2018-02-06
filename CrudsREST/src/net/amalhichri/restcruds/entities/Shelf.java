package net.amalhichri.restcruds.entities;

/**
 * @author Amal
 *
 */
public class Shelf {

	
	private int id;
	private String location;
	private Category category;
	
	public enum Category{History, ScienceFiction,Poetry,Physics;}
	
	public Shelf(){
		super();
	}
	
	public Shelf(int id, String location, Category category) {
		super();
		this.id = id;
		this.location = location;
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
}
