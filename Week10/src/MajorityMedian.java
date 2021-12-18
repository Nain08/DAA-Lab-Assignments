import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MajorityMedian
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file=new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week10\\src\\MajorityInput");
        Scanner scan=new Scanner(file);
        int size= scan.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
            arr[i]=scan.nextInt();
        Arrays.sort(arr);
        findMajority(arr);
        System.out.print("Median = ");
        if(size%2==0)
            System.out.println((arr[size/2]+arr[size/2-1])/2);
        else
            System.out.println(arr[size/2]);
    }

    private static void findMajority(int[] arr)
    {
        int n=arr.length;
        int maxCount = 0;
        int index = -1; // sentinels
        for(int i = 0; i < n; i++)
        {
            int count = 0;
            for(int j = 0; j < n; j++)
            {
                if(arr[i] == arr[j])
                    count++;
            }
            if(count > maxCount)
            {
                maxCount = count;
                index = i;
            }
        }
        if (maxCount > n/2)
            System.out.println ("YES");
        else
            System.out.println ("NO");
    }

}
