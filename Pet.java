
import java.util.Scanner;


public class Pet {
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds = 0;
    private int age = 0;
    private boolean alive = true;

    public Pet(int energyMax, int hungryMax, int cleanMax) {
        this.energyMax = energyMax;
        this.hungryMax = hungryMax;
        this.cleanMax = cleanMax;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
    }

    public String toString(){
        return "E:"+energy+"/"+energyMax+", S:"+hungry+"/"+hungryMax+", L:"
                +clean+"/"+cleanMax+", D:"+diamonds+", I:"+age;
    }
    
    public int getEnergyMax() {
        return energyMax;
    }

    public int getHungryMax() {
        return hungryMax;
    }

    public int getCleanMax() {
        return cleanMax;
    }

    public int getEnergy() {
        return energy;
    }

    public int getHungry() {
        return hungry;
    }

    public int getClean() {
        return clean;
    }

    public int getDiamonds() {
        return diamonds;
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return alive;
    }

    private void setEnergy(int energy) {
        this.energy = energy;
    }

    private void setHungry(int hungry) {
        this.hungry = hungry;
    }

    private void setClean(int clean) {
        this.clean = clean;
    }

    void play(){
        if(alive){
            if(energy < 0 || hungry < 0 || clean < 0){
                alive = false;
                System.out.println(toString());
                if(energy < 0){
                    System.out.println("Morreu sem energia");
                }else if(hungry < 0){
                    System.out.println("Morreu de fome");
                }else if(clean < 0){
                    System.out.println("Morreu de sujeira");
                }
            }else{
                energy -= 2;
                hungry -= 1;
                clean -= 3;
                diamonds += 1;
                age++;
            }
        }
    }
    
    void shower(){
        if(alive){
            if(energy < 0 || hungry < 0 || clean < 0){
                alive = false;
                System.out.println(toString());
                if(energy < 0){
                    System.out.println("Morreu sem energia");
                }else if(hungry < 0){
                    System.out.println("Morreu de fome");
                }else if(clean < 0){
                    System.out.println("Morreu de sujeira");
                }
            }else{
                energy -= 3;
                hungry -= 1;
                clean = cleanMax;
                age += 2; 
            }
        }
    }
    
    void eat(){
        if(alive){
            if(energy < 0 || hungry < 0 || clean < 0){
                alive = false;
                System.out.println(toString());
                if(energy < 0){
                    System.out.println("Morreu sem energia");
                }else if(hungry < 0){
                    System.out.println("Morreu de fome");
                }else if(clean < 0){
                    System.out.println("Morreu de sujeira");
                }
            }else{
                energy -= 1;
                hungry += 4;
                clean -= 2;
                age++;
                if(hungry > hungryMax){
                    hungry = hungryMax;
                }
            }  
        }
    }
    
    void sleep(){
        if(alive){
            if(energy < 0 || hungry < 0 || clean < 0){
                alive = false;
                System.out.println(toString());
                if(energy < 0){
                    System.out.println("Morreu sem energia");
                }else if(hungry < 0){
                    System.out.println("Morreu de fome");
                }else if(clean < 0){
                    System.out.println("Morreu de sujeira");
                }
            }else{
                if(energy < 16){
                    while(energy < energyMax){
                        energy++;
                        age++;
                    }
                }else{
                    System.out.println("Nao estou com sono");
                }
            }
        }
    }
    
    void show(){
        System.out.println(toString());
    }
    
    public static void main(String[] args) {
        Pet pet = new Pet(20, 10, 15);
        while(true){
            if(pet.isAlive()){
                Scanner tcl = new Scanner(System.in);
                String comando = tcl.nextLine();
                if(comando.equals("play")){
                    pet.play();
                }else if(comando.equals("clean")){
                    pet.shower();
                }else if(comando.equals("eat")){
                    pet.eat();
                }else if(comando.equals("sleep")){
                    pet.sleep();
                }else if(comando.equals("show")){
                    pet.show();
                }
            }else{
                System.out.println("Pet esta morto");
            }
        }
        }
        
    }

