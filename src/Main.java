import com.conversor.monedas.Request;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion = 0;
        double valorDinero;
        String Menu = """
                ***********************************
                Sea bienvenido al conversor de moneda \n
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Salir
                Elige una opción Valida:
                ***********************************
                """;
        Request request = new Request();
        Scanner teclado = new Scanner(System.in);

        while (opcion != 7) {
            try {
                System.out.print(Menu);
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresar la cantidad a convertir");
                        valorDinero = teclado.nextDouble();
                        request.getConvertMoney("UD", "ARS", valorDinero);
                        break;
                    case 2:
                        System.out.println("Ingresar la cantidad a convertir");
                        valorDinero = teclado.nextDouble();
                        request.getConvertMoney("ARS", "USD", valorDinero);
                        break;
                    case 3:
                        System.out.println("Ingresar la cantidad a convertir");
                        valorDinero = teclado.nextDouble();
                        request.getConvertMoney("USD", "BRL", valorDinero);
                        break;
                    case 4:
                        System.out.println("Ingresar la cantidad a convertir");
                        valorDinero = teclado.nextDouble();
                        request.getConvertMoney("BRL", "USD", valorDinero);
                        break;
                    case 5:
                        System.out.println("Ingresar la cantidad a convertir");
                        valorDinero = teclado.nextDouble();
                        request.getConvertMoney("USD", "COP", valorDinero);
                        break;
                    case 6:
                        System.out.println("Ingresar la cantidad a convertir");
                        valorDinero = teclado.nextDouble();
                        request.getConvertMoney("COP", "USD", valorDinero);
                        break;
                    case 7:
                        System.out.println("Gracias por utilizar el programa");
                        break;
                    default:
                        System.out.println("Opción no valida");
                }

            } catch (InputMismatchException e) {
                System.out.println("Dato mal ingresado, por favor revisar, error marcado: " + e.getMessage());
                teclado.nextLine();
            }
        }
    }
}
