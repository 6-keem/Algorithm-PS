import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int V, E;
    static int startVertex;
    static LinkedList<Node> [] graph = null;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static final int INF = 9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String [] str = bufferedReader.readLine().split(" ");
        V = Integer.parseInt(str[0]);
        E = Integer.parseInt(str[1]);
        startVertex = Integer.parseInt(bufferedReader.readLine());
        graph = new LinkedList[V + 1];

        for(int i = 1 ; i < graph.length ; i ++){
            graph[i] = new LinkedList<>();
        }

        for(int i = 0 ; i < E ; i ++){
            str = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(str[0]);
            int end = Integer.parseInt(str[1]);
            int weight = Integer.parseInt(str[2]);
            graph[start].push(new Node(end, weight));
        }
        shortestPath();
        bufferedWriter.flush();
    }
    public static void shortestPath() throws IOException {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int [] distance = new int[V + 1];
        for(int i = 1 ; i < distance.length ; i ++)
            distance[i] = INF;
        boolean [] visited = new boolean[V + 1];
        distance[startVertex] = 0;
        priorityQueue.add(new Node(startVertex,0));

        while(!priorityQueue.isEmpty()){
            Node node = priorityQueue.remove();
            int v = node.end;
            if(visited[v])
                continue;
            visited[v] = true;
            for(Node cur : graph[v]){
                if(!visited[cur.end] && distance[v] + cur.weight < distance[cur.end]){
                    distance[cur.end] = distance[v] + cur.weight;
                    priorityQueue.add(new Node(cur.end, distance[cur.end]));
                }
            }
        }

        for(int i = 1 ; i < distance.length ; i ++){
            if(distance[i] < INF)
                bufferedWriter.write(Integer.toString(distance[i]));
            else
                bufferedWriter.write("INF");
            bufferedWriter.newLine();
        }
    }
    static class Node implements Comparable<Node>{
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}