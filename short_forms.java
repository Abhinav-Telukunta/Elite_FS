/*Now a days, everyone is used type the words using short-forms,
A short-form can be created by replacing non-intersected substrings 
with their respective lengths.

e.g., elite can be written as follows:
    - e3e (by replacing lut with 3), 
    - el2e (by replacing it with 2), 
    - 3t1 (by replacing eli and e with 3 and 1).
etc.


You will be given a word.
Your task is to find all possible short-fomrs of the given word, 
and print them as a list of lexicographic order.


Input Format:
-------------
A string W, the word.

Output Format:
--------------
Print the list of possible short-forms of W in lexographic order. 


Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[4, 3t, 2i1, 2it, 1m2, 1m1t, 1mi1, 1mit, k3, k2t, k1i1, k1it, km2, km1t, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[3, 2e, 1s1, 1se, c2, c1e, cs1, cse]
*/

import java.util.*;
class short_forms{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        int n=word.length();
        ArrayList<String>ans=new ArrayList<>();
        ans.add(word);
        ArrayList<String>indexes=new ArrayList<>();
        for(int i=0;i<n;++i){
            indexes.add(String.valueOf(i));
            generate_short(word,ans,indexes);
            indexes.clear();
        }
        Collections.sort(ans);
        System.out.println(ans);
    }
    public static void generate_short(String word,ArrayList<String>ans,ArrayList<String>indexes){
        String temp=new String(word);
        char[] ch=temp.toCharArray();
        for(int i=0;i<indexes.size();++i){
            int idx=Integer.parseInt(indexes.get(i));
            ch[idx]='*';
        }
        int count=0;
        String res="";
        for(int i=0;i<ch.length;++i){
            if(ch[i]=='*') count++;
            else if(count!=0){
                res+=count;
                count=0;
            }
            if(ch[i]!='*') res+=ch[i];
        }
        if(count!=0) res+=count;
        ans.add(res);
        int num=Integer.parseInt(indexes.get(indexes.size()-1));
        for(int i=num+1;i<word.length();++i){
            indexes.add(String.valueOf(i));
            generate_short(word,ans,indexes);
            indexes.remove(indexes.size()-1);
        }
    }
}
