import java.util.ArrayList;
import java.util.List;

public class ProblemaMochila {

    public static void main(String[] args) {
        int[] P = {4, 2, 1, 3};
        int[] B = {2000, 1500, 1500, 2100};
        String[] dispositivos = {"Laptop", "Tablet", "Smartphone", "Cámara"};
        int W = 6;

        mochila(P, B, dispositivos, W);
    }

    public static int mochila(int[] P, int[] B, String[] dispositivos, int W) {
        int N = P.length;

        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (P[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], B[i - 1] + dp[i - 1][w - P[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        List<String> seleccionados = new ArrayList<>();
        int w = W;

        for (int i = N; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                seleccionados.add(dispositivos[i - 1]);
                w -= P[i - 1];
            }
        }

        System.out.println("Beneficio máximo: " + dp[N][W]);
        System.out.println("Dispositivos en la mochila: " + seleccionados);

        return dp[N][W];
    }
}
