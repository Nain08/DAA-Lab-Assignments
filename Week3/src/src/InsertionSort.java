package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week3\\src\\src\\InsertionSortInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            insertion(arr);
        }
    }
    static void insertion(int[] arr)
    {
        int swaps=0,comparisons=0;
        for(int i=1;i<arr.length;i++)
        {

            int temp=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>temp)
            {
                arr[j+1]=arr[j];
                j--;
                comparisons++;
                swaps++;
            }
            arr[j+1]=temp;
            swaps++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Comparisons="+comparisons);
        System.out.println("Swaps="+swaps);
    }
}
