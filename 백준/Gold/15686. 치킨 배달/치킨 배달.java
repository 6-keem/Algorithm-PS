import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static int [][]graph = null;
    private static ArrayList<Point> homeList = new ArrayList<>();
    private static ArrayList<Point> chickenList = new ArrayList<>();
    private static boolean [] visited = null;
    private static int n,m;
    private static int distance = Integer.MAX_VALUE;
    public static final int HOME = 1;
    public static final int CHICKEN = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < n ; j ++){
                graph[i][j] = scanner.nextInt();
                if(graph[i][j] == HOME)
                    homeList.add(new Point(j,i));
                else if(graph[i][j] == CHICKEN)
                    chickenList.add(new Point(j,i));
            }
        }
        visited = new boolean[chickenList.size()];
        backTracking(0,0);
        System.out.println(distance);
        scanner.close();
    }
    public static void backTracking(int count, int index){
        //치킨집이 선택될 수도 있고 안될 수도 있는데 선택된 치킨 집 중에서 가장 가까운 치킨 집에 대해 거리 계산
        if(count == m){
            int total = 0;
            for(int i = 0 ; i < homeList.size() ; i++){
                int dist = Integer.MAX_VALUE;
                for(int j = 0 ; j < chickenList.size() ; j++){
                    if(visited[j] == true){
                        int temp = Math.abs(homeList.get(i).getX() - chickenList.get(j).getX()) +
                                Math.abs(homeList.get(i).getY() - chickenList.get(j).getY());
                        dist = dist < temp ? dist : temp;
                    }
                }
                total += dist;
            }
            distance = distance < total ? distance : total;
        }
        else {
            for(int i = index ; i < chickenList.size() ; i ++){
                if(visited[i] == false){
                    visited[i] = true;
                    backTracking(count + 1, i + 1);
                    visited[i] = false;
                }
            }
        }
    }
    static class Point{
        private int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){return x;}
        public int getY(){return y;}
    }
}