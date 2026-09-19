
public class Veiculo {

    private String marca;
    private String modelo;
    private int ano;
    private String placa;

    public Veiculo(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa.toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("Marca: %-15s | Modelo: %-20s | Ano: %d | Placa: %s",
                marca, modelo, ano, placa);
    }
}
