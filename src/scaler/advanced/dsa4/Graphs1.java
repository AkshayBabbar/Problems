package src.scaler.advanced.dsa4;

import java.util.*;

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
                graph.get(x).set(y, 2);
                dfsIsland(x, y, graph);
            }
        }
    }

    /**
     * Cycle in Directed Graph
     * <p>
     * Problem Description
     * Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     * <p>
     * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
     * <p>
     * NOTE:
     * <p>
     * The cycle must contain atleast two nodes.
     * There are no self-loops in the graph.
     * There are no multiple edges between two nodes.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     * <p>
     * <p>
     * Problem Constraints
     * 2 <= A <= 105
     * <p>
     * 1 <= M <= min(200000,A*(A-1))
     * <p>
     * 1 <= B[i][0], B[i][1] <= A
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first argument given is an integer A representing the number of nodes in the graph.
     * <p>
     * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return 1 if cycle is present else return 0.
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = 5
     * B = [  [1, 2]
     * [4, 1]
     * [2, 4]
     * [3, 4]
     * [5, 2]
     * [1, 3] ]
     * Input 2:
     * <p>
     * A = 5
     * B = [  [1, 2]
     * [2, 3]
     * [3, 4]
     * [4, 5] ]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 0
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
     * Explanation 2:
     * <p>
     * The given graph doesn't contain any cycle.
     */
    public static int checkCyclicDirectedGraph(int nodes, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nodes + 1);

        for (int i = 0; i < nodes + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.size(); i++) {
            adjList.get(graph.get(i).get(0)).add(graph.get(i).get(1));
        }
        ArrayList<Boolean> visited = getVisitedArrayBFS(nodes, adjList);
        for (int i = 0; i < visited.size(); i++) {
            if (!visited.get(i)) {
                return 1;
            }
        }

        return 0;
    }

    /**
     * Q5. Cycle in Undirected Graph
     * Solved
     * feature icon
     * Get your doubts resolved blazing fast with Chat GPT Help
     * Check Chat GPT
     * feature icon
     * Using hints except Complete Solution is Penalty free now
     * Use Hint
     * Problem Description
     * <p>
     * Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.
     * <p>
     * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
     * <p>
     * NOTE:
     * <p>
     * The cycle must contain atleast three nodes.
     * There are no self-loops in the graph.
     * There are no multiple edges between two nodes.
     * The graph may or may not be connected.
     * Nodes are numbered from 1 to A.
     * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
     * <p>
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= A, M <= 3*105
     * <p>
     * 1 <= B[i][0], B[i][1] <= A
     * <p>
     * Input Format
     * <p>
     * The first argument given is an integer A representing the number of nodes in the graph.
     * <p>
     * The second argument given is an matrix B of size M x 2 which represents the M edges such that there is a edge between node B[i][0] and node B[i][1].
     * <p>
     * <p>
     * <p>
     * Output Format
     * <p>
     * Return 1 if cycle is present else return 0.
     * <p>
     * <p>
     * <p>
     * Example Input
     * <p>
     * Input 1:
     * <p>
     * A = 5
     * B = [  [1. 2]
     * [1, 3]
     * [2, 3]
     * [1, 4]
     * [4, 5]
     * ]
     * Input 2:
     * <p>
     * A = 3
     * B = [  [1. 2]
     * [1, 3]
     * ]
     * <p>
     * <p>
     * Example Output
     * <p>
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * 0
     * <p>
     * Example Explanation
     * <p>
     * Explanation 1:
     * <p>
     * There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1
     * Explanation 2:
     * <p>
     * No cycle present in the graph so we will return 0.
     */

    public static int checkCyclicUndirectedGraph(int nodes, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(nodes + 1);

        for (int i = 0; i < nodes + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> integers : graph) {
            adjList.get(integers.get(0)).add(integers.get(1));
        }

        ArrayList<Boolean> visitedArray = new ArrayList<>();

        for (int i = 0; i < nodes + 1; i++) {
            visitedArray.add(false);
        }
        ArrayList<Boolean> visited = getVisitedArrayDFS(nodes, adjList, adjList.getFirst().getFirst(), visitedArray);
        for (int i = 0; i < visited.size(); i++) {
            if (!visited.get(i)) {
                return 1;
            }
        }

        return 0;
    }

    private static ArrayList<Boolean> getVisitedArrayBFS(int nodes, ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < nodes + 1; i++) {
            visited.add(false);
        }
        for (int i = 0; i < nodes; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (adjList.get(i).isEmpty()) {
                queue.offer(i);
            }
            queue.add(i);
            visited.set(i, true);

            while (!queue.isEmpty()) {
                int front = queue.poll();
                ArrayList<Integer> frontArray = adjList.get(front);
                for (int neighbour : frontArray) {
                    if (!visited.get(neighbour)) {
                        visited.set(neighbour, true);
                        queue.add(neighbour);
                    }
                }
            }
        }
        return visited;
    }

    private static ArrayList<Boolean> getVisitedArrayDFS(int nodes, ArrayList<ArrayList<Integer>> adjList, int start, ArrayList<Boolean> visitedArray) {
        visitedArray.set(start, true);
        ArrayList<Integer> adjListNodes = adjList.get(start);
        for (int neightbour : adjListNodes) {
            if (!visitedArray.get(neightbour)) {
                getVisitedArrayDFS(nodes, adjList, neightbour, visitedArray);
            }
        }
        return visitedArray;

    }

    /**
     * Q2. Shortest Distance in a Maze
     * Problem Description
     * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
     * <p>
     * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
     * <p>
     * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
     * <p>
     * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
     * <p>
     * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 2 <= N, M <= 100
     * <p>
     * 0 <= A[i] <= 1
     * <p>
     * 0 <= B[i][0], C[i][0] < N
     * <p>
     * 0 <= B[i][1], C[i][1] < M
     * <p>
     * <p>
     * <p>
     * Input Format
     * The first argument given is the integer matrix A.
     * <p>
     * The second argument given is an array of integer B.
     * <p>
     * The third argument if an array of integer C.
     * <p>
     * <p>
     * <p>
     * Output Format
     * Return a single integer, the minimum distance required to reach destination
     * <p>
     * <p>
     * <p>
     * Example Input
     * Input 1:
     * <p>
     * A = [ [0, 0],
     * [0, 0] ]
     * B = [0, 0]
     * C = [0, 1]
     * Input 2:
     * <p>
     * A = [ [0, 1],
     * [1, 0] ]
     * B = [0, 0]
     * C = [1, 1]
     * <p>
     * <p>
     * Example Output
     * Output 1:
     * <p>
     * 1
     * Output 2:
     * <p>
     * -1
     * <p>
     * <p>
     * Example Explanation
     * Explanation 1:
     * <p>
     * Go directly from start to destination in distance 1.
     * Explanation 2:
     * <p>
     * It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
     */
    public int shortestDistance(ArrayList<ArrayList<Integer>> graph, ArrayList<Integer> B, ArrayList<Integer> C) {
        int row = graph.size();
        int col = graph.get(0).size();
        ArrayList<ArrayList<Integer>> distance = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            distance.add(new ArrayList<>());
        }
        distance.get(B.get(0)).set(B.get(1), 0);// dest.
        dijkstra(graph, B, distance);
        return distance.get(C.get(0)).get(1) == Integer.MAX_VALUE ? -1 : distance.get(B.get(0)).get(1);
    }

    public void dijkstra(ArrayList<ArrayList<Integer>> maze, ArrayList<Integer> start, ArrayList<ArrayList<Integer>> distance) {
        ArrayList<ArrayList<Integer>> dirs = new ArrayList<>();
        dirs.add(new ArrayList<>(java.util.Arrays.asList(0, 1)));
        dirs.add(new ArrayList<>(java.util.Arrays.asList(0, -1)));
        dirs.add(new ArrayList<>(java.util.Arrays.asList(-1, 0)));
        dirs.add(new ArrayList<>(java.util.Arrays.asList(1, 0)));
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
        ArrayList<Integer> startingPoint = new ArrayList<>();
        startingPoint.add(start.get(0));
        startingPoint.add(start.get(1));
        startingPoint.add(0);
        queue.offer(startingPoint);

        while (!queue.isEmpty()) {
            ArrayList<Integer> s = queue.poll();
            if (distance.get(s.get(0)).get(s.get(1)) < s.get(2)) {
                continue;
            }
            for (ArrayList<Integer> dir : dirs) {
                int x = s.get(0) + dir.get(0);
                int y = s.get(1) + dir.get(1);
                int count = 0;
                while (x >= 0 && y >= 0 && x < maze.size() && y < maze.get(0).size() && maze.get(x).get(y) == 0) {
                    x += dir.get(0);
                    y += dir.get(1);
                    count++;
                }
                if (distance.get(s.get(0)).get(s.get(1)) + count < distance.get(x - dir.get(0)).get(y - dir.get(1))) {
                    distance.get(x - dir.get(0)).set(y - dir.get(1), distance.get(s.get(0)).get(s.get(1)) + count);
                    ArrayList<Integer> newPoint = new ArrayList<>();
                    newPoint.add(x - dir.get(0));
                    newPoint.add(y - dir.get(1));
                    newPoint.add(distance.get(x - dir.get(0)).get(y - dir.get(1)));
                    queue.offer(newPoint);
                }
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> vertices = new ArrayList<>();
        vertices.add(new ArrayList<>(Arrays.asList(1, 4)));
        vertices.add(new ArrayList<>(Arrays.asList(2, 1)));
        vertices.add(new ArrayList<>(Arrays.asList(4, 3)));
        vertices.add(new ArrayList<>(Arrays.asList(4, 5)));
        vertices.add(new ArrayList<>(Arrays.asList(2, 4)));
        vertices.add(new ArrayList<>(Arrays.asList(1, 5)));
        vertices.add(new ArrayList<>(Arrays.asList(5, 3)));
        vertices.add(new ArrayList<>(Arrays.asList(2, 5)));
        vertices.add(new ArrayList<>(Arrays.asList(5, 1)));
        vertices.add(new ArrayList<>(Arrays.asList(4, 2)));
        vertices.add(new ArrayList<>(Arrays.asList(3, 1)));
        vertices.add(new ArrayList<>(Arrays.asList(5, 4)));
        vertices.add(new ArrayList<>(Arrays.asList(3, 4)));
        vertices.add(new ArrayList<>(Arrays.asList(1, 3)));
        vertices.add(new ArrayList<>(Arrays.asList(4, 1)));
        vertices.add(new ArrayList<>(Arrays.asList(3, 5)));
        vertices.add(new ArrayList<>(Arrays.asList(3, 2)));
        vertices.add(new ArrayList<>(Arrays.asList(5, 2)));

        int[][] edges = new int[1][2];
        edges[0][0] = 0;
        edges[0][1] = 4;
        System.out.println(checkCyclicDirectedGraph(5, vertices));

        System.out.println(validPath(5, edges, 0, 4));
        createAdjList(5, vertices);


    }
}
