import java.util.Date;

public class Produit {
    int identifiant;
    String libelle;
    String marque;
    float prix;
    Date dateExpiration;

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Produit() {
    }

    public Produit(int identifiant, String libelle, String marque, float prix) {
        this.identifiant = identifiant;
        this.libelle = libelle;
        this.marque = marque;
        this.prix = prix;
    }
    public void afficher() {
        System.out.println("Produit ID: " + identifiant);
        System.out.println("Libellé: " + libelle);
        System.out.println("Marque: " + marque);
        System.out.println("Prix: " + prix);
    }


    @Override
    public String toString() {
        return "Produit{" +
                "identifiant=" + identifiant +
                ", libelle='" + libelle + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", dateExpiration=" + dateExpiration +
                '}';
    }


    public boolean comparer(Produit autreProduit) {
        return this.identifiant == autreProduit.getIdentifiant() &&
                this.libelle.equals(autreProduit.getLibelle()) &&
                this.prix == autreProduit.getPrix();
    }

    // Static method to compare two products
    public static boolean comparer(Produit produit1, Produit produit2) {
        return produit1.getIdentifiant() == produit2.getIdentifiant() &&
                produit1.getLibelle().equals(produit2.getLibelle()) &&
                produit1.getPrix() == produit2.getPrix();
    }



}