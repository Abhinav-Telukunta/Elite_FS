/*Indian Army setup N military-camps, sitauted at random places at LAC in Galwan.
To safeguard all the military-camps, Govt of India planned to setup protective 
S.H.I.E.L.D,  And the cost of the S.H.I.E.L.D will be very expensive.
Govt of India ask your help to build the S.H.I.E.L.D that should enclose all 
the camp locations and have least cost.

You are given the locations of military-camps camps[l]=[Xl, Yl], 
where Xl, Yl indiacates the co-ordinates of the military-camp in the Galwan.

Your task is to return the military camp locations, 
those are on the edge of the S.H.I.E.L.D. Print the locations in ascending order.

Input Format:
-------------
Line-1: An integer N, number of military camps.
Next N lines: Two space separated integers, camp location.

Output Format:
--------------
Print all the camp locations, which are at the ede of S.H.I.E.L.D.


Sample Input-1:
---------------
8
1 1
1 3
2 2
3 3
3 2
3 5
4 3
5 2

Sample Output-1:
----------------
[1, 1],[1, 3],[3, 5],[5, 2],


Sample Input-2:
---------------
5
1 1
2 2
3 3
4 4
5 1

Sample Output-2:
----------------
[1, 1],[2, 2],[3, 3],[4, 4],[5, 1],
*/
import java.util.*;
class hull{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] points=new int[n][2];
        for(int i=0;i<n;++i){
            int x=sc.nextInt();
            int y=sc.nextInt();
            points[i][0]=x;
            points[i][1]=y;
        }
        TreeSet<int[]>hull=new TreeSet<>((a,b)->{if(a[0]!=b[0]) return a[0]-b[0]; else return a[1]-b[1];});
        if(n<=3){
            for(int[]p:points) hull.add(p);
        }
        else{
            int lm=0;
            for(int i=0;i<n;++i){
                if(points[i][0]<points[lm][0]) lm=i;
            }
            int p=lm;
            do{
                int q=(p+1)%n;
                for(int i=0;i<n;++i){
                    if(orientation(points[p],points[i],points[q])<0){
                        q=i;
                    }
                }
                for(int i=0;i<n;++i){
                    if(i!=p && i!=q && orientation(points[p],points[i],points[q])==0 && inBetween(points[p],points[i],points[q])) hull.add(points[i]);
                }
                hull.add(points[q]);
                p=q;
            }while(p!=lm);
        }
        for(int[] arr:hull) System.out.print(Arrays.toString(arr)+",");
    }
    public static int orientation(int[] p,int[] q,int[] r){
        return (q[1]-p[1])*(r[0]-q[0])-(q[0]-p[0])*(r[1]-q[1]);
    }
    public static boolean inBetween(int[] p,int[] i,int[] q){
        boolean a=i[0]>=p[0] && i[0]<=q[0] || i[0]<=p[0] && i[0]>=q[0];
        boolean b=i[1]>=p[1] && i[1]<=q[1] || i[1]<=p[1] && i[1]>=q[1];
        return a&&b;
    }
}