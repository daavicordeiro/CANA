import java.util.*;

public class SubsetSumZeroBacktracking {

    public static void main(String[] args) {
        int[] numeros = {-7, -3, -2, 5, 8};

        System.out.println("Array de entrada: " + Arrays.toString(numeros));
        System.out.println("Buscando subconjuntos com soma zero (usando backtracking)...");

        List<Integer> subconjuntoAtual = new ArrayList<>();
        boolean[] encontrou = {false}; // Para saber se pelo menos um subconjunto foi encontrado

        buscarSubconjuntos(0, numeros, subconjuntoAtual, 0, encontrou);

        if (!encontrou[0]) {
            System.out.println("Nenhum subconjunto com soma zero foi encontrado.");
        }
    }

   
    public static void buscarSubconjuntos(int indice, int[] numeros, List<Integer> subconjuntoAtual, int somaAtual, boolean[] encontrou) {
        
        System.out.println("Índice: " + indice + ", Subconjunto atual: " + subconjuntoAtual + ", Soma atual: " + somaAtual);

        if (somaAtual == 0 && !subconjuntoAtual.isEmpty()) {
            System.out.println("Subconjunto encontrado com soma zero: " + subconjuntoAtual);
            encontrou[0] = true;
            
        }

        
        if (indice == numeros.length) {
            return;
        }

        
        subconjuntoAtual.add(numeros[indice]);
        buscarSubconjuntos(indice + 1, numeros, subconjuntoAtual, somaAtual + numeros[indice], encontrou);

    
        subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        buscarSubconjuntos(indice + 1, numeros, subconjuntoAtual, somaAtual, encontrou);
    }
}
