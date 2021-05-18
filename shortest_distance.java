/*Amith decided go on a holiday trip. 
Given a map of N holiday spots numbered 0,1,2,.. N-1, map shows the connecting routes
between the holiday sopts, the routes are bidirectional, and
the connecting routes are indicates as routes[i] = [from , to , distance ]. 
He can travel only a certian distance D.

Your task is to find the holiday spot H with the smallest number of holiday spots
that are reachable from H and whose distance is at most D, 

If there are multiple holiday spots, return H with the greatest number.


Input Format:
-------------
Line-1 : Three integers, N number of holiday spots, R is the number of connecting 
        routes and D is the distance can travel.
Next R lines : Three space separated integers, from , to and distance.

Output Format:
--------------
Print an integer, holiday spot.


Sample Input-1:
---------------
4 4 4
0 1 3
1 2 1
1 3 4
2 3 1

Sample Output-1:
----------------
3


Explanation:
------------
Distance can travel= 4,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1, Holiday-spot 2] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 2, Holiday-spot 3] 
Holiday-spot 2 -> [Holiday-spot 0, Holiday-spot 1, Holiday-spot 3] 
Holiday-spot 3 -> [Holiday-spot 1, Holiday-spot 2] 

Holiday-spots 0 and 3 have 2 reachable Holiday-spots at a distance = 4, 
but we have to return Holiday-spot 3 since it has the greatest number.


Sample Input-2:
---------------
5 6 2
0 1 2
0 4 8
1 2 3
1 4 2
2 3 1
3 4 1

Sample Output-2:
----------------
0

Explanation:
------------
Distance can travel= 2,

From			Reachable sopts
-------------------------------------
Holiday-spot 0 -> [Holiday-spot 1] 
Holiday-spot 1 -> [Holiday-spot 0, Holiday-spot 4] 
Holiday-spot 2 -> [Holiday-spot 3, Holiday-spot 4] 
Holiday-spot 3 -> [Holiday-spot 2, Holiday-spot 4]
Holiday-spot 4 -> [Holiday-spot 1, Holiday-spot 2, Holiday-spot 3]

Holiday-spots 0 has 1 reachable Holiday-spot at a distance = 2, 
*/

import java.util.*;
class reach{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int d=sc.nextInt();
        ArrayList<int[]>edges=new ArrayList<>();
        for(int i=0;i<r;++i){
            int from=sc.nextInt();
            int to=sc.nextInt();
            int dist=sc.nextInt();
            edges.add(new int[]{from,to,dist});
        }
        ArrayList<int[]>ans=new ArrayList<>();
        for(int node=0;node<n;++node){
            int[] distances=new int[n];
            Set<Integer>visited=new HashSet<>();
            visited.add(node);
            Arrays.fill(distances,Integer.MAX_VALUE);
            distances[node]=0;
            for(int[] edge:edges){
                if(edge[0]==node) distances[edge[1]]=edge[2];
                else if(edge[1]==node) distances[edge[0]]=edge[2];
            }
            while(true){
                int select_node=-1,minn=Integer.MAX_VALUE;
                for(int i=0;i<n;++i){
                    if(!visited.contains(i) && distances[i]<minn){
                        minn=distances[i];
                        select_node=i;
                    }
                }
                if(select_node==-1) break;
                visited.add(select_node);
                for(int[] edge:edges){
                    if(edge[0]==select_node && !visited.contains(edge[1])) {
                        if(distances[select_node]+edge[2]<distances[edge[1]]){
                            distances[edge[1]]=distances[select_node]+edge[2];
                        }
                    }
                    else if(edge[1]==select_node && !visited.contains(edge[0])){
                        if(distances[select_node]+edge[2]<distances[edge[0]]){
                            distances[edge[0]]=distances[select_node]+edge[2];
                        }
                    }
                }
            }
            int count=0;
            for(int ele:distances){
                if(ele<=d) count++;
            }
            ans.add(new int[]{node,count});
        }
        Collections.sort(ans,(a,b)->{if(a[1]!=b[1]) return a[1]-b[1]; else return b[0]-a[0];});
        System.out.println(ans.get(0)[0]);
    }
}
