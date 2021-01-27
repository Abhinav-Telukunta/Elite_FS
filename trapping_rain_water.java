/*
A Kid is arranging a structure using building blocks, 
by placing individual building-block adjacent to each other.

A building-block is a vertical alignment of blocks.
		                            ___
here one block each represents  as |___|.

The following structure made up of using building blocks

                      ___
                  ___|___|    ___
                 |___|___|_w_|___|___              ___
              ___|___|___|___|___|___| w   _w_  w |___| 
          ___|___|___|___|___|___|___|_w__|___|_w_|___|____________

            0  1   3   4   2   3    2   0   1   0   2

Once the structure is completed, kid pour water(w) on it.

You are given a list of integers, heights of each building-block in a row.
Now your task How much amount of water can be stored by the structure.


Input Format:
-------------
Space separated integers, heights of the blocks in the structure. 

Output Format:
--------------
Print an integer, 


Sample Input:
-------------
0 1 3 4 2 3 2 0 1 0 2
    
Sample Output:
--------------
6
    
Explanation:
-----------
In the above structure,  6 units of water (w represents the water in the structure)
can be stored.

 */
import java.util.*;
public class trapping_rain_water{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int[] arr=new int[s.length];
        for(int i=0;i<s.length;++i) arr[i]=Integer.parseInt(s[i]);
        int ans=0;
        for(int i=0;i<arr.length;++i){
            int left_max=0,right_max=0;
            for(int j=i+1;j<arr.length;++j){
                right_max=Math.max(right_max,arr[j]);
            }
            for(int j=i-1;j>=0;--j){
                left_max=Math.max(left_max,arr[j]);
            }
            if(Math.min(left_max,right_max)-arr[i]>0) ans+=Math.min(left_max,right_max)-arr[i];
        }
        System.out.println(ans);
    }
}
