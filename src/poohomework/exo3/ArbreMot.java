package poohomework.exo3;

public class ArbreMot {
    Mot node;
    ArbreMot pere,filsG,filsD;

    Mot maximum(){
        return new Mot();
    }

    int taille(){
        return taille(this);
    }
    private int taille(ArbreMot arbre){
        if(arbre == null)
            return 0;
        return 1 + arbre.taille(arbre.filsG) + arbre.taille(arbre.filsD);
    }
    boolean recherche(Mot mot){
       return recherche(mot,this);
    }
    private boolean recherche(Mot mot, ArbreMot node){
        if(node==null) return false;
        if(node.node.getMt() == mot.getMt())
            return true;
        return recherche(mot,node.filsG) || recherche(mot,node.filsD);
    }
    void inserer(String ch){
        ArbreMot temp=this;
        ArbreMot temp1=null;
        Mot newMot=new Mot(ch);
        //si la racine est vide et n'a aucun mot
        if(temp.node == null){
            this.node=newMot;
            return;
        }
        while(temp!=null){
            temp1=temp;
            if(temp.node.compareMots(newMot) == 1){
                temp=temp.filsG;
            }else{
                temp=temp.filsD;
            }
        }
        if(temp1.node.compareMots(newMot)==1){
            temp1.filsG=new ArbreMot();
            temp1.filsG.pere=temp1;
            temp1.filsG.node=newMot;
        }else{
            temp1.filsD=new ArbreMot();
            temp1.filsD.pere=temp1;
            temp1.filsD.node=newMot;
        }
    }
    void afficher(){
        afficher(this);
    }
    private void afficher(ArbreMot arbre){
        if(arbre!=null){
            afficher(arbre.filsG);
            System.out.println(arbre.node.getMt());
            afficher(arbre.filsD);
        }
    }

    int profondeur(){
        return profondeur(this);
    }
    private int profondeur(ArbreMot arbre){
        if(arbre==null)
            return 0;
        int profondeurGauche = profondeur(arbre.filsG);
        int profondeurDroite = profondeur(arbre.filsD);

        if (profondeurGauche > profondeurDroite)
            return (profondeurGauche + 1);
        else
            return (profondeurDroite + 1);
    }
    void listeValeursAscendants(){

    }
    void listeValeursDescendants(){

    }
    boolean egale(ArbreMot arbre){
        return identique(arbre);
    }
    boolean identique(ArbreMot arbre){
        if(this.taille()!=arbre.taille()) return false;
        return identique(this,arbre);
    }
    private boolean identique(ArbreMot arbre1,ArbreMot arbre2){
        if(arbre1==null && arbre2==null) return true;
        if(arbre1==null || arbre2==null) return false;
        if(arbre1.node.compareMots(arbre2.node)!=0)
            return false;
        else
            return true && identique(arbre1.filsG,arbre2.filsG) && identique(arbre1.filsD,arbre2.filsD);
    }
}
