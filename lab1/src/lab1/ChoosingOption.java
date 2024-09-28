package lab1;

import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		
		JOptionPane.showMessageDialog(null, "You've chose: " + (option==JOptionPane.YES_NO_OPTION?"YES":"NO"));
	System.exit(0);
	}
}
