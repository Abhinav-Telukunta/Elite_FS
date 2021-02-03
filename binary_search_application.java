/*
 There are N bags containing gold boxes. In each bag, gold boxes are with certain weights that are
arranged according to weights from smallest to largest arranged strictly ,create a method in such a way
that we need to return the least weight of gold box which is common in all the given bags.
If we don’t have any least common weight of gold box in any bag then return -1.

Input Format:
-------------
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.

Output Format:
--------------
Print the least weight of gold box, if found
Print -1, if not found.


Sample Input:
---------------
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8

Sample Output:
----------------
3

 */
import java.util.*;
public class binary_search_application{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] mat=new int[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                mat[i][j]=sc.nextInt();
            }
        }
        int maxx=mat[0][0],count=1;
        int row=1;
        while(true){
            int num=get_atleast(mat,row,maxx);
            //System.out.println(num);
            if(num==-1){
                System.out.println(-1);
                break;
            }
            if(maxx==num){
                count++;
                if(count==m){
                    System.out.println(maxx);
                    break;
                }
            }
            else{
                maxx=num;
                count=1;
            }
            row=(row+1)%m;
            
        }
    }
    public static int get_atleast(int[][] mat,int row,int maxx){
        int low=0,high=mat[row].length-1;
        int ans=-1,prev_mid=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(mat[row][mid]>=maxx){
                if(mid<prev_mid){
                    ans=mat[row][mid];
                    prev_mid=mid;
                }
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}
