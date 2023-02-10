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

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", fruit.getName());

    }

    public void printCart(){
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails();

        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n", calculateTotalPrice());

        System.out.println("이전으로 돌아가려면 엔터를 누르세요. ");
        scanner.nextLine();
    }

    public void printCartItemDetails(){
        iterator = items.iterator();
        while (iterator.hasNext()){
            Fruit fruit = iterator.next();
            if (fruit instanceof Apple){
                System.out.printf(
                        "  %s %s %6d원 \n",fruit.getName(),fruit.getColor(),fruit.getPrice()
                );
            }

            else if (fruit instanceof Grape){
                System.out.printf(
                        "  %s %s %6d원 \n",fruit.getName(),fruit.getColor(),fruit.getPrice()
                );
            }

            else if (fruit instanceof Mango){
                System.out.printf(
                        "  %s %s %6d원 \n",fruit.getName(),fruit.getColor(),fruit.getPrice()
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
