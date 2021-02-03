/*
Few people standing in row, where male candidates are represented with 0 and 
Female with 1. We are given any random number ‘R’ such that ‘R’ values of males
need to be replaced with female at certain positions in such a way that we can
form longest female continuous group given in a row.

Your task is to help to form the longest female continuous group 
in the row and print the length of it.

Input Format:
-------------
Line-1: Two integers N and R, number of people and R.
Line-2: N space separated integers, [0, 1] only.

Output Format:
--------------
Print the length of longest female group.

Sample Input-1:
---------------
10 3
1 0 1 1 1 0 0 0 1 0

Sample Output-1:
----------------
7

Sample Input-2:
---------------
14 2
1 1 1 1 0 0 1 1 1 1 1 0 1 1 0

Sample Output-2:
----------------
11

 */
import java.util.*;
class two_pointer{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer>zero_indices=new ArrayList<>();
        for(int i=0;i<n;++i){
            if(arr[i]==0) zero_indices.add(i);
        }
        int j=0,i=0,ans=0,ptr=0,f=0;
        for(int idx=0;idx<n;++idx){
            if((idx==n-1 && arr[idx]==1) || arr[idx]==0){
                r--;
                f=1;
            }
            if(r<0 && f==1) {
                if(idx==n-1 && arr[idx]==1) i=idx+1;
                else i=idx;
                //System.out.println(i);
                ans=Math.max(ans,i-j);
                j=zero_indices.get(ptr)+1;
                ptr++;
                f=0;
            }
            
        }
        System.out.println(ans);
 
    }
}