import java.util.*;

public class SubsetSumZero {

    public static void main(String[] args) {
       
        int[] numeros = {-7, -3, -2, 5, 8};

        System.out.println("Array de entrada: " + Arrays.toString(numeros));
        System.out.println("Buscando subconjuntos com soma zero...");

      
        encontrarSubconjuntosSomaZero(numeros);
    }

    public static void encontrarSubconjuntosSomaZero(int[] numeros) {
        int n = numeros.length;
        boolean encontrou = false;

        for (int i = 1; i < (1 << n); i++) {
            List<Integer> subconjunto = new ArrayList<>();
            int soma = 0;

            System.out.print("Subconjunto gerado: { ");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subconjunto.add(numeros[j]);
                    soma += numeros[j];
                    System.out.print(numeros[j] + " ");
                }
            }
            System.out.print("} -> Soma: " + soma);

            if (soma == 0) {
                System.out.println("  <- Soma zero encontrada!");
                encontrou = true;
            } else {
                System.out.println();
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum subconjunto com soma zero foi encontrado.");
        }
    }
}
