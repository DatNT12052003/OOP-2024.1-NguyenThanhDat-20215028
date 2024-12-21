package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayingScreen extends JFrame {
    private Media media;
    private Timer timer;
    private int progress = 0;
    private float mediaDuration; 

    public PlayingScreen(Media media) {
        this.media = media;

        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            this.mediaDuration = dvd.getLength(); 
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            this.mediaDuration = cd.getLength(); 
        } else {
            this.mediaDuration = 100; 
        }

        setTitle("Now Playing: " + media.getTitle());
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Now Playing: " + media.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel statusLabel = new JLabel("Playing...");
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        statusLabel.setForeground(Color.RED);
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JProgressBar progressBar = new JProgressBar(0, (int) mediaDuration);
        progressBar.setValue(0);
        progressBar.setStringPainted(true); 
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopMedia();
            }
        });
        stopButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20));
        panel.add(titleLabel);
        panel.add(statusLabel);
        panel.add(progressBar);
        panel.add(Box.createVerticalStrut(20));
        panel.add(stopButton);

        add(panel);
        setVisible(true);

        startMediaTimer(progressBar);
    }

    private void startMediaTimer(JProgressBar progressBar) {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 
                progress++;

                progressBar.setValue(progress);

                if (progress >= mediaDuration) {
                    stopMedia();
                }
            }
        });
        timer.start(); 
    }

    private void stopMedia() {
        if (timer != null) {
            timer.stop(); 
        }
        dispose();
    }

    public void showMedia() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
