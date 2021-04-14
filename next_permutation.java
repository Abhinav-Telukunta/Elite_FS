/*You are given a list of digits( 0 to 9) digits[].
A number is formed using the given order of the list.
for example: given list is [1,3,2], then number is 132.

Find the next biggest number in the lexographic order using 
the same list of digits, by using the each digit in the list only once,
and print the digit list of such biggest number.

If such biggest number is not possible, 
print the smallest lexographic order of the digits.

Input Format:
-------------
Line-1 : An integer N, number of digits.
Line-2 : N space separated integers, list of digits.

Output Format:
--------------
Print an integer list.


Sample Input-1:
---------------
4
1 2 4 3

Sample Output-1:
----------------
[1, 3, 2, 4]


Sample Input-2:
---------------
4
4 3 2 1

Sample Output-2:
----------------
[1, 2, 3, 4]
*/
import java.util.*;
class next_permutation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int swap_idx=0,flag=0;
        for(int i=n-1;i>0;--i){
            if(arr[i-1]<arr[i]){
                swap_idx=i-1;
                flag=1;
                break;
            }
        }
        if(flag==0){
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
        }
        else{
            int ele=arr[swap_idx];
            int minn=Integer.MAX_VALUE;
            int just_greater_idx=0;
            for(int i=swap_idx+1;i<n;++i){
                if(arr[i]>ele && arr[i]<=minn){
                    minn=arr[i];
                    just_greater_idx=i;
                }
            }
            int temp=arr[swap_idx];
            arr[swap_idx]=arr[just_greater_idx];
            arr[just_greater_idx]=temp;
            int[] t=new int[n-swap_idx];
            int j=0;
            for(int i=n-1;i>swap_idx;--i) t[j++]=arr[i];
            j=0;
            for(int i=swap_idx+1;i<n;++i) arr[i]=t[j++];
            System.out.println(Arrays.toString(arr));
        }
 
        
        
    }
}