import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        Candidato[] candidatos = new Candidato[n];

        for (int i = 0; i < n; i++) {
            String primeiroNome = gerarNome();
            String partido = gerarPartido();
            int intencaoVotos = gerarVotos();
            candidatos[i] = new Candidato(primeiroNome, partido, intencaoVotos);
        }


        ordenaPartido(candidatos);
        ordenaVotos(candidatos);
        ordenaNome(candidatos);
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println(candidatos[i].toString());
        }

        System.out.println("Digite o nome do candidato que deseja buscar:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        int response = pesquisaBinaria(candidatos, nome);
        if (response == -1) {
            System.out.println("Candidato não existe no array");
        } else {
            System.out.println(candidatos[response].toString());
        }

    }

    private static String gerarNome() {
        String[] nomes = {"Lula", "Bolsonaro", "Marina Silva", "Ciro Gomes", "Simone Tebet"};
        Random random = new Random();
        return nomes[random.nextInt(nomes.length)];
    }

    private static String gerarPartido() {
        String[] partidos = {"PSDB", "PT", "Partido Novo", "PL", "MDB"};
        Random random = new Random();
        return partidos[random.nextInt(partidos.length)];
    }
    private static int gerarVotos() {
        Random random = new Random();
        return random.nextInt(10);
    }


    public static void ordenaPartido(Candidato[] candidatos) {
        int min = 0;
        for (int i = 0; i < candidatos.length-1; i++) {
            min = i;
            for (int j = i+1; j < candidatos.length; j++)
                if (candidatos[j].getPartido().compareTo(candidatos[min].getPartido()) < 0)
                    min = j;
            Candidato T = candidatos[i];
            candidatos[i] = candidatos[min];
            candidatos[min] = T;
        }
    }

    public static void ordenaVotos (Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            int j = i;
            Candidato B = candidatos[i];
            while ((j > 0) && (candidatos[j-1].getIntencaoVotos() > B.getIntencaoVotos())) {
                candidatos[j] = candidatos[j-1];
                j--;
            }
            candidatos[j] = B;
        }
    }

    public static void ordenaNome (Candidato[] candidatos) {
        for (int i = 1; i < candidatos.length; i++) {
            int j = i;
            Candidato B = candidatos[i];
            while ((j > 0) && (candidatos[j-1].getPrimeiroNome().compareTo(B.getPrimeiroNome())) > 0) {
                candidatos[j] = candidatos[j-1];
                j--;
            }
            candidatos[j] = B;
        }
    }

    public static int pesquisaBinaria(Candidato[] candidatos, String nome) {
        int inf = 0; int sup = candidatos.length - 1;
        while (inf <= sup) {
            int med = (inf + sup) / 2;
            if (nome.equals(candidatos[med].getPrimeiroNome()))
                return med;
            else if (nome.compareTo(candidatos[med].getPrimeiroNome()) < 0 )
                sup = med - 1;
            else
                inf = med + 1;
        }
        return -1;
    }

}
