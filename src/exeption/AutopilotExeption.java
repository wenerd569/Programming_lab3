package exeption;

public class AutopilotExeption extends VaehicleExeption{
    private String message;

    public AutopilotExeption(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return "Возникла ошибка автопилота: " + message;
    }
}
