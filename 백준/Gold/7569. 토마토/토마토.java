import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    private static int n, m, h;
    private final static int ROTTEN = 1;
    private final static int NORMAL = 0;
    private static int[][][] tomatos = null;
    private static int []dx = {-1,0,1,0,0,0};
    private static int []dy = {0,-1,0,1,0,0};
    private static int []dz = {0,0,0,0,-1,1};
    private static class MyPoint {
        private int x, y, z;
        public MyPoint(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }
        public int getX(){return x;}
        public int getY(){return y;}
        public int getZ(){return z;}
    }
    private static LinkedList<MyPoint> linkedList = new LinkedList<>();
    private static void dfs(int z, int y, int x){
        for(int i = 0 ; i < 6 ; i ++){
            int tempZ = z + dz[i];
            int tempY = y + dy[i];
            int tempX = x + dx[i];

            if(0 <= tempZ && tempZ < h && 0 <= tempY && tempY < n && 0 <= tempX && tempX < m
                && tomatos[tempZ][tempY][tempX] == NORMAL){
                linkedList.add(new MyPoint(tempZ,tempY,tempX));
                tomatos[tempZ][tempY][tempX] += tomatos[z][y][x] + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        h = scanner.nextInt();

        tomatos = new int[h][n][m];
        for(int k = 0 ; k < h ; k++){
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < m ; j ++){
                    tomatos[k][i][j] = scanner.nextInt();
                    if(tomatos[k][i][j] == ROTTEN)
                        linkedList.add(new MyPoint(k,i,j));
                }
            }
        }

        while(!linkedList.isEmpty()){
            MyPoint temp = linkedList.removeFirst();
            dfs(temp.z,temp.y,temp.x);
        }

        int day = Integer.MIN_VALUE;
        for(int k = 0 ; k < h ; k++){
            for(int i = 0 ; i < n ; i ++){
                for(int j = 0 ; j < m ; j ++){
                    if(tomatos[k][i][j] == NORMAL){
                        System.out.println(-1);
                        return;
                    }
                    day = Math.max(day, tomatos[k][i][j]);
                }
            }
        }
        System.out.println(day - 1);
        scanner.close();
    }
}