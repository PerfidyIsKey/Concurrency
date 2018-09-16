import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assignment1_2 {
    public void sortList(int amount) {
        ArrayList<Integer> list = createList(amount);
        ArrayList<Integer> listToSort1 = new ArrayList<>();
        ArrayList<Integer> listToSort2 = new ArrayList<>();
        for (int i = 0; i < list.size()/2; i++) {
            listToSort1.add(list.get(i));
        }
        for (int i = list.size()/2; i < list.size(); i++) {
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
        System.out.println(mergeLists(sorter1.getList(), sorter2.getList()));
    }

    /**
     * This method creates a list of random numbers depending on the amount specified.
     * @param amount is the amount of numbers that needs to be created.
     * @return the created list.
     */
    public ArrayList<Integer> createList(int amount) {
        ArrayList<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int random = (int) (Math.random() * 100) + 1;
            unsortedList.add(random);
        }
        return unsortedList;
    }

    /**
     * In this method we merge the two lists provided into one sorted list.
     * @param list1 is the list from the first thread.
     * @param list2 is the list from the second thread.
     * @return the sorted and merged list.
     */
    public ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
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