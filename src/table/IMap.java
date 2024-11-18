
package table;

import exeption.ObjectNotFoundExeption;
import roads.Places;
import roads.Way;

public interface IMap {
    public Way getWay() throws ObjectNotFoundExeption;
    public void drawWay(Way way) throws ObjectNotFoundExeption;
    public boolean searchPlace(Places place);
}