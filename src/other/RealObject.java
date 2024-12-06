package other;

public abstract class RealObject {
    private Vector2 coord;
    
    public RealObject(Vector2 coord){
        this.coord = coord;
    }

    public Vector2 getCoord(){
        return coord;
    }
    public void setCoord(Vector2 coord){
        this.coord = coord; 
    }
}
