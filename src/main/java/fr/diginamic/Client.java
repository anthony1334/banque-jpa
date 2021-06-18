package fr.diginamic;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id auto-increment
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;


    @ManyToOne//Jointure avec la table Banque
    @JoinColumn(name = "BANQUE_ID")
    private Banque banque;

    @ManyToMany// Jointure avec la table Client
    @JoinTable(name="COMPTE_CLIENT",
            joinColumns = @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE",referencedColumnName = "ID"))
            private Set<Compte> comptes = new HashSet<>();

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Banque banque, Set<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
        this.comptes = comptes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }


}
