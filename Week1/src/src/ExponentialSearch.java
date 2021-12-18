package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExponentialSearch
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\DAA Lab\\Week1\\src\\BinarySearchInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            int key = scan.nextInt();
            ExponentialSearch(arr, key);
        }
        scan.close();
    }
    public static void ExponentialSearch(int arr[],int key)
    {
        int i=1;
        int n=arr.length;
        if(arr[0]==key)
        {
            System.out.println("Present "+1);
            return;
        }
        while(i<arr.length&&arr[i]<key)
        {
            i=i*2;

        }
       BinarySearch(arr,i/2,Math.min(i,n-1),key);
        //linearSearch(arr,i/2,key);

    }
    /*public static void linearSearch(int[] arr,int i, int key)
    {
        int count=0;
        boolean found=false;
        for (int j=i;j< arr.length;j++)
        {
            count++;
            if (arr[j] == key)
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
    }*/
    public static void BinarySearch(int[] arr,int low,int high, int key)
    {
        int count=0;
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
