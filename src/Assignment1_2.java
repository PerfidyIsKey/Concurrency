import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assignment1_2 {
    public void sortList(int amount) {
        ArrayList<Integer> listToSort1 = createList(amount / 2);
        ArrayList<Integer> listToSort2 = createList(amount / 2);
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
        System.out.println(mergeLists(sorter1.getList(), sorter2.getList()));
    }

    private ArrayList<Integer> createList(int amount) {
        ArrayList<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int random = (int) (Math.random() * 100) + 1;
            unsortedList.add(random);
        }
        return unsortedList;
    }

    private ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int currentIndex = 0;
        for (int number : list2) {
            boolean found = false;
            for (int i = currentIndex; i < list1.size(); i++) {
                if (!found) {
                    if (number<=list1.get(i)) {
                        currentIndex = i;
                        list1.set(currentIndex, list2.get(i));
                        found = true;
                    }
                }
            }
        }

        return list1;
    }
}