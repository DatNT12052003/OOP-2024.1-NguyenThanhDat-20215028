package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.text.DecimalFormat;

public class CartScreen extends JFrame {
    private static final long serialVersionUID = 1L;
    private Cart cart;
    private Container cp;
    private static Store store;

    public CartScreen(Cart cart) {
        this.cart = cart;
        cp = getContentPane();
        
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(createCenter());
        cp.add(scrollPane, BorderLayout.CENTER);
        
        // Add the total price label and order button to the south area
        cp.add(createBottomPanel(), BorderLayout.SOUTH);

        setTitle("Cart");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Add total price label and order button next to each other
        bottomPanel.add(createTotalPriceLabel());
        bottomPanel.add(createOrderButton());

        return bottomPanel;
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        return north;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS - Cart");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        JButton backButton = new JButton("Back to Store");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store); // Switch to StoreScreen
                dispose(); // Close CartScreen
            }
        });
        header.add(backButton);

        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel();
        int itemsInCart = cart.getItemsOrdered().size();
        
        // Set up the layout with 3 columns (you can adjust the number of columns as needed)
        int columns = 3;
        int rows = (int) Math.ceil((double) itemsInCart / columns); // Automatically adjust the rows based on the number of media items
        center.setLayout(new GridLayout(rows, columns, 5, 5)); // 5px horizontal and vertical gaps

        for (Media media : cart.getItemsOrdered()) {
            MediaStore mediaCell = new MediaStore(media);

            // "Remove from Cart" button
            JButton removeButton = new JButton("Remove from Cart");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cart.removeMedia(media); // Remove media from cart
                    updateCenter(); // Update the cart UI
                }
            });

            // Create JPanel to hold both the media and the button
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout()); // Use BorderLayout to hold media and button

            // Add media cell to the center of the panel
            panel.add(mediaCell, BorderLayout.CENTER);
            
            // Add remove button to the bottom of the panel
            panel.add(removeButton, BorderLayout.SOUTH);

            // Add panel to the center layout (which is using GridLayout)
            center.add(panel);
        }

        return center;
    }


    private JPanel createTotalPriceLabel() {
        JPanel pricePanel = new JPanel();
        JLabel totalPriceLabel = new JLabel("Total: $" + formatTotalPrice(cart.totalCost()));
        totalPriceLabel.setFont(new Font(totalPriceLabel.getFont().getName(), Font.PLAIN, 20));
        pricePanel.add(totalPriceLabel);
        return pricePanel;
    }

    private JPanel createOrderButton() {
        JPanel orderPanel = new JPanel();
        JButton orderButton = new JButton("Order");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the cart is empty
                if (cart.getItemsOrdered().isEmpty()) {
                    // Show error message if the cart is empty
                    JOptionPane.showMessageDialog(CartScreen.this, 
                        "Your cart is empty. Please add items before placing an order.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Show success message if the cart is not empty
                    JOptionPane.showMessageDialog(CartScreen.this, 
                        "Order placed successfully!", 
                        "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear the cart and reset the total cost to 0
                    cart.getItemsOrdered().clear();

                    // After clearing the cart, update the total price to 0 and refresh the screen
                    updateCenter();
                }
            }
        });
        orderPanel.add(orderButton);
        return orderPanel;
    }


    private String formatTotalPrice(float totalPrice) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(totalPrice);
    }

    private void updateCenter() {
        getContentPane().removeAll();
        cp.add(createNorth(), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(createCenter());
        cp.add(scrollPane, BorderLayout.CENTER);
        cp.add(createBottomPanel(), BorderLayout.SOUTH); // Ensure total price and order button are updated
        revalidate();
        repaint();
    }

    public static Store getStore() {
        return store;
    }

    public static void setStore(Store store) {
        CartScreen.store = store;
    }
}
