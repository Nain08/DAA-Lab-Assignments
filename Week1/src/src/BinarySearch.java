package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BinarySearch
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\DAA Lab\\Week1\\src\\BinarySearchInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++)
            {
                arr[j]=scan.nextInt();
            }
            int key=scan.nextInt();
            BinarySearch(arr,key);
        }
        scan.close();
    }
    public static void BinarySearch(int[] arr, int key)
    {
        int low=0,high=arr.length-1,count=0;
        boolean found=false;
        while(low<=high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
            {
                found=true;
                count++;
                System.out.println("Present " + count);
                return;
            }
            else if (key > arr[mid])
            {
                count++;
                low = mid + 1;
            }
            else
            {
                count++;
                high = mid - 1;
            }
        }
        if(!found)
        {
            System.out.println("Not Present "+count);
        }
    }
}