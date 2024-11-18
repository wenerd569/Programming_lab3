package roads;

public enum Places{
    SUNNY_CITY("Солнечный город"),
    FLOWER_CITY("Цветочный город");

protected final String name;

private Places(String name){
    this.name = name;
}

@Override
public String toString(){
    return name;
}
}
