package JogoDados;

import java.util.Random;

public class Dados {
    private int lados = 6;

    // constructors
    public Dados () {
        this(6);
    }

    public Dados(int lados) {
        this.lados = lados;
    }

    // getters and setters
    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

    public int rolar () {
        Random rand = new Random();
        int result = rand.nextInt(getLados()) + 1;
        return result;
    }
}
