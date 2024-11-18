package people;


public class Pestrenkiy extends Human{
    
    @Override
    public void waveHand() {
        System.out.println(toString() + "помахал рукой");
    }

    @Override
    public String toString(){
        return "Пёстренький";
    }
}
