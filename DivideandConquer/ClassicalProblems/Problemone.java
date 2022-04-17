//Finding maximum and minimum from a given array of elements
import java.util.*;
import java.io.*;
class Problemone{
    static class  FastReader{
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

            return (Integer.parseInt(next()));
        }
    }
    public static FastReader in = new FastReader();
    private static void addvalue(int [] arr){

        for(int i=0;i<arr.length;i++){

            int val = in.nextInt();
            arr[i] = val;
        }
    }
    private static int straightmaxmin(int [] arr){
        // Time Complexity = O(n) every case
        // Space Complexity = O(1) every case
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){

            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;

    }
    private static int straightminimum(int [] arr){
        // Time Complexity = O(n) every case
        // Space Complexity = O(1) every case
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){

            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
    private static int divideandconquermaxmin(int [] arr,int i,int j){
        // Time Complexity = O(n) every case
        // Space Complexity = O(logn) every case
        // T(n) = 2*T(n/2) + c 

        if(i==j)
          return arr[i];
        else if(i==j-1){

            if(arr[i]>arr[j])
              return arr[i];
            else 
              return arr[j];
        }
        else{


            int mid = (i+j)/2;
            int max1 = divideandconquermaxmin(arr, i, mid);
            int max2 = divideandconquermaxmin(arr, mid+1, j);

            if(max1>max2)
              return max1;
            else
              return max2;
        }
          
    }
    public static void main(String args[]){


        int size = in.nextInt();
        int [] arr = new int[size];
        addvalue(arr);
        //System.out.println(straightmaxmin(arr));
        //System.out.println(straightminimum(arr));
        //System.out.print(divideandconquermaxmin(arr,0,arr.length-1));
        
    }
}

