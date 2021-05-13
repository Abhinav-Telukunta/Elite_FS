/*Kohinoor diamond is robbed by Hrithik,
He kept the diamond in a suitcase, the suitcase has a lock with 4 circular wheels, 
and each wheel consist of 0-9 digits in the order 0,1,2,3,4,5,6,7,8,9 only.
You can rotate a wheel from 0 to 9 or 9 to 0.

As the diamond is most valuable, the lock has some traps,
if anybody try to unlock the suitcase and reached any one of the traps,
the suitcase will be blasted. And you will be dead.

Initially, the suitcase lock is set to 0000.
and you will be given the unlock key, your task to find and print
the minimum number of rotations required to unlock the suitcase.
If it is not possible to unlock the suitcase without blasting, print -1.

NOTE:
In one rotation you can choose any one wheel and 
rotate to its next or previous digit.


Input Format:
-------------
Line-1: space separated strings, each string of length 4 and contains only digits [0-9]
Line-2: A string, key to unlock.

Output Format:
--------------
Print an integer, the minimum number of rotations required to unlock.


Sample Input-1:
---------------
0302 0202 0203 2323 3003
0303 

Sample Output-1:
----------------
8

Explanation:
------------
To unlock the suitcase the valid rotations are as follows:
0000 > 1000 > 1100 > 1200 > 1201 > 1202 > 0202 > 0302 > 0303.


Sample Input-2:
---------------
6656 6676 6766 6566 5666 7666 6665 6667
6666 

Sample Output-2:
----------------
-1

Explanation:
------------
You can't unlock the suitcase.
*/
import java.util.*;
class unlock{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        Set<String>traps=new HashSet<>();
        for(String sub:s) traps.add(sub);
        String dest=sc.next();
        if(traps.contains("0000")){
            System.out.println(-1);
            System.exit(0);
        }
        Set<String>visited=new HashSet<>();
        Queue<String>queue=new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int count=0,f=0;
        parent:while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;++i){
                String pattern=queue.poll();
                if(pattern.equals(dest)){
                    f=1;
                    break parent;
                }
                for(int j=0;j<4;++j){
                    char ch=pattern.charAt(j);
                    String plus=pattern.substring(0,j)+(ch=='9'?"0":""+(char)(ch+1))+pattern.substring(j+1);
                    String minus=pattern.substring(0,j)+(ch=='0'?"9":""+(char)(ch-1))+pattern.substring(j+1);
                    if(!visited.contains(plus) && !traps.contains(plus)){
                        queue.add(plus);
                        visited.add(plus);
                    } 
                    if(!visited.contains(minus) && !traps.contains(minus)){
                        queue.add(minus);
                        visited.add(minus);
                    }
                }
            }
            count++;
        }
        if(f==1) System.out.println(count);
        else System.out.println(-1);
    }
}
