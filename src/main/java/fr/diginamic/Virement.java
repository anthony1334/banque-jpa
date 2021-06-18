package fr.diginamic;

import javax.persistence.*;

@Entity
public class Virement extends Operation {

    private int id;
    private String beneficiaire;

    public Virement() {
    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
