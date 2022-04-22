// Find any two element in the array such that their sum should be equal to 1000
import java.util.*;
import java.io.*;
public class ProblemSix {
    
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

    private static FastReader in = new FastReader();
    public static void addElements(int [] arr){


        for(int i=0;i<arr.length;i++){

            int x = in.nextInt();
            arr[i] = x;
        }
    }
    public static boolean bs(int [] arr,int i,int j,int a){

        if(i>j)
          return false;
        else if(i==j){

            int b = arr[i];
            if((a+b)==1000)
              return true;
            else
              return false;
        }
        else{

            int mid = (i+j)/2;

            int b = arr[mid];
            if((a+b)==1000)
              return true;

            else if((a+b)>1000)
              return bs(arr,i,mid-1,a);
            else
              return bs(arr,mid+1,j,a);
        }

    }
    public static boolean solutionone(int [] arr){
       
       // N times Binary Search
       // Time complexity = O(n*logn)
       // Space complexity = O(logn)
       // T(n) = c + T(n/2) 
       for(int i=0;i<arr.length-1;i++){

        int a = arr[i];
        boolean sol = bs(arr,i+1,arr.length-1,a);

        if(sol)
          return true;
       }
       return false;
    }
    public static boolean solutiontwo(int [] arr){
        
        // Greedy Solution
        // Time complexity = O(n)
        // Space complexity = O(1)
        int i = 0;
        int j = arr.length-1;
        while(i<j){


            if((arr[i]+arr[j])==1000)
               return true;
            else if((arr[i]+arr[j])>1000)
              j--;
            else
             i++;
              
        }
        return false;
    }
    public static void main(String args[]){


        int n = in.nextInt();
        int [] arr = new int[n];

        addElements(arr);
        
        // Binary Search solution
        if(solutionone(arr))
          System.out.print("The Element is Present in The Array");
        else
          System.out.print("The Element is Not Present in The Array");
          
        // Greedy Solution
        if(solutiontwo(arr))
          System.out.print("The Element is Present in The Array");
        else
          System.out.print("The Element is not Present in The Array");        
    }
    
}
