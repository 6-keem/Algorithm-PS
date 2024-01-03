import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = scanner.nextInt();

        for(int i = 0 ; i < n ; i ++){
            int a = scanner.nextInt();
            if(a == 0){
                if(heap.isEmpty())
                    System.out.println("-1");
                else{
                    System.out.println(heap.remove());
                }
            }
            else{
                for(int j = 0 ; j < a ; j ++)
                    heap.add(scanner.nextInt());
            }
        }
        scanner.close();
    }
}
