import java.util.Scanner;

public class Main {

    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int qtdVeiculos = solicitarQuantidadeVeiculos();

        Veiculo[] arrayVeiculo = new Veiculo[qtdVeiculos];
        Veiculo[] arrayVeiculoAntes = new Veiculo[qtdVeiculos];

        preencherVeiculos(arrayVeiculo, arrayVeiculoAntes);

        int criterio = solicitarCriterioOrdenacao();

        ordenarVeiculosBubbleSort(arrayVeiculo, criterio);

        System.out.println("\n--- Veículos cadastrados ANTES DE ORDENAR ---");
        exibirLista(arrayVeiculoAntes);

        System.out.println("\n--- Veículos cadastrados DEPOIS DE ORDENAR ---");
        exibirLista(arrayVeiculo);

    }

    public static int solicitarQuantidadeVeiculos() {
        System.out.println("Quantos veículos você deseja inserir no sistema?");
        return ler.nextInt();
    }

    public static void preencherVeiculos(Veiculo[] veiculos, Veiculo[] copia) {
        for (int i = 0; i < veiculos.length; i++) {
            System.out.println("Informe a placa do " + (i + 1) + "º Veículo:");
            String placa = ler.next();

            System.out.println("Informe o modelo do " + (i + 1) + "º Veículo:");
            String modelo = ler.next();

            System.out.println("Informe a fabricante do " + (i + 1) + "º Veículo:");
            String fabricante = ler.next();

            veiculos[i] = new Veiculo(placa, modelo, fabricante);
            copia[i] = new Veiculo(placa, modelo, fabricante);
        }
    }

    public static int solicitarCriterioOrdenacao() {
        System.out.println("Informe o critério de ordenação:");
        System.out.println("1. PLACA");
        System.out.println("2. MODELO");
        System.out.println("3. FABRICANTE");
        return ler.nextInt();
    }

    public static void ordenarVeiculosBubbleSort(Veiculo[] veiculos, int criterio) {
        for (int i = 0; i < veiculos.length - 1; i++) {
            for (int j = 0; j < veiculos.length - 1 - i; j++) {
                boolean precisaTrocar = false;

                switch (criterio) {
                    case 1:
                        precisaTrocar = veiculos[j].getPlaca().compareToIgnoreCase(veiculos[j + 1].getPlaca()) > 0;
                        break;
                    case 2:
                        precisaTrocar = veiculos[j].getModelo().compareToIgnoreCase(veiculos[j + 1].getModelo()) > 0;
                        break;
                    case 3:
                        precisaTrocar = veiculos[j].getFabricante().compareToIgnoreCase(veiculos[j + 1].getFabricante()) > 0;
                        break;
                    default:
                        System.out.println("Critério inválido. Ordenando por PLACA por padrão.");
                        precisaTrocar = veiculos[j].getPlaca().compareToIgnoreCase(veiculos[j + 1].getPlaca()) > 0;
                }

                if (precisaTrocar) {
                    Veiculo aux = veiculos[j];
                    veiculos[j] = veiculos[j + 1];
                    veiculos[j + 1] = aux;
                }
            }
        }
    }

    public static void exibirLista(Veiculo[] lista) {
        for (Veiculo v : lista) {
            v.exibirInfo();
            System.out.println("---------------------------");
        }
    }
}
