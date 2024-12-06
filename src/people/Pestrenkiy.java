package people;

import other.Vector2;

public class Pestrenkiy extends Human{
    
    public Pestrenkiy(Vector2 coord){
        super(coord);
    }


    @Override
    public void waveHand() {
        System.out.printf("%1$s помахал рукой\n", toString());
    }

    @Override
    public String toString(){
        return "Пёстренький";
    }
}
