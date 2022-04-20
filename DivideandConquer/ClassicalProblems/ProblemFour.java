//A sorted array of n distinct integers Find any element such that arr[i] = i
import java.util.*;
import java.io.*;
public class ProblemFour{

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

    private static  FastReader in = new FastReader();
    public static void addElements(int [] arr){

        for(int i=0;i<arr.length;i++){

            int x = in.nextInt();
            arr[i] = x;
        }
    }
    public static boolean solution(int [] arr,int i,int j){

        //Time complexity = O(logn)
        //Space complexity = O(logn)
        //T(n) = T(n/2) + c
        //When The Problem is Small and 0 element array
        if(i>j)
         return false;
        // One Element array
        else if(i==j){
            if(arr[i]==i)
              return true;
            else
              return false;
        }
        else{

            int mid = (i+j)/2;
            if(arr[mid]==mid)
              return true;
            else if(arr[mid]<mid)
              return solution(arr, mid+1, j);
            else
              return solution(arr, i, mid-1);
        }
    }
    public static void main(String [] args){

        int n = in.nextInt();
        int [] arr = new int [n];

        //add ELements
        addElements(arr);

        if(solution(arr,0,arr.length-1))
          System.out.print("The Elements is Present in The Array");
        else
         System.out.print("The Elements is not Present in The Array");
    }
    
}

