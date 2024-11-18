package cars.details.door;


public class Door{
    enum DoorState{
        OPEN,
        CLOSE,
    }
    protected DoorState state;
    
    public void open(){
        state = DoorState.OPEN;
    }
    public void close(){
        state = DoorState.CLOSE;
    }
    public boolean isOpen(){
        if (state == DoorState.OPEN){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "дверь";
    }
}