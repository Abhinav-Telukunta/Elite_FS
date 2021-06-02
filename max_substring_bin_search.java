/*Charlie Brown is working with strings,
He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

MaxSub is a substring which appears atleast twice in S with Maximum length. 

Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
and print the length of MaxSub. If there is MaxSub, return 0.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, length of MaxSub


Sample Input-1:
---------------
babababba

Sample Output-1:
----------------
5

Explanation: 
------------
The Maximum substring is 'babab' , which occurs 2 times.


Sample Input-2:
---------------
abbbbba

Sample Output-2:
----------------
4

Explanation: 
------------
The Maximum substring is 'bbbb' , which occurs 2 times.


Sample Input-3:
---------------
vignesh

Sample Output-3:
----------------
0

*/
import java.util.*;
class max_substring_bin_search{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int low=0,high=s.length();
        while(low<=high){
            int mid=(low+high)/2;
            Map<String,Integer>map=new HashMap<>();
            for(int i=0;i<n-mid+1;++i){
                String substr=s.substring(i,i+mid);
                map.put(substr,map.getOrDefault(substr,0)+1);
            }
            int f=0;
            for(Map.Entry<String,Integer>entry:map.entrySet()){
                if(entry.getValue()>=2){
                    f=1;
                    break;
                }
            }
            if(f==0) high=mid-1;
            else low=mid+1;
        }
        System.out.println(low-1);
    }
}