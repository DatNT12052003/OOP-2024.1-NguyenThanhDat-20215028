//package hust.soict.dsai.aims;
//
//import java.util.Scanner;
//
//import hust.soict.dsai.aims.cart.Cart;
//import hust.soict.dsai.aims.media.Book;
//import hust.soict.dsai.aims.media.CompactDisc;
//import hust.soict.dsai.aims.media.DigitalVideoDisc;
//import hust.soict.dsai.aims.media.Media;
//import hust.soict.dsai.aims.media.Playable;
//import hust.soict.dsai.aims.media.Track;
//import hust.soict.dsai.aims.store.Store;
//
//public class Aims {
//    public static void main(String[] args) {
//        Store store = new Store();
//        Cart cart = new Cart();
//        Scanner scanner = new Scanner(System.in);
//        //Add DVD in Store
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		store.addMedia(dvd1);
//
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science", "George Lucas", 87, 24.95f);
//		store.addMedia(dvd2);
//
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//		store.addMedia(dvd3);
//       
//		Track track1 = new Track("Mot Con Vit", 3);
//		Track track2 = new Track("Be Len Ba", 4);
//		Track track3 = new Track("Mashup 2017", 7);
//		Track track4 = new Track("Mashup 2024", 10);
//		Track track5 = new Track("Em Cua Ngay Hom Qua", 4);
//		Track track6 = new Track("Hay Trao Cho Anh", 5);
//
//		//Add CD in Store
//		CompactDisc cd1 = new CompactDisc("Nhac Hay 01", "Nhac Tre", "Son Tung MTP", 10.00f);
//		cd1.addTrack(track5);
//		cd1.addTrack(track6);
//		store.addMedia(cd1);
//		
//		CompactDisc cd2 = new CompactDisc("Nhac Hay 02", "Nhac Thieu Nhi", "Linh tinh", 5.50f);
//		cd2.addTrack(track1);
//		cd2.addTrack(track2);
//		store.addMedia(cd2);
//		
//		CompactDisc cd3 = new CompactDisc("Nhac Hay 03", "Mashup", "Linh tinh", 12.05f);
//		cd3.addTrack(track3);
//		cd3.addTrack(track4);
//		store.addMedia(cd3);
//		
//		//Add Book in Store
//		String author1 = new String("Nguyen Thanh Dat");
//		String author2 = new String("Phan Trung Duc");
//		String author3 = new String("Duong Van Gioi");
//		
//		Book book1 = new Book("Giang Dao 4.0", "Dao Ly", 99.00f);
//		book1.addAuthor(author1);
//		book1.addAuthor(author3);
//		store.addMedia(book1);
//		
//		Book book2 = new Book("Lien Quan Mobile", "Ky Nang Game", 100.00f);
//		book2.addAuthor(author1);
//		book2.addAuthor(author2);
//		store.addMedia(book2);
//		
//		Book book3 = new Book("An Lau De", "An Uong", 20.00f);
//		book3.addAuthor(author1);
//		book3.addAuthor(author2);
//		book3.addAuthor(author3);
//		store.addMedia(book3);
//		
//        while (true) {
//            showMenu();
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1: // View store
//                    viewStore(store, cart, scanner);
//                    break;
//                case 2: // Update store
//                    updateStore(store, scanner);
//                    break;
//                case 3: // See current cart
//                    seeCart(cart, scanner);
//                    break;
//                case 0: // Exit
//                    System.out.println("Exiting... Goodbye!");
//                    scanner.close();
//                    return;
//                default:
//                    System.out.println("Invalid choice! Please choose 0-1-2-3.");
//            }
//        }
//    }
//
//    public static void showMenu() {
//        System.out.println("AIMS: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. View store");
//        System.out.println("2. Update store");
//        System.out.println("3. See current cart");
//        System.out.println("0. Exit");
//        System.out.println("--------------------------------");
//        System.out.println("Please choose a number: 0-1-2-3");
//    }
//
//    public static void viewStore(Store store, Cart cart, Scanner scanner) {
//        while (true) {
//            store.display();
//            storeMenu();
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter media title: ");
//                    scanner.nextLine();
//                    String title = scanner.nextLine();
//                    Media media = store.searchStoreByTitle(title);
//                    if (media != null) {
//                        System.out.println(media);
//                        mediaDetailsMenu();
//                        int mediaChoice = scanner.nextInt();
//                        switch (mediaChoice) {
//                            case 1: // Add to cart
//                                cart.addMedia(media);
//                                System.out.println("Media added to cart!");
//                                break;
//                            case 2: // Play media
//                                if (media instanceof Playable) {
//                                    ((Playable) media).play();
//                                } else {
//                                    System.out.println("This media cannot be played!");
//                                }
//                                break;
//                            case 0: // Back
//                                break;
//                            default:
//                                System.out.println("Invalid choice!");
//                        }
//                    } else {
//                        System.out.println("Media not found!");
//                    }
//                    break;
//                case 2: // Add media to cart
//                    System.out.print("Enter media title: ");
//                    scanner.nextLine(); // Consume newline
//                    title = scanner.nextLine();
//                    media = store.searchStoreByTitle(title);
//                    if (media != null) {
//                        cart.addMedia(media);
//                        System.out.println("Media added to cart!");
//                    } else {
//                        System.out.println("Media not found!");
//                    }
//                    break;
//                case 3: // Play a media
//                    System.out.print("Enter media title: ");
//                    scanner.nextLine(); // Consume newline
//                    title = scanner.nextLine();
//                    media = store.searchStoreByTitle(title);
//                    if (media instanceof Playable) {
//                        ((Playable) media).play();
//                    } else {
//                        System.out.println("This media cannot be played!");
//                    }
//                    break;
//                case 4: // See current cart
//                    seeCart(cart, scanner);
//                    break;
//                case 0: // Back
//                    return;
//                default:
//                    System.out.println("Invalid choice! Please choose 0-1-2-3-4.");
//            }
//        }
//    }
//
//    public static void updateStore(Store store, Scanner scanner) {
//        System.out.println("1. Add media");
//        System.out.println("2. Remove media");
//        System.out.println("Chose: ");
//        int choice = scanner.nextInt();
//    	String title;
//    	Media media;
//        scanner.nextLine(); // Consume newline
//        if (choice == 1) {
//            // Logic to add media to store
//            System.out.println("CHOOSE MEDIA");
//            System.out.println("1. DVD");
//            System.out.println("2. CD");
//            System.out.println("3. Book");
//            System.out.println("Chose: ");
//            int addChoice = scanner.nextInt();
//        	if(addChoice == 1) {
//        		DigitalVideoDisc dvd = new DigitalVideoDisc("Naruto", "Manga", "Masashi Kishimoto", 25.95f);
//        		store.addMedia(dvd);
//        		System.out.println("Added: " + dvd.toString());
//        	}else if (addChoice == 2) {
//        		CompactDisc cd = new CompactDisc("Nhac Hay 04", "Nhac Vang", "Dan Nguyen", 10.50f);
//        		Track track1 = new Track("Chuyen Hoa Sim", 5);
//        		Track track2 = new Track("Thoi Doi", 4);
//        		cd.addTrack(track1);
//        		cd.addTrack(track2);
//        		store.addMedia(cd);
//        		System.out.println("Added: " + cd.toString());
//        	}else if (addChoice == 3){
//        		String author = new String("Nguyen Thanh Dat");
//        		
//        		Book book = new Book("Nguyen Ly OOP", "Lap Trinh", 200.00f);
//        		book.addAuthor(author);
//        		store.addMedia(book);
//        		System.out.println("Added: " + book.toString());
//        	}else {
//        		System.out.println("Invalid choice!");
//        	}
//        } else if (choice == 2) {
//            System.out.print("Enter media title: ");
//            scanner.nextLine(); // Consume newline
//            title = scanner.nextLine();
//            media = store.searchStoreByTitle(title);
//            if (media != null) {
//                store.removeMedia(media);
//            }else {
//            	System.out.println("Media not found!");
//            }
//        } else {
//            System.out.println("Invalid choice!");
//        }
//    }
//
//    public static void seeCart(Cart cart, Scanner scanner) {
//        while (true) {
//            cart.display();
//            cartMenu();
//            
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1: // Filter medias
//                    // Logic for filtering
//                	String title;
//                	Media media;
//                	System.out.println("1. Filter by ID");
//                	System.out.println("2. Filter by Title");
//                	System.out.println("Chose: ");
//                	int sortChoice = scanner.nextInt();
//                	if(sortChoice == 1) {
//                		System.out.println("Enter a id:");
//                		int id = scanner.nextInt();
//                		media = cart.searchCartById(id);
//                		if (media != null) {
//                			System.out.println("Found:");
//                			System.out.println(media.toString());
//                		}else {
//                			System.out.println("Not found media by id = " + id);
//                		}
//                	}else if (sortChoice == 2) {
//                        System.out.print("Enter media title: ");
//                        scanner.nextLine(); // Consume newline
//                		title = scanner.nextLine();
//                		media = cart.searchCartByTitle(title);
//                		if (media != null) {
//                			System.out.println("Found:");
//                			System.out.println(media.toString());
//                		}else {
//                			System.out.println("Not found media by title: " + title);
//                		}
//                	}else {
//                		 System.out.println("Invalid choice!");
//                	}
//                    break;
//                case 2: // Sort medias
//                	System.out.println("1. Sort by title -> cost");
//                	System.out.println("2. Sort by cost -> title");
//                	System.out.println("Chose: ");
//                	sortChoice = scanner.nextInt();
//                	if(sortChoice == 1) {
//                		cart.sortByTitleCost();
//                		cart.display();
//                	}else if (sortChoice == 2) {
//                		cart.sortByCostTitle();
//                		cart.display();
//                	}else {
//                		 System.out.println("Invalid choice!");
//                	}
//                    break;
//                case 3: // Remove media
//                    System.out.print("Enter media title: ");
//                    scanner.nextLine(); // Consume newline
//                    title = scanner.nextLine();
//                    media = cart.searchCartByTitle(title);
//                    if (media != null) {
//                        cart.removeMedia(media);
//                        System.out.println("Removed: " + media.toString());
//                    }else {
//                    	System.out.println("Media not found!");
//                    }
//                    break;
//                case 4: // Play a media
//                    System.out.print("Enter media title: ");
//                    scanner.nextLine(); // Consume newline
//                    title = scanner.nextLine();
//                    media = cart.searchCartByTitle(title);
//                    if (media instanceof Playable) {
//                        ((Playable) media).play();
//                    } else {
//                        System.out.println("This media cannot be played!");
//                    }
//                    break;
//                case 5: // Place order
//                    System.out.println("Order placed!");
//                    float totalCost = 0;
//                    for(Media m : cart.getItemsOrdered()) {
//                    	System.out.println(m.toString());
//                    	totalCost += m.getCost();
//                    }
//                    System.out.println("Total Cost: " + totalCost + "$.");
//                    cart.emptyCart();
//                    return;
//                case 0: // Back
//                    return;
//                default:
//                    System.out.println("Invalid choice! Please choose 0-1-2-3-4-5.");
//            }
//        }
//    }
//
//    public static void storeMenu() {
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. See a media’s details");
//        System.out.println("2. Add a media to cart");
//        System.out.println("3. Play a media");
//        System.out.println("4. See current cart");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.println("Please choose a number: 0-1-2-3-4");
//    }
//
//    public static void mediaDetailsMenu() {
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Add to cart");
//        System.out.println("2. Play");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.println("Please choose a number: 0-1-2");
//    }
//
//    
//    
//    public static void cartMenu() {
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Filter medias in cart");
//        System.out.println("2. Sort medias in cart");
//        System.out.println("3. Remove media from cart");
//        System.out.println("4. Play a media");
//        System.out.println("5. Place order");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.println("Please choose a number: 0-1-2-3-4-5");
//    }
//}
