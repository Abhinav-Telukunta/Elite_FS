/*

Ananth interested in creating the acronyms for any word.
The definition of acronym is another word with a concatenation of its first letter,
 the number of letters between the first and last letter, and its last letter. 
 
 If a word has only two characters, then it is an acronym of itself.
 
 Examples:
	- Acronym of 'dog' is 'd1g'.
	- Acronym of 'another' is 'a5r'.
	- Acronym of 'ab' is 'ab'.

You are given a list of vocabulary, and another list of words.
Your task is to check is word with the vocabulary and
return "true" if atleast one of the following rules satisfied:
	1. acronym of the word should not match with any of the acronyms of vocabulary
	2. if acronym of the word matches with any of the acronyms of vocabulary
	'the word' and matching words in vocabulary should be same.
Otherwise, return 'false'.

Input Format:
-------------
Line-1: Space separated strings, vocabulary[] 
Line-2: Space separated strings, words[] 

Output Format:
--------------
Print N boolean values, where N = words.length. 


Sample Input-1:
---------------
cool bell cool coir move more mike
cool char move 

Sample Output-1:
----------------
true false false


 */
import java.util.*;
public class acronym{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] vocab=sc.nextLine().split(" ");
        String[] words=sc.nextLine().split(" ");
        Map<String,ArrayList<Integer>>map=new HashMap<>();
        int idx=0;
        for(String s:vocab){
            String acr=s.charAt(0)+"";
            int len=s.length()-2;
            if(len>0) acr+=len;
            acr+=s.charAt(s.length()-1)+"";
            if(map.get(acr)!=null){
                ArrayList<Integer>temp=map.get(acr);
                temp.add(idx);
                map.put(acr,temp);
            }
            else{
                ArrayList<Integer>temp=new ArrayList<Integer>();
                temp.add(idx);
                map.put(acr,temp);
            }
            idx++;
        }
        for(String s:words){
            String acr=s.charAt(0)+"";
            int len=s.length()-2;
            if(len>0) acr+=len;
            acr+=s.charAt(s.length()-1)+"";
            if(map.get(acr)==null) System.out.print(true+" ");
            else{
                int flag=0;
                ArrayList<Integer>arr=map.get(acr);
                for(int index:arr){
                    if(!vocab[index].equals(s)) {
                        System.out.print(false+" ");
                        flag=1;
                        break;
                    }
                }
                if(flag==0) System.out.print(true+" ");
            }
            
        }
    }
}
