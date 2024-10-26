package aims_project;

public class DigitalVideoDisc {
	private String titile;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public String getTitile() {
		return titile;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public DigitalVideoDisc(String titile) {
		super();
		this.titile = titile;
	}
	
	public DigitalVideoDisc(String titile, String category, float cost) {
		super();
		this.titile = titile;
		this.category = category;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String titile, String category, String director, float cost) {
		super();
		this.titile = titile;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String titile, String category, String director, int length, float cost) {
		super();
		this.titile = titile;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
}
