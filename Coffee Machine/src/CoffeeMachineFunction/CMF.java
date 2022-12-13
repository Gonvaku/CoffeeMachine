package CoffeeMachineFunction;

import java.util.Objects;
import java.util.Scanner;

/*
It requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number
of cups a user needs.
If the coffee machine has enough supplies to make the specified amount of coffee, the program should print
"Yes, I can make that amount of coffee".
If the coffee machine can make more than that, the program should output "Yes, I can make that amount of coffee
(and even N more than that)", where N is the number of additional cups of coffee that the coffee machine can make.
If the amount of given resources is not enough to make the specified amount of coffee, the program should output
"No, I can make only N cup(s) of coffee".
Like in the previous stage, the coffee machine needs 200 ml of water, 50 ml of milk,
and 15 g of coffee beans to make one cup of coffee.
 */
public class CMF {
    static int water;
    static int milk;
    static int coffee;
    static int cups;
    static int money;
    public static void setMachineValue(String input, int newValue) {
        if (input == "water") {
            water = newValue;
        } else if (input == "milk") {
            milk = newValue;
        } else if (input == "coffee") {
            coffee = newValue;
        } else if (input == "cups") {
            cups = newValue;
        } else if (input =="money") {
            money = newValue;
        }

    }
    public static void getMachineStatus() {
        System.out.println("The coffee machine has: ");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee+" g of coffee beans");
        System.out.println(cups+" disposable cups ");
        System.out.println("$"+money+" of money");

    }
    public static void setFullMachine(int newWater,int newMilk, int newCoffee, int newCups, int newMoney) {
        water = newWater;
        milk = newMilk;
        coffee = newCoffee;
        cups = newCups;
        money = newMoney;
    }
    public static void howMany(int input){
        // 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.
        int cupsW = water / 200;
        int cupsM = milk / 50;
        int cupsC = coffee / 15;

        int totalCups=min(cupsW,cupsM,cupsC);
        if (cups < totalCups) {
            System.out.println("No, I can make only " + cups + " cup(s) of coffee");
        }else {
            if (totalCups==input) {
                System.out.println("Yes, I can make that amount of coffee");
            } else if (totalCups>input) {
                int rest=totalCups-input;
                System.out.println("Yes, I can make that amount of coffee (and even "+rest+" more than that)");
            } else if (input>totalCups) {
                System.out.println("No, I can make only " +totalCups + " cup(s) of coffee");

            }
        }
        }

    public static void machineAction(String input){
        Scanner scanny = new Scanner(System.in);
            if (Objects.equals(input, "buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte," +
                        " 3 - cappuccino, back - to main menu: ");
                String choice = scanny.nextLine();
                CanI(choice);

            } else if (Objects.equals(input, "fill")) {
                System.out.println("Write how many ml of water you want to add: ");
                int value = scanny.nextInt();
                setMachineValue("water",water+value);
                System.out.println("Write how many ml of milk you want to add: ");
                value = scanny.nextInt();
                setMachineValue("milk",milk+value);
                System.out.println("Write how many grams of coffee beans you want to add:  ");
                value = scanny.nextInt();
                setMachineValue("coffee",coffee+value);
                System.out.println("Write how many disposable cups you want to add:  ");
                value = scanny.nextInt();
                setMachineValue("cups",cups+value);


            }else if (Objects.equals(input, "take")) {
                System.out.println("I gave you: "+money);
                setMachineValue("money",0);

            } else if (Objects.equals(input, "remaining")) {
                getMachineStatus();

        }

    }

    public static void  typeOfCoffee(String number){
        //For one espresso, the coffee machine needs :
        // 250 ml of water and 16 g of coffee beans. It costs $4.
        //For a latte, the coffee machine needs :
        // 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        //And for a cappuccino, the coffee machine needs :
        // 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.

        if (Objects.equals(number, "1")) {

                setMachineValue("water",water-250);
                setMachineValue("coffee",coffee-16);
                setMachineValue("money",money+4);
                setMachineValue("cups",cups-1);


        } else if (Objects.equals(number, "2")) {
;
                setMachineValue("water", water - 350);
                setMachineValue("milk", milk - 75);
                setMachineValue("coffee", coffee - 20);
                setMachineValue("money", money + 7);
                setMachineValue("cups", cups - 1);


        }else if (Objects.equals(number, "3")) {

                setMachineValue("water",water -200);
                setMachineValue("milk",milk - 100);
                setMachineValue("coffee",coffee -12);
                setMachineValue("money",money +6);
                setMachineValue("cups",cups-1);


        } else {
            if(Objects.equals(number, "back")){
                System.out.println("Going back...");
            } else {
                System.out.println("ERROR: Please input a valid input ");
            }

        }
    }

    public static void CanI(String number){
    boolean booly=true;
        switch (number) {
            case "1":
                if(water<250) {
                    System.out.println("Sorry, not enough water!");
                    booly=false;
                } if(coffee<16) {
                    System.out.println("Sorry, not enough coffee!");
                    booly=false;
                } if(cups==0) {
                    System.out.println("Sorry, not enough cups!");
                    booly=false;
                } else if (booly==true) {typeOfCoffee("1");
                System.out.println("I have enough resources, making you a coffee!");}
                break;
            case "2":
                if(water<350) {
                    System.out.println("Sorry, not enough water!");
                    booly=false;
                }if(milk<75) {
                    System.out.println("Sorry, not enough milk!");
                    booly=false;
                } if(coffee<20) {
                    System.out.println("Sorry, not enough coffee!");
                    booly=false;
                } if(cups==0) {
                    System.out.println("Sorry, not enough cups!");
                    booly=false;
                } else if (booly==true) {typeOfCoffee("2");
                    System.out.println("I have enough resources, making you a coffee!");}
                break;

            case "3":
                if(water<200) {
                    System.out.println("Sorry, not enough water!");
                    booly=false;
                }if(milk<100) {
                    System.out.println("Sorry, not enough water!");
                    booly=false;
                } if(coffee<12) {
                    System.out.println("Sorry, not enough coffee!");
                    booly=false;
                } if(cups==0) {
                    System.out.println("Sorry, not enough cups!");
                    booly=false;
            } else if (booly==true){typeOfCoffee("3");
                System.out.println("I have enough resources, making you a coffee!");}
                break;

        }

    }

    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
