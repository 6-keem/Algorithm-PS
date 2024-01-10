import java.util.Scanner;

public class Main{
    private static String [][] colors = null;
    private static boolean [][] visited = null;
    private static int [] dx = {-1,0,1,0};
    private static int [] dy = {0,1,0,-1};
    private static int n;

    private static void dfs(int y, int x, String currentCharacter){
        if(visited[y][x])
            return;
        visited[y][x] = true;
        for(int i = 0 ; i < 4 ; i ++){
           int tempY = y + dy[i];
           int tempX = x + dx[i];
           if(0 <= tempX && tempX < n && 0 <= tempY && tempY < n && currentCharacter.equals(colors[tempY][tempX]))
               dfs(tempY,tempX, currentCharacter);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        visited = new boolean[n][n];
        colors = new String[n][n];

        for(int i = 0 ; i < n ; i ++){
            String []color = scanner.next().split("");
            for(int j = 0 ; j < color.length ; j ++) {
                colors[i][j] = color[j];
                visited[i][j] = false;
            }
        }

        int normal = 0,colorBlind = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j ++){
                if(!visited[i][j]){
                    dfs(i,j,colors[i][j]);
                    normal ++;
                }
            }
        }

        for(int i = 0 ; i < n ;i ++){
            for(int j = 0 ; j < n ; j++){
                visited[i][j] = false;
                if(colors[i][j].equals("G"))
                    colors[i][j] = "R";
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j ++){
                if(!visited[i][j]){
                    dfs(i,j,colors[i][j]);
                    colorBlind++;
                }
            }
        }

        System.out.println(normal + " " + colorBlind);
        scanner.close();
    }
}