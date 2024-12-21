package hust.soict.dsai.aims.screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

import javax.swing.JButton;

public class AddCDScreen extends AddItemToStoreScreen {

	private static final long serialVersionUID = 1L;
	private JTextField textField_4;
	private JTable table;
	private int rowCount=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCDScreen frame = new AddCDScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCDScreen() {
		setSize(670,590);
		getCancelButton().setLocation(31, 477);
		getAddButton().setLocation(31, 426);
		getResetButton().setLocation(31, 375);

		JLabel artistLabel = new JLabel("Artist");
		artistLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		artistLabel.setBounds(31, 223, 174, 40);
		getContentPane().add(artistLabel);
		
		JLabel trackLabel = new JLabel("Track");
		trackLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trackLabel.setBounds(31, 273, 174, 40);
		getContentPane().add(trackLabel);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(255, 223, 357, 40);
		getContentPane().add(textField_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Length"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(255, 273, 357, 245);
		getContentPane().add(scrollPane);
		

		getResetButton().addActionListener(new ResetAllItemAddFormActionListener());
		getAddButton().addActionListener(new AddNewItemToStoreActionListener());
		
		JButton addRowButton = new JButton("ADD ROW");
		addRowButton.addActionListener(new addARowForInput());
		addRowButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addRowButton.setBounds(31, 331, 143, 34);
		getContentPane().add(addRowButton);
		
		JLabel lblNewLabel = new JLabel("Please add a row first!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 308, 174, 13);
		getContentPane().add(lblNewLabel);

	}
	
	/**
	 * ADD ROW BUTTON's action
	 */
	private class addARowForInput implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(new Object[] {null,null});
			rowCount++;
		}
	}
	
	/**
	 * RESET BUTTON's action
	 */
	private class ResetAllItemAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			getTextField_1().setText("");
			getTextField_2().setText("");
			getTextField_3().setText("");
			textField_4.setText("");
			
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();

			for( int i = 0 ; i < rowCount ; i++ ) {				
				model_table.setValueAt("",i,0 );
				model_table.setValueAt("",i,1 );
			}
			
			
			for( int i = 0 ; i < rowCount ; i++ ) {			
				model_table.removeRow(0);
			}
			
			rowCount=0;
			getAddButton().setEnabled(true);
		}
	}
	
	/**
	 * ADD BUTTON's action
	 */
	private class AddNewItemToStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String tempTitle = getTextField_1().getText();
			String tempCategory = getTextField_2().getText();
			String tempStringCost = getTextField_3().getText();
			float tempCost = Float.parseFloat(tempStringCost);
			String tempArtist = textField_4.getText();
			
			List<Track> tempTrackList = new ArrayList<Track>();
			for( int i = 0 ; i < rowCount; i++ ) {				
				String tempTrackTitle = table.getValueAt(i, 0)+"";
				String tempStringTrackLength   = table.getValueAt(i, 1)+"";
				int tempLength = Integer.parseInt(tempStringTrackLength);
				tempTrackList.add(new Track(tempTrackTitle, tempLength));
			}

			System.out.println(tempTrackList);
			CompactDisc newCDToStore = new CompactDisc(tempTitle, tempCategory, tempCost, tempArtist, tempTrackList);
			StoreScreen.store.addMedia(newCDToStore);
			StoreScreen.store.display();
			
			getAddButton().setEnabled(false);
		}
	}
}
