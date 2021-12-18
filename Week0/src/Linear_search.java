/*Given an array of non-negative integers, design a linear algorithm and implement it using a program to find whether a
given key element is present in the array or not. Also, find the total number of comparisons for each input case.
 (Time Complexity = O(n), where n is the size of input).
 */

import java.util.*;
public class Linear_search
{
    public static void main(String[] args)
    {
        int arr[]=new int[]{1,3,5,8,11,14};

        int k=5,count=0;
        boolean found=false;
        for(int i=0;i< arr.length;i++)
        {
            if(arr[i]==k)
            {
                found=true;
                break;
            }
            count++;
        }
        if(found)
        {
            System.out.println(k+" found after "+count+"  comparisons");
        }
        else
        {
            System.out.println(k+" not found");
        }
    }
}
