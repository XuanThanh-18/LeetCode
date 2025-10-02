package LeedCode;

import java.util.*;

public class SampleDFS {
    public static void BFSWithStack(int [][] graph){
        // khai bao
        Stack<Integer> stack = new Stack<>();
        Set<Integer> isVisited = new HashSet<>();

        // khoi tao
        stack.push(0);
        isVisited.add(0);

        // duyet theo stack
        while(!stack.isEmpty()){
            // lay phan tu trong stack
            int cur = stack.pop();
            // xu ly
            System.out.println(cur + " ");
            // tim cac phan tu ke voi cur va add vao stack
            for(int i=0 ; i < graph[0].length;i++){
                if(graph[cur][i] == 1 && !isVisited.contains(i)){
                    stack.push(i);
                    isVisited.add(i);
                }
            }
        }
    }
    public static void BFSWithRecursion(int u,List<Integer> listNodes[],Set<Integer> isVisited){
        System.out.println(u + " ");
        for(int v : listNodes[u]){
            if(!isVisited.contains(v) ){
                isVisited.add(v);
                BFSWithRecursion(v,listNodes,isVisited);

            }
        }
    }
    public static void main(String[] args) {
        int [][] graph = {
                {0,1,0,0,0,0,0},
                {1,0,1,1,1,0,0},
                {0,1,0,0,0,1,0},
                {0,1,0,0,0,1,1},
                {0,1,0,0,0,0,1},
                {0,0,1,1,0,0,0},
                {0,0,0,1,1,0,0}
        };
        List<Integer> listNodes [] = new List[graph.length];
        for(int i=0;i<graph.length;i++){
            listNodes[i] = new ArrayList<>();
            for(int j = 0 ; j < graph[0].length; j++){
                if(graph[i][j]==1) listNodes[i].add(j);else continue;
            }
        }
        Set<Integer> isVisited = new HashSet<>();
        isVisited.add(0);
        BFSWithRecursion(0,listNodes,isVisited);
    }
}
