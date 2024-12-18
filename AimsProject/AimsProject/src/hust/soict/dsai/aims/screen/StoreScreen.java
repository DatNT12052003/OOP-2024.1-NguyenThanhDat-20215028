
package hust.soict.dsai.aims.screen;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
public class StoreScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Store store = new Store();
	Container cp = getContentPane();
	
	/**
	 * Create north area
	 */
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	/**
	 * create menuBar
	 */
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem menuItem = new JMenuItem("View store");
		menuItem.addActionListener(new ViewStoreForDetail()); 
		menu.add(menuItem);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		menu.add(smUpdateStore);
		
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddDVDScreen.main(null);
            }
        });
        
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddBookScreen.main(null);
            }
        });
        
        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AddCDScreen.main(null);
            }
        });
        
        smUpdateStore.add(addDVDItem);
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        
        
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	/**
	 * create header
	 */
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		
		return header;
	}
	
	/**
	 * create center area
	 */
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 2, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < store.getStoreQuantity(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}	
		
		return center;
	}
	
	/**
	 * view store menuItem's action
	 */
	private class ViewStoreForDetail implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			getContentPane().removeAll();
			cp.add(createNorth(), BorderLayout.NORTH);
			JScrollPane scrollPane = new JScrollPane(createCenter());
			cp.add(scrollPane);
			cp.add(scrollPane, BorderLayout.CENTER);
			revalidate();
			repaint();
		}
	}
	
	/**
	 * create Screen
	 */
	public StoreScreen(Store store) {
		StoreScreen.store = store;
		
		
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(createCenter());
		cp.add(scrollPane);
		cp.add(scrollPane, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * launch the Screen
	 */
	public static void main(String[] args) {
		databaseInput();
		//store.display();
		new StoreScreen(store);
	}
	
	/**
	 * initialize the database
	 */
	private static void databaseInput() {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
       
		Track track1 = new Track("Mot Con Vit", 3);
		Track track2 = new Track("Be Len Ba", 4);
		Track track3 = new Track("Mashup 2017", 7);
		Track track4 = new Track("Mashup 2024", 10);
		Track track5 = new Track("Em Cua Ngay Hom Qua", 4);
		Track track6 = new Track("Hay Trao Cho Anh", 5);

		//Add CD in Store
		CompactDisc cd1 = new CompactDisc("Nhac Hay 01", "Nhac Tre", "Son Tung MTP", 10.00f);
		cd1.addTrack(track5);
		cd1.addTrack(track6);
		store.addMedia(cd1);
		
		CompactDisc cd2 = new CompactDisc("Nhac Hay 02", "Nhac Thieu Nhi", "Linh tinh", 5.50f);
		cd2.addTrack(track1);
		cd2.addTrack(track2);
		store.addMedia(cd2);
		
		CompactDisc cd3 = new CompactDisc("Nhac Hay 03", "Mashup", "Linh tinh", 12.05f);
		cd3.addTrack(track3);
		cd3.addTrack(track4);
		store.addMedia(cd3);
		
		//Add Book in Store
		String author1 = new String("Nguyen Thanh Dat");
		String author2 = new String("Phan Trung Duc");
		String author3 = new String("Duong Van Gioi");
		
		Book book1 = new Book("Giang Dao 4.0", "Dao Ly", 99.00f);
		book1.addAuthor(author1);
		book1.addAuthor(author3);
		store.addMedia(book1);
		
		Book book2 = new Book("Lien Quan Mobile", "Ky Nang Game", 100.00f);
		book2.addAuthor(author1);
		book2.addAuthor(author2);
		store.addMedia(book2);
		
		Book book3 = new Book("An Lau De", "An Uong", 20.00f);
		book3.addAuthor(author1);
		book3.addAuthor(author2);
		book3.addAuthor(author3);
		store.addMedia(book3);
	}
	
}
