/*Mr Parandhamayya working with words.
He is given a word W, you need to divide the word into N non-empty parts, 
such that all the newly formed words should be distinct, and 
if you append all those words should form original word W.

Your task is to help Mr Parandhamayya to divide the word into N parts,
such that, the value of N should be maximized, and print N.

Input Format:
-------------
Line-1: A string W, a word.

Output Format:
--------------
Print an integer result, the value of N.


Sample Input-1:
---------------
banana

Sample Output-1:
----------------
4

Explanation: 
------------
One way to divide the word is "b","a","n","ana".
If you divide it like "b","a","n","an","a".The word "a" will be repeated.
So it is not allowed to divide like the second way.


Sample Input-2:
---------------
mississippi

Sample Output-2:
----------------
7

Explanation: 
------------
One of the way to divide the word is "m","i","s","si","ssi","p","pi".

NOTE: Subsequences are not allowed.
*/
import java.util.*;
class divide{
    static int ans=Integer.MIN_VALUE;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        Set<String>set=new HashSet<>();
        compute(set,s,n,0);
        System.out.println(ans);
    }
    public static void compute(Set<String>set,String s,int n,int start){
        if(start==n){
            ans=Math.max(ans,set.size());
            return;
        }
        for(int i=start+1;i<=n;++i){
            String sub=s.substring(start,i);
            if(!set.contains(sub)){
                set.add(sub);
                compute(set,s,n,i);
                set.remove(sub);
            }
        }
    }
}
