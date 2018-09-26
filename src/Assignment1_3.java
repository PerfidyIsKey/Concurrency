import java.util.ArrayList;

public class Assignment1_3 {


    public void run(int amount, int threshold) {
        ArrayList<Integer> list = createList(amount);
        recursiveSort(list, threshold);
    }

    /**
     * This method recursively splits the list provided into threads if the if-statement is reached, and merges them afterwards.
     * @param list the list provided by the outer method, or provided recursively by the thread.
     * @return the sorted list created.
     */
    public ArrayList<Integer> recursiveSort(ArrayList<Integer> list, int threshold) {
        if (list.size() > threshold) {
            ArrayList<Integer> listToSort1 = new ArrayList<>();
            ArrayList<Integer> listToSort2 = new ArrayList<>();
            //these for-loops split the array into 2 separate arrays.
            for (int i = 0; i < list.size() / 2; i++) {
                listToSort1.add(list.get(i));
            }
            for (int i = list.size() / 2; i < list.size(); i++) {
                listToSort2.add(list.get(i));
            }

            Assignment1_3Thread sorter1 = new Assignment1_3Thread(listToSort1, threshold);
            Assignment1_3Thread sorter2 = new Assignment1_3Thread(listToSort2, threshold);
            Thread t1 = new Thread(sorter1);
            Thread t2 = new Thread(sorter2);
            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException iex) {
            }
            return mergeLists(sorter1.getList(), sorter2.getList());
        }
        else {
            Assignment1_1 assignment1_1 = new Assignment1_1();
            return assignment1_1.sortList(list);
        }

    }
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
    public ArrayList<Integer> createList(int amount) {
        ArrayList<Integer> unsortedList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int random = (int) (Math.random() * 100) + 1;
            unsortedList.add(random);
        }
        return unsortedList;
    }
}