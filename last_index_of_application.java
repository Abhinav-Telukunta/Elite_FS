/*
Pramod is working on words. He used to remove all the duplicate letters from a
word.

Pramod is given a word W. His task to remove all the duplicated letters from W,
in such a way that the resulatant word R, contains no duplicate letters and all
distinct letters from W should be there in R.and R should appear first in the 
dictionary order. 

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resulatant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb

Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos    */
import java.util.*;
class last_index_of_application{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        Map<Character,Integer>map=new HashMap<>();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(map.get(ch)==null) map.put(ch,s.lastIndexOf(ch));
        }
        Set<Character>set=new HashSet<>();
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(!set.contains(ch)){
                while(!stack.isEmpty() && ch<stack.peek() && map.get(stack.peek())>i){
                    set.remove(stack.pop());
                }
                stack.push(ch);
                set.add(ch);
            }
        }
        StringBuffer sb=new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}