package app;

import product.Fruit;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.Scanner;


public class OrderApp {

    public void start(){

        ProductRepository productRepository = new ProductRepository();
        ArrayList<Fruit> products = productRepository.getFruits();
        Menu menu = new Menu(products);
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart(productRepository, menu);

        System.out.println(" 🍽️ fruit basket 🍽️ ");

        Order order = new Order(cart);


        while (true) {
            menu.printMenu();
            String input = scanner.nextLine();

            if (input.equals("+")){
                order.makeorder();
                break;
            }

            else {
                int menuNumber = Integer.parseInt(input);

                if (menuNumber == 0) cart.printCart();
                else if (1 <= menuNumber && menuNumber <= productRepository.getFruits().size()) {
                    cart.addToCart(menuNumber);
                }
            }
        }
    };
}
