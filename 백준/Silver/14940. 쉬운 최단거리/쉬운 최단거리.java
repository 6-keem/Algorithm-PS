import java.io.*;
import java.util.ArrayList;

public class Main{
    static int [][] graph = null;
    static boolean [][] visited = null;
    static int n, m;
    static int []dx = {-1,0,1,0};
    static int []dy = {0,-1,0,1};
    static final int GOAL = 2;
    static final int AVAIL = 1;
    static final int WALL = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String []input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        visited = new boolean[n][m];
        int y = 0, x = 0;
        for(int i = 0 ; i < n ; i ++){
            input = bufferedReader.readLine().split(" ");
            for(int j = 0 ; j < m ; j ++){
                graph[i][j] = Integer.parseInt(input[j]);
                visited[i][j] = false;
                if(graph[i][j] == GOAL){
                    y = i;
                    x = j;
                    graph[i][j] = 0;
                }
            }
        }

        bfs(y,x);

        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m;  j++){
                if(!visited[i][j] && graph[i][j] == AVAIL)
                    bufferedWriter.write("-1 ");
                else
                    bufferedWriter.write(Integer.toString(graph[i][j]) + " ");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
    private static void bfs(int y, int x){
        ArrayList<Point> arrayList = new ArrayList<>();
        arrayList.add(new Point(y,x));

        while(!arrayList.isEmpty()){
            Point point = arrayList.remove(0);
            for(int i = 0 ; i < 4 ; i ++){
                int tempY = point.getY() + dy[i];
                int tempX = point.getX() + dx[i];
                if(0 <= tempX && tempX < m && 0 <= tempY && tempY < n && graph[tempY][tempX] != WALL && !visited[tempY][tempX]){
                    arrayList.add(new Point(tempY,tempX));
                    visited[tempY][tempX] = true;
                    graph[tempY][tempX] = graph[point.getY()][point.getX()] + 1;
                }
            }
        }
    }

    static class Point{
        private int x, y;
        public Point(int y, int x){
            this.x = x;
            this.y = y;
        }
        public int getX(){return x;}
        public int getY(){return y;}
    }
}