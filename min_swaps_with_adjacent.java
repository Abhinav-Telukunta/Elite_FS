/*You are given a square box with square cubes in it.
Each cube of size 1*1*1, and colored with either white or blue.
white cube represented by 1 and blue cube represented by 0.

In one operation, You can choose any two adjacent horizontal lines of the box and 
swap them. The box is said to be diagonal box, if all the square cubes 
above the main diagonal are blue colored.

Your task is to find the the minimum number of operations needed to arrange the box 
as diagonal box , if it is not possible to arrange return  -1.

The main diagonal of a box is the diagonal that starts at cube (0, 0) and
ends at cube (n-1, n-1) .

Input Format:
-------------
Line-1: An integer, N size of the box.
Next N lines: N space separated integers, colors of the cubes in the box.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
3
0 1 0
1 0 1
1 0 0

Sample Output-1:
----------------
2


Sample Input-2:
---------------
4
1 1 0 0
1 0 1 0
0 1 0 0
1 0 1 0

Sample Output-2:
----------------
-1
*/
import java.util.*;
class diag{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j) mat[i][j]=sc.nextInt();
        }
        int[] arr=new int[n];
        int k=0;
        for(int[] row:mat){
            int cnt=0;
            int ptr=n-1;
            while(ptr>=0 && row[ptr]==0){
                cnt++;
                ptr--;
            }
            arr[k++]=cnt;
        }
        int ans=0,f=0;
        for(int i=0;i<n;++i){
            if(arr[i]<n-i-1){
                int j=i;
                while(j<n && arr[j]<n-i-1){
                    j++;
                }
                if(j==n){
                    f=1;
                    break;
                }
                while(j>i){
                    int t=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=t;
                    ans++;
                    j--;
                }
            }
        }
        if(f==0) System.out.println(ans);
        else System.out.println(-1);
    }
}