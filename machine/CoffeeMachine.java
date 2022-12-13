package machine;

import CoffeeMachineFunction.CMF;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        CMF.setFullMachine(400,540,120,9,550);
        loopty();
    }

    private static void loopty() {
        Scanner input = new Scanner(System.in);
        boolean i = true;
        while (i) {
            System.out.println(" ");
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = input.nextLine();
            action.toLowerCase();
            if (action.equals("exit")) {
                i = false;
            } else {
                CMF.machineAction(action);
            }
        }
    }
}
