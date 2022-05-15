package poohomework.exo5;

public enum Mois {
    JANVIER(31,"jan","january"),
    FEVRIER(28,"fev","february"),
    MARS(31,"mar","march"),
    AVRIL(30,"avr","april"),
    MAI(31,"mai","may"),
    JUIN(30,"jui","june"),
    JUILLET(31,"jul","july"),
    AOUT(31,"aou","august"),
    SEPTEMBRE(30,"sep","september"),
    OCTOBRE(31,"oct","october"),
    NOVEMBRE(30,"nov","november"),
    DECEMBRE(31,"dec","december");
    final int nombreDesJours;
    final String abv3Lettres;
    final String nomAnglais;
    Mois(int nombreDesJours,String abv3Lettres,String nomAnglais){
        this.nombreDesJours=nombreDesJours;
        this.abv3Lettres=abv3Lettres;
        this.nomAnglais=nomAnglais;
    }
    //methods
    static void afficher(){
        for(Mois mois : Mois.values()) {
            System.out.println(mois);
        }
    }
    static boolean accepteChaine(String ch){
        for(Mois mois : Mois.values()) {
            if(mois.equals(ch)) {
                return true;
            }
        }
        return false;
    }
    static Mois getMois(int num){
        if(num < 1 || num > 12) return null;
        return Mois.values()[num - 1];
    }
    static void afficher(Mois mois){
        System.out.println(mois + ": (nombre des jours='" +mois.nombreDesJours + "', Abv='" +mois.abv3Lettres + "', Nom en anglais='" +mois.nomAnglais + "')");
    }
    static Mois rechercherParAbr(String abr){
        for(Mois mois : Mois.values()) {
            if(mois.abv3Lettres.equals(abr)) {
                return mois;
            }
        }
        return null;
    }
    }

