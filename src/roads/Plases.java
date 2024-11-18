package roads;

public enum Plases{
    SUNNY_CITY("Солнечный город"),
    FLOWER_CITY("Цветочный город");

protected final String name;

private Plases(String name){
    this.name = name;
}

@Override
public String toString(){
    return name;
}
}
