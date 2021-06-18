package fr.diginamic;

import javax.persistence.*;
import java.util.Set;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)// Heritage avec les tables Adresse et Banque
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id auto-increment
    private  int id;
    private  String numero;
    private double solde;


    @ManyToMany// Jointure avec la table Client
    @JoinTable(name="COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE",referencedColumnName = "ID"))
            private Set<Client> clients;

    @OneToMany(mappedBy = "compte")// Jointure avec la table Operation
    private Set<Operation>operations;

    public Compte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }



    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
