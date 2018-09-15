import java.util.ArrayList;
public class API {
    private ArrayList<Integer> numbersArray = new ArrayList<>();

    public static void main(String[] args) {
        new API().run();
    }

    private ArrayList<Integer> AmountOfNumbersArray = new ArrayList<>();

    private void run() {
        numbersArray.add(25000);
        numbersArray.add(50000);
        numbersArray.add(100000);
        numbersArray.add(200000);
        numbersArray.add(400000);
        numbersArray.add(800000);
//        Om Assignment 1.1 en 1.2 te testen, uncomment de volgende lijnen van code, en comment de "Assignment3();"
//        Assignment1();
//        Assignment2();
        Assignment3();
    }

    private void Assignment1() {
        Assignment1_1 assignment11 = new Assignment1_1();
        for (int amount : numbersArray
                ) {
            long start = System.currentTimeMillis();
            assignment11.run(amount);
            long finish = System.currentTimeMillis();
            System.out.println("Time for " + amount + " numbers: " + (finish - start));
        }
    }
    private void Assignment2() {
        Assignment1_2 assignment1_2 = new Assignment1_2();
        for (int amount : numbersArray
                ) {
            long start = System.currentTimeMillis();
            assignment1_2.sortList(amount);
            long finish = System.currentTimeMillis();
            System.out.println("Time for " + amount + " numbers: " + (finish - start));
        }
    }
    private void Assignment3() {
        Assignment1_3 assignment1_3 = new Assignment1_3();
        for (int amount : numbersArray
                ) {
            long start = System.currentTimeMillis();
            assignment1_3.run(amount);
            long finish = System.currentTimeMillis();
            System.out.println("Time for " + amount + " numbers: " + (finish - start));
        }
        System.out.println("Process done");
    }
}