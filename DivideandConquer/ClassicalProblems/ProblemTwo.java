//Finding power of an element
import java.util.*;
import java.io.*;
public class ProblemTwo {


    static class FastReader{
     
        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));

        }
        String next(){

            while(st==null || !st.hasMoreElements()){

                try{

                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }

            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
    }
    private static int straightfindpowerone(int a,int n){

        // Time Complexity = O(n)
        // Space Complexity = O(1)
        
        int val = a;
        for(int i=1;i<n;i++){

            val*= a;

        }
        return val;
    }
    private static int divideandconquer(int a,int n){

        // Time complexity = O(logn)
        // Space Complexity or Stack Space = O(logn)
        // T(n) = T(n/2) + c
        if(n==1){

            return a;
        }
        else{

            int mid = (n/2);
            int left = divideandconquer(a, mid);
            int result = left*left;
            if(n%2==0)
              return result;
            else
              return (result*a);
        }
    }
    public static FastReader in = new FastReader();
    public static void main(String args[]){


        int a = in.nextInt();
        int n = in.nextInt();
        //System.out.print(straightfindpowerone(a, n));
        //System.out.println(divideandconquer(a, n));

    }
}
