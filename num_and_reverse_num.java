/*Nagireddy is working with a list of integers list[], all are positive integers.
Nagireddy is defined a pair[p,q] as reserved pair, 
iff the pair[p,q] follows the below rules:
	- In the pair, [p,q] : p and q are indices, and 0 <= p < q < N.
	- Sum of list[p] and reverse(list[q]) and Sum of list[q] and reverse(list[p]) 
	  shoud be equal.

Your task is to help Mr Nagireddy, to find and count the number of reserved pairs 
in the given list of integers, list[].


Input Format:
-------------
Line-1: An integer N, size of the list.
Line-2: N space seperated integers, elements of the list.

Output Format:
--------------
Print an integer, number of reserved pairs.


Sample Input-1:
---------------
5
91 78 23 89 27

Sample Output-1:
----------------
3
87+23=110 23+87=110

Explanation:
------------
The pairs are: [78, 23], [23, 89] and [78, 89]
Pair-1: 78+32 => 87 + 23 => equals 110
Pair-2: 89+32 => 98 + 23 => equals 121
Pair-3: 78+98 => 87 + 89 => equals 176


Sample Input-2:
---------------
5
22 10 36 29 7

Sample Output-2:
----------------
1

Explanation:
------------
The pair is [22, 7]
*/
import java.util.*;
class reserved{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        int[] rev=new int[n];
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
            rev[i]=reverse(arr[i]);
            int num=arr[i]-rev[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int val=entry.getValue();
            if(val>1){
                ans+=((val)*(val-1))/2;
            }
        }
        System.out.println(ans);
    }
    public static int reverse(int num){
        StringBuilder sb=new StringBuilder(String.valueOf(num));
        return Integer.parseInt(sb.reverse().toString());
    }
}