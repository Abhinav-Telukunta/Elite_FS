/*There are N celebrities participated in Go-Green Campaign,
All of them joined together and each one planted a tree on a flat land
at different positions.
 
Now, your task is to find the maximum number of trees in single straight line.

Input Format:
-------------
Line-1 -> An integers N, number of trees planted.
Next N lines -> Two space separated integers, position of the tree.

Output Format:
--------------
Print an integer as result.


Sample Input:
-------------
6
1 1
3 2
5 3
4 1
2 3
1 4

Sample Output:
--------------
4

Explanation:
------------

    Y
    |
    |	"
    | 		"			"
    |			"
    |	"			"	
    ------------------------- X
    0   1   2   3   4   5
*/

import java.util.*;
class st_line{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<int[]>points=new ArrayList<>();
        for(int i=0;i<n;++i){
            int x=sc.nextInt();
            int y=sc.nextInt();
            points.add(new int[]{x,y});
        }
        int ans=0;
        for(int i=0;i<points.size();++i){
            for(int j=0;j<points.size();++j){
                if(j!=i){
                    int[] co1=points.get(i);
                    int[] co2=points.get(j);
                    double slope1=((co2[1]-co1[1])*1.0)/(co2[0]-co1[0]);
                    int temp=2;
                    for(int k=0;k<points.size();++k){
                        if(k!=i && k!=j){
                            int[] co3=points.get(k);
                            double slope2=((co3[1]-co1[1])*1.0)/(co3[0]-co1[0]);
                            if(slope2==slope1) temp++;
                        }
                    }
                    ans=Math.max(ans,temp);
                }
            }
        }
        System.out.println(ans);
    }
}