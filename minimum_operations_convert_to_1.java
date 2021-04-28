/*Sampoornesh Babu is learning arithmatics.
His teacher given him a task to find the minimum number of operations
required to convert a given integer I to 1.

Sampoornesh is allowed to perform the following operations:
	- If I is even, convert I with I/2 .
	- In I is odd, convert I with either I+1 or I-1.

Now it's your task to help Sampoornesh Babu to find and print
the minimum number of operations required.

Input Format:
-------------
An integer I.

Output Format:
--------------
Print an integer, the minimum number of operations required.


Sample Input-1:
---------------
10

Sample Output-1:
----------------
4

Explanation:
------------
10 -> 5 -> 4-> 2 -> 1.


Sample Input-2:
---------------
15

Sample Output-2:
----------------
5

Explanation:
------------
15 -> 16 -> 8 -> 4 -> 2 -> 1.
*/
import java.util.*;
class min_operations{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Integer>map=new HashMap<>();
        int ans=convert(map,n);
        System.out.println(ans);
    }
    public static int convert(Map<Integer,Integer>map,int num){
        if(map.get(num)!=null) return map.get(num);
        else if(num==1){
            map.put(num,0);
            return 0;
        }
        else if(num>0 && num%2==0) {
            int count=convert(map,num/2)+1;
            map.put(num,count);
            return count;
        }
        else if(num>0 && num%2!=0) {
            int count=Math.min(convert(map,num+1),convert(map,num-1))+1;
            map.put(num,count);
            return count;
        }
        return Integer.MAX_VALUE;
    }
}