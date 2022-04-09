package programacaoavancada;

import java.util.Scanner;

/**
 *
 * @author Fagner Silva
 */
public class Currupio extends Passaro {
    //- Defina duas classe concretas chamadas Papagaio e Currupio que estendem Passaro

    Scanner sc = new Scanner(System.in);

    String cantar() {
        return "Piu frio fru fri Pió";
        // * O método cantar() mostra na tela a string "Piu frio fru fri Pió"
    }

    void voar() {
        /* O método voar() retorna o menor valor entre o valor informado e a
       distancia máxima de voo definida no construtor do objeto  */
        int b = 20, valor;
        System.out.println("\nDigite a distancia do currupio:");
        valor = sc.nextInt();
        if ((valor > b)) {
            System.out.println("\n o menor valor é: "+b);

        } else {
            System.out.println("\n o menor valor é: "+valor);
        }
    }
}
