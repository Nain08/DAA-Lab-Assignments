package src;/*Given a sorted array of positive integers containing few duplicate elements, design an algorithm and implement it using a program to
find whether the given key element is present in the array or not. If present, then also find the number of copies of given key.
(Time Complexity = O(log n))
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopiesOfKey
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\DAA Lab\\Week2\\src\\SearchInput");
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
            int count=search(arr,key);
            if(count==-1)
                System.out.println("Element not present");
            else
                System.out.println(key+"-"+count);
        }
        scan.close();
    }
    public static int search(int []arr,int key)
    {
        int i,j;
        int n=arr.length;
        i=first(arr,0,n-1,key);
        if(i==-1)
            return i;
        j=last(arr,i,n-1,key);
        return  j-i+1;
    }

    public static int first(int arr[],int low,int high,int key)
    {
        if(high>=low)
        {
            int mid=(low+high)/2;
            if((mid==0||key>arr[mid-1])&&arr[mid]==key)
                return mid;
            else if(key>arr[mid])
                return first(arr,(mid+1),high,key);
            else
                return first(arr,low,(mid-1),key);
        }
        return -1;
    }
    public static int last(int arr[],int low,int high,int key)
    {
        if(high>=low)
        {
            int mid=(low+high)/2;
            if((mid==arr.length-1||key<arr[mid+1])&&arr[mid]==key)
                return mid;
            else if(key<arr[mid])
                return last(arr,low,(mid-1),key);
            else
                return last(arr,(mid+1),high,key);
        }
        return -1;
    }
}

