import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Intersection
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week5\\src\\IntersectionInput");
        Scanner scan = new Scanner(file);
        int size1 = scan.nextInt();
        int arr1[] = new int[size1];
        for (int i = 0; i < size1; i++)
        {
            arr1[i] = scan.nextInt();
        }
        int size2 = scan.nextInt();
        int arr2[] = new int[size2];
        for (int j = 0; j < size2; j++)
        {
            arr2[j] = scan.nextInt();
        }
        intersection(arr1,size1,arr2,size2);
    }
    public static void intersection(int arr1[],int size1,int arr2[],int size2)
    {
        int i=0,j=0;
        while(i<size1&&j<size2)
        {
            if(arr1[i]<arr2[j])
            {
                i++;
            }
            else if(arr1[i]>arr2[j])
            {
                j++;
            }
            else
            {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
        }
    }
}

