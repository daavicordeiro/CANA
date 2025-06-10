import java.util.*;

public class SubsetSumIterativo {
    public static void main(String[] args) {
        int[] numeros = { -7, -3, -2, 5, 8 };

        // Inicializa a lista de subconjuntos com o subconjunto vazio
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>()); // subconjunto vazio

        // Iterativamente constrói subconjuntos
        for (int num : numeros) {
            // Novos subconjuntos formados ao adicionar o elemento atual
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();

            for (List<Integer> subconjunto : subconjuntos) {
                List<Integer> novoSubconjunto = new ArrayList<>(subconjunto);
                novoSubconjunto.add(num);
                novosSubconjuntos.add(novoSubconjunto);
            }

            // Adiciona os novos subconjuntos à lista principal
            subconjuntos.addAll(novosSubconjuntos);
        }

        // Remover o subconjunto vazio e mostrar cada passo
        subconjuntos.removeIf(List::isEmpty);

        // Lista final com subconjuntos que somam zero
        List<List<Integer>> subconjuntosZero = new ArrayList<>();

        for (List<Integer> subconjunto : subconjuntos) {
            int soma = 0;
            for (int num : subconjunto) {
                soma += num;
            }
            // Mostrar o passo atual
            System.out.println("Subconjunto atual: " + subconjunto + " | Soma: " + soma);
            if (soma == 0) {
                subconjuntosZero.add(subconjunto);
            }
        }

        // Mostrar o resultado final
        System.out.println("\nSubconjuntos que somam zero:");
        for (List<Integer> subconjunto : subconjuntosZero) {
            System.out.println(subconjunto);
        }
    }
}
