package poohomework.exo3;

public class TabMot {
    private int maxMots;
    Mot[] arrayMots;
    private int current=0;
    //Constructor
    TabMot(int maxMots){
        this.maxMots=maxMots;
        this.arrayMots=new Mot[maxMots];
    }
    //getters and setters
    void setMaxMots(int maxMots){
        this.maxMots=maxMots;
    }
    int getMaxMots(){
        return maxMots;
    }
    int getCurrent(){
        return current;
    }
    //methods
    void ajouterMot(Mot mot){
        //we check if the table's length has exceeded or reached the max allowed length else, we push the new Mot
        if(current>=maxMots) {
            System.out.println("Vous Avez exceder la taille maximale.");
            return;
        }
        arrayMots[current]=mot;
        current++;
    }
    void afficher(){
        System.out.println("Les elements de la table : ");
        for (int i = 0; i < current; i++) {
            System.out.println(arrayMots[i]);
        }
    }
}
