/*Given a bunch of baskets in a row, each basket contains few fruits in it.
You can select K number of baskets, one after other.
The selection of basket is either from beginning or from the end the row.

Return the maximum number of fruits you have after K baskets collected.

Input Format:
-------------
Line-1 -> Two integers N and K, N is no of baskets and K is the basket 
count you can pick.
Line-2 -> N space separated integers fruits[], fruits in each basket.

Output Format:
--------------
Print an integer, Maximum num of fruits you can collect.


Sample Input-1:
---------------
7 3
1 2 3 4 5 6 1

Sample Output-1:
----------------
12


Sample Input-2:
---------------
5 3
2 2 2 2 2

Sample Output-2:
----------------
6


Sample Input-3:
---------------
8 3
1 79 80 1 1 1 200 1

Sample Output-3:
----------------
202
*/
import java.util.*;
class max_fruits{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int rem_len=n-k;
        int minn=Integer.MAX_VALUE,ans=0;
        for(int i=0;i<n-rem_len+1;++i){
            int total=0;
            for(int j=i;j<i+rem_len;++j){
                total+=arr[j];
            }
            if(total<minn){
                ans=0;
                for(int j=0;j<i;++j) ans+=arr[j];
                for(int j=i+rem_len;j<n;++j) ans+=arr[j];
                minn=total;
            }
        }
        System.out.println(ans);
        
    }
}
