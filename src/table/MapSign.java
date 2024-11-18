package table;
import exeption.ObjectNotFoundExeption;
import roads.Plases;
import roads.Way;

public class MapSign extends Sign implements IMap{
    protected Way way;
    protected final Plases[] plases;

    public MapSign(Plases ... places){
        this.plases = places;
    }

    @Override
    public Way getWay() throws ObjectNotFoundExeption{
        if (way == null     ){
            throw new ObjectNotFoundExeption();
        }
        return way;
    }

    @Override
    public void drawWay(Way way) throws ObjectNotFoundExeption{
        if (searthPlace(way.startSity()) && searthPlace(way.endCity())){
            this.way = way;
        }
        else{
            throw new ObjectNotFoundExeption();
        }
    }

    @Override
    public boolean searthPlace(Plases plase) {
        for (int i = 0; i < plases.length; i++){
            if (plase == plases[i]){
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
