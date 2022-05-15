package poohomework.exo5;
import java.util.Scanner;

public class TestEnum {
    public static void main(String[] args) {
        //le tout premier affichage
        Mois.afficher();
        //creation et affichage de tableau
        Scanner scanner=new Scanner(System.in);
        final int N=5;
        Mois tableau[] = new Mois[N];
        System.out.println("Entrer "+N+" mois dans le tableau :");
        for (int i = 0; i < N; i++) {
            System.out.println("Entrer un numero de mois [1...12] :");
            int moisNum=scanner.nextInt();
            tableau[i]= (Mois.getMois(moisNum)!=null) ? Mois.getMois(moisNum) : Mois.JANVIER;
        }
        System.out.println("Les mois saisies sont :");
        for (int i = 0; i < N; i++) {
            System.out.println(tableau[i]);
        }
        //affichage des mois avec nbr des jours == 31
        System.out.println("Afficher les mois dont le nombre de jours est égal à 31 :");
        for(Mois mois : Mois.values()) {
            if(mois.nombreDesJours ==31) {
                Mois.afficher(mois);
            }
        }
        //affichage de Ieme mois
        System.out.println("Entrer un nombre de mois vous voulez afficher :");
        int I=scanner.nextInt();
        if(I<1 || I>12){
            System.out.println("le nombre de mois doit etre compris entre 1 et 12 !");
        }else{
            System.out.println("le "+I+"eme mois est :");
            Mois.afficher(Mois.getMois(I));
        }
        //remplissage de tableau avec abr
        Mois tableau1[] = new Mois[N];
        System.out.println("Entrer "+N+" mois dans le tableau :");
        for (int i = 0; i < N; i++) {
            System.out.println("Entrer un abv de mois (jan,fev...) :");
            String moisAbv=scanner.next();
            tableau[i]= (Mois.rechercherParAbr(moisAbv)!=null) ? Mois.rechercherParAbr(moisAbv) : Mois.JANVIER;
        }
        System.out.println("Les mois saisies sont :");
        int counterJanvier=0;
        for (int i = 0; i < N; i++) {
           if(tableau[i].ordinal()==0) counterJanvier++;
        }
        System.out.println("Nombre D'occurence de mois de Janvier est :"+counterJanvier);



    }
}
