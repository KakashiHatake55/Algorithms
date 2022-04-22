//An array of n elements find the position of an element x such that before that element all elements are in increasing order 
// before that element all are in decreasing order otherwise return -1
import java.util.*;
import java.io.*;
public class ProblemFive {
    

    static class FastReader{

        BufferedReader br;
        StringTokenizer st;

        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){

            while(st==null ||!st.hasMoreElements()){

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
    private static FastReader in = new FastReader();
    public static void addElements(int [] arr){

        for(int i=0;i<arr.length;i++){

            int x = in.nextInt();
            arr[i] = x;
        }
    }
    public static int solution(int [] arr,int i,int j){

        //Time complexity = O(1) Best Case
        //                = O(logn) Worst Case
        // T(n) = c + T(n/2)

        int mid = (i+j)/2;
        if(mid+1<arr.length && mid-1>=0){

            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])
                return mid;
            else if(arr[mid+1]>arr[mid])
              return solution(arr,mid+1,j);
            else
              return solution(arr,i,mid-1);

        }
        return -1;
    }
    public static void main(String args[]){

        int n = in.nextInt();
        int [] arr = new int[n];

        addElements(arr);

        int indx = solution(arr,0,arr.length-1);

        if(indx!=-1){
             
            System.out.print("The ELement is exist at the indx "+ indx);
        }
        else
          System.out.print("The Element doesn't exist int the Array");
    }
}
