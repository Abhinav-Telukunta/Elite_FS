/*
 Gopal would like to go on Tour, and planned a schedule.
Airport authority has created a new way of issuing tickets.
Gopal purchased a set of airline tickets, 
each ticket contains the 'departure from' and 'arrival to'.

Redesign the Gopal's tour schedule in an order.
Gopal intially must begin his tour from BZA.
Hence the tour schedule's start point should begin with BZA. 

You are given a list of flight tickets which Gopal has purchased.
Your task is to find out and return the tour schedule that has the least lexical order.
Gopal must use all the tickets once and only once.

Note:
------
If there are multiple valid schedules, you should return the schedule 
that has the smallest lexical order when read as a single string. 
For example, the schedule ["BZA", "LGA"] has a smaller lexical order than ["BZA", "LGB"].

All airports are represented by three capital letters.
You may assume all tickets form at least one valid schedule.

Input Format:
-------------
Single Line of tickets separated by comma, and each ticket separated by space, 
Gopal's flight tickets.

Output Format:
--------------
Print the schedule, which is smallest lexical order of tour schedule.


Sample Input-1:
----------------
DEL HYD,BZA DEL,BLR MAA,HYD BLR

Sample Output-1:
--------------------
[BZA, DEL, HYD, BLR, MAA]


Sample Input-2:
------------------
BZA BLR,BZA CCU,BLR CCU,CCU BZA,CCU BLR

Sample Output-2:
------------------
[BZA, BLR, CCU, BZA, CCU, BLR]


 */
import java.util.*;
public class dfs_tickets{
    Map<String,TreeSet<String>>adj=new HashMap<>();
    Map<ArrayList<String>,Integer>visited=new HashMap<>();
    ArrayList<String>ans=new ArrayList<>();
    public void addEdge(String src,String dest){
        adj.computeIfAbsent(src,x->new TreeSet<>()).add(dest);
        ArrayList<String>temp=new ArrayList<>();
        temp.add(src);
        temp.add(dest);
        visited.put(temp,0);
    }
    public void display(){
        System.out.println(ans);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(",");
        dfs_tickets obj=new dfs_tickets();
        for(String sub:s){
            String[] tour=sub.split(" ");
            String src=tour[0],dest=tour[1];
            obj.addEdge(src,dest);
        }
        obj.dfs("BZA");
        obj.display();
        
    }
    public boolean dfs(String node){
        ans.add(node);
        for(String neigh:adj.getOrDefault(node,new TreeSet<>())){
            ArrayList<String>temp=new ArrayList<>();
            temp.add(node);
            temp.add(neigh);
            if(visited.get(temp)==0){
                visited.put(temp,1);
                if(dfs(neigh)) return true;
                visited.put(temp,0);
            }
            else{
                if(checkAllVisited(visited)) return true;
            }
        }
        if(checkAllVisited(visited)) return true;
        ans.remove(ans.size()-1);
        return false;
    }
    public boolean checkAllVisited(Map<ArrayList<String>,Integer>visited){
        for(Map.Entry<ArrayList<String>,Integer>entry:visited.entrySet()){
            if(entry.getValue()==0) return false;
        }
        return true;
    }
    
}
