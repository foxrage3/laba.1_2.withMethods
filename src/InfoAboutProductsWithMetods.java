/*
– определить товары с максимальным количеством единиц;
– определить среднюю цену товаров и количество товаров с ценой ниже
средней;
– упорядочить список по убыванию цен товаров;
– организовать поиск по наименованию товара, исправление одного из полей и вывод полной информации о товаре после редактирования. */

import java.util.Scanner;

class Product {
    String name;
    String manufacturer;
    int amount;
    double price;
}

public class InfoAboutProductsWithMetods {
    public static Scanner sc;

    public static Product[] fillProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product();
            System.out.println("Name");
            products[i].name = sc.nextLine();
            System.out.println("Manufacturer");
            products[i].manufacturer = sc.nextLine();
            System.out.println("Amount");
            products[i].amount = sc.nextInt();
            System.out.println("Price");
            products[i].price = sc.nextDouble();
            sc.nextLine();
        }
        return products;
    }

    public static void printProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println("Name = " + products[i].name + " Manufacturer = " + products[i].manufacturer +
                    " Amount = " + products[i].amount + " Price = " + products[i].price);
        }
    }

    public static void printProduct(Product product) {
        System.out.println("Name = " + product.name + " Manufacturer = " + product.manufacturer +
                " Amount = " + product.amount + " Price = " + product.price);
    }

    public static int findProductWithGreatestAmount(Product[] products) {
        int productWithGreatestAmount = 0;
        int greatAmount = products[productWithGreatestAmount].amount;
        for (int i = 0; i < products.length; i++) {
            if (products[i].amount > greatAmount) {
                productWithGreatestAmount = i;
                greatAmount = products[productWithGreatestAmount].amount;
            }
        }
        return productWithGreatestAmount;
    }

    public static double findAvgPrice(Product[] products) {
        double allPrice = 0;
        for (int i = 0; i < products.length; i++) {
            allPrice = allPrice + products[i].price;
        }
        return (allPrice/products.length);
    }

    public static int findMoreThanAvgPrice(Product[] products) {
        int kol = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i].price > findAvgPrice(products)) {
                kol = kol + 1;
            }
        }
        return (kol);
    }

    public static void sortedByDecreaseInPrices(Product[] products) {
        for (int i = 0; i < products.length - 1; i++) {
            for (int j = 0; j < products.length - 1 - i; j++) {
                if (products[j].price < products[j + 1].price) {
                    Product rab = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = rab;
                }
            }
        }
    }

    public static int findIndexProductsByName(Product[]products, String searchName) {
        int searchIndex = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i].name.equals(searchName)) {
                searchIndex = i;
            }
        }
        return searchIndex;
    }

    public static void redBook(Product product) {
        System.out.println("Какое поле хотите исправить?");
        System.out.println("name, manufacturer, amount, price");
        String redPole = sc.nextLine();
        switch (redPole) {
            case "name": {
                System.out.println("New name ");
                String newName = sc.nextLine();
                product.name = newName;
                break;
            }
            case "manufacturer": {
                System.out.println("New manufacturer ");
                String newManufacturer = sc.nextLine();
                product.manufacturer = newManufacturer;
                break;
            }
            case "amount": {
                System.out.println("New amount ");
                int newAmount = sc.nextInt();
                product.amount = newAmount;
                break;
            }
            case "price": {
                System.out.println("New price ");
                double newPrice = sc.nextDouble();
                product.price = newPrice;
                break;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Count");
        sc = new Scanner(System.in);
        int count = sc.nextInt();
        sc.nextLine();
        Product[] products = new Product[count];
        products = fillProducts(products);
        printProducts(products);
        int indexGreatAmount = findProductWithGreatestAmount(products);
        System.out.println("Product with greatest amount");
        printProduct(products[indexGreatAmount]);
        System.out.println("AvgPrice = " + findAvgPrice(products));
        System.out.println("Products with prices more than average: " + findMoreThanAvgPrice(products));
        sortedByDecreaseInPrices(products);
        System.out.println("Sorted by decrease in prices");
        printProducts(products);
        System.out.println("Enter name");
        String searchName = sc.nextLine();
        int searchIndex = findIndexProductsByName(products, searchName);
        if (searchIndex!=-1) {
            System.out.println("Найдена книга");
            printProduct(products[searchIndex]);
            redBook(products[searchIndex]);
            System.out.println("Отредактированная информация о книге");
            printProduct(products[searchIndex]);
        }
        else {
            System.out.println("Ничего не найдено");
        }
    }
}

