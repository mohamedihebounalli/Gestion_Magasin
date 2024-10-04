import java.util.Date;

public class Main {
    public static void main(String[] args) {
Produit produitVide =new Produit();
            System.out.println("Produit vide créé: " + produitVide);

Produit p1 =new Produit(1021,"lait","delice",13);
        Produit p2 =new Produit(2510,"yaourt","vitalait",0);
        Produit p3=new Produit(3250,"tomate","sicam",1200);
        System.out.println("\nProduits créés:");
        p1.afficher();
        p2.afficher();
        p3.afficher();

        p1.prix = 700;
        System.out.println("Produit lait après modification:");
        p1.afficher();

        p2.prix = 500;
        p3.prix=900;

        System.out.println("\nProduits modifiés:");
        p1.afficher();
        p2.afficher();
        p3.afficher();

        System.out.println("\nProduits avec toString():");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // 8. Ajouter la date d'expiration
        Date dateExpLait = new Date(2024, 9, 20);
        Date dateExpYaourt = new Date(2024, 10, 15);
        Date dateExpTomate = new Date(2025, 3, 10);

        p1.dateExpiration = dateExpLait;
        p2.dateExpiration = dateExpYaourt;
        p3.dateExpiration = dateExpTomate;

        // Afficher à nouveau les produits avec les dates d'expiration
        System.out.println("\nProduits avec date d'expiration:");
        p1.afficher();
        p2.afficher();
        p3.afficher();

        Magasin magasin1 = new Magasin("M1", "101 Rue D", 50);
        magasin1.ajouterProduit(new Produit(5, "Ordinateur", "Électronique", 800));
        magasin1.ajouterProduit(new Produit(7, "Stylo", "Papeterie", 2));

        Magasin magasin2 = new Magasin("M2", "789 Rue C", 50);
        magasin2.ajouterProduit(new Produit(3, "Bouteille", "Eau", 10));
        magasin2.ajouterProduit(new Produit(4, "Pomme", "Fruits", 5));

        magasin1.afficherDetails();
        magasin2.afficherDetails();

        System.out.println("Total de produits  " + Magasin.getTotalProduits());

        magasin1.afficherLibelles();
        magasin1.afficherTousLesProduits();

        System.out.println("Nombre total de produits dans tous les magasins : " + Magasin.getTotalProduits());

        boolean areSame = p1.comparer(p2);
        System.out.println("Produit Lait1 et Lait2 sont identiques: " + areSame);

        boolean areSameStatic = Produit.comparer(p1, p2);
        System.out.println("Produit Lait1 et Yaourt sont identiques: " + areSameStatic);



        boolean foundLait = magasin1.chercherProduit("Lait");
        boolean foundTomate = magasin1.chercherProduit("Tomate");

        System.out.println("Produit Lait trouvé: " + foundLait);
        System.out.println("Produit Tomate trouvé: " + foundTomate);

        Magasin magasinAvecPlusDeProduits = Magasin.magasinAvecPlusDeProduits(magasin1, magasin2);

        if (magasinAvecPlusDeProduits != null) {
            System.out.println("Le magasin avec plus de produits est le magasin ID: " + magasinAvecPlusDeProduits.getIdentifiant());
        } else {
            System.out.println("Les deux magasins ont le même nombre de produits.");
        }

            boolean result = magasin1.supprimer(p1);
            System.out.println("Suppression réussie: " + result);

            magasin1.afficherMagasin();

            Produit produitChocolat = new Produit(4785, "Chocolat", "Nestle", 25);
            result = magasin1.supprimer(produitChocolat);
            System.out.println("Suppression réussie: " + result);
    }
}