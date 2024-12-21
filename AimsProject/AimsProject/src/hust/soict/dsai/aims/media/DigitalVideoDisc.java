package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc() {
		super();
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public void play() throws PlayerException{
		if(this.getLength()>0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("Error: DVD lenght is non-positive!");
		}
	}
	
	public String toString() {
        return this.getId() +". DVD - " + this.getTitle() + " - " + this.getCategory() +" - " 
				+ this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + "$.";
    }
}
