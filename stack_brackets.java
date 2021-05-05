/*Subodh is interested in playing with Strings,
For a given String 'S', Subodh applies some rules to find the value of 'S'.
The rules are as follows:
	- If it is a balanced [] has value 1
	- XY has value X + Y , where X and Y are balanced [] strings.
	- [Z] has score 2 * Z , where Z is a balanced parentheses string.
	
Find out the value of given String and print it.

Note: All the given strings are balanced

Input Format:
----------------
A String contains only '[', ']'


Output Format:
------------------
Print an integer as result.


Sample Input-1:
-------------------
[]

Sample Output-1:
---------------------
1

Sample Input-2:
-------------------
[[]]

Sample Output-2:
---------------------
2

Sample Input-3:
-------------------
[[][[]]]

Sample Output-3:
---------------------
6
*/
import java.util.*;
class balanced{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        Stack<Character>stackChar=new Stack<>();
        Stack<Integer>stackInt=new Stack<>();
        int score=0;
        for(int i=0;i<ch.length;++i){
            if(ch[i]=='['){
                stackChar.push('[');
                stackInt.push(score);
                score=0;
            }
            else{
                stackChar.pop();
                score=stackInt.pop()+Math.max(2*score,1);
            }
        }
        System.out.println(score);
    }
}
