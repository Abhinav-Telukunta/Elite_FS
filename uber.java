/*UBER driver has a vehicle, daily he used go in only one direction.
Capacity of the vehicle is S (no of seats except driver seat), 

Given a list of N bookings, booking[i]= [ num_customers, pickup, drop ].
booking indicates, number of customers to pick up, and pick up, droping points.

Initially the vehicle is empty.

Return true if and only if it is possible to pick up and drop off all customers 
of all bookings.

Input Format:
-------------
Line-1 -> Two integers N and S, number of bookings and number of seats in the vehicle.
Next N Lines -> three space separated integers, num_customers, pickup point, 
                dropping point

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true
*/
import java.util.*;
class uber{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int[][] bookings=new int[n][3];
        Set<Integer>set=new TreeSet<>();
        for(int i=0;i<n;++i){
            int customers=sc.nextInt();
            int pick=sc.nextInt();
            int drop=sc.nextInt();
            bookings[i]=new int[]{customers,pick,drop};
            set.add(pick);
            set.add(drop);
        }
        int people=0;
        for(int point:set){
            for(int[] booking:bookings){
                if(booking[2]==point) people-=booking[0];
            }
            for(int[] booking:bookings){
                if(booking[1]==point && people+booking[0]<=s) people+=booking[0];
            }
        }
        if(people==0) System.out.println("true");
        else System.out.println("false");
    }
}
