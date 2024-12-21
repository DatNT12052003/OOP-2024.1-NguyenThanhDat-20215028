package hust.soict.dsai.aims.cart;

public class CartSingleton {
    private static Cart cartInstance;

    private CartSingleton() {}

    public static Cart getCart() {
        if (cartInstance == null) {
            cartInstance = new Cart(); 
        }
        return cartInstance;
    }

    public static void resetCart() {
        cartInstance = null;
    }
}
