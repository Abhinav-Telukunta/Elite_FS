/*
A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

UoC offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.

 */
import java.util.*;
class top_sort{
    int v;
    LinkedList<Integer>adj[];
    public top_sort(int n){
        this.v=n;
        adj=new LinkedList[n];
        for(int i=0;i<n;++i) adj[i]=new LinkedList<>();
    }
    public void addEdge(int u,int v){
        adj[v].add(u);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int subjects=sc.nextInt();
        int conditions=sc.nextInt();
        top_sort obj=new top_sort(subjects);
        for(int i=0;i<conditions;++i){
            int u=sc.nextInt();
            int v=sc.nextInt();
            obj.addEdge(u,v);
        }
        obj.topological_sort();
        
    }
    public void topological_sort(){
        ArrayList<Integer>ans=new ArrayList<>();
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();
        for(int i=0;i<v;++i){
            int in_degree=0;
            for(int j=0;j<v;++j){
                if(adj[j].contains(i)) in_degree++;
            }
            ArrayList<Integer>temp=new ArrayList<>();
            temp.add(i);
            temp.add(in_degree);
            arr.add(temp);
        }
        while(arr.size()!=0){
            int flag=0,node=0;
            for(int i=0;i<arr.size();++i){
                if(arr.get(i).get(1)==0){
                    flag=1;
                    node=arr.get(i).get(0);
                    arr.remove(i);
                    break;
                }
            }
            if(flag==0){
                ans.clear();
                break;
            }
            else{
                ans.add(node);
                for(int neigh:adj[node]){
                    for(int i=0;i<arr.size();++i){
                        if(arr.get(i).get(0)==neigh){
                            arr.get(i).set(1,arr.get(i).get(1)-1);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
