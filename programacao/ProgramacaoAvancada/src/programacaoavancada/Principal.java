package programacaoavancada;

/**
 *
 * @author Fagner Silva
 */
public class Principal {

    public static void main(String[] args) {
        Papagaio t1 = new Papagaio();
        System.err.println(t1.cantar() + "\n");
        t1.voar();

        Currupio t2 = new Currupio();
        System.err.println(t2.cantar());
        t2.voar();
    }

}
