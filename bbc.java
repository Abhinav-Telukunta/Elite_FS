/*Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I

Output Format:
--------------
Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
*/

import java.util.*;
class bbc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int low=1,high=2,digit=1;
        for(;;){
            if(num>=low && num<=high) break;
            else{
               digit++;
               low=high+1;
               high=low*2;
            }
        }
        int res=num-low;
        String temp=Integer.toBinaryString(res);
        int rem=digit-temp.length();
        String ans="";
        for(int i=0;i<rem;++i) ans+="0";
        ans+=temp;
        System.out.println(ans);
    }
}