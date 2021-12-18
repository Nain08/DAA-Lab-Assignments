package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week3\\src\\src\\SelectionSortInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            selection(arr);
        }
    }
        static void selection(int[] arr)
        {
            int swaps=0,comparisons=0;
            for(int i=0;i<arr.length-1;i++)
            {
                int min = i;
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] < arr[min])
                        min = j;
                    comparisons++;
                }
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                swaps++;

            }
            System.out.println(Arrays.toString(arr));
            System.out.println("Comparisons = "+comparisons);
            System.out.println("Swaps = "+swaps);
        }

    }
