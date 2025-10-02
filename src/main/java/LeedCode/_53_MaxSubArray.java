package LeedCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _53_MaxSubArray {
    public static int MaxLeft(int[] a, int i,int j) {
        int sum =0,maxSum=Integer.MIN_VALUE;
        for(int k = j ;k>=i;k--){
            sum+=a[k];
            if(sum>maxSum)
                maxSum=sum;
        }
        return maxSum;
    }

    public static int MaxRight(int[] a, int i,int j) {
        int sum =0,maxSum=Integer.MIN_VALUE;
        for(int k = i ;k<=j;k++){
            sum+=a[k];
            if(sum>maxSum)
                maxSum=sum;
        }
        return maxSum;
    }

    public static int MaxSub(int[] a, int i,int j) {
        if(i==j) return a[i];
        else{
            int m = (i+j)/2;
            int wL = MaxSub(a,i,m);
            int wR = MaxSub(a,m+1,j);
            int wM = MaxLeft(a,i,m) + MaxRight(a,m+1,j);
            return Math.max(wL,Math.max(wR,wM));
        }
    }
    public static void main(String[] args) throws IOException {
        int[] a =new int[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println(MaxSub(a,0,n-1));
    }
}
