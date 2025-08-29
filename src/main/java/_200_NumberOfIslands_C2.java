import java.util.LinkedList;
import java.util.Queue;

public class _200_NumberOfIslands_C2 {
    static int row,col;
    static int [] dr = {-1,0,1,0};
    static int [] dc = {0,1,0,-1};
    static Queue<int[]> queue = new LinkedList<>();
    public static int numIslands(char[][] grid) {
        int count =0;
        row = grid.length;
        col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '*';
                    queue.add(new int[]{i,j});
                    count++;
                    BFS(grid);
                }
            }
        }
        return count;
    }
    public static boolean isValid(int x, int y){
        return x >=0 && y>=0 && x < row && y < col;
    }
    private static void BFS(char[][] grid) {
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int d =0 ; d < 4 ; d ++){
                int x = temp[0] + dr[d];
                int y = temp[1] + dc[d];
                if(isValid(x, y) && grid[x][y] == '1'){
                    grid[x][y] = '*';
                    queue.add(new int[]{x,y});
                }
            }
        }
    }

    public static void main(String[] args) {
        char [][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
}
