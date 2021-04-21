/*Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]
*/
import java.util.*;
class expression{
    static ArrayList<String>ans=new ArrayList<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        ArrayList<ArrayList<String>>arr=new ArrayList<ArrayList<String>>();
        int n=ch.length;
        int f=0;
        ArrayList<String>temp=new ArrayList<>();
        String str="",str1="";
        for(int i=0;i<n;++i){
            if(ch[i]=='[') {
                f=1;
                if(!str1.equals("")){
                    ArrayList<String>t=new ArrayList<>();
                    t.add(str1);
                    arr.add(t);
                    str1="";
                }
            }
            else if(f==1 && ch[i]!='[' && ch[i]!=']'){
                str+=ch[i];
            }
            else if(ch[i]==']'){
                f=0;
                String[] parts=str.split(",");
                for(String part:parts) temp.add(part);
                arr.add(new ArrayList(temp));
                temp.clear();
                str="";
            }
            else str1+=ch[i];
        }
        if(!str1.equals("")){
            ArrayList<String>t=new ArrayList<>();
            t.add(str1);
            arr.add(t);
            str1="";
            f=1;
        }
        dfs(arr,"",0,arr.size());
        Collections.sort(ans);
        System.out.println(ans);
    }
    public static void dfs(ArrayList<ArrayList<String>>arr,String s,int index,int n){
        if(index==n){
            ans.add(s);
            return;
        }
        ArrayList<String>sub=arr.get(index);
        for(int i=0;i<sub.size();++i){
            String temp=new String(s);
            s+=sub.get(i);
            dfs(arr,s,index+1,n);
            s=temp;
        }
    }
}
