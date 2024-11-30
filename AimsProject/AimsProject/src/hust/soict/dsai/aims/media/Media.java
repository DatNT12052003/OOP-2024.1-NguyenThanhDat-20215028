package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	public static final Comparator<Media> COMPARATOR_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARATOR_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;
	static int count = 0;

	public Media() {
		
	}

	public Media(String title) {
		count++;
		this.id = count;
		this.title = title;
	}

	public Media(String title, String category) {
		count++;
		this.id = count;
		this.title = title;
		this.category = category;
	}


	public Media(String title, String category, float cost) {
		count++;
		this.id = count;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || !(obj instanceof Media)) return false; 

	    Media other = (Media) obj;
	    return java.util.Objects.equals(this.title, other.title);
	}

	
	public String toString() {
        return this.getId() +". DVD - " + this.getTitle() + " - " + this.getCategory() + " : " + this.getCost() + "$.";
    }	
}
