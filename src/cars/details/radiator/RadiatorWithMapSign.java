
package cars.details.radiator;

import table.IMap;

public class RadiatorWithMapSign extends Radiator implements IMapHolder{
    private IMap map;

    public RadiatorWithMapSign(IMap map){
        this.map = map;
    }

    @Override
    public IMap getMap() {
        return map;
    }

    @Override
    public void setMap(IMap map) {
        this.map = map; 
    }
}