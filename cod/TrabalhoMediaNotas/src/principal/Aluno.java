
package principal;
import java.util.ArrayList;

public class Aluno {
    private String rga;
    private String nome;
    private double mediaFinal;
    
    ArrayList<Notas> notas = new ArrayList<Notas>();

    public Aluno(String rga, String nome, double mediaFinal) {
        this.rga = rga;
        this.nome = nome;
        this.mediaFinal = mediaFinal;
    }

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public ArrayList<Notas> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

    
    
}
