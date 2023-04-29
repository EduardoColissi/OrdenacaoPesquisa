public class Candidato {
    private String primeiroNome;
    private String partido;
    private int intencaoVotos;

    public Candidato(String primeiroNome, String partido, int intencaoVotos) {
        this.primeiroNome = primeiroNome;
        this.partido = partido;
        this.intencaoVotos = intencaoVotos;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getPartido() {
        return partido;
    }

    public int getIntencaoVotos() {
        return intencaoVotos;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setIntencaoVotos(int intencaoVotos) {
        this.intencaoVotos = intencaoVotos;
    }

    @Override
    public String toString() {
        return "Candidato{" +
                "primeiroNome='" + this.primeiroNome + '\'' +
                ", partido='" + this.partido + '\'' +
                ", intencaoVotos=" + this.intencaoVotos +
                '}';
    }
}
