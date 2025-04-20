public class Veiculo{
    private String placa;
    private String modelo;
    private String fabricante;

    public Veiculo (String placa, String modelo, String fabricante){
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;

    }

    public String getFabricante() {
        return fabricante;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPlaca(String nome) {
        this.placa = nome;

    }
    public void setFabricante(String especie) {
        this.fabricante = especie;

    }
    public void exibirInfo() {
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Fabricante: " + fabricante);
    }
}

