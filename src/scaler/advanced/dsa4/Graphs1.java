package src.scaler.advanced.dsa4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs1 {


//    public int solve(int A, int[][] B) {
//        boolean[] visited = new boolean[B.length+1];
//        Arrays.fill(visited, false);
//
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(B[0][0]);
//        visited[0] = true;
//        while(!queue.isEmpty()){
//            int node = queue.poll();
//
//            for(int i =0; i<node;i++ ){
//                int v = node[i];
//                if(!visited[i]){
//                    queue.add();
//                }
//            }
//        }
//
//        if(visited[A]){
//            return 1;
//        }
//        return 0;
//    }


    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] list = createAdjacencyList(A, B);
        int[] visitedArr = new int[A + 1];
        bfs(1, list, visitedArr);
        return (visitedArr[A] == 1) ? 1 : 0;
    }

    //TC: O(V+E) SC: O(V+E)
    public ArrayList<Integer>[] createAdjacencyList(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] res = new ArrayList[A + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < B.size(); i++) {
            res[B.get(i).get(0)].add(B.get(i).get(1));
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> createAdjList(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(A + 1);

        for (int i = 0; i < adjList.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            adjList.get(B.get(i).get(0)).add(B.get(i).get(1));
        }
        return adjList;
    }

    //TC: O(V+E) SC(recursion stack): O(V+E)
    public void dfs(int start, ArrayList<Integer>[] list, int[] visitedArr) {
        visitedArr[start] = 1;
        for (int i = 0; i < list[start].size(); i++) {
            int neighbour = list[start].get(i);
            if (visitedArr[neighbour] != 1) {
                dfs(neighbour, list, visitedArr);
            }
        }
    }

    public void dfsList(int start, ArrayList<ArrayList<Integer>> adjList, ArrayList<Boolean> visitedArray){
        visitedArray.set(start,true);
        ArrayList<Integer> adjListNodes = adjList.get(start);
        for (int i = 0; i < adjListNodes.size(); i++) {
            int neightbour = adjListNodes.get(i);
            if(!visitedArray.get(neightbour)){
                dfsList(neightbour, adjList,visitedArray);
            }
        }
    }

    //TC: O(V+E) SC(queue): O(V) i.e. Max number of edges for a vertex
    public void bfs(int start, ArrayList<Integer>[] list, int[] visitedArr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedArr[start] = 1;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            for (int i = 0; i < list[front].size(); i++) {
                int neighbour = list[front].get(i);
                if (visitedArr[neighbour] != 1) {
                    visitedArr[neighbour] = 1;
                    queue.add(neighbour);
                }
            }
        }
    }

    public void bfsList(int start, ArrayList<ArrayList<Integer>> adjList, ArrayList<Boolean> vistedArray) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vistedArray.set(start, true);

        while (!queue.isEmpty()) {
            int front = queue.poll();
            ArrayList<Integer> frontArray = adjList.get(front);
            for (int i = 0; i < frontArray.size(); i++) {
                int neighbour = frontArray.get(i);
                if(!vistedArray.get(neighbour)){
                    vistedArray.set(neighbour,true);
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> vertices = new ArrayList<>();
        vertices.add(new ArrayList<>(Arrays.asList(2, 3)));
        vertices.add(new ArrayList<>(Arrays.asList(1, 3)));
        vertices.add(new ArrayList<>(Arrays.asList(1, 2)));
        vertices.add(new ArrayList<>(Arrays.asList(1, 4)));
        vertices.add(new ArrayList<>(Arrays.asList(4, 5)));
        createAdjList(5, vertices);


    }
}
