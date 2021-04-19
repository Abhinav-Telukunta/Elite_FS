/*Pramod is planning to design a program, which helps to create 
the IP addresses posssible from a given string S, 
where each IP address should be valid.

It is guaranteed that S contains only digits.

Can you help pramod in designing such program, which returns all possible IP addresses.
Print the answer in lexicographic order.

NOTE:
-----

- A valid IP address consists of exactly four integers, 
each integer is between 0 and 255, separated by single dots 
and cannot have leading zeros
- IP Addresses are said to be valid if it falls in the range 
from 0.0.0.0 to 255.255.255.255

- IP addresses like [123.012.234.255 , 123.234.345.34] are invalid.

Input Format:
-------------
A string S, contains only digits [0-9].

Output Format:
--------------
Print all possible IP addresses which are valid.


Sample Input-1:
---------------
23323311123

Sample Output-1:
----------------
[233.233.11.123, 233.233.111.23]


Sample Input-2:
---------------
12345678

Sample Output-2:
----------------
[1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


Sample Input-3:
---------------
02550255

Sample Output-3:
----------------
[0.25.50.255, 0.255.0.255]
*/
import java.util.*;
class ip_address{
    static ArrayList<String>ans=new ArrayList<>();
    static ArrayList<String>arr=new ArrayList<>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        compute_ip(s,0,0);
        System.out.println(ans);
    }
    public static void compute_ip(String s,int index,int count){
        if(count==4 && index==s.length()){
            String res="";
            int f=0;
            for(String part:arr){
                if(part.charAt(0)=='0' && part.length()>2){
                    f=1;
                    break;
                }
                res+=part;
            } 
            if(f==0) ans.add(res.substring(0,res.length()-1));
            return;
        }
        for(int i=index;i<index+3;++i){
            if(i<s.length()){
                String str=s.substring(index,i+1);
                if(str.length()>=0 && str.length()<=3){
                    int num=Integer.parseInt(str);
                    if(num>=0 && num<=255){
                        str+=".";
                        arr.add(str);
                        compute_ip(s,i+1,count+1);
                        arr.remove(arr.size()-1);
                    }
                }
            }

        }
    }
}
