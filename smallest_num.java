/*Pramod is working on patterns.
He is given a pattern P of length N-1, He needs to construct a list L[] of length N.
And the list L[] has to construct using the integers from 1 to N only.

To construct the list, He defined a rule set as follows based on the pattern P:
	- if P[i] == 'A', then L[i] < L[i+1].
	- if P[i] == 'D', then L[i] > L[i+1].
	- And the L[] should be lexicographically smallest.

You will be given the pattern P of length N-1 
Your task is to construct the list using the pattern and 
according to the rules set by Pramod.

NOTE:
Can you solve the problem in O(N) time complexity?

Input Format:
-------------
A string, the pattern consist of only A and D alphabets.

Output Format:
--------------
Print the list, according to the given pattern.


Sample Input-1:
---------------
DAA

Sample Output-1:
----------------
[2, 1, 3, 4]

Explanation:
------------
Using the sequence DAA there are more than one way of creating the list:
for example: [2,1,3,4], [3,1,2,4], [4,1,2,3].
According to the given info, the result should be lexicographically smallest.
So the answer is [2,1,3,4].


Sample Input-2:
---------------
ADA

Sample Output-2:
----------------
[1, 3, 2, 4]

Explanation:
------------
Using the sequence ADA there are more than one way of creating the list:
for example: [1,3,2,4], [1,4,2,3], [2,4,1,3], [2,3,1,4]..etc
According to the given info, the result should be lexicographically smallest.
So the answer is [1,3,2,4].
*/

import java.util.*;
class smallest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char[] ch=s.toCharArray();
        int n=s.length()+1;
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=1;i<=n;++i) arr.add(i);
        int count=0;
        int i=0,st_idx=-1;
        while(i<ch.length){
            if(ch[i]=='D') {
                count++;
                if(st_idx==-1) st_idx=i;
            }
            else if(count!=0){
                reverse(arr,st_idx,st_idx+count);
                count=0;
                i=i+count;
                st_idx=-1;
            }
            i++;
        }
        if(count!=0){
            reverse(arr,st_idx,st_idx+count);
        }
        System.out.println(arr);
        
    }
    public static void reverse(ArrayList<Integer>arr,int low,int high){
        while(low<high){
            int t=arr.get(low);
            arr.set(low,arr.get(high));
            arr.set(high,t);
            low++;
            high--;
        }
    }
}