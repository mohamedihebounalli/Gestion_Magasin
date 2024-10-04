import java.lang.reflect.Array;
import java.util.List;

public class Magasin {
    private String identifiant;
    private String adresse;
    private int capacite;
    private Produit[] produits;
    private int nombreProduits;
    private static int totalProduits = 0;

    public Magasin(String identifiant, String adresse, int capacite) {
        this.identifiant = identifiant;
        this.adresse = adresse;
        this.capacite = capacite;
        this.produits = new Produit[capacite];
        this.nombreProduits = 0;
    }
    public String getIdentifiant() {
        return identifiant;
    }

    public void ajouterProduit(Produit produit) {
        if (isProduitPresent(produit)) {
            System.out.println("Le produit " + produit.getLibelle() + " existe déjà dans le magasin.");
            return;
        }
        if (nombreProduits < capacite) {
            produits[nombreProduits] = produit;
            nombreProduits++;
            totalProduits++;
            System.out.println("Produit " + produit.getLibelle() + " ajouté avec succès.");
        } else {
            System.out.println("Capacité maximale atteinte. Impossible d'ajouter plus de produits.");
        }
    }

    // product is already
    private boolean isProduitPresent(Produit produit) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].getIdentifiant() == produit.getIdentifiant()) {
                return true;
            }
        }
        return false;
    }

    public void afficherDetails() {
        System.out.println("Magasin ID: " + identifiant);
        System.out.println("Adresse: " + adresse);
        System.out.println("Capacité: " + capacite);
        System.out.println("Produits:");
        for (int i = 0; i < nombreProduits; i++) {
            System.out.println("Nom: " + produits[i].getLibelle() + ", Prix: " + produits[i].getPrix());
        }
    }

    public static int getTotalProduits() {
        return totalProduits;
    }

    public void afficherLibelles() {
        System.out.println("Libellés des produits dans le magasin:");
        for (int i = 0; i < nombreProduits; i++) {
            System.out.println("- " + produits[i].getLibelle());
        }
    }

    public void afficherTousLesProduits() {
        System.out.println("Tous les produits dans le magasin:");
        for (int i = 0; i < nombreProduits; i++) {
            System.out.println(produits[i].toString());
        }
    }

    public boolean chercherProduit(String libelle) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].getLibelle().equalsIgnoreCase(libelle)) {
                return true;
            }
        }
        return false;
    }

    public static Magasin magasinAvecPlusDeProduits(Magasin magasin1, Magasin magasin2) {
        if (magasin1.nombreProduits > magasin2.nombreProduits) {
            return magasin1;
        } else if (magasin1.nombreProduits < magasin2.nombreProduits) {
            return magasin2;
        } else {
            return null; // or return magasin1; or magasin2; depending on your preference
        }
    }

    public boolean supprimer(Produit p) {
        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].getIdentifiant() == p.getIdentifiant()) {
                // Shift products left to fill the gap
                for (int j = i; j < nombreProduits - 1; j++) {
                    produits[j] = produits[j + 1];
                }
                produits[nombreProduits - 1] = null; // Clear the last product reference
                nombreProduits--;
                totalProduits--;
                System.out.println("Produit " + p.getLibelle() + " supprimé avec succès.");
                return true;
            }
        }
        System.out.println("Produit " + p.getLibelle() + " non trouvé.");
        return false;
    }


    public void afficherMagasin() {
        System.out.println("Magasin ID: " + identifiant + ", Adresse: " + adresse);
        System.out.println("Produits dans le magasin:");
        for (int i = 0; i < nombreProduits; i++) {
            System.out.println("- " + produits[i].getLibelle() + " : " + produits[i].getPrix() + " TND");
        }
    }
}



