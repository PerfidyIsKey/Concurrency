import java.util.ArrayList;

public class Assignment1_1 {
    public void run(int amountOfNumbers){
        sortList(createList(amountOfNumbers));

    }

    public ArrayList<Integer> createList(int amountOfNumbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < amountOfNumbers; i++) {
            list.add((int) (Math.random() * 100) + 1);
        }
        return list;
    }
    public ArrayList<Integer> sortList(ArrayList<Integer> listToSort){
        ArrayList<Integer> list = listToSort;
        ArrayList<Integer> sortedList = new ArrayList<>();
        int currentchecked = 0;
        while (0<list.size()){
            int smallestNumberPos= list.size()-1;
            for (int i = 0;i<list.size();i++) {
                if(list.get(i)<=list.get(smallestNumberPos)){
                    smallestNumberPos = i;
                }
            }
            sortedList.add(list.get(smallestNumberPos));
            list.remove(smallestNumberPos);
        }
        return sortedList;
    }
}