public class KnapsackBasico {
    public static void main(String[] args) {
        // Dados dos itens: nome, peso e preco
        String[] nomes = {"Livro", "Notebook", "Câmera", "Garrafa Térmica", "Headset", "Tablet"};
        int[] pesos = {3, 4, 2, 1, 2, 3};
        int[] precos = {8, 10, 5, 3, 4, 6};

        // Calcular razão valor/peso
        double[] razoes = new double[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            razoes[i] = (double) precos[i] / pesos[i];
        }

        // Ordenar manualmente em ordem decrescente de razão (algoritmo de ordenação simples: seleção)
        for (int i = 0; i < nomes.length - 1; i++) {
            int maiorIndice = i;
            for (int j = i + 1; j < nomes.length; j++) {
                if (razoes[j] > razoes[maiorIndice]) {
                    maiorIndice = j;
                }
            }
            // Trocar elementos
            String tempNome = nomes[i];
            nomes[i] = nomes[maiorIndice];
            nomes[maiorIndice] = tempNome;

            int tempPeso = pesos[i];
            pesos[i] = pesos[maiorIndice];
            pesos[maiorIndice] = tempPeso;

            int tempPreco = precos[i];
            precos[i] = precos[maiorIndice];
            precos[maiorIndice] = tempPreco;

            double tempRazao = razoes[i];
            razoes[i] = razoes[maiorIndice];
            razoes[maiorIndice] = tempRazao;
        }

        // Capacidade da mochila
        int capacidade = 10;
        int pesoTotal = 0;
        int valorTotal = 0;

        System.out.println("Itens escolhidos:");

        // Escolher itens seguindo o algoritmo guloso
        for (int i = 0; i < nomes.length; i++) {
            if (pesoTotal + pesos[i] <= capacidade) {
                System.out.println("- " + nomes[i] + " (Peso: " + pesos[i] + " kg, Preço: R$" + precos[i] + ")");
                pesoTotal += pesos[i];
                valorTotal += precos[i];
            } else {
                System.out.println("Não coube: " + nomes[i] + " (Peso: " + pesos[i] + " kg)");
            }
        }

        System.out.println("\nPeso total: " + pesoTotal + " kg");
        System.out.println("Valor total: R$" + valorTotal);
    }
}
