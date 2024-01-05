import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        for(int i = 0 ; i < r ; i ++){
            HashMap<String, Integer> hashMap = new HashMap<>();
            int n = scanner.nextInt();
            for(int j = 0 ; j < n ; j ++){
                String detail = scanner.next();
                String item = scanner.next();
                if(hashMap.get(item) == null)
                    hashMap.put(item, 1);
                else
                    hashMap.replace((item),hashMap.get(item) + 1);
            }
            int total = 1;
            for(String key : hashMap.keySet())
                total *= hashMap.get(key)+1;
            total -= 1;
            System.out.println(total);
        }
        scanner.close();
    }
}
