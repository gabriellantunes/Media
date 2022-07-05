
package principal;

public class Notas {
    private String rga;
    private double nota;
    private double peso;
    private double nFinal;

    public Notas(String rga, double nota, double peso, double nFinal) {
        this.rga = rga;
        this.nota = nota;
        this.peso = peso;
        this.nFinal = nFinal;
    }

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getnFinal() {
        return nFinal;
    }

    public void setnFinal(double nFinal) {
        this.nFinal = nFinal;
    }

    
}
