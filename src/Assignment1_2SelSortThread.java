import java.util.ArrayList;

public class Assignment1_2SelSortThread implements Runnable {
    private ArrayList<Integer> list;
    public Assignment1_2SelSortThread(ArrayList<Integer> list) {
        this.list = list;
    }

    /**
     * This method is always executed by the thread created with this runnable.
     */
    @Override
    public void run() {

        //For assignment 1.2, comment out the if/else statements above and uncomment the code below.
        Assignment1_1 selectSorter = new Assignment1_1();
        ArrayList<Integer> sortedList = selectSorter.sortList(list);
        list = sortedList;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}