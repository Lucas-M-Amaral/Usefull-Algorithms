// Best case O(n log(n))
// Average case O(n log(n))
// Worst case O(n^2) if already sorted

import java.util.Random;
import java.util.ArrayList;

public class Quicksort {

    public static void main(String args[]) 
    {

        Random rand = new Random();

        int upperBound = 20;

        ArrayList<Integer> array = new ArrayList<>();

        for(int i = 0; i < upperBound; i++)
        {
            array.add(rand.nextInt(upperBound));
        }

        System.out.println("Length: " + array.size());

        System.out.println("\nUNSORTED: ");

        for (int i = 0; i < array.size(); i++) 
        {
            System.out.print(array.get(i) + " ");
        }

        System.out.println("\n");

        quickSort(array, 0, array.size() - 1); // Calling Quicksort;

        System.out.println("SORTED: ");

        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
    }

    private static void quickSort(ArrayList<Integer> array, int start, int end) 
    {
        if (end <= start)
            return; // base case

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(ArrayList<Integer> array, int start, int end) 
    {
        int pivot = array.get(end);
        int i = start - 1;

        for (int j = start; j <= end; j++)
        {
            if (array.get(j) < pivot) {
                i++;
                int temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
            }
        }
        i++;
        int temp = array.get(i);
        array.set(i, array.get(end));
        array.set(end, temp);

        return i;
    }
}