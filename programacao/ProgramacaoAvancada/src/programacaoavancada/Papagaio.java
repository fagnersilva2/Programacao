package programacaoavancada;

import java.util.Scanner;

/**
 *
 * @author Fagner Silva
 */
public class Papagaio extends Passaro {
    //- Defina duas classe concretas chamadas Papagaio e Currupio que estendem Passaro

    Scanner sc = new Scanner(System.in);

    String cantar() {
        return "Papagaio legal";
        //O método cantar() mostra na tela a string "Papagaio legal"
    }

    /* O método voar() retorna o menor valor entre o valor informado
            e a distancia máxima de voo definida no construtor do objeto  */
    public void voar() {
        int b = 20, valor;
        System.out.println("\nDigite a distancia do papagaio:");
        valor = sc.nextInt();
        if ((valor > b)) {
            System.out.println("\n o menor valor é: "+b);

        } else {
            System.out.println("\n o menor valor é: "+valor);
        }
    }



}
