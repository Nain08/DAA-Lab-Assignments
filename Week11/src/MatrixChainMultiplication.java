import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixChainMultiplication
{
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\IdeaProjects\\DAA\\Week11\\src\\MatrixChainInput");
        Scanner scan = new Scanner(file);
        int n=scan.nextInt();
        int p[]=new int[n+1];

        for(int i=0;i<n;i++)
        {
            int row= scan.nextInt();
            int col=scan.nextInt();
            p[i]=row;
            if(i==n-1)
                p[i+1]=col;
        }
        matrixChainOrder(p,n+1);

    }
    public static void matrixChainOrder(int p[],int n)
    {
        int[][] m =new int[n][n];
        int i,j,k,L,q;
        for(i=1;i<n;i++)
            m[i][i] = 0;
        for(L=2;L<n;L++)
        {
            for(i=1;i<n-L+1;i++)
            {
                j=i+L-1;
                if(j==n)
                    continue;
                m[i][j]=Integer.MAX_VALUE;
                for(k=i;k<=j-1;k++)
                {
                    q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q<m[i][j])
                        m[i][j]=q;
                }
            }
        }
        System.out.println(m[1][n-1]);
    }
}
