package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\DAA Lab\\Week1\\src\\LinearSearchInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++)
            {
                arr[j] = scan.nextInt();
            }
            int key= scan.nextInt();
            linearSearch(arr,key);
        }
        scan.close();
    }
    public static void linearSearch(int[] arr, int key)
    {
        int count=0;
        boolean found=false;
        for (int j : arr)
        {
            count++;
            if (j == key)
            {
                found = true;
                break;
            }
        }
        if(found)
        {
            System.out.println("Present "+count);
        }
        else
        {
            System.out.println("Not Present "+count);
        }
    }
}