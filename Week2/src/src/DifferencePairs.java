package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DifferencePairs
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\DAA Lab\\Week2\\src\\DifferencePairInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j =0 ; j < size; j++)
            {
                arr[j]=scan.nextInt();
            }
            int key= scan.nextInt();
            count(arr,key);
        }

        scan.close();
    }
    static void count(int[] arr,int key)
    {
        int count=0;
           for(int i=0;i<arr.length;i++)
           {
               for(int j=i+1;j<arr.length;j++)
               {
                   int diff=Math.abs(arr[i]-arr[j]);
                   if(diff==key)
                   {
                       count++;
                   }
               }
           }
        System.out.println(count);

    }
}
