package estacionamento;

public class Carro {
    // attributes
    private static final double valorHora = 1.5;
    private String placa;
    private String modelo;
    private int horaEnt;
    private int horaSai;

    // constructor
    public Carro () {
        this(" ", " ", 0, 0);
    }
    public Carro(String placa, String modelo, int horaEnt, int horaSai) {
        this.placa = placa;
        this.modelo = modelo;
        this.horaEnt = horaEnt;
        this.horaSai = horaSai;
    }

    // getters
    public String getPlaca() {
        return placa;
    }

    public String getModelo () {
        return modelo;
    }

    public int getHoraEnt () {
        return horaEnt;
    }

    public int getHoraSai () {
        return horaSai;
    }

    // setters
    public void setPlaca (String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setHoraEnt(int horaEnt) {
        this.horaEnt = horaEnt;
    }

    public void setHoraSai(int horaSai) {
        this.horaSai = horaSai;
    }

    // methods
    public void print () {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Hora de Entrada: " + horaEnt);
        System.out.println("Hora de Saída: " + horaSai);
        System.out.println("Valor de Pagamento: " + getTotal());
    }
    public double getTotal () {
        return ((horaSai - horaEnt) * valorHora); //não consegui usra a função tempo pois esta no ubuntu
    }
}
