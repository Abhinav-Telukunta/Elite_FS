/*Mr Nagireddy working with statements.
Each statement consists of only lowercase alphabets and whitespaces, 
and each statement neither starts nor ends with a whitespace
and each word in the statement separated by a single whitespace only.

Mr Nagireddy's task is to perform the join operation on these statements:
The joining operations is performed as follows:
	- If the last word of a statement-1 and first word of statement-2 are same,
	then you can join the statements-1 & statement-2 and 
	the joining word will appears once in the result statement.
	- It is not allowed to join the statements with itself.
Note that the order of joining the statements matters.

You will be given N statements.
Your task is to help Mr Nagireddy to join the statements, and 
return them as a list of distinct statements in lexicographic order.


Input Format:
-------------
Line-1: An integer N, number of statements.
Next N lines: Single line String, the statement with one or more words.

Output Format:
--------------
Print the list of strings, the joined statements.


Sample Input-1:
---------------
3
write the code
code in java
java code

Sample Output-1:
----------------
[code in java code, java code in java, write the code in java]


Sample Input-2:
---------------
4
programming language
language is java
language is python
java is based on oops concepts

Sample Output-2:
----------------
[language is java is based on oops concepts, 
programming language is java, 
programming language is python]


Sample Input-3:
---------------
3
A B C
B C A
C A B

Sample Output-3:
----------------
[A B C A B, B C A B C, C A B C A]

NOTE: You have to print the list in a single line.

*/
import java.util.*;
class map_app{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        String[] sentences=new String[n];
        for(int i=0;i<n;++i) sentences[i]=sc.nextLine();
        ArrayList<String>ans=new ArrayList<>();
        Map<String,ArrayList<String>>start=new HashMap<>();
        for(String sub:sentences){
            start.computeIfAbsent(sub.split(" ")[0],x->new ArrayList()).add(sub);
        }
        for(String sub:sentences){
            String[] words=sub.split(" ");
            String last=words[words.length-1];
            if(start.get(last)!=null){
                for(String next:start.get(last)){
                    String res=sub;
                    int idx=next.indexOf(" ");
                    if(idx==-1) ans.add(res);
                    else {
                        res+=" ";
                        res+=next.substring(idx+1);
                        ans.add(res);
                    }
                }
            }
        }
        Collections.sort(ans);
        System.out.println(ans);
        
        
    }
}
