import java.util.ArrayList;
import java.util.List;

public class SubsetSumZeroBackT {

    public static void main(String[] args) {
        int[] numeros = {-7, -3, -2, 5, 8};
        encontrarSubconjuntosComSomaZero(numeros, 0, new ArrayList<>(), 0);
    }

    public static void encontrarSubconjuntosComSomaZero(int[] numeros, int indice, List<Integer> atual, int somaAtual) {
        if (somaAtual == 0 && !atual.isEmpty()) {
            System.out.println(atual);
        }
        if (indice == numeros.length) {
            return;
        }

        // Incluir o elemento atual
        atual.add(numeros[indice]);
        encontrarSubconjuntosComSomaZero(numeros, indice + 1, atual, somaAtual + numeros[indice]);

        // Excluir o elemento atual (backtrack)
        atual.remove(atual.size() - 1);
        encontrarSubconjuntosComSomaZero(numeros, indice + 1, atual, somaAtual);
    }
}
