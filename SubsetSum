import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int[] numeros = {-7, -3, -2, 5, 8};

        System.out.println("Subconjuntos com soma zero:");
        encontrarSubconjuntosComSomaZero(numeros);
    }

    public static void encontrarSubconjuntosComSomaZero(int[] numeros) {
        int n = numeros.length;
        // Total de subconjuntos possíveis (2^n)
        int totalSubconjuntos = (1 << n);

        for (int mascara = 1; mascara < totalSubconjuntos; mascara++) { // Começamos de 1 para evitar subconjunto vazio
            List<Integer> subconjunto = new ArrayList<>();
            int soma = 0;

            for (int i = 0; i < n; i++) {
                if ((mascara & (1 << i)) != 0) { // Checa se o i-ésimo elemento está presente no subconjunto
                    subconjunto.add(numeros[i]);
                    soma += numeros[i];
                }
            }

            if (soma == 0) {
                System.out.println(subconjunto);
            }
        }
    }
}
