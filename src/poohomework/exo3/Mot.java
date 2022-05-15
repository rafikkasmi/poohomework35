package poohomework.exo3;

public class Mot {
    private String mt;
    //Constructors
    Mot(){}
    Mot(String mt){
        this.mt=mt;
    }
    //getters and setters
    void setMt(String mt){
        this.mt=mt;
    }
    String getMt(){
        return mt;
    }
    //methods
    Mot inverse(){
        return new Mot(new StringBuilder(mt).reverse().toString());
    }
    int compareMots(Mot mot2){
        int diffLength = mt.length() - mot2.getMt().length();
        if(diffLength==0){
            return 0;
        }else if(diffLength>0){
            return 1;
        }else{
            return -1;
        }
    }
    void afficher(){
        System.out.println(mt);
    }
}
