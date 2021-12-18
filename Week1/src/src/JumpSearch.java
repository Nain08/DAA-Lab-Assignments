package src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JumpSearch
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
            JumpSearch(arr, key);
        }
        scan.close();
    }
        public static void JumpSearch(int[] arr,int key)
        {
            int n=arr.length;
            int step= (int) Math.floor(Math.sqrt(n));
            int prev=0,count=0;
            boolean found=false;
            while(arr[Math.min(step,n)-1]<key)
            {
                count++;
                prev=step;
                step+=(int) Math.floor(Math.sqrt(n));
                if(prev>=n)
                    found=false;
            }
            while (arr[prev]<key)
            {
                count++;
                prev++;
                if(prev==Math.min(step,n))
                    found=false;
            }
            if (arr[prev]==key)
            {
                count++;
                found=true;
            }
            if (found)
                System.out.println("Present "+count);
            else
                System.out.println("Not Present "+count);
            }
}

