/*Basava interested playing with digits.
He wants create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 6

Sample Output-1:
----------------
[171, 282, 393, 606, 717, 828, 939]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]
*/
import java.util.*;
class equal_diff{
    static Deque<Integer>dq=new ArrayDeque<>();
    static ArrayList<Integer>ans=new ArrayList<>();
    static Set<Integer>set=new HashSet<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int d=sc.nextInt();
        for(int i=1;i<=9;++i) {
            dq.add(i);
            compute(n,d,i,1);
            dq.clear();
        }
        Collections.sort(ans);
        System.out.println(ans);
   
    }
    public static void compute(int n,int d,int digit,int curr){
        if(curr==n){
            String num="";
            for(Integer ele:dq) num+=ele;
            int number=Integer.parseInt(num);
            if(String.valueOf(number).length()==n && !set.contains(number)){
              ans.add(number);
              set.add(number);
            } 
            return;

        }
        if(digit+d<=9) {
            dq.add(digit+d);
            compute(n,d,digit+d,curr+1);
            dq.pollLast();
        }
        if(digit-d>=0){
            dq.add(digit-d);
            compute(n,d,digit-d,curr+1);
            dq.pollLast();
        }
    }
}

