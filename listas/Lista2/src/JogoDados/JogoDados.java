package JogoDados;

public class JogoDados {
    public static void main(String[] args) {
        // const
        final int MAX = 5;

        // declaring and inserting objects
        Jogador a = new Jogador("Roberto");
        Jogador b = new Jogador("Flávio");

        // playing
        int aux, aux2;
        while (a.getPontuacao() < MAX && b.getPontuacao() < MAX) {
            aux = a.getDado().rolar();
            aux2 = b.getDado().rolar();

            System.out.print("==============================");
            System.out.println("\n" + a.getNome() + " rolou " + aux);
            System.out.println("\n" + b.getNome() + " rolou " + aux2);

            if (aux > aux2)
                a.addPoint();
            else if (aux2 > aux)
                b.addPoint();
            else
                System.out.println("\nEMPATE!");


        }

        // showing the winner
        if (a.getPontuacao() == MAX)
            System.out.println("\nParabéns " + a.getNome() + "!!!");
        else
            System.out.println("\nParabéns " + b.getNome() + "!!!");
    }
}
