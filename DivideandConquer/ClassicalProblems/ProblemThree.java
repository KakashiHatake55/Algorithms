//Given an array of elements find a elements is present there or not
import java.util.*;
import java.io.*;
public class ProblemThree {
    

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
    public static int  LinearSearch(int [] arr,int key){

        //Time complexity = O(n)
        // Space complexity = O(1)
        for(int i=0;i<arr.length;i++){

            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    public static int BinarySearch(int [] arr,int i,int j,int key){

        //Time complexity = O(logn) Wrost Case
        //                = O(1)    Best Case
        //Space complexity = O(logn) Wrost Case
        //                 = O(1)    Best Case
        //    T(n) = c + T(n/2)
        //Problem is Small
        if(i>j)
         return -1;
        else if(i==j){

            if(arr[i]==key){

                return i;
            }
            else
              return -1;
        }
        else{

            int mid = (i+j)/2;
            // Best case
            if(arr[mid]== key)
              return mid;
            // Wrost case
            else if(arr[mid]<key)
                return BinarySearch(arr, mid+1, j, key);
            else
               return BinarySearch(arr, i, mid-1, key);
        }

    }
    public static int IterativeBS(int arr[],int i,int j,int key){


        while(i<=j){


            if(i==j){

                if(arr[i]==key)
                  return i;
                else
                  return -1;
            }
            else{

                int mid = (i+j)/2;

                if(arr[mid]==key)
                  return mid;
                else if(arr[mid]<key)
                  i = mid+1;
                else
                  j = mid-1;
            }
            
              
        }
        return -1;
    }
    public static void main(String args []){

        int n = in.nextInt();
        int [] arr = new int [n];
        addElements(arr);

        int k = in.nextInt();
        
        // LinearSearch
        int indxL = LinearSearch(arr,k);
        if(indxL!=-1)
           System.out.print("The Key is Present in The Array at "+ indxL);
        else
           System.out.print("The Key is not Present in The Array");
        
        //BinarySearch
        int indxB = BinarySearch(arr,0,arr.length-1,k);
        if(indxB!=-1)
         System.out.print("The key is Present in The Array at "+ indxB);
        else
         System.out.print("The key is not Present in The Array");
         
        //Iterative BinarySearch
        int indxI = IterativeBS(arr,0,arr.length,k);
        if(indxI!=-1)
         System.out.print("The key is Present in The Array at "+ indxI);
        else
         System.out.print("The key is not Present in The Array");
    }


}
