import java.util.ArrayList;

public class Assignment1_1 {
    public void run(int amountOfNumbers){
        sortList(createList(amountOfNumbers));

    }

    /**
     * This method creates a list of random numbers depending on the amount specified.
     * @param amountOfNumbers is the amount of numbers that needs to be created.
     * @return the created list.
     */
    public ArrayList<Integer> createList(int amountOfNumbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < amountOfNumbers; i++) {
            list.add((int) (Math.random() * 100) + 1);
        }
        return list;
    }

    /**
     * In this method we sort the provided list using selection sort.
     * @param listToSort is the list provided.
     * @return the sorted list.
     */
    public ArrayList<Integer> sortList(ArrayList<Integer> listToSort){
        ArrayList<Integer> list = listToSort;
        ArrayList<Integer> sortedList = new ArrayList<>();
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