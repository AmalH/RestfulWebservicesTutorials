package net.amalhichri.restcruds.business;

import java.util.ArrayList;
import java.util.List;

import net.amalhichri.restcruds.entities.Shelf;
import net.amalhichri.restcruds.entities.Shelf.Category;

/**
 * @author Amal
 *
 */
public class ShelfBusiness {

	private List<Shelf> shelfs;

	
	public ShelfBusiness() {
		shelfs=new ArrayList<Shelf>();
		shelfs.add(new Shelf(1,"Library3 Room1",Category.History));
		shelfs.add(new Shelf(2,"Library2 Room1",Category.Poetry));
		shelfs.add(new Shelf(3,"Library1 Romm3",Category.Physics));
		shelfs.add(new Shelf(4,"Library1 Romm2",Category.ScienceFiction));
	}

	public List<Shelf> getshelfs() {
		return shelfs;
	}

	public void setshelfs(List<Shelf> shelfs) {
		this.shelfs = shelfs;
	}
	
	public Shelf getShelfById(int id){
		
		for (Shelf s:shelfs){
			if(s.getId()==id)
				return s;
		}
		return null;
	}
	
	
	public List<Shelf> getShelfByType(Category category){
		List<Shelf> list=new ArrayList<Shelf>();
		for (Shelf c:shelfs){
			if(c.getCategory().equals(category))
				list.add(c);
		}
		return list;
	}
	
}
