/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers, and asked the students 
to find the sum of numbers between indices S1 and S2 (S1<=S2), inclusive.

Now it’s your task to implement the Solution class:
	- public Solution(int[] nums) : Initializes the object with the integer array nums .
	- public long sum(int S1, int S2): Returns the sum of the subarray nums[S1, S2] 
	(i.e., nums[S1] + nums[S1 + 1], ..., nums[S2] ).


Input Format:
-------------
Line-1: An integer n, size of the array nums[] (set of numbers).
		where 1 <= n <= 22000
Line-2: Two integers S1 and S2, index positions 
		where 0 <= S1 <= S2 < n

Output Format:
--------------
An integer, sum of integers between indices(s1, s2).


Sample Input-1:
---------------
8
2 6

Sample Output-1:
----------------
2864403

NOTE: 
----
First 8 values of the input are: 
115053, 59099, 681359, 526248, 123844, 612168, 920784, 591204
*/
import java.util.*;
public class Fenwick_Tree_Prefix_Sum{
    int[] arr;
    long[] farr;
    public Fenwick_Tree_Prefix_Sum(int[] nums){//nums array is already given
        arr=new int[nums.length];
        for(int i=0;i<nums.length;++i) arr[i]=nums[i];
        farr=new long[nums.length+1];
        update(farr,arr);
    }
    public void update(long[] farr,int[] arr){//update
        for(int idx=1;idx<farr.length;++idx){
            int val=arr[idx-1];
            int i=idx;
            while(i<farr.length){
                farr[i]+=val;
                i+=i&-i;
            }
        }
    }
    public long sum(int S1,int S2){//prefix sum
        S2++;
        long first=0,second=0;
        while(S1>0){
            first=first+farr[S1];
            S1-=S1&-S1;
        }
        while(S2>0){
            second=second+farr[S2];
            S2-=S2&-S2;
        }
        return second-first;
    }
}