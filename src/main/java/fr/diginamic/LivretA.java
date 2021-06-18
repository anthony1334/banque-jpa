package fr.diginamic;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
    private double taux;

    public LivretA(double taux) {
        this.taux = taux;
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
