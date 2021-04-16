/*You are decorating a side wall with balloons.
You have an unlimited set of ballons of three different colors.

The decoration should have N rows of 3 balloons each. 
You have to make sure that no two adjacent balloons have the same colour.
both vertically and horizontally.

Return the number of ways you can decorate the wall,  
the answer must be computed modulo 10^9 + 7

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer as outpur, number of ways to decorate.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
12

Explanation:
------------
Suppose the colors are, B, G, R. Given N is 1
RBR	BRB	GRB
RBG	BRG	GRG
RGR	BGR	GBR
RGB	BGB	GBG


Sample Input-2:
---------------
2

Sample Output-2:
----------------
54

*/
import java.util.*;
public class max_decoration_ways{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] two=new long[n];
        long[] three=new long[n];
        long mod=(long)1e9+7;
        two[0]=three[0]=6;
        for(int i=1;i<n;++i){
            two[i]=(3*two[i-1]+2*three[i-1])%mod;
            three[i]=(2*two[i-1]+2*three[i-1])%mod;
        }
        System.out.println((int)((two[n-1]+three[n-1])%mod));
    }
}