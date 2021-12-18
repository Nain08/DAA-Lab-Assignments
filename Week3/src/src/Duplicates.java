package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Duplicates
{
    public static void main(String[] args) throws FileNotFoundException
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week3\\src\\src\\DuplicatesInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++)
        {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            MergeSort(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr));
            boolean found=false;
            for(int x=0;x<arr.length-1;x++)
            {
                if(arr[x]==arr[x+1])
                {
                    found=true;
                    break;
                }

            }
            if(found)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    static void MergeSort(int[] arr, int l,int r)
    {
        if(l<r)
        {
            int mid=(l+r)/2;
            MergeSort(arr,l,mid);
            MergeSort(arr,mid+1,r);
            Merge(arr,l,mid,r);
        }

    }
    static void Merge(int[] arr, int l, int mid , int r)
    {
        int res[]=new int[r-l+1];
        int i=l;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=r)
        {
            if(arr[i]<=arr[j])
            {
                res[k]=arr[i];
                i++;
            }
            else
            {
                res[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid)
        {
            res[k]=arr[i];
            k++;
            i++;
        }
        while(j<=r)
        {
            res[k]=arr[j];
            j++;
            k++;
        }
        for(int x=l;x<=r;x++)
        {
            arr[x]=res[x-l];
        }
    }
}
