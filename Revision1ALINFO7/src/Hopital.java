/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 *
 * @author wiemhjiri
 */
public class Hopital {

    public Map<Medecin, ListPatients> medecinPatiens;

    public Hopital() {
       medecinPatiens=new HashMap<>();
    }

    public void ajouterMedecin(Medecin m) {
        medecinPatiens.put(m,new ListPatients());
    }

    public void ajouterPatient(Medecin m, Patient p) {
       ListPatients l=medecinPatiens.get(m);

       if(l==null)
       {
           ajouterMedecin(m);
           l=medecinPatiens.get(m);
           l.ajouterPatient(p);
           medecinPatiens.put(m,l);
       }
        l.ajouterPatient(p);
        medecinPatiens.put(m,l);
    }
    /*Avec l'api stream */

    public void afficherMap() {
        /*First way*/
        for (Map.Entry<Medecin,ListPatients> mp:medecinPatiens.entrySet())
        {
            System.out.println("Medecin :"+mp.getKey());
            System.out.println(mp.getValue());
        }

        /*Second Way */
       medecinPatiens.forEach((m,l)-> System.out.println("Medecin :"+m+" "+l));

    }

    /* Afficher les patients dont le nom est "mohamed" 
    qui appartiennent au medecin m passé en paramétre */
    public void afficherMedcinPatients(Medecin m) {
        medecinPatiens.get(m).getListP().stream().
                filter(e->e.getNom().equals("mohamed")).
                forEach(e-> System.out.println(e));
    }



}
