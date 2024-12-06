package people;

import other.Vector2;

public class Knopochka extends Human {
    
    public Knopochka(Vector2 coord){
        super(coord);
    }
    
    @Override
    public void waveHand() {
        System.out.printf("%1$s помахала рукой\n", toString());
    }    
    @Override
    public String toString(){
        return "Кнопочка";
    }
}
