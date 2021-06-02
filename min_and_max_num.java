/*Shaggy Rogers is working with numbers.
He is given a number N, 
He wants to replace all occurrences of a digit in the number N,
with another digit between [0-9]. May be with same number too.

But there should not be any leading zeros in the number after the replacement,
Or the number should not become zero.

Rogers can perform the replacement of the occurrences of the digit in N for two 
times, He will generate two new numbers P and Q, such that the value of |P-Q| 
should be Maximum.

Your task is to help Shaggy Roers to find the maximum difference of P and Q possible.


Input Format:
-------------
An integer N, the number

Output Format:
--------------
Print an integer, the maximum difference of P and Q


Sample Input-1:
---------------
123

Sample Output-1:
----------------
820

Explanation:
------------
Replacement-1: replace 1 with 9 you will get P as 923
Replacement-2: replace 2 with 0 you will get Q as 103
So Max difference is 820.


Sample Input-2:
---------------
4254

Sample Output-2:
----------------
8008

Explanation:
------------
Replacement-1: replace 4 with 9 you will get P as 9259
Replacement-2: replace 4 with 1 you will get Q as 1251
So Max difference is 8008.
*/
import java.util.*;
class number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        char[] min=new char[n];
        char[] max=new char[n];
        for(int i=0;i<n;++i){
            min[i]=s.charAt(i);
            max[i]=s.charAt(i);
        }
        int numrmax=9;
        for(int i=0;i<n;++i){
            if(max[i]!='9'){
                numrmax=max[i];
                break;
            }
        }
        int numrmin=0,num=0;
        char rep='0';
        for(int i=0;i<n;++i){
            if(min[i]!='0'){
                if(i==0 && min[i]=='1'){
                    num=min[i];
                    continue;
                }
                else if(i==0){
                    numrmin=min[i];
                    rep='1';
                    break;
                }
                else if(min[i]!=num){
                    numrmin=min[i];
                    break;
                }
            }
        }
        for(int i=0;i<n;++i){
            if(max[i]==numrmax) max[i]='9';
        }
        for(int i=0;i<n;++i){
            if(min[i]==numrmin) min[i]=rep;
        }
        int num1=Integer.parseInt(new String(max));
        int num2=Integer.parseInt(new String(min));
        //System.out.println(num1+" "+num2);
        System.out.println(num1-num2);
        
        
    }
}
