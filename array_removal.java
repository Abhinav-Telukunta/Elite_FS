/*Siddarth is working with a list of integers, 0-indexed list.
The list is said to be decent list, if the sum of the inteers at odd indices 
equal to the sum of integers at even indices in the list.

Now, siddarth can choose any index position, and delete the element from the list.
and check whether the resultant list is a decent list or not.
Due to the deletion of an element, the index postions may vary. 

For example, if the list is [2,1,3,4,1] :
	- delete the element at index 1 => list is [2,3,4,1]
	- delete the element at index 2 => list is [2,1,4,1]
	- delete the element at index 3 => list is [2,1,3,1]
	- delete the element at index 4 => list is [2,1,3,4]

Siddarth has to find out how many indices you can remove one at a time and,
check that the resultant list becomes a decent list.

Your task is to help siddarth to find the count of all such indices.

Input Format:
-------------
Line-1: An integer N, number of elements in the list.
Line-2: N space separated integers, the list.

Output Format:
--------------
Print an integer, number of indices you can find.


Sample Input-1:
---------------
5
1 2 2 1 2

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5
2 2 2 2 2

Sample Output-2:
----------------
5


Sample Input-3:
---------------
4
3 2 7 5

Sample Output-3:
----------------
1
*/
import java.util.*;
class decent{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int ans=0;
        ArrayList<Integer>peven=new ArrayList<>();
        ArrayList<Integer>podd=new ArrayList<>();
        int sum=0;
        for(int i=0;i<n;i+=2){
            sum+=arr[i];
            peven.add(sum);
        }
        sum=0;
        for(int i=1;i<n;i+=2){
            sum+=arr[i];
            podd.add(sum);
        }
        int es=peven.size()-1;
        int os=podd.size()-1;
        for(int i=0;i<n;++i){
            int beven=i==0?0:peven.get((i-1)/2);
            int bodd=(i==0 || i==1)?0:(i%2==0?podd.get((i-1)/2):podd.get((i-1)/2-1));
            int aeven=i%2==0?peven.get(es)-beven-arr[i]:peven.get(es)-beven;
            int aodd=i%2!=0?podd.get(os)-bodd-arr[i]:podd.get(os)-bodd;
            int even=beven+aodd;
            int odd=bodd+aeven;
            if(even==odd) ans++;
        }
        System.out.println(ans);
    }
}
