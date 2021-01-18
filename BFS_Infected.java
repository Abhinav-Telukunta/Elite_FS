/*
 A dangerous virus "ebola" is spreading across african countries.
Few people stand in a form of p*q grid, some positions in the grid are empty.

The grid is represented with three values 0,1, 2.
Where
	- 0 indicates an empty position,
	- 1 indiactes a healthy person , or
	- 2 indiactes an infected person.
	
Every minute, any healthy person who is 4-directionally adjacent to an infected 
person becomes infected.

Your task is to find out the minimum amount of time in minutes that the virus 
takes to spread among all the people in that grid.

If this is impossible, return -1.

NOTE:
4-directions are Up, Down, Left, Right.

Input Format:
-------------
Line-1: Two integers P and Q, size of the grid.
Next P lines: contains Q space separated integers, either 0, 1, or 2.

Output Format:
--------------
An integer, the minimum amount of time in minutes


Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Explanation-1:
--------------
There is an infected person at position (0, 0).
In the first minute: people in (0, 1) and (1, 0) positions are infected.
In the second minute: people in (0, 2) and (1, 1) positions are infected.
In the third minute: person in (1, 2) position is infected.
In the fourth minute: person in (2, 2) position is infected.


Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation-2:
--------------
The healthy person in the bottom left corner (row 2, column 0) is never infected, 
because infection only happens 4-directionally.

Sample Input-3:
---------------
1 2
0 2

Sample Output-3:
----------------
0

Explanation-3: 
-------------
Since there is already no healthy person at minute 0, the answer is just 0.
 */
import java.util.*;
public class BFS_Infected{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] mat=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                mat[i][j]=sc.nextInt();
            }
        }
        LinkedList<String>start=new LinkedList<>();
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(mat[i][j]==2) start.add(i+" "+j);
            }
        }
        int ans=0;
        while(!start.isEmpty()){
            LinkedList<String>next_start=new LinkedList<>();
            for(int i=0;i<start.size();++i){
                String[] temp=start.get(i).split(" ");
                int ridx=Integer.parseInt(temp[0]);
                int cidx=Integer.parseInt(temp[1]);
                LinkedList<String>t=checkAdjacent(mat,ridx,cidx,r,c);
                for(int j=0;j<t.size();++j) next_start.add(t.get(j));
            }
            if(next_start.size()==0) break;
            start=new LinkedList<>(next_start);
            ans++;
        }
        if(checkAll(mat)) System.out.println(ans);
        else System.out.println(-1);
    }
    public static LinkedList<String> checkAdjacent(int[][]mat,int ridx,int cidx,int r,int c){
        LinkedList<String>res=new LinkedList<>();
        if(ridx+1<r && mat[ridx+1][cidx]==1){
            mat[ridx+1][cidx]=2;
            res.add((ridx+1)+" "+cidx);
        }
        if(ridx-1>=0 && mat[ridx-1][cidx]==1){
            mat[ridx-1][cidx]=2;
            res.add((ridx-1)+" "+cidx);
        }
        if(cidx+1<c && mat[ridx][cidx+1]==1){
            mat[ridx][cidx+1]=2;
            res.add(ridx+" "+(cidx+1));
        }
        if(cidx-1>=0 && mat[ridx][cidx-1]==1){
            mat[ridx][cidx-1]=2;
            res.add(ridx+" "+(cidx-1));
        }
        return res;
    }
    public static boolean checkAll(int[][]mat){
        for(int i=0;i<mat.length;++i){
            for(int j=0;j<mat[0].length;++j){
                if(mat[i][j]==1) return false;
            }
        }
        return true;
    }
}