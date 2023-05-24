import java.util.*;
public class sol4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minPills(n, v, arr));
        sc.close();
    }
    public static int minPills(int N, int V, int[] a) {
        int pills = 0;
        int health = V;
        for (int i = 0; i < N; i++) {
            if (health <= 0) {
                break; 
            } 
            else if (a[i] >= health) {
                pills++;
                health = health + a[i];
            } 
            else {
                health--;
            }
        }
        return pills;
    }
}