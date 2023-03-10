package app;

import product.Apple;
import product.Fruit;
import product.Grape;
import product.Mango;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Cart {

    private Scanner scanner = new Scanner(System.in);

    private ArrayList<Fruit> items = new ArrayList<>();
    Iterator<Fruit> iterator = items.iterator();

    private ProductRepository productRepository;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private Menu menu;

    public Cart(ProductRepository productRepository, Menu menu) {
        this.productRepository = productRepository;
        this.menu = menu;
    }

    public void addToCart(int productId) {

        Fruit fruit = productRepository.findbyId(productId);
        items.add(fruit);

        System.out.printf("[๐ฃ] %s๋ฅผ(์) ์ฅ๋ฐ๊ตฌ๋์ ๋ด์์ต๋๋ค.\n", fruit.getName());

    }

    public void printCart(){
        System.out.println("๐งบ ์ฅ๋ฐ๊ตฌ๋");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("ํฉ๊ณ : %d์\n", calculateTotalPrice());

        System.out.println("์ด์ ์ผ๋ก ๋์๊ฐ๋ ค๋ฉด ์ํฐ๋ฅผ ๋๋ฅด์ธ์. ");
        scanner.nextLine();
    }

    public void printCartItemDetails(){
        iterator = items.iterator();
        while (iterator.hasNext()){
            Fruit fruit = iterator.next();
            if (fruit instanceof Apple){
                System.out.printf(
                        "  %s %s %6d์ \n",fruit.getName(),fruit.getColor(),fruit.getPrice()
                );
            }

            else if (fruit instanceof Grape){
                System.out.printf(
                        "  %s %s %6d์ \n",fruit.getName(),fruit.getColor(),fruit.getPrice()
                );
            }

            else if (fruit instanceof Mango){
                System.out.printf(
                        "  %s %s %6d์ \n",fruit.getName(),fruit.getColor(),fruit.getPrice()
                );
            }
        }
    }

    int calculateTotalPrice(){
        int totalPrice = 0;
        iterator = items.iterator();
        while (iterator.hasNext()) {
            Fruit fruit = iterator.next();
            totalPrice += fruit.getPrice();
        }
        return totalPrice;
    }



}
