
package cars;

import exeption.ObjectNotFoundExeption;
import roads.Way;
import sign.IMap;

public interface IMapHolder {
    public IMap takeMap() throws ObjectNotFoundExeption;
    public Way readWay() throws ObjectNotFoundExeption;
    public void setMap(IMap map);
}