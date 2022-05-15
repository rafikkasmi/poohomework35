package poohomework.exo3;

public class Main {

    public static void main(String[] args) {
        TabMot tab=new TabMot(100);
        //ajouter N mots :
        int N=5;
        for (int i = 0; i < N; i++) {
            tab.ajouterMot(new Mot("rafik"+i));
        }
        //afficher les mots qui ont une chaine inferieure a cette chaine :
        final String CHAINE1 = "l'obstination est le chemin de la réussite";
        final Mot MOT1=new Mot(CHAINE1);
//        System.out.println("Les mots avec une chaine inferieure a `"+CHAINE1+"` sont :");
        for (int i = 0; i < tab.getCurrent(); i++) {
            if(tab.arrayMots[i].compareMots(MOT1)==-1){
//                System.out.println(tab.arrayMots[i].getMt());
            }
        }
        //afficher les inverses
        final String CHAINE2="Se réunir est un début ; rester ensemble est un progrès ; travailler ensemble est la réussite.";
        final Mot MOT2=new Mot(CHAINE2);
//        System.out.println("les inverses des mots qui ont une chaine supérieure à `"+CHAINE2+"` sont :");
        for (int i = 0; i < tab.getCurrent(); i++) {
            if(tab.arrayMots[i].compareMots(MOT2)==1){
//                System.out.println(tab.arrayMots[i].inverse().getMt());
            }
        }

        ArbreMot arbre =new ArbreMot();
        arbre.inserer("rafikk");
        arbre.inserer("rafi");
        arbre.inserer("rafik");
        arbre.inserer("rafikkk");
        arbre.inserer("rak");
        arbre.inserer("rk");
        arbre.inserer("r");
        //arbre.afficher();
        ArbreMot arbre2 =new ArbreMot();
        arbre2.inserer("rafikk");
        arbre2.inserer("rafi");
        arbre2.inserer("rafik");
        arbre2.inserer("rafikkk");
        arbre2.inserer("rak");
        arbre2.inserer("rk");
//        arbre2.inserer("r");

//        System.out.println(arbre.recherche(new Mot("rafi")));
        System.out.println(arbre.egale(arbre2));



    }
}
