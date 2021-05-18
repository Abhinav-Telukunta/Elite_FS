/*Given a set of N batteries with some voltages[], the voltage can be '+ve' or '-ve',
and you need to setup a perticular voltage V.

Your task is to check if the sum of voltages of contiguous subset of batteries
is equal to the required voltage V and the batteries in the subset should be 
maximum in count. If such subset is found print the count of batteries in it.
Otherwise, print 0.

Input Format:
-------------
Line-1 : Two integers N and V, number of batteries and required voltage.
Line-2 : N space separated integers, voltages of N batteries.

Output Format:
--------------
Print an integer, maximum count of batteries in a contiguous subset 
whose voltages sum is equal to V.


Sample Input-1:
---------------
5 3
2 -2 7 -4 3

Sample Output-1:
----------------
4

Explanation:
--------------
The sum of contiguous subset of batteries with volates: [2, -2, 7, -4] is equals 3.
and it is the maximum.

Sample Input-2:
---------------
4 2
-5 -3 5 3

Sample Output-2:
----------------
2

Explanation: 
------------
The sum of contiguous subset of batteries with volates: [-3, 5] is equals 2.
and it is the maximum.
*/

import java.util.*;
class subarray_equal_k{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int len=0;
        Map<Integer,Integer>map=new HashMap<>();
        int sum=0,max_len=0;
        for(int i=0;i<n;++i){
            sum+=arr[i];
            if(sum==k) max_len=i+1;
            if(map.get(sum)==null) map.put(sum,i);
            if(map.get(sum-k)!=null) max_len=Math.max(max_len,i-map.get(sum-k));
        }
        System.out.println(max_len);
    }
}