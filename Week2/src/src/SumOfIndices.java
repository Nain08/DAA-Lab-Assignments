package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Given a sorted array of positive integers, design an algorithm and implement it using a program to find three indices i, j, k such that
arr[i] + arr[j] = arr[k].
 */
public class SumOfIndices
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\DAA Lab\\Week2\\src\\SumOfIndicesInput");
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
            search(arr);
        }
        scan.close();
    }
    static void search(int []arr)
    {
        boolean found=false;
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                for (int k = 2; k < n; k++) {

                    if (arr[i] + arr[j] == arr[k]) {
                        System.out.println((i + 1) + "," + (j + 1) + "," + (k + 1));
                        found = true;
                        return;
                    }

                }
            }

        }
        if(!found)
        {
            System.out.println("No Sequence found");
        }
    }
}
