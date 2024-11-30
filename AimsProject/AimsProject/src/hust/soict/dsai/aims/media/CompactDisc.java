package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String artist) {
		super(title);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist) {
		super(title, category);
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		tracks.remove(track);
	}
	
	public int getLength() {
	    int totalLength = 0;

	    if (tracks != null) {
	        for (Track track : tracks) {
	            if (track != null) {
	                totalLength += track.getLength();
	            }
	        }
	    }

	    return totalLength;
	}

	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		System.out.println("----------------------------------------------");
		for (Track track : tracks) {
			track.play();
		}
	}

	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	@Override
	public String toString() {
	    StringBuilder listTrack = new StringBuilder();
	    for (Track s : tracks) {
	        listTrack.append(s.getTitle()).append(", ");
	    }

	    if (listTrack.length() >= 2) {
	    	listTrack.setLength(listTrack.length() - 2);
	    }

	    return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() +
	           " - " + listTrack + " : " + this.getCost() + "$.";
	}
}
