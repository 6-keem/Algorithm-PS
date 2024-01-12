import java.util.Scanner;

public class Main{
    static class Item{
        private int weight, value;
        public Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
        public int getWeight(){return weight;}
        public int getValue(){return value;}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Item []items = new Item[n + 1];
        int [][]dp = new int[n + 1][k + 1];
        items[0] = new Item(0,0);

        for(int i = 1 ; i <= n ; i ++){
            int weight = scanner.nextInt();
            int value = scanner.nextInt();
            items[i] = new Item(weight,value);
        }

        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <= k ; j ++){
                dp[i][j] = dp[i-1][j];
                if(j - items[i].getWeight() >= 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i].getWeight()] + items[i].getValue());
            }
        }

        System.out.println(dp[n][k]);
        scanner.close();
    }
}