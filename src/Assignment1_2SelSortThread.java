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
        //this if statement checks if the list-size is bigger than 200000,
        //if this is the case the list will be sent back into recursion to be split again.
        //otherwise it will be sorted immediately.
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
        //For assignment 1.2, comment out the if/else statements above and uncomment the code below.
        //Assignment1_1 selectSorter = new Assignment1_1();
        //ArrayList<Integer> sortedList = selectSorter.sortList(list);
        //list = sortedList;
    }

    public ArrayList<Integer> getList() {
        return list;
    }
}