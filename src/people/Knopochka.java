package people;


public class Knopochka extends Human {
    @Override
    public void waveHand() {
        System.out.printf("%1$s помахала рукой\n", toString());
    }    
    @Override
    public String toString(){
        return "Кнопочка";
    }
}
