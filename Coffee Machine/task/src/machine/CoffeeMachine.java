package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int balance_water = 400;
    private static int balance_milk = 540;
    private static int balance_beans = 120;
    private static int balance_cups = 9;
    private static int balance_money = 550;
    private static final Scanner scanner = new Scanner(System.in);


    public CoffeeMachine() {

    }

    public static void main(String[] args) {
        // init
        choose_program();

    }

    public static void choose_program() {

        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        boolean exit = false;
        String method = scanner.next();
        switch (method) {
            case "buy":
                // buy product
                buy();
                break;
            case "take":
                // take money
                take();
                break;
            case "fill":
                // fill machine
                fill();
                break;
            case "remaining":
                system_stat();
                break;
            case "exit":
                exit = true;
                break;
        }
        if (!exit) {
            choose_program();
        }
    }

    static void not_volume(String product) {
        System.out.println("Sorry, not enough " + product + "!");
    }

    static void get_drink(int water, int milk, int beans, int money) {
        boolean resources = true;

        if (balance_water - water < 0) {
            not_volume("water");
            resources = false;
        } else if (balance_milk - milk < 0) {
            not_volume("milk");
            resources = false;
        } else if (balance_beans - beans < 0) {
            not_volume("beans");
            resources = false;
        } else if (balance_cups - 1 < 0) {
            not_volume("cups");
            resources = false;
        }

        if (resources) {
            balance_water = balance_water - water;
            balance_milk = balance_milk - milk;
            balance_beans = balance_beans - beans;
            balance_cups = balance_cups - 1;
            balance_money = balance_money + money;
        }
    }

    static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        String product = scanner.next();
        switch (product) {
            case "1":
                // espresso
                get_drink(250, 0, 16, 4);
                break;
            case "2":
                // latte
                get_drink(350, 75, 20, 7);
                break;
            case "3":
                // cappucino
                get_drink(200, 100, 12, 6);
                break;
            case "back":
                break;

        }
    }

    static void take() {
        System.out.println("I gave you " + balance_money + "\n");
        balance_money = 0;
    }

    static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        balance_water = balance_water + scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        balance_milk = balance_milk + scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        balance_beans = balance_beans + scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        balance_cups = balance_cups + scanner.nextInt();
    }

    static void system_stat() {
        //init
        System.out.print("The coffee machine has:\n" +
                +balance_water + " of water\n" +
                +balance_milk + " of milk\n" +
                +balance_beans + " of coffee beans\n" +
                +balance_cups + " of disposable cups\n" +
                +balance_money + " of money\n");
    }

}