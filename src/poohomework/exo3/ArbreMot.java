package poohomework.exo3;

public class ArbreMot {
    Mot node;
    ArbreMot pere,filsG,filsD;
    //constructeur pour initiliser les racines
    ArbreMot(Mot mot){
        this.node=mot;
        pere=filsD=filsG=null;
    }
    //jai utilisé 2 fonctions avec le meme nom dont l'une des 2 est privé , pour pouvoir utilisé la recursivité.

    //maximum cherche le noeud qui se situe a l'extreme droite (vu que l'arbre c'est un ABR)
    Mot maximum(){
        return maximum(this);
    }
    private Mot maximum(ArbreMot arbre){
        if(arbre.filsD==null) return arbre.node;
        return maximum(arbre.filsD);
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
            temp1.filsG=new ArbreMot(newMot);
            temp1.filsG.pere=temp1;
        }else{
            temp1.filsD=new ArbreMot(newMot);
            temp1.filsD.pere=temp1;
        }
    }
    //afficher fait le parcours infixé de l'arbre d'une maniere recursive
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
    //listeValeursAscendants affiche tous les noeuds qui sont des peres d'autres noeuds
    void listeValeursAscendants(){
        listeValeursAscendants(this);
    }
    private void listeValeursAscendants(ArbreMot arbre){
        if(arbre!=null){
            afficher(arbre.filsG);
            if(arbre.pere!=null)System.out.println(arbre.pere.node.getMt());
            afficher(arbre.filsD);
        }
    }
    //listeValeursDescendants affiche tous les noeuds qui sont des fils d'autres noeuds
    void listeValeursDescendants(){
        listeValeursDescendants(this);
    }
    private void listeValeursDescendants(ArbreMot arbre){
        if(arbre!=null){
            afficher(arbre.filsG);
            if(arbre.filsD!=null)System.out.println(arbre.filsD.node.getMt());
            if(arbre.filsG!=null)System.out.println(arbre.filsG.node.getMt());
            afficher(arbre.filsD);
        }
    }
    //egale utilise la fonction recherche, et assure l'existence de mot dans l'autre arbre.
    boolean egale(ArbreMot arbre){
        if(arbre==null) return true;
        if(!this.recherche(arbre.node)){
            return false;
        }
        return true && this.egale(arbre.filsG) && this.egale(arbre.filsD);
    }
    //identique fait le parcours infixé des 2 arbres en meme temps et assure qu'ils ont la meme valeur
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
