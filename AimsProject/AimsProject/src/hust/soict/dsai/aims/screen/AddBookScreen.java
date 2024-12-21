package hust.soict.dsai.aims.screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddBookScreen extends AddItemToStoreScreen {

	private static final long serialVersionUID = 1L;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookScreen frame = new AddBookScreen();
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
	public AddBookScreen() {
		
		JLabel dvdDirector = new JLabel("Authors");
		dvdDirector.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdDirector.setBounds(31, 227, 174, 40);
		getContentPane().add(dvdDirector);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(255, 227, 357, 40);
		getContentPane().add(textField_4);
		
		getResetButton().addActionListener(new ResetAllItemAddFormActionListener());
		getAddButton().addActionListener(new AddNewItemToStoreActionListener());

		JLabel lblNewLabel = new JLabel("Example: author1,author2,...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 265, 254, 13);
		getContentPane().add(lblNewLabel);
	}
	
	/**
	 * RESET BUTTON's Action
	 */
	private class ResetAllItemAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			getTextField_1().setText("");
			getTextField_2().setText("");
			getTextField_3().setText("");
			textField_4.setText("");
			
			getAddButton().setEnabled(true);
		}
	}
	
	/**
	 * ADD BUTTON's Action
	 */
	private class AddNewItemToStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			
			String tempTitle = getTextField_1().getText();
			
			String tempCategory = getTextField_2().getText();
			
			String tempStringCost = getTextField_3().getText();
			
			float tempCost = Float.parseFloat(tempStringCost);
			String tempDirector = textField_4.getText();
			
			System.out.println("Danh sách tác giả trong ArrayList:");
			List<String> authorList = splitAuthors(tempDirector);;
			Book newBookToStore = new Book(tempTitle, tempCategory, tempCost, authorList);
			StoreScreen.store.addMedia(newBookToStore);
			StoreScreen.store.display();
			
			getAddButton().setEnabled(false);
		}
	}
	
	/**
	 * get authors's name algorithm
	 */
	private static ArrayList<String> splitAuthors(String authorsInput) {
        ArrayList<String> authorsList = new ArrayList<>();
        
        if (authorsInput != null && !authorsInput.isEmpty()) {
            String[] authorsArray = authorsInput.split(",");
            
            for (String author : authorsArray) {
                authorsList.add(author.trim());
            }
        }
        return authorsList;
    }
}
