package questao01;

import java.util.Arrays;
import java.util.Random;

public class BilheteDeLoteria {

    private int[] bilhete;

    public BilheteDeLoteria(int tamanho) {
        this.bilhete = new int[tamanho];
        Random random = new Random();
        int valor;
        for (int i = 0; i < tamanho; ) {
            valor = random.nextInt(60) + 1;
            boolean check = contains(bilhete, valor);
            if(!check) {
                bilhete[i] = valor;
                i++;
            }
        }
        Arrays.sort(bilhete);
    }

    public boolean contains(int[] vetor, int valor) {
        boolean achou = false;
        for(int i = 0; i < vetor.length; i++) {
            if(vetor[i] == valor) {
                achou = true;
                break;
            }
        }
        return achou;
    }

    public int qtdNumerosContidos(BilheteDeLoteria bilheteOutro) {
        int numContidos = 0;
            for(int i = 0; i < bilheteOutro.getBilhete().length; i++) {
                if(contains(bilhete, bilheteOutro.getBilhete()[i])) {
                    numContidos++;
                }
            }
        return numContidos;
    }

    @Override
    public String toString() {
        return Arrays.toString(bilhete);
    }

    public int[] getBilhete() {
        return bilhete;
    }

}
