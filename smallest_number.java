/*Somesh is working on Number Strings.
He got an idea to find the smallest possible number by 
deleting some digits from the number without changing 
the relative order of digits in it.

You will be given a integer String 'num', and an integer n.
Find the smallest number possible after deleting n digits from 'num'.

Note: If the number string 'num' turns to empty, print 0.

Input Format:
-------------
Line-1 : A string num, consist of digits only.
Line-2 : An integer n, number of digits to delete.

Output Format:
--------------
Print the smallest possible number.


Sample Input-1:
---------------
1432219
3

Sample Output-1:
----------------
1219

Explanation: 
------------
Delete the three digits 4, 3, and 2 to form the smallest number 1219.

Sample Input-2:
---------------
10200
1

Sample Output-2:
----------------
200

Explanation:
------------
Delete the leading 1 and the smallest number is 200. 
Note that the output must not contain leading zeroes.

*/
import java.util.*;
public class smallest_number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();++i) arr[i]=s.charAt(i)-'0';
        int n=arr.length;
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<arr.length;++i){
            while(!stack.isEmpty() && arr[i]<stack.peek() && i-k<stack.size()) stack.pop();
            if(stack.size()<n-k) stack.push(arr[i]);
        }
        StringBuffer sb=new StringBuffer();
        while(!stack.isEmpty()) sb.append(stack.pop());
        if(sb.length()==0) System.out.println("0");
        String res=sb.reverse().toString();
        int idx=0,flag=0;
        for(int i=0;i<res.length();++i){
            if(res.charAt(i)!='0'){
                idx=i;
                flag=1;
                break;
            }
        }
        if(flag==0) System.out.println("0");
        else System.out.println(res.substring(idx));
    }
}
