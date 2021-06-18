package fr.diginamic;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class AssuranceVie extends  Compte {
    private LocalDate dateFin;
    private double taux;


    public AssuranceVie(LocalDate dateFin, double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
