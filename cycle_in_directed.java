/*There are N cities in a state.
The cities are connected with roadways. All the roadways are unidirectional.
There can be self roadways to a city, and parallel routes between two cities.

You are given the lists of R roadways[], where roadways[i]=[p,q]
indicates there is a roadway connecting city-p and city-q.
where 0 <= p < N, and 0 <= q < N and 0 <= i < R.

You are given two city numebrs S and D.
Your task is to find out whether all the routes starting from city-S should stopped at city-D or not.

The rules to find the routes are as follows:
	- At least one route exists from the city-S to city-D.
	- If a route exists from city-S to other city with no outgoing roadways, 
	then that city should be city-D.
	- The number of possible routes from city-S to city-D is a finite number.

Return true if and only if all roadways from city-S lead to city-D.
Otherwise return false.

Input Format:
-------------
Line-1: Two space separated integers N and R, number of cities and number of roads
Next R lines: Two space separated integers p and q, Road from city-p to city-q.
Last line: Two space separated integers S and D.
 
Output Format:
--------------
Print a boolean value, if you can find finite number of routes between city-S to city-D.


Sample Input-1:
---------------
4 4
0 1
0 2
2 3
3 1
0 1

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 2
0 1
0 2
0 2

Sample Output-2:
----------------
false


Sample Input-3:
---------------
4 4
0 1
1 1
1 2
1 3
0 3

Sample Output-3:
----------------
false
*/
import java.util.*;
class finite_roadways{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        ArrayList<int[]>edges=new ArrayList<>();
        for(int i=0;i<r;++i){
            int u=sc.nextInt();
            int v=sc.nextInt();
            edges.add(new int[]{u,v});
        }
        int src=sc.nextInt();
        int dest=sc.nextInt();
        if(checkOutgoing(edges,n,r,src,dest) || checkCycle(edges,n,r,src,dest)) System.out.println(false);
        else System.out.println(true);
    }
    public static boolean checkOutgoing(ArrayList<int[]>edges,int n,int r,int src,int dest){
        for(int node=0;node<n;++node){
            if(node!=dest){
                int f=0;
                for(int[] edge:edges){
                    if(edge[0]==node){
                        f=1;
                        break;
                    }
                }
                if(f==0) return true;
            }
        }
        return false;
    }
    public static boolean checkCycle(ArrayList<int[]>edges,int n,int r,int src,int dest){
        boolean[] visited=new boolean[n];
        boolean[] stack=new boolean[n];
        for(int i=0;i<n;++i){
            if(isCycle(i,visited,stack,edges)) return true;
        }
        return false;
    }
    public static boolean isCycle(int i,boolean[] visited,boolean[] stack,ArrayList<int[]>edges){
        if(stack[i]) return true;
        if(visited[i]) return false;
        visited[i]=true;
        stack[i]=true;
        ArrayList<Integer>adj=new ArrayList<>();
        for(int[] edge:edges){
            if(edge[0]==i) adj.add(edge[1]);
        }
        for(int num:adj){
            if(isCycle(num,visited,stack,edges)) return true;
        }
        stack[i]=false;
        return false;
    }
}
