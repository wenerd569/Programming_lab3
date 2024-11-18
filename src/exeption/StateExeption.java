package exeption;


public class StateExeption extends Exception{

    @Override
    public String getMessage() {
        return "Ошибка состояния объекта";
    }
}
