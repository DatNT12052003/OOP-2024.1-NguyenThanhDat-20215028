package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private float length;
	
	public Track(String title, float length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || !(obj instanceof Track)) return false; 

	    Track other = (Track) obj;
	    return java.util.Objects.equals(this.title, other.title) && this.length == other.length;
	}

	
	public void play() throws PlayerException{
		if(this.getLength()>0) {
			System.out.println("Playing Track: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}else {
			throw new PlayerException("Error: DVD lenght is non-positive!");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
