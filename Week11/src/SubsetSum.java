import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubsetSum
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week11\\src\\SubsetSumInput");
        Scanner scan = new Scanner(file);
        int size=scan.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=scan.nextInt();
        }
        boolean result=canPartition(arr);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    public static boolean canPartition(int[] nums)
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        sum=sum/2;
        int n=nums.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int j=1;j<=sum;j++)
        {
            dp[0][j]=false;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(j<nums[i-1])
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
            }
        }
        return dp[n][sum];
    }
}
