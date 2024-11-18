package people;


public class Knopochka extends Human {
    @Override
    public void waveHand() {
        System.out.println(toString() + "помахала рукой");
    }    
    @Override
    public String toString(){
        return "Кнопочка";
    }
}
