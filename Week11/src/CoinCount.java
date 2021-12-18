import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoinCount
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week11\\src\\CoinInput");
        Scanner scan = new Scanner(file);
        int size=scan.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=scan.nextInt();
        }
        int amount=scan.nextInt();
        count(arr,size,amount);
    }

    private static void count(int[] arr, int size, int amount)
    {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is constructed
        // in bottom up manner using the base case (n = 0)
        int table[]=new int[amount+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<size; i++)
            for(int j=arr[i]; j<=amount; j++)
                table[j] += table[j-arr[i]];

        System.out.println(table[amount]);
    }
}
