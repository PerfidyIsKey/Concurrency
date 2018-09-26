import java.util.ArrayList;

public class Assignment1_3Thread implements Runnable{
    private ArrayList<Integer> list;
    private int threshold;

    public Assignment1_3Thread(ArrayList<Integer> listToSort, int threshold){
        list = listToSort;
        this.threshold = threshold;
    }

    @Override
    public void run() {
            ArrayList<Integer> listToSplit = list;
            Assignment1_3 splitter = new Assignment1_3();
            list = splitter.recursiveSort(listToSplit, threshold);
    }
    public ArrayList<Integer> getList(){
        return list;
    }
}