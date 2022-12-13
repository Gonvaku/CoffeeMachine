package machine.CoffeeMachineFunction;

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
public class CMF2 {
    static int water;
    static int milk;
    static int coffee;


    public static void setMachineValue(String input, int newValue) {
        if (input == "water") {
            water = newValue;
        } else if (input == "milk") {
            milk = newValue;
        } else if (input == "coffee") {
            coffee = newValue;
        }

    }
    public static String getMachineStatus() {
        String status = "Water: "+water+" ,Milk: "+milk+" ,Coffee: "+coffee;
        System.out.println(status);
        return status;
    }
    public static void setFullMachine(int newWater,int newMilk, int newCoffee) {
            water = newWater;
            milk = newMilk;
            coffee = newCoffee;
        }
    public static void  howMany(int input){
        // 200 ml of water, 50 ml of milk, and 15 g of coffee beans to make one cup of coffee.
        int cupsW = water / 200;
        int cupsM = milk / 50;
        int cupsC = coffee / 15;
        int totalCups=min(cupsW,cupsM,cupsC);
        if (totalCups==input) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (totalCups>input) {
            int rest=totalCups-input;
            System.out.println("Yes, I can make that amount of coffee (and even "+rest+" more than that)");
        } else if (input>totalCups) {
            System.out.println("No, I can make only " +totalCups + " cup(s) of coffee");

        }

    }
    public static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

}
