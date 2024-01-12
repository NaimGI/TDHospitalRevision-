

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author wiemhjiri
 */
public class ListPatients implements InterfacePatient{
    private List<Patient> listP;

    public ListPatients(){
      listP=new ArrayList<>();
    }

    public List<Patient> getListP() {
        return listP;
    }

    @Override
    public void ajouterPatient(Patient p) {
       listP.add(p);
    }

    @Override
    public void supprimerPatient(Patient p) {
       listP.remove(p);//equals dans patient
    }

/* Avec l'api stream */
    @Override
    public boolean rechercherPatient(Patient p) {
     //return listP.stream().anyMatch((Patient pa)->p.equals(pa));
        return listP.stream().anyMatch(pa->p.equals(pa));
    }
    
/* Avec l'api stream */
    @Override
    public boolean rechercherPatient(int cin) {
               /* for (int i=0;i<listP.size();i++)
                {if(listP.get(i).getCin()==cin)
                    return true;
                }
                return false;*/
                return listP.stream().anyMatch(e->e.getCin()==cin);
    }

    @Override
    public void afficherPatients() {
        listP.forEach(e->System.out.println(e));
        listP.stream().forEach(e-> System.out.println(e));
    }
    
/* Avec lambda expression */
    @Override
    public void trierPatientsParNom() {

        Collections.sort(listP); //il faut redéfinir comparable dans la classe Patient
    Collections.sort(listP,new TriNom());

    Collections.sort(listP,(Patient p1,Patient p2)
            ->{return p1.getNom().compareTo(p2.getNom());});

        Collections.sort(listP,(p1,p2)
                ->p1.getNom().compareTo(p2.getNom()));
    }
    
/* Avec l'api stream */
    public void PatientSansRedondance(){
              listP.stream().distinct().forEach(e-> System.out.println(e));
    }
    
    /*Méthode toString */

    @Override
    public String toString() {
        String str="Liste patients";
        for (Patient p:listP)
        {
            str+=p+"\n";
        }
            return str;

    }
    
    
}
