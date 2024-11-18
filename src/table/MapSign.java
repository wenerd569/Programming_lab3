package table;
import exeption.ObjectNotFoundExeption;
import roads.Places;
import roads.Way;

public class MapSign extends Sign implements IMap{
    protected Way way;
    protected final Places[] places;

    public MapSign(Places ... places){
        this.places = places;
    }

    @Override
    public Way getWay() throws ObjectNotFoundExeption{
        if (way == null){
            throw new ObjectNotFoundExeption();
        }
        return way;
    }

    @Override
    public void drawWay(Way way) throws ObjectNotFoundExeption{
        if (searchPlace(way.startSity()) && searchPlace(way.endCity())){
            this.way = way;
        }
        else{
            throw new ObjectNotFoundExeption();
        }
    }

    @Override
    public boolean searchPlace(Places place) {
        for (int i = 0; i < places.length; i++){
            if (place == places[i]){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "табличка на которой нарисованна карта города страны коротышек";
    }
}
