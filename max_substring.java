/*For this challenge, a substring is defined as any contiuous group of one or more 
characters of a string. For example, the unique substrings of "baca" are [b, ba, 
bac, baca, a, ac, aca, c ,ca] . The list in alphabetical order is [a, ac, aca, b, 
ba, bac, baca, c, ca]. in this case, the maximum substrin, alphabetically, is 'ca'.

Given a string s, determine its maximum substring.

Your task is to design a function, that return the maximum substring of s.

NOTE:
String s contains only lowercase alphabets.

Input Format:
-------------
A string, s

Output Format:
--------------
print a string, maximum substring.


Sample Input-1:
---------------
baca

Sample Output-1:
----------------
ca


Sample Input-2:
---------------
banana

Sample Output-2:
----------------
nana

*/
import java.util.*;
public class max_substring{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        char ch='a';
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)>ch) ch=s.charAt(i);
        }
        ArrayList<Integer>index=new ArrayList<>();
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)==ch) index.add(i);
        }
        String ans="";
        for(int i=0;i<index.size();++i){
            if(s.substring(index.get(i)).compareTo(ans)>0){
                ans=s.substring(index.get(i));
            }
        }
        System.out.println(ans);
        
    }
}
