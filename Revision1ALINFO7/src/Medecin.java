

/**
 *
 * @author wiemhjiri
 */
public class Medecin{
    private int cin;
    private String nom;
    private String prenom;
    private int numOrdre;

    public Medecin(int cin, String nom, String prenom, int numOrdre) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.numOrdre = numOrdre;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumOrdre() {
        return numOrdre;
    }

    
    @Override
    public boolean equals(Object obj) {
       if(obj==this) return true;
       if(obj==null) return false;
       if(obj.getClass()!=this.getClass())
           return false;
       Medecin m=(Medecin) obj;
       if (m.cin==this.cin&&numOrdre==m.numOrdre)
           return true;
       return false;
    }


    @Override
    public String toString() {
        return "Medecin{" +
                "cin=" + cin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numOrdre=" + numOrdre +
                '}';
    }

    @Override
    public int hashCode() {
        return cin+numOrdre;
    }
}
