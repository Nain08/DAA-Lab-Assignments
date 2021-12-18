import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SumEqualKey
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week5\\src\\SumInput");
        Scanner scan = new Scanner(file);
        int testCases = scan.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scan.nextInt();
            int arr[] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = scan.nextInt();
            }
            int sum=scan.nextInt();
            Arrays.sort(arr);
            findKey(arr,sum);
        }
    }
    public static void findKey(int arr[],int sum)
    {
        int low = 0;
        int high = arr.length - 1;
        boolean flag=false;
        while (low < high)
        {
            if (arr[low] + arr[high] == sum) {
                System.out.println("The pair is : (" + arr[low] + ", " + arr[high] + ")");
                flag=true;
            }
            if (arr[low] + arr[high] > sum) {
                high--;
            }
            else {
                low++;
            }
        }
        if(flag==false)
            System.out.println("No such pair exist");
    }
}
