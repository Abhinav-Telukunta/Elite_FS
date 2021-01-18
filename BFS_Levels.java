/*
EA Sports, developed a video game.
They designed a game in such a way that, there are L number of levels from 1 to L.
There are D number of dependencies where each dependency[m] = [ Xm, Ym ], 
represents a prerequisite relationship, that is, in order to play level-Ym,  
you must have completed the level-Xm . 

In one day you can complete any number of levels as long as you have completed 
all the prerequisites levels in the game. 

You cannont play a level-Ym which has some prerequisite level-Xm on same day.

Write a method to return the minimum number of days to complete all the levels 
in the game. If there is no way to complete all the levels, return -1.


Input Format:
-------------
Line-1: An integer L, number of levels.
Line-2: An integer D, number of dependencies.
Next D lines: Two space separated integers, Xm and Ym.

Output Format:
--------------
An integer, the minimum number of days to complete all the levels in the game.


Sample Input-1:
---------------
3
2
1 3
2 3

Sample Output-1:
----------------
2

Explanation-1:
--------------
On the first day, levels 1 and 2 are completed. 
On the second day, level 3 is completed.


Sample Input-2:
---------------
3
3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

Explanation-2:
-------------
No level can be completed because they depend on each other.

 */
import java.util.*;
public class BFS_Levels{
    int v;
    Map<Integer,ArrayList<Integer>>map;
    public BFS_Levels(int n){
        this.v=n;
        map=new HashMap<>();
        for(int i=1;i<=v;++i) map.put(i,new ArrayList<Integer>());
    }
    public void addEdge(int u,int v){
        map.get(u).add(v);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int levels=sc.nextInt();
        int d=sc.nextInt();
        BFS_Levels g=new BFS_Levels(levels);
        for(int i=0;i<d;++i){
            int u=sc.nextInt();
            int v=sc.nextInt();
            g.addEdge(v,u);
        }
        Map<Integer,ArrayList<Integer>>res=g.bfs();
        //System.out.println(res);
        int ans=0,flag=0;
        while(true){
            if(res.size()==0) break;
            Set<Integer>s=new HashSet<>();
            for(Map.Entry<Integer,ArrayList<Integer>>entry:res.entrySet()){
                if(entry.getValue().size()==0){
                    s.add(entry.getKey());
                }
            }
            if(s.size()==0){
                flag=1;
                break;
            }
            for(int num:s){
                res.remove(num);
                for(Map.Entry<Integer,ArrayList<Integer>>entry:res.entrySet()){
                    if(entry.getValue().contains(num)) entry.getValue().remove(new Integer(num));
                }
            }
            ans++;
        }
        if(flag==0) System.out.println(ans);
        else System.out.println(-1);
        
    }
    public Map<Integer,ArrayList<Integer>> bfs(){
        Map<Integer,ArrayList<Integer>>res=new HashMap<>();
        for(int i=1;i<=v;++i){
            Set<Integer>visited=new HashSet<>();
            Queue<Integer>queue=new LinkedList<>();
            queue.add(i);
            while(!queue.isEmpty()){
                int temp=queue.poll();
                visited.add(temp);
                for(int j=0;j<map.get(temp).size();++j){
                    int neighbor=map.get(temp).get(j);
                    if(!visited.contains(neighbor)) queue.add(neighbor);
                }
            }
            visited.remove(i);
            ArrayList<Integer>temp=new ArrayList<>();
            for(int num:visited) temp.add(num);
            res.put(i,temp);
        }
        return res;
    }
}
