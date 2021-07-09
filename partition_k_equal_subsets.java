/*Sukumar is a math teacher. He has 1*N matrix, filled with positive numbers.
He has given a task to his students. They have to form G number of groups
using the numbers of the matrix, you can use each number only once.
And the sum of the numbers in each group should be equal.
The groups may contain one or more elements.

Your task is to help the students, to check whether is it possible to make G groups
from the numbers of the given matrix.
If possible, print true. Otherwise, print false.


Input Format:
-------------
Line-1: Two space separated integers, N and G
Line-2: N space separated integers, list[]

Output Format:
--------------
Print a boolean result.


Sample Input-1:
---------------
7 4
3 2 5 1 8 6 7

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6 3
3 2 5 1 6 5

Sample Output-2:
----------------
false
*/

import java.util.*;
class divide{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        int sum=0;
        int maxx=Integer.MIN_VALUE;
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
            sum+=arr[i];
            maxx=Math.max(maxx,arr[i]);
        }
        if(sum%k!=0 || k>n || maxx>sum/k) System.out.println(false);
        else{
            boolean[] visited=new boolean[n];
            Arrays.sort(arr);
            boolean ans=dfs(arr,0,n-1,visited,sum/k,k);
            System.out.println(ans);
        }
    }
    public static boolean dfs(int[] A, int sum, int st, boolean[] visited, int target, int k) {
        if(k==0) return true;
        if(sum==target && dfs(A,0,A.length-1,visited,target,k-1)) return true;
        for(int i=st;i>=0;--i) {
            if(!visited[i] && sum+A[i]<=target) {
                visited[i]=true;
                if(dfs(A,sum+A[i],i-1,visited,target,k))
                    return true;
                visited[i]=false;
            }
        }
        return false;
    }
}