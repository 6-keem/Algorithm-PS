import java.util.Scanner;

public class Main {
    private static int [][]array;
    private static int n, m;
    private static int calculate(){
        int answer = 1;
        int maxLength = n > m ? n : m;
        for(int length = 1 ; length < maxLength ; length++){
            for(int i = 0 ; i < n ; i ++){
                if(i + length < n){
                    for(int j = 0 ; j < m ; j ++){
                        if(length + j < m){
                            int lt = array[i][j];
                            int rt = array[i][j + length];
                            int lb = array[i+length][j];
                            int rb = array[i + length][j+length];
                            if(lt == rt && rt == lb && lb == rb)
                                answer = (length + 1) * (length + 1);
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        array = new int[n][m];
        for(int i = 0 ; i < n ; i ++){
            String tokens[] = scanner.next().split("");
            for(int j = 0 ; j < m ; j ++){
                array[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        System.out.println(calculate());
        scanner.close();
    }
}