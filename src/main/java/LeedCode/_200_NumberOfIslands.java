package LeedCode;

public class _200_NumberOfIslands {
    static int []dr = {-1,0,1,0};
    static int []dc = {0,1,0,-1};
    static int row ;
    static int col;
    static boolean [][]isVisited;
    public static int numIslands(char[][] grid) {
        int count = 0 ;
        row = grid.length;
        col = grid[0].length;
        isVisited = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1' && !isVisited[i][j]){
                    isVisited[i][j] = true;
                    DFS(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public static boolean isValid(int i , int j){
        return i>=0 && j >= 0 && i < row && j < col;
    }
    private static void DFS(int i, int j, char[][] graph) {
        for(int d =0 ; d<4;d++){
            int x = i + dr[d];
            int y = j + dc[d];
            if(isValid(x,y) && !isVisited[x][y] && graph[x][y] == '1' ){
                    isVisited[x][y] = true;
                    DFS(x,y,graph);
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
