
package cars.details.radiator;

import exeption.ObjectNotFoundExeption;
import table.IMap;

public interface IMapHolder {
    public IMap getMap() throws ObjectNotFoundExeption;
    public void setMap(IMap mapSign);
}