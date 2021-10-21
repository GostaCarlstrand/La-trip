package com.company;

import com.company.product.Product;

import java.util.ArrayList;

public class Purchase {
    Menu menu;
    Market market;
    Character character;
    Receipt receipt;
    ArrayList <Product> productCart = new ArrayList<Product>();
    private int totalSum;       //Used to store the product total value

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
        String displayCart = productCart.toString().replace("[", "").replace("]", "");
        return displayCart;
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
            if (!character.checkAgeToPurchase(character.getAge())) {
                System.out.println("Sorry, you are under age, come back in " + (21-character.getAge()) + " years");
                productCart.clear();
                addProductToCart(market.franksProductInStock, market.franksBrandName);    //Calling the method if character is under age
            }
        }

        totalSum = calculatePrice(productCart);
        if (!(character.checkCharacterHasMoney(character.getWalletBalance(), totalSum))){
            System.out.println("You only have " + character.getWalletBalance() + " dollars, this will cost you\n "+
                    totalSum + ", come back with more money!");
            productCart.clear();
            addProductToCart(market.franksProductInStock, market.franksBrandName);//Call the method to return and not execute the other code in the method
        }
        character.updateWalletBalance(totalSum);
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
            if (menuChoice.equalsIgnoreCase("return")) {
                running = false;
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
                running = false;
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
                } else if (menuChoice.equalsIgnoreCase("1")) {
                    market.marketActivities(); // Leave store and return to market

                } else if (menuChoice.equalsIgnoreCase("2")) {       //Remove any of the objects
                    if (!(productCart.isEmpty())) {
                        removeProductsFromCart();
                        break;
                    } else {
                        System.out.println("Your cart is empty, you have no products to remove");
                        break;
                    }
                } else if (menuChoice.equalsIgnoreCase("3")) {       // Remove all objects in shopping cart
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
