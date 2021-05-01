/*You are given a phrase and a paper of size m*n.
So you can type exactly m * n characters on that paper.
i.e,. there are 'm' rows and in each row you can type 'n' characters
You need to type the phrase on the paper with some rules.

The rules are as follows:
    - A word in the phrase cannot be split into two lines.
    - The order of words in the phrase shuld not change.
    - Two consecutive words in a line must be separated by a single space.

Your task is to find out how many times the phrase can be typed on the paper.

constraint:
	Length of each word is <=10.

Input Format:
-------------
Line-1: Three space separated integers m, n, and s, grid size m*n, number of words.
Line-2: 's' space separated strings, set of words

Output Format:
--------------
Print an integer, no.of times set of words fit into the grid.


Sample Input-1:
---------------
2 8 2
social distance

Sample Output-1:
----------------
1

Explanation:
------------
social__
distance


Sample Input-2:
---------------
3 6 3
a bc def

Sample Output-2:
----------------
2

Explanation:
------------
a_bc__
def_a_
bc_def
*/
import java.util.*;
class phrases{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int n=sc.nextInt();
        sc.nextLine();
        String[] s=sc.nextLine().split(" ");
        int ans=0,f=0;
        for(String sub:s){
            if(sub.length()>c){
                f=1;
                break;
            }
        }
        if(f!=1){
            int row=0,ptr=0,rem_space=c;
            while(row<r){
                int len=s[ptr].length();
                if(len>rem_space){
                    rem_space=c;
                    row++;
                }
                if(row<r){
                    rem_space=rem_space-(len+1);
                }
                ptr=(ptr+1)%n;
                if(ptr==0) ans++;
            }
        }
        System.out.println(ans);
        
    }
}
