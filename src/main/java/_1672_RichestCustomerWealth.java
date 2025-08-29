public class _1672_RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        int t=0;
        while(true){
            int sum = 0 ;
            for(int i=0;i<accounts[t].length;i++){
                sum += accounts[t][i];
            }
            if(sum>maxWealth) maxWealth = sum;
            t++;
            if(t == accounts.length) break;
        }
        return maxWealth;
    }
    public static void main(String[] args) {
        int [][] arr = {{1,5,7,9,4},{2, 4, 6, 2, 5}};
        System.out.println(maximumWealth(arr));
    }
}
