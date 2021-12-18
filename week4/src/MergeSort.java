import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week\\src\\MergeSortInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            mergeSort(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void mergeSort(int arr[],int l,int r)
    {
        if(l>=r)
        {
            return;
        }
        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    public static void merge(int arr[],int l,int mid,int r)
    {
        int b[]=new int[r-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid&&j<=r)
        {
            if(arr[i]<arr[j])
            {
                b[k]=arr[i];
                i++;
            }
            else
            {
                b[k]=arr[j];
                j++;
            }
            k++;
        }

        while(j<=r)
        {
            b[k]=arr[j];
            k++;
            j++;
        }


        while(i<=mid)
        {
            b[k]=arr[i];
            i++;
            k++;
        }

        int m=0;
        for(i=l;i<=r;i++)
        {
            arr[i]=b[m];
            m++;
        }
    }
}
