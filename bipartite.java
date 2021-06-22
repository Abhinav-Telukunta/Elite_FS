/*
 In a school, there are N students in a class numbered from 1,2,3..N.
During the play time in school, drill master wants to split them into 
two teams based on their interest.

If the pair of students want to play opposite each other, drill master should 
put them in different teams, e.g. pair[i] = (A,B), it is not allowed to 
put A and B in same team.
 
You need to find out whether is it possible to put everyone into two teams or not
return true if it is possible, otherwise false.

Input Format:
----------------
Line-1 -> Two Integers, N and P, number of students N, number of pairs P.
Next P lines -> Two integers, one pair[i], where 'i' is from 0 to P-1

Output Format:
------------------
Print a boolean result.


Sample Input-1:
-------------------
5 4
1 2
1 3
2 4
3 5

Sample Output-1:
---------------------
true

Explanation: 
----------------
team1 [1,4,5], team2 [2,3]


Sample Input-2:
-------------------
5 5
1 2
2 3
3 4
4 5
1 5

Sample Output-2:
---------------------
false

 */
import java.util.*;
class two_teams{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int[][] graph=new int[n+1][n+1];
        for(int i=0;i<p;++i){
            int u=sc.nextInt();
            int v=sc.nextInt();
            graph[u][v]=1;
        }
        int f=0;
        parent:for(int node=1;node<=n;++node){
            int[] color=new int[n+1];
            Arrays.fill(color,-1);
            Queue<Integer>queue=new LinkedList<Integer>();
            queue.add(node);
            color[node]=0;
            while(!queue.isEmpty()){
                int u=queue.poll();
                if(graph[u][u]==1) {
                    f=1;
                    break parent;
                }
                for(int v=1;v<=n;++v){
                    if(graph[u][v]==1 && color[v]==-1){
                        color[v]=1-color[u];
                        queue.add(v);
                    }
                    else if(graph[u][v]==1 && color[v]==color[u]){
                        f=1;
                        break parent;
                    }
                }
            }
        }
        System.out.println(f==0?true:false);
    }
}