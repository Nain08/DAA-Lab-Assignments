import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week5\\src\\CountingSortInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            char[] arr = new char[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.next().charAt(0);
            }
            countingSort(arr, size);
        }
    }

    private static void countingSort(char[] arr, int size)
    {
        int freq[]=new int[26];
        int flag=0;
        for(int i=0;i<size;i++)
        {
            freq[i]=0;
        }
        for(int i=0;i<size;i++)
        {
            freq[arr[i]-97]++;
        }
        int max=1;
        int j=0;
        for(int i=0;i<26;i++)
        {
            if(freq[i]>max)
            {
                flag=1;
                max=freq[i];
                j=i;
            }
        }
        char ch= (char) (j+97);
        if(flag==0)
            System.out.println("No Duplicate elements present");
        else
            System.out.println(ch+" - "+max);
    }
}
