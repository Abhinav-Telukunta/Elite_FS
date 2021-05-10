/*Bunny is playing with binary strings.
He wants to divide a binary string B into 3 parts, each part length is >= '1',
when we combine the 3 parts will result the string B.
eg. B is divided as d1, d2, d3. if we combine d1, d2 and d3 should result B.

Your task is to find the number of ways to divide the Binary String B 
into 3 parts, where each part should contain equal number of 1's.

The answer may be too large, return it modulo 10^9 + 7.

Input Format:
-------------
A string B, a binary string B.

Output Format:
--------------
Print an integer, number of ways to break B.


Sample Input-1:
---------------
01010010

Sample Output-1:
----------------
6

Explanation:
------------
There are six ways to break S into 3 parts 
where each part contain the equal number of  1's.
01 | 01 | 0010
01 | 010 | 010
01 | 0100 | 10
010 | 1 | 0010
010 | 10 | 010
010 | 100 | 10


Sample Input-2:
---------------
010010

Sample Output-2:
----------------
0
*/

import java.util.*;
class split_into_three{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char[] ch=s.toCharArray();
        int ones=0;
        for(int i=0;i<ch.length;++i){
            if(ch[i]=='1') ones++;
        }
        if(ones%3!=0) System.out.println(0);
        else if(ones==0) {
        	int len=ch.length;
        	System.out.println((len-1)*(len-2)/2);
        }
        else{
            int num_ones_in_each_part=ones/3;
            int i=0,j=0;
            ones=0;
            int f=0;
            for(int k=0;k<ch.length;++k){
                if(ch[k]=='1') ones++;
                if(ones==num_ones_in_each_part && f==0){
                    i=k;
                    f=1;
                    ones=0;
                }
                else if(ones==num_ones_in_each_part && f==1){
                    j=k;
                    break;
                }
            }
            int after_i_zeros=0;
            for(int k=i+1;k<ch.length;++k){
                if(ch[k]=='0') after_i_zeros++;
                else break;
            }
            int after_j_zeros=0;
            for(int k=j+1;k<ch.length;++k){
                if(ch[k]=='0') after_j_zeros++;
                else break;
            }
            int mod=(int)1e9+7;
            System.out.println(((after_i_zeros+1)*(after_j_zeros+1))%mod);
        }
    }
}
