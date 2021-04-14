/*Ashok is given an array of integers nums.
His task is to find the longest contiguous subsequence S, 
the product of all the numbers in the subsequence should be positive.

Return the length of longest contiguous subarray.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous subsequence


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4
*/
import java.util.*;
public class longest_subarray_length_with_positive_product{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;++i) arr[i]=Integer.parseInt(s[i]);
        int len=0,neg=0,pos=0;
        for(int i=0;i<arr.length;++i){
            if(arr[i]>0){
                pos++;
                if(neg!=0) neg++;
                len=Math.max(len,pos);
            }
            else if(arr[i]<0){
                int t=pos;
                pos=neg;
                neg=t;
                neg++;
                if(pos!=0) pos++;
                len=Math.max(len,pos);
            }
            else{
                pos=0;
                neg=0;
            }
        }
        System.out.println(len);
    }
}
