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
        for (ArrayList<Integer> integers : B) {
            res[integers.get(0)].add(integers.get(1));
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> createAdjList(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(A + 1);

        for (int i = 0; i < A + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> integers : B) {
            adjList.get(integers.get(0)).add(integers.get(1));
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

    public void dfsList(int start, ArrayList<ArrayList<Integer>> adjList, ArrayList<Boolean> visitedArray) {
        visitedArray.set(start, true);
        ArrayList<Integer> adjListNodes = adjList.get(start);
        for (int neightbour : adjListNodes) {
            if (!visitedArray.get(neightbour)) {
                dfsList(neightbour, adjList, visitedArray);
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
            for (int neighbour : frontArray) {
                if (!vistedArray.get(neighbour)) {
                    vistedArray.set(neighbour, true);
                    queue.add(neighbour);
                }
            }
        }
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        boolean[] visitedArray = new boolean[n];
        for (int i = 0; i < n; i++) {
            visitedArray[i] = false;
        }
        boolean[] resultArray = bfs(source, adjList, visitedArray);
        for (boolean b : resultArray) {
            if (!b) {
                return false;
            }
        }
        return true;


    }

    public static boolean[] bfs(int start, ArrayList<ArrayList<Integer>> adjList, boolean[] visitedArray) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visitedArray[start] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            ArrayList<Integer> frontArray = adjList.get(front);
            for (int neighbour : frontArray) {
                if (!visitedArray[neighbour]) {
                    visitedArray[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return visitedArray;
    }

    public int solveDynamicIsland(ArrayList<ArrayList<Integer>> graph) {
        int ans = 0;
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.getFirst().size(); j++) {
                if (graph.get(i).get(j) == 1) {
                    ans++;
                    dfsIsland(i, j, graph);
                }
            }
        }
        return ans;
    }

    public void dfsIsland(int x, int y, ArrayList<ArrayList<Integer>> graph) {

        ArrayList<Integer> dx = new ArrayList<>(Arrays.asList(0, 0, -1, 1));
        ArrayList<Integer> dy = new ArrayList<>(Arrays.asList(-1, 1, 0, 0));

        for (int k = 0; k < 4; k++) {
            x = x + dx.get(k);
            y = y + dy.get(k);

            if (x >= 0 && x < graph.size() && y >= 0 && y < graph.getFirst().size() && graph.get(x).get(y) == 1) {
                graph.get(x).set(y,2);
                dfsIsland(x, y, graph);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> vertices = new ArrayList<>();
//        vertices.add(new ArrayList<>(Arrays.asList(2, 3)));
//        vertices.add(new ArrayList<>(Arrays.asList(1, 3)));
//        vertices.add(new ArrayList<>(Arrays.asList(1, 2)));
//        vertices.add(new ArrayList<>(Arrays.asList(1, 4)));
//        vertices.add(new ArrayList<>(Arrays.asList(4, 5)));
        vertices.add(new ArrayList<>(Arrays.asList(0, 4)));
        int[][] edges = new int[1][2];
        edges[0][0] = 0;
        edges[0][1] = 4;

        System.out.println(validPath(5, edges, 0, 4));
        createAdjList(5, vertices);


    }
}
