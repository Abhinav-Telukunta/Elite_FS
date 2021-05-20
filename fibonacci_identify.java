/*Pramod is working on Strings consist of digits only. 
He wants to findout, whether the given string can form Fibonacci sequence or not.

A String can form a Fibonacci Sequence, if it contains at least three numbers,
and numbers are in the following order:
first, second, third  = first + second, fourth = third + second, .. so on.

Return true, if the given string can form fibonacci sequence,
otherwise, return false.

Note: Numbers in the fibonacci sequence contains no leading 0's.
for example, 2, 03,5 or 2,3,05 or 02,3,5 are not valid.

Input Format:
-------------
A String consist of digits only

Output Format:
--------------
Print a boolean value as result.


Sample Input-1:
---------------
23581321

Sample Output-1:
----------------
true

Explanation: 
------------
Fibonacci Sequence is : 2, 3, 5, 8, 13, 21
2, 3, 2+3=5, 3+5=8, 5+8=13, 8+13=21.

Sample Input-2:
---------------
199100199

Sample Output-2:
----------------
true

Explanation: 
------------
Fibonacci Sequence is : 1 99 100 199
1, 99, 1+99=100, 99+100=199.
*/
import java.util.*;
class fib{
    static Stack<Long>stack=new Stack<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        boolean ans=compute_fibonacci(s,0,0,s.length()/2,s.length());
        System.out.println(ans);
    }
    public static boolean compute_fibonacci(String s,int idx,int count,int end,int n){
        if(count==2){
            long second=stack.pop();
            long first=stack.peek();
            stack.push(second);
            int f=0;
            while(idx<n){
                long num=first+second;
                String eq=String.valueOf(num);
                int len=eq.length();
                if(!s.substring(idx,Math.min(n,idx+len)).equals(eq)){
                    f=1;
                    break;
                }
                first=second;
                second=num;
                idx=idx+len;
                
            }
            return f==0?true:false;
        }
        for(int i=idx;i<end;++i){
            String sub=s.substring(idx,i+1);
            stack.push(Long.parseLong(sub));
            if(compute_fibonacci(s,i+1,count+1,n/2,n)) return true;
            stack.pop();
        }
        return false;
    }
}
