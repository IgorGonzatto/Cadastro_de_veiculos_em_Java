import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VeiculoService {

    private static final int ANO_MINIMO = 1900;

    private final List<Veiculo> veiculos;

    public VeiculoService() {
        this.veiculos = new ArrayList<>();
    }

    /**
     * Cadastra um novo veículo após realizar as validações necessárias.
     *
     * @return mensagem descrevendo o resultado da operação
     */
    public String cadastrar(String marca, String modelo, int ano, String placa) {
        String validacao = validarDados(ano, placa);
        if (validacao != null) {
            return validacao;
        }

        Veiculo veiculo = new Veiculo(marca, modelo, ano, placa);
        veiculos.add(veiculo);
        return "Veículo cadastrado com sucesso!";
    }

    public String listar() {
        if (veiculos.isEmpty()) {
            return "Nenhum veículo cadastrado.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-3s | %-15s | %-20s | %-4s | %s%n",
                "#", "Marca", "Modelo", "Ano", "Placa"));
        sb.append("-".repeat(65)).append("\n");

        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            sb.append(String.format("%-3d | %-15s | %-20s | %-4d | %s%n",
                    i + 1, v.getMarca(), v.getModelo(), v.getAno(), v.getPlaca()));
        }

        return sb.toString();
    }

    /**
     * Consulta um veículo pela placa.
     *
     * @return dados do veículo encontrado ou mensagem de não encontrado
     */
    public String consultar(String placa) {
        Veiculo encontrado = buscarPorPlaca(placa);

        if (encontrado == null) {
            return "Nenhum veículo encontrado com a placa: " + placa.toUpperCase();
        }

        return "Veículo encontrado:\n" +
               "  Marca  : " + encontrado.getMarca()  + "\n" +
               "  Modelo : " + encontrado.getModelo() + "\n" +
               "  Ano    : " + encontrado.getAno()    + "\n" +
               "  Placa  : " + encontrado.getPlaca();
    }

    private String validarDados(int ano, String placa) {
        int anoMaximo = LocalDate.now().getYear() + 1;

        if (ano < ANO_MINIMO || ano > anoMaximo) {
            return String.format(
                    "Ano inválido! Informe um ano entre %d e %d.", ANO_MINIMO, anoMaximo);
        }

        if (buscarPorPlaca(placa) != null) {
            return "Placa já cadastrada! Não é possível cadastrar dois veículos com a mesma placa.";
        }

        return null;
    }

    private Veiculo buscarPorPlaca(String placa) {
        String placaNormalizada = placa.toUpperCase();
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placaNormalizada)) {
                return v;
            }
        }
        return null;
    }
}
