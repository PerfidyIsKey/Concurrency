import java.util.ArrayList;

public class Assignment1_2SelSortThread implements Runnable {
    private ArrayList<Integer> list;
    public Assignment1_2SelSortThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Assignment1_1 selectSorter = new Assignment1_1();
        ArrayList<Integer> sortedList = selectSorter.sortList(list);
        list = sortedList;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}