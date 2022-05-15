package poohomework.exo3;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        TabMot tab=new TabMot(100);
        //ajouter N mots :
        System.out.println("Entrer N le nombre des mots que vous voulez inserer : ");
        int N=scanner.nextInt();
        System.out.println("Entrer les mots mot par mot :");
        for (int i = 0; i < N; i++) {
            String text=scanner.next();
            tab.ajouterMot(new Mot(text));
        }
        //afficher les mots qui ont une chaine inferieure a cette chaine :
        final String CHAINE1 = "l'obstination est le chemin de la réussite";
        final Mot MOT1=new Mot(CHAINE1);
        System.out.println("Les mots avec une chaine inferieure a `"+CHAINE1+"` sont :");
        for (int i = 0; i < tab.getCurrent(); i++) {
            if(tab.arrayMots[i].compareMots(MOT1)==-1){
                System.out.println(tab.arrayMots[i].getMt());
            }
        }
        //afficher les inverses
        final String CHAINE2="Se réunir est un début ; rester ensemble est un progrès ; travailler ensemble est la réussite.";
        final Mot MOT2=new Mot(CHAINE2);
        System.out.println("les inverses des mots qui ont une chaine supérieure à `"+CHAINE2+"` sont :");
        for (int i = 0; i < tab.getCurrent(); i++) {
            if(tab.arrayMots[i].compareMots(MOT2)==1){
                System.out.println(tab.arrayMots[i].inverse().getMt());
            }
        }

        ArbreMot arbre =new ArbreMot(new Mot("test1"));
        arbre.inserer("rafikk");
        arbre.inserer("rafi");
        arbre.inserer("rafik");
        arbre.inserer("rafikkk");
        arbre.inserer("rak");
        arbre.inserer("rk");
        arbre.inserer("r");
        //arbre.afficher();
        ArbreMot arbre2 =new ArbreMot(new Mot("rafik"));
        arbre2.inserer("rafikk2");
        arbre2.inserer("rafi");
        arbre2.inserer("rafik");
        arbre2.inserer("rafikkkfdsafdf");
        arbre2.inserer("rak");
        arbre2.inserer("rk");
        arbre2.inserer("r");



    }
}
