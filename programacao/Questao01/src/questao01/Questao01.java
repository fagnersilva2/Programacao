/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao01;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Fagner Silva
 */
public class Questao01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o numero");
        n = input.nextInt();
        fatorial(n);

    }

    public static BigInteger fatorial(int numero) {
        int controle = 0;
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= numero; i++) {
            controle++;
            resultado = resultado.multiply(BigInteger.valueOf(i));

        }
        System.out.println("O fatorial de  " + numero + " é = " + resultado);
        return resultado;
    }

}
