package exeption;

public class WayExeption extends Exception{
    private String message;

    public WayExeption(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return "Ошибка постороения пути: " + message;
    }
}
