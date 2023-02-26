import java.util.Arrays;
import java.util.Random;

class Main {
    final Random random = new Random();

    public static void main(String[] args) {
        Main main = new Main();

        int[] vetor = main.criarVetorOrdenado();


        main.buscaSequencial(vetor, vetor[4]);
        System.out.println("-".repeat(100));

        main.buscaBinaria(vetor, vetor[0]);
        System.out.println("-".repeat(100));

        main.buscaBinaria(vetor, vetor[9]);
        System.out.println("-".repeat(100));

        main.buscaBinaria(vetor, -10);
        System.out.println("-".repeat(100));

        main.buscaBinaria(vetor, 10000);
        System.out.println("-".repeat(100));

        main.buscaBinaria(vetor, 500);
        System.out.println("-".repeat(100));
    }

    private void buscaSequencial(int[] vetor, int valor) {
        System.out.printf("Busca Sequencial de '%d' em %s\n", valor, Arrays.toString(vetor));

        int indice = -1;

        for (int i = 0; i < vetor.length; i++) {

            if (vetor[i] == valor) {
                indice = i;
                break;
            }
        }


        if (indice >= 0) {
            System.out.printf("O valor '%d' foi encontrado na posicao %d\n", vetor[indice], indice);
        } else {
            System.out.printf("O valor '%d' nao foi encontrado\n", valor);
        }
    }

    private void buscaBinaria(int[] vetor, int valor) {
        System.out.printf("Busca Binaria de '%d' em %s\n", valor, Arrays.toString(vetor));

        int inicio = 0;
        int meio;
        int fim = vetor.length;

        int indice = -1;


        while (true) {
            meio = (inicio + fim) / 2;

            if (valor > vetor[meio]) {
                inicio = meio + 1;

            } else if (valor < vetor[meio]) {
                fim = meio - 1;

            } else {
                indice = meio;
                break;
            }

            if (inicio + fim <= 0 || inicio >= fim) {
                break;
            }
        }

        if (indice >= 0) {
            System.out.printf("O valor '%d' foi encontrado na posicao %d\n", vetor[indice], indice);
        } else {
            System.out.printf("O valor '%d' nao foi encontrado\n", valor);
        }
    }

    private int[] criarVetorOrdenado() {
        final int[] vetor = new int[10];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(1, 1001);
        }

        Arrays.sort(vetor);

        return vetor;
    }
}