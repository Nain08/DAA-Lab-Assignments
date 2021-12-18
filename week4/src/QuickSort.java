import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week4\\src\\src\\MergeSortInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            quickSort(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void quickSort(int[] arr,int l ,int r)
    {
        if(l<r)
        {
            int pivot=partition(arr,l,r);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,r);
        }
    }
    public static int partition(int[] arr,int l,int r)
    {
        int pivot=arr[l];
        int count=0;
        for(int i=l+1;i<=r;i++)
        {
            if(arr[i]<=pivot)
                count++;
        }
        int pivotIndex=l+count;
        arr[l]=arr[pivotIndex];
        arr[pivotIndex]=pivot;
        int i=l,j=r;
        while(i<j)
        {
            while(i<=r&&arr[i]<=pivot)
                i++;
            while(arr[j]>pivot)
                j--;
            if(i<=j)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        return pivotIndex;
    }
}
