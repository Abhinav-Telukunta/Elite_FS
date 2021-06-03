/*The city of chandigarh is one of the best planned city. 
All the locations in the city are assigned in the form of grid.
Further after the onsight of COVID-19 certain localities having been marked
as containment localities, other localities  marked as normal. 

The chief minister of punjab Capt. Amrinder Singh has hired you to help him 
with some logistic planning. Capt. Amrinder Singh has given you a map, 
where all the containment localities are marked as 1 and covid free locations as 0.

You are asked to identify a suitable location where the punjab government can 
set up a Makeshift Hospital. This Makeshift Hospital has to be at the closest 
Manhattan Distance from all the Containment localities, i.e. the sum of distance 
of this makeshift hospital is the least from all containment localities.
 
 
Input Format:
-------------
Line-1 -> two integers size of the grid, r * c
Next r lines-> contains 'c' space seperated integers, [0, 1] only.

Output Format:
--------------
Print an integer as result.


Sample Input:
-----------------
3 5
1 0 0 0 1
0 0 0 0 0
0 0 1 0 0

Sample Output:
-------------------
6

Explanation: 
----------------
Given three containment localities at (0,0), (0,4), and (2,2):
The point (0,2) is an suitable location , as the total
travel distance of 2+2+2=6 is minimal. 
So return 6.

*/
import java.util.*;
class dist{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] mat=new int[r][c];
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j) mat[i][j]=sc.nextInt();
        }
        ArrayList<int[]>ctmt=new ArrayList<>();
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                if(mat[i][j]==1) ctmt.add(new int[]{i,j});
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<r;++i){
            for(int j=0;j<c;++j){
                int temp=0;
                for(int[] edge:ctmt){
                    temp+=Math.abs(i-edge[0])+Math.abs(j-edge[1]);
                }
                ans=Math.min(ans,temp);
            }
        }
        System.out.println(ans);
    }
}
