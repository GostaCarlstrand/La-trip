package com.company;

import com.company.product.Product;

import java.util.ArrayList;

public class Purchase {
    Menu menu;
    Market market;
    Character character;
    Receipt receipt;
    ArrayList <Product> productCart = new ArrayList<Product>();
    private int totalSum;
    String [] acceptedRemovePhrases = {"Remove any product", "Remove", "Remove products","remove prod", "remove product", "2"};
    String [] acceptedClearPhrases = {"clear cart","erase cart", "delete cart", "3", "clear my cart", "clear", "remove all"};

    public Purchase(Market market, Character character, Receipt receipt, Menu menu) {
        this.market = market;
        this.character = character;
        this.receipt = receipt;
        this.menu = menu;


    }
    public int getTotalSum() {
        return totalSum;
    }
    public void displayProducts(Product[] productInStock) {
        for (Product product : productInStock) {
            System.out.println(product.getName());
        }

    }
    private String displayCart() {
        return productCart.toString().replace("[", "").replace("]", "");
    }
    public int calculatePrice(ArrayList <Product> productCart) {
        int totalSum = 0;
        for (Product i : productCart) {
            totalSum += (i).getPrice();
        }
        return totalSum;
    }
    private void checkOut(String brandName) {
        if (brandName == market.franksBrandName)
        {
            if (!character.checkAge(character.getAge())) {
                System.out.println("Sorry, you are under age, come back in " + (21-character.getAge()) + " years");
                productCart.clear();
                market.marketActivities();
            }
        }

        totalSum = calculatePrice(productCart);
        if (!(character.checkCharacterHasMoney(totalSum))){
            System.out.println("You only have " + character.getWalletBalance() + " dollars, this will cost you\n "+
                    totalSum + ", come back with more money!");
            productCart.clear();
            market.marketActivities();
        }
        character.reduceWalletBalance(totalSum);
        System.out.println("That will be: " + totalSum);
        receipt.createReceipt(brandName);
        receipt.writeReceipt(brandName, productCart);

        productCart.clear();            //Erase the elements in the ArrayList
    }
    public void removeProductsFromCart () {
        boolean running = true;
        System.out.println("Here you can enter the products that you would like to remove,\n" +
                "Type return to continue shopping");
        while (running) {
            System.out.println("This is your current cart: " + displayCart());
            System.out.print("What product would you like to remove?: ");
            String menuChoice = menu.menuInput();
            boolean isPartOfProductCart = false;
            if (menu.acceptedInputs(menuChoice, menu.acceptedExitPhrases)) {
                break;
            }
            for (Product p : productCart) {
                if (menuChoice.equalsIgnoreCase(p.getName())) {
                    productCart.remove(p);
                    isPartOfProductCart = true;
                    break;
                }
            }

            if (!isPartOfProductCart) {
                System.out.println("Your cart does not contain that product");
            }

            if (productCart.isEmpty()) {
                break;
            }
        }
    }
    public void addProductToCart(Product [] productInStock, String brandName) {
        boolean running = true;
        while (running) {
            System.out.print("What can I get you?: ");
            String menuChoice = menu.menuInput();
            for (int i = 0; i < productInStock.length; i++) {
                if (menuChoice.equalsIgnoreCase(productInStock[i].getName())) {
                    productCart.add(productInStock[i]);
                } else if (menu.acceptedInputs(menuChoice, menu.acceptedExitPhrases)) {       //accepted inputs are entered in the menu Class
                    System.out.println("Ok, have a good day");
                    productCart.clear();
                    market.marketActivities(); // Leave store and return to market


                } else if (menu.acceptedInputs(menuChoice, acceptedRemovePhrases)) {       //Remove any of the objects
                    if (!(productCart.isEmpty())) {
                        removeProductsFromCart();
                        break;
                    } else {
                        System.out.println("Your cart is empty, you have no products to remove");
                        break;
                    }
                } else if (menu.acceptedInputs(menuChoice, acceptedClearPhrases)) {       // Remove all objects in shopping cart
                    productCart.clear();
                    System.out.println("Your cart is now empty");
                    break;
                } else if (menuChoice.equalsIgnoreCase("4")) {
                    checkOut(brandName);
                    market.marketActivities();
                }
            }
            if ((productCart.isEmpty())) {
                displayProducts(productInStock);
            } else {
                System.out.println("Product in your cart: " + displayCart());
            }

        }
    }
}
