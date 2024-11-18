
package table;

import exeption.ObjectNotFoundExeption;
import roads.Plases;
import roads.Way;

public interface IMap {
    public Way getWay() throws ObjectNotFoundExeption;
    public void drawWay(Way way) throws ObjectNotFoundExeption;
    public boolean searthPlace(Plases plase);
}