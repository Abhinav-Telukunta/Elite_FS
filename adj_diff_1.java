/*Mr Srikanth is working with numbers.
He wants to find all the AD Numbers,
An AD Number is defined as follows:
	- All the adjacent digits in the given number N 
	should have an absolute difference of 1 only. 

You will be given two integers, start and end,
Your task is to find all the AD Numbers in ascending order
in the range of [start, end], where both are inclusive.

Constarint:
----------
0 <= start < end <2*10^9.

Input Format:
-------------
Two space separated intergers,  start and end.

Output Format:
--------------
Print a list of integers.


Sample Input-1:
---------------
0 15

Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12]


Sample Input-2:
---------------
25 65

Sample Output-2:
----------------
[32, 34, 43, 45, 54, 56, 65]
*/
import java.util.*;
class ad{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int e=sc.nextInt();
        int minlen=String.valueOf(s).length();
        int maxlen=String.valueOf(e).length();
        ArrayList<String>ans=new ArrayList<>();
        if(s<=0 && 0<=e) ans.add("0");
        for(int len=minlen;len<=maxlen;++len){
            for(int i=1;i<=9;++i){
                compute(ans,len,String.valueOf(i),s,e);
            }
        }
        System.out.println(ans);
    }
    public static void compute(ArrayList<String>ans,int len,String curr,int s,int e){
        if(curr.length()==len){
            int num=Integer.parseInt(curr);
            if(s<=num && num<=e) ans.add(curr);
            return;
        }
        int lastChar=curr.charAt(curr.length()-1)-'0';
        if(lastChar-1>=0) compute(ans,len,curr+""+(lastChar-1),s,e);
        if(lastChar+1<=9) compute(ans,len,curr+""+(lastChar+1),s,e);
        
    }
}