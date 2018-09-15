import java.util.ArrayList;

public class Assignment1_2SelSortThread implements Runnable {
    private ArrayList<Integer> list;
    public Assignment1_2SelSortThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        if(list.size()>200000){
            ArrayList<Integer> listToSplit = list;
            Assignment1_3 splitter = new Assignment1_3();
            list = splitter.recursiveSort(listToSplit);
        }
        else{
            Assignment1_1 selectSorter = new Assignment1_1();
            ArrayList<Integer> sortedList = selectSorter.sortList(list);
            list = sortedList;
        }
        //Voor assignment 1.2, comment de if else statements hier boven en uncomment de code hier onder.
        //Assignment1_1 selectSorter = new Assignment1_1();
        //ArrayList<Integer> sortedList = selectSorter.sortList(list);
        //list = sortedList;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}