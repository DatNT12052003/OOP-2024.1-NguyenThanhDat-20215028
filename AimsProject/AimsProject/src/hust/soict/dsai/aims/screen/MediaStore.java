package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel{
	private static final long serialVersionUID = 1L;
	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			JButton detailButton = new JButton("Details");
			playButton.addActionListener(new playChosenMedia());
			detailButton.addActionListener(new seeMediaDetail());
			container.add(playButton);
			container.add(detailButton);
		}else {
			JButton detailButton = new JButton("Details");
			detailButton.addActionListener(new seeMediaDetail());
			container.add(detailButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class playChosenMedia implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			media.playDialog();
			playMedia(media);
		}
	}
	
	private void playMedia(Media media) {
	    PlayingScreen playingScreen = new PlayingScreen(media);
	    playingScreen.showMedia(); 
	    
	    if (media instanceof DigitalVideoDisc) {
	        DigitalVideoDisc dvd = (DigitalVideoDisc) media;
	        System.out.println("Now playing DVD: " + dvd.getTitle());
	    } else if (media instanceof CompactDisc) {
	        CompactDisc cd = (CompactDisc) media;
	        System.out.println("Now playing CD: " + cd.getTitle());
	    } else {
	        System.out.println("Opening book details: " + media.getTitle());
	    }
	}

	
	private class seeMediaDetail implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent evt) {
	        String mediaDetails = getMediaDetails(media);
	        
	        JOptionPane.showMessageDialog(null, mediaDetails, "Media Details", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	    private String getMediaDetails(Media media) {
	        StringBuilder details = new StringBuilder();
	        
	        details.append("Title: ").append(media.getTitle()).append("\n")
	               .append("Cost: ").append(media.getCost()).append(" $\n");
	        
	        if (media instanceof DigitalVideoDisc) {
	            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
	            details.append("Director: ").append(dvd.getDirector()).append("\n")
	                   .append("Length: ").append(dvd.getLength()).append(" mins\n");
	        } else if (media instanceof CompactDisc) {
	            CompactDisc cd = (CompactDisc) media;
	            details.append("Artist: ").append(cd.getArtist()).append("\n")
	                   .append("Length: ").append(cd.getLength()).append(" mins\n");
	        } else {
	        	Book book = (Book) media;
	            details.append("Authors: ");
	            List<String> authors = book.getAuthors();
	            if (authors != null && !authors.isEmpty()) {
	                details.append(String.join(", ", authors)).append("\n");
	            } else {
	                details.append("Unknown\n");
	            }
	        }
	        
	        return details.toString();
	    }
	}

}
