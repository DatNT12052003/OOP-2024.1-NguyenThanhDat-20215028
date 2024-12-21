package hust.soict.dsai.aims.screen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddItemToStoreScreen extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton addButton;
	private JButton resetButton;
	private JButton cancelButton;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemToStoreScreen frame = new AddItemToStoreScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AddItemToStoreScreen() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Add Media");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dvdTitle = new JLabel("Title");
		dvdTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdTitle.setBounds(31, 77, 174, 40);
		contentPane.add(dvdTitle);
		
		JLabel dvdCategory = new JLabel("Category");
		dvdCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdCategory.setBounds(31, 127, 174, 40);
		contentPane.add(dvdCategory);
		
		JLabel dvdCost = new JLabel("Cost");
		dvdCost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdCost.setBounds(31, 177, 174, 40);
		contentPane.add(dvdCost);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 77, 357, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 127, 357, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 177, 357, 40);
		contentPane.add(textField_3);
		
		resetButton = new JButton("RESET");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resetButton.addActionListener(new ResetAllItemAddFormActionListener());
		resetButton.setBounds(31, 352, 143, 41);
		contentPane.add(resetButton);
		
		addButton = new JButton("ADD");
		addButton.addActionListener(new AddNewItemToStoreActionListener());
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBounds(255, 352, 143, 41);
		contentPane.add(addButton);
		
		cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBounds(469, 352, 143, 41);
		contentPane.add(cancelButton);	
	}
	
	private class ResetAllItemAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
		}
	}
	
	private class AddNewItemToStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
		}
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public void setResetButton(JButton resetButton) {
		this.resetButton = resetButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}	
}
