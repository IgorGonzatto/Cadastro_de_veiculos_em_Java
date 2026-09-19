import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final VeiculoService service = new VeiculoService();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarVeiculo();
                case 2 -> listarVeiculos();
                case 3 -> consultarVeiculo();
                case 0 -> System.out.println("\nSistema encerrado. Até logo!");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n======= Cadastro de Veículos OO =======");
        System.out.println("1 - Cadastrar Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Consultar Veículo");
        System.out.println("0 - Sair");
        System.out.println("----------------------------------------");
    }

    private static void cadastrarVeiculo() {
        System.out.println("\n--- Cadastrar Veículo ---");

        System.out.print("Marca  : ");
        String marca = scanner.nextLine().trim();

        System.out.print("Modelo : ");
        String modelo = scanner.nextLine().trim();

        int ano = lerInteiro("Ano    : ");

        System.out.print("Placa  : ");
        String placa = scanner.nextLine().trim();

        if (marca.isEmpty() || modelo.isEmpty() || placa.isEmpty()) {
            System.out.println("\nErro: nenhum campo pode estar vazio.");
            return;
        }

        String resultado = service.cadastrar(marca, modelo, ano, placa);
        System.out.println("\n" + resultado);
    }

    private static void listarVeiculos() {
        System.out.println("\n--- Lista de Veículos ---");
        System.out.println(service.listar());
    }

    private static void consultarVeiculo() {
        System.out.println("\n--- Consultar Veículo ---");
        System.out.print("Informe a placa: ");
        String placa = scanner.nextLine().trim();

        System.out.println("\n" + service.consultar(placa));
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
            }
        }
    }
}
