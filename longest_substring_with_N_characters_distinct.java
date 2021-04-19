/*Kiran is given a string S, and an integer N.
Kiran wants to find the longest substring which has following properties:
	- the substring of S should be maximum in length, and 
	- should contains atmost N distint characters in it.
	
Can you help Kiran to find the longest substring 'ls' with above properties,
and return the length of the substring 'ls'.

Input Format:
-------------
Line-1: A string S
Line-2: An integer N, number of distinct characters.

Output Format:
--------------
Print an integer, lenth of longest substring with atmost N distinct characters.


Sample Input-1:
---------------
philippines
3

Sample Output-1:
----------------
6

Sample Input-2:
---------------
abaccdbcca
2

Sample Output-2:
----------------
3
*/
import java.util.*;
public class longest_substring_with_N_characters_distinct{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int N=sc.nextInt();
        Deque<Character>dq=new ArrayDeque<>();
        int count=0,ans=0;
        for(int i=0;i<s.length();++i){
            if(dq.contains(s.charAt(i))){
                dq.add(s.charAt(i));
                ans=Math.max(ans,dq.size());
            }
            else{
                if(count+1<=N){
                    dq.add(s.charAt(i));
                    count++;
                }
                else{
                    while(!(count+1<=N)){
                        if(dq.size()>0){
                            char ch=dq.pollFirst();
                            if(!dq.contains(ch)) count--;
                        }
                    }
                    dq.add(s.charAt(i));
                    count++;
                }
                ans=Math.max(ans,dq.size());
            }
        }
        System.out.println(ans);
    }
}