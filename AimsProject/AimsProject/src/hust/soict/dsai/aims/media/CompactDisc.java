package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

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
	
	public CompactDisc(String title, String category, float cost, String artist, List<Track> tracks) {
		super(title, category, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track)) {
			tracks.add(track);
		}
	}
	
	public void removeTrack(Track track) {
		tracks.remove(track);
	}
	
	public float getLength() {
	    float totalLength = 0.0f;

	    if (tracks != null) {
	        for (Track track : tracks) {
	            if (track != null) {
	                totalLength += track.getLength();
	            }
	        }
	    }

	    return totalLength;
	}

	public void play() throws PlayerException {
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
	
	
	
	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
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

	    return this.getId() + ". CD - " + this.getTitle() + " - " + this.getCategory() +
	           " - " + listTrack + " : " + this.getCost() + "$.";
	}
}
