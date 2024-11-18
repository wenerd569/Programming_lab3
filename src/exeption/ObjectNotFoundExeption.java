package exeption;

public class ObjectNotFoundExeption extends Exception{
    @Override
    public String getMessage(){
        return "Объект не найден";
    }
}
