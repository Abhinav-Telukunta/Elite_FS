/*Babylonians invented muliplication of numbers.

You will be given two strings consist of digits only.
You have to perform the multiplication of these two strings using 
Babylonians approach, and return the result of multiplication of two strings.


Input Format:
-------------
Two space separated strings, num1 and num2.

Output Format:
--------------
Print the product of two strings num1 and num2.


Sample Input-1:
---------------
5 4 

Sample Output-1:
----------------
20


Sample Input-2:
---------------
121 432 

Sample Output-2:
----------------
52272

Note:
-----
	- Input should contain digits only, and should not contain leading 0's except 0.
	- Output will be in the range of integer only.
	- There will be no leading minus '-' symbol also.
	- Should not use built-in BigInteger library.
	- Should not convert the given strings into integers.
*/
import java.util.*;
class multiply{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        String ans=evaluate(s1,s2);
        System.out.println(ans);
    }
    public static String evaluate(String s1,String s2){
        int len1=s1.length(),len2=s2.length();
        int pos1=0,pos2=0;
        int[] arr=new int[len1+len2];
        for(int idx2=len2-1;idx2>=0;--idx2){
            int num1=s2.charAt(idx2)-'0';
            int carry=0;
            pos1=0;
            for(int idx1=len1-1;idx1>=0;--idx1){
                int num2=s1.charAt(idx1)-'0';
                int total=num1*num2+carry+arr[pos1+pos2];
                arr[pos1+pos2]=total%10;
                carry=total/10;
                pos1++;
            }
            if(carry>0) arr[pos1+pos2]+=carry;
            pos2++;
        }
        int i=arr.length-1;
        while(i>=0 && arr[i]==0) i--;
        if(i==-1) return "0";
        String ans="";
        for(int j=i;j>=0;--j) ans+=arr[j];
        return ans;
    }
}
