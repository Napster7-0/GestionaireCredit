package Credit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dell
 */
public abstract class GetCredit {
    protected long salaire;
    protected int age;
    protected boolean canGetCredit;
    protected String categorie;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    public long getSalaire() {
        return salaire;
    }

    public void setSalaire(long salaire) {
        this.salaire = salaire;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GetCredit(long salaire, int age) {
        this.salaire = salaire;
        this.age = age;
    }

    public boolean isCanGetCredit() {
        return canGetCredit;
    }

    public void setCanGetCredit(boolean canGetCredit) {
        this.canGetCredit = canGetCredit;
    }
    
    abstract public long maxCredit(int age, long salaire);
    
}
class GetCredit1 extends GetCredit {

    public GetCredit1(long salaire, int age) {
        super(salaire, age);
    }
    @Override public long maxCredit(int age, long salaire){
        if ((50000<= salaire && age <=45) || (salaire > 200000)){
            setCanGetCredit(true);
            setCategorie("Crédit Minime");
            return 1000000;
        }
        else{
            setCanGetCredit(false);
            setCategorie("Nous ne pouvons vous satifaire!\nVous n'êtes pas élligible à l'octroie d'un crédit.");
        }
        return 0;
    }
}

class GetCredit2 extends GetCredit1 {

    public GetCredit2(long salaire, int age) {
        super(salaire, age);
    }
    @Override public long maxCredit(int age, long salaire){
        setCanGetCredit(true);
        if ((100000< salaire && age <=45)|| (salaire > 200000)){
            setCategorie("Crédit Junior");
            return 2000000;
        }
        else if (age<55){
            return super.maxCredit(age, salaire);
        }
        setCategorie("Nous ne pouvons vous satifaire!\nVous n'êtes pas élligible à l'octroie d'un crédit.");
        return 0;
    }
}

class GetCredit3 extends GetCredit2 {

    public GetCredit3(long salaire, int age) {
        super(salaire, age);
    }
    @Override public long maxCredit(int age, long salaire){
        setCanGetCredit(true);
        if ((200000< salaire && age <=45) || (salaire > 300000)){
            setCategorie("Crédit Equilibre");
            return 3000000;
        }
        else if (age<55){
            return super.maxCredit(age, salaire);
        }
        setCategorie("Nous ne pouvons vous satifaire!\nVous n'êtes pas élligible à l'octroie d'un crédit.");
        return 0;
    }
}

class GetCredit4 extends GetCredit3 {

    public GetCredit4(long salaire, int age) {
        super(salaire, age);
    }
    @Override public long maxCredit(int age, long salaire){
        setCanGetCredit(true);
        if (300000< salaire && age <=45){
            setCategorie("Crédit Gold");
            return 5000000;
        }
        else if (age<55 && salaire >= 50000){
           return super.maxCredit(age, salaire);
        }
        setCategorie("Nous ne pouvons vous satifaire!\nVous n'êtes pas élligible à l'octroie d'un crédit.");
        return 0;
    }
    public String GettingACredit(long mont){
        long maxMont = maxCredit(getAge(),getSalaire());
        String str = getCategorie();
        if (isCanGetCredit()){
            if(mont > maxMont ){
        // message a afficher dans le box info
                return "\nVotre Profil ne vous permet d'emprunter qu'au max " + Long.toString(maxMont)+ 
                        "\nAppuyer sur \"Poursuivre l_octroie\" pour emprunter cette somme!";
            }
            else{
        //   message d'eligibilite au credit dans la box info
            return "\nVous voulez contracter un prêt de "+Long.toString(mont) +
                    "\nAppuyer sur \"Poursuivre l_octroie\" pour emprunter cette somme!";
            }
        }
        else{
            // message d'ilelligibilite au credit
            return str;
        }
    }
    public String infoCredit(){
        String _str = Long.toString(maxCredit(getAge(),getSalaire()));
        String str = getCategorie();
        if(str.equals("Crédit Minime")){
            return "Vous appartenez à la Catégorie " + str.toUpperCase()+ 
                        "\n\n Vous avez la possibilité d'emprunter jusqu'à " + _str;
        }
        else if (str.equals("Crédit Junior")){
            return "Vous appartenez à la Catégorie " + str.toUpperCase()+ 
                        "\n\n Vous avez la possibilité d'emprunter jusqu'à " + _str;
        }
        else if (str.equals("Crédit Equilibre")){
            return "Vous appartenez à la Catégorie " + str.toUpperCase()+ 
                        "\n\n Vous avez la possibilité d'emprunter jusqu'à " + _str;
        }
        else if (str.equals("Crédit Gold")){
            return "Vous appartenez à la Catégorie " + str.toUpperCase()+ 
                        "\n\n Vous avez la possibilité d'emprunter jusqu'à " + _str;
        }
        return getCategorie();
    }
}
