package fr.diginamic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)// Heritage avec les tables Adresse et Banque
public  class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id auto-increment
    private  int id;
    private  String numero;
    private double solde;


    @ManyToMany// Jointure avec la table Client
    @JoinTable(name="COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_COMPTE",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID"))
            private Set<Client> clients = new HashSet<>();

    @OneToMany(mappedBy = "compte")// Jointure avec la table Operation
    private Set<Operation>operations ;

    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
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
    public void virementCredit(Virement virement,Compte compte){
        if (virement.getMontant() > compte.getSolde()) {
            System.out.println("operation impossible");
        }
        else{
            compte.setSolde(virement.getMontant()+compte.getSolde());
        }
    }

}
