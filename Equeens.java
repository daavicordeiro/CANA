package Equeens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;


public class Equeens {

    public static void main(String[] args) {
        solveNQueens(8); // Resolver o problema das 8 damas
    }

    public static void solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(); // Lista para armazenar soluções
        ArrayList<String> tabul = new ArrayList<>();   // Representação do tabuleiro

        backQueens(result, tabul, new HashSet<>(), new HashSet<>(), new HashSet<>(), 0, n);

        if (!result.isEmpty()) {
            System.out.println("\nSolução encontrada:\n");
            for (String linha : result.get(0)) {
                System.out.println(linha);
            }
        }
    }

    private static boolean backQueens(List<List<String>> result, ArrayList<String> tabul,
                                      Set<Integer> rainhasColunas, Set<Integer> diagPrinci, Set<Integer> diagSegund,
                                      int linha, int tam) {

        if (linha == tam) {
            result.add(new ArrayList<>(tabul));
            return true; // Parar após a primeira solução
        }

        // Gera uma ordem aleatória de colunas para tentar
        List<Integer> colunas = new ArrayList<>();
        for (int i = 0; i < tam; i++) colunas.add(i);
        Collections.shuffle(colunas); // Embaralha

        for (int i : colunas) {
            if (rainhasColunas.contains(i) || diagPrinci.contains(linha - i) || diagSegund.contains(linha + i)) {
                continue; // Posição inválida, pula
            }

            // Marca posição como usada
            rainhasColunas.add(i);
            diagPrinci.add(linha - i);
            diagSegund.add(linha + i);

            tabul.add(linhaTabul(i, tam));

            if (backQueens(result, tabul, rainhasColunas, diagPrinci, diagSegund, linha + 1, tam)) {
                return true;
            }

            // Backtrack
            tabul.remove(tabul.size() - 1);
            rainhasColunas.remove(i);
            diagPrinci.remove(linha - i);
            diagSegund.remove(linha + i);
        }

        return false;
    }

    private static String linhaTabul(int localRainha, int tam) {
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < tam; i++) {
            if (i == localRainha) {
                aux.append(" Q ");
            } else {
                aux.append(" . ");
            }
        }
        return aux.toString();
    }
}

