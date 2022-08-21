package questao01;

import java.util.ArrayList;

public class MinhaLoteria {

    public static void main(String[] args) {
        BilheteDeLoteria bilhetePremiado = new BilheteDeLoteria(6);
        for(int x = 6; x <= 15; x++) {
            //ArrayList não é usado e está dando problema no código (OutOfMemory)
            //ArrayList<BilheteDeLoteria> bilhetes = new ArrayList<>();

            boolean megaSena = false;
            int numeros;
            int quina = 0;
            int quadra = 0;
            long tentativas = 0;
            while(megaSena == false) {
                BilheteDeLoteria bilheteSorteado = new BilheteDeLoteria(x);
                //bilhetes.add(bilheteSorteado);
                numeros = bilhetePremiado.qtdNumerosContidos(bilheteSorteado);

                tentativas++;

                if(numeros == 4)
                    quadra++;
                else if (numeros == 5)
                    quina++;
                else if (numeros == 6)
                    megaSena = true;
            }
            System.out.printf("Jogos de %d numeros: voce apostou %d vezes para ganhar na mega-sena. Dentre esses jogos, voce acertou %d quadras e %d quinas.\n\n", x, tentativas, quadra, quina);
        }
    }
}


