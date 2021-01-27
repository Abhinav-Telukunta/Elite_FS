/*
Murali playing a mobile game, Blast the letters.

In the game he is given a word W and value R.
Murali has to perform the blasting operation as follows:
	- He has to blast the mimeograph M of length R in W, 
	  a mimeograph is a string such that each letter in it should be same.
	- After blasting the mimeograph, the rest of the string on 
	  its left side and right side, concatenated together.

Murali has to perform the blasting operation repeatedly, 
until no more mimeograph M found.

Your task is to return the final string after all the blast operations have been done.

Input Format:
-------------
Line-1: A string and an integer, W and R.

Output Format:
--------------
Print a string, the final string after all the blast operations have been done.


Sample Input-1:
--------------- 
ababbaaab 3

Sample Output-1:
----------------
aba

Sample Input-2:
--------------- 
caaabbbaacdddd 2

Sample Output-2:
----------------
cabc


 */
import java.util.*;
public class stack_application{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int k=Integer.parseInt(s[1]);
        char[] charr=s[0].toCharArray();
        Stack<Character>stack=new Stack<>();
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=0;i<charr.length;++i){
            if(stack.isEmpty() || charr[i]==stack.peek()){
                stack.push(charr[i]);
                if(arr.size()>0) arr.add(arr.get(arr.size()-1)+1);
                else arr.add(1);
                if(arr.get(arr.size()-1)==k){
                    for(int j=0;j<k;++j) {
                        stack.pop();
                        arr.remove(arr.size()-1);
                    }
                }
            }
            else{
                stack.push(charr[i]);
                arr.add(1);
            }
        }
        StringBuffer sb=new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
