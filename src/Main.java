import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final String SEND_COMMAND = "send";
    private static final String STOP_COMMAND = "stop";

    public static void main(String[] args) {
        System.out.println("============ INICIANDO O CLIENTE ============");
        EchoClient echoClient = null;
        try{
            echoClient = new EchoClient(null, EchoClient.DEFAULT_SERVER_PORT);
            System.out.println("============ CLIENTE INICIADO ============");
            Scanner scanner = new Scanner(System.in);
            String command = "";
            boolean running = true;
            System.out.println("============ COMANDO: ============");
            while (running){
                try {
                    command = scanner.nextLine();
                    if(command.equalsIgnoreCase(SEND_COMMAND) || command.equalsIgnoreCase(STOP_COMMAND.substring(0,1))){
                        echoClient.send();
                    }else if(command.equalsIgnoreCase(STOP_COMMAND)){
                        running = false;
                        System.out.println("============ FINALIZANDO CLIENTE ============");
                        echoClient.stop();
                        System.out.println("============ CLIENTE FINALIZADO ============");
                    }else{
                        System.out.println("============ COMANDO NÃO SUPORTADO ============");
                        System.out.println("============ COMANDO: ============");
                    }
                }catch (InputMismatchException exception){
                    exception.printStackTrace();
                }
            }
            scanner.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}