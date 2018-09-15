import java.util.ArrayList;

public class Assignment1_3 {

    public void run(int amount) {
        Assignment1_2 assignment1_2 = new Assignment1_2();
        ArrayList<Integer> list = assignment1_2.createList(amount);
        System.out.println(recursiveSort(list));
    }

    public ArrayList<Integer> recursiveSort(ArrayList<Integer> list) {
        Assignment1_2 assignment1_2 = new Assignment1_2();

        if (list.size() > 200000) {
            ArrayList<Integer> listToSort1 = new ArrayList<>();
            ArrayList<Integer> listToSort2 = new ArrayList<>();
            for (int i = 0; i < list.size() / 2; i++) {
                listToSort1.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                listToSort2.add(list.get(i));
            }
            Assignment1_2SelSortThread sorter1 = new Assignment1_2SelSortThread(listToSort1);
            Assignment1_2SelSortThread sorter2 = new Assignment1_2SelSortThread(listToSort2);
            Thread t1 = new Thread(sorter1);
            Thread t2 = new Thread(sorter2);
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException iex) {
            }
            return assignment1_2.mergeLists(sorter1.getList(), sorter2.getList());
        }
        else {
            Assignment1_1 assignment1_1 = new Assignment1_1();
            return assignment1_1.sortList(list);
        }

    }
}
