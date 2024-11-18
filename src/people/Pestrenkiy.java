package people;


public class Pestrenkiy extends Human{
    
    @Override
    public void waveHand() {
        System.out.printf("%1$s помахал рукой\n", toString());
    }

    @Override
    public String toString(){
        return "Пёстренький";
    }
}
