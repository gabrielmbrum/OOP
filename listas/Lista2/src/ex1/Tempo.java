package ex1;

public class Tempo {
    private int horas;
    private int minuto;
    private int segundo;

    // Constructor
    public Tempo () {
        this(0, 0, 0);
    }

    public Tempo (int h, int m, int s) {
        horas = h;
        minuto = m;
        segundo = s;
    }

    // Getters and Setter
    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    // Imprime no formato hh:mm:ss
    public void Print() {
        System.out.println("\n" + horas + ":" + minuto + ":" + segundo);
    }

    // Substrai dois objetos e coloca o resultado no objeto que chamou o método
    public void Subtrai (Tempo t) {
        // se t.horas for maior que horas, horas recebe 0
        horas = (t.horas > horas) ? 0 : horas - t.horas;

        if (horas == 0) {
            minuto = 0;
            segundo = 0;
            return;
        }

        // t.minuto > minuto && horas != 0
        if (t.minuto > minuto) {
            horas -= 1;
            minuto = 60 - (t.minuto - minuto);

        } else {
            minuto -= t.minuto;
        }

        if (t.segundo > segundo) {
            if (minuto > 0) {
                minuto -= 1;
                segundo = 60 -(t.segundo - segundo);
            } else {
                segundo = 0;
            }
        } else segundo -= t.segundo;
    }

    // Soma dois objetos e coloca o resultado no objeto que chamou o método
    public void Soma (Tempo t) {
        // somando segundos
        if (segundo + t.segundo > 60) {
            minuto += 1;
            segundo = (segundo + t.segundo) - 60;
        } else {
            segundo += t.segundo;
        }

        // somando minutos
        if (minuto + t.minuto > 60) {
            horas += 1;
            minuto = (minuto + t.minuto) - 60;
        } else {
            minuto += t.minuto;
        }

        // somando horas
        horas += t.horas;
    }

    // Sobrecarrega o método "Soma" e retorna um objeto com a soma dos elementos
    public Tempo SomaSobre (Tempo t1, Tempo t2) {
        t1.Soma(t2);
        return t1;
    }

}
