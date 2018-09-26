import java.util.ArrayList;

public class API {
    private ArrayList<Integer> numbersArray = new ArrayList<>();
    private ArrayList<Integer> thresholdArray = new ArrayList<>();

    public static void main(String[] args) {
        new API().run();
    }

    private void run() {
        numbersArray.add(25000);
        numbersArray.add(50000);
        numbersArray.add(100000);
        numbersArray.add(200000);
        numbersArray.add(400000);
        numbersArray.add(800000);

        thresholdArray.add(10000);
        thresholdArray.add(20000);
        thresholdArray.add(40000);
        thresholdArray.add(80000);
        thresholdArray.add(160000);
//        To test Assignment 1.1 and 1.2, uncomment the following lines of code, and comment "Assignment3();"
//        Assignment1();
//        Assignment2();
        Assignment3();
    }

    private void Assignment1() {
        Assignment1_1 assignment1_1 = new Assignment1_1();
        for (int amount : numbersArray
                ) {
            long start = System.currentTimeMillis();
            assignment1_1.run(amount);
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
        for (int threshold : thresholdArray) {
            for (int amount : numbersArray
                    ) {
                long start = System.currentTimeMillis();
                assignment1_3.run(amount, threshold);
                long finish = System.currentTimeMillis();
                System.out.println("Threshold: "+threshold+", Time for " + amount + " numbers: " + (finish - start));
            }
        }
        System.out.println("Process done");
    }
}