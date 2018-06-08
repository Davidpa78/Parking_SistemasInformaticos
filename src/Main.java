import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
     static Scanner escaner = new Scanner(System.in);

    public static void main (String[] args){
       ;
        int filas = 5;
        int columnas = 10;
        int n_switch = 0;
        int recaudacion = 0;
        int [] coordenadas = new int[2];
        char [][] parking = new char[filas][columnas];
        int parking_lleno = 0;
        int contador_coches =0;
        int contador_motos = 0;
        int contador_autobuses = 0;

        Motos motos[] = new Motos[100];
        Coches coches[] = new Coches[100];
        Autobus autobuses[] = new Autobus[100];


        //INICIALIZAR ARRAYS
        for (int i = 0; i< motos.length; i++){
            Autobus autobus = new Autobus("","","",0,"");
            autobuses[i] = autobus;

        }
        for (int i = 0; i< motos.length; i++){
            Motos moto = new Motos("","","",0);
            motos[i] = moto;

        }
        for (int i = 0; i< coches.length; i++){
            Coches coche = new Coches("","","",false,"");
            coches[i] = coche;

        }

        inicializarParking(parking,filas,columnas);


    do {





        System.out.println("\n"
                +"  +--------------------------------------------------+\n"
                +"  |                      PARKING                     |\n"
                + "  +--------------------------------------------------+\n"
                + "  |   1: Ver al parking                              |\n"
                + "  |   2: Entrada de un coche                         |\n"
                + "  |   3: Entrada de una moto                         |\n"
                + "  |   4: Entrada de un autobús                       |\n"
                + "  |   5: Salida de un vehículo                       |\n"
                + "  |   6: Ver recaudación                             |\n"
                + "  |   7: Salir del programa                          |\n"
                + "  +--------------------------------------------------+");
try {
    System.out.print("Introduce el número de opción: ");
    n_switch = escaner.nextInt();
}catch (Exception exception){
    System.out.println("Valores numéricos");

}

        switch (n_switch){
            case 1:
                System.out.println();
                System.out.println();

                imprimirParking(parking,filas,columnas);
                break;
            case 2:
                CogerCoordenadas(coordenadas);
                Integer integer4 = ComprobarPosicionEntrada(parking,coordenadas);
                if(parking_lleno < 24){
                    if(integer4 == 0) {
                        parking[coordenadas[0]][coordenadas[1]] = 'C';
                        Añadircoche(coches,contador_coches);
                        recaudacion += 5;
                        parking_lleno++;
                    }
                    else if (integer4 == 1)
                        System.out.println("Posicion ocupada por vehículo o columnas");
                }

                else
                    System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");
                break;
            case 3:
                CogerCoordenadas(coordenadas);
                Integer integer3 = ComprobarPosicionEntrada(parking,coordenadas);
                if(parking_lleno < 24){
                if(integer3 == 0) {
                    Añadirmoto(motos,contador_motos);
                    parking[coordenadas[0]][coordenadas[1]] = 'M';
                    recaudacion += 3;
                    parking_lleno++;
                }

                else if(integer3 == 1)
                    System.out.println("Posicion ocupada por vehículo o columnas");
                }else
                    System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");
                break;
            case 4:
                CogerCoordenadas(coordenadas);
                Integer integer1 = ComprobarPosicionEntrada(parking,coordenadas);
                if(parking_lleno < 24){
                if(integer1 == 0) {
                    Añadirautobus(autobuses,contador_autobuses);
                    parking[coordenadas[0]][coordenadas[1]] = 'A';
                    recaudacion += 10;
                    parking_lleno++;
                }
                else if(integer1 == 1)
                    System.out.println("Posicion ocupada por vehículo o columnas");}

                    else
                        System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");

                break;
            case 5:
                CogerCoordenadas(coordenadas);
                Integer integer2 = ComprobarPosicionSalida(parking,coordenadas);
                if(integer2 == 0){
                    parking[coordenadas[0]][coordenadas[1]] = '\0';
                }
                else if (integer2 == 1)
                    System.out.println("Introduce una posición con un vehículo existente");

                break;
            case 6:
                System.out.println("La recaudación del parking es de " + recaudacion);
                break;
            case 7:
                System.out.println("Gracias por usar el programa");
                break;
                default:
                    System.out.println("Solo números del 1 al 7");
                break;
        }





    }while (n_switch != 7);
    }



    private static void imprimirParking(char[][] matriz, int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();

            System.out.println();
        }
    }
    private static void inicializarParking(char[][] matriz, int filas, int columnas) {

            for(int i=0; i<filas; i++) {
                for (int j=0; j<columnas; j++) {
                    if ((i == 0 && j == 0)||  (i == 0 && j == 9) || (i == 4 && j == 0) || (i == 4 && j == 9 ) || (i == 2 && j == 0))
                        matriz[i][j] = 'X';
                    else if (i == 1 && j == 0)
                        matriz[i][j] = 'E';
                    else if (i == 3 && j == 0)
                        matriz[i][j] = 'S';
                    else if ((i == 0 && j == 1 ) ||(i == 0 && j == 2)||(i == 0 && j ==3)|| (i == 0 && j ==4)|| (i == 0 && j ==5)|| (i == 0 && j ==6)|| (i == 0 && j ==7)||(i == 0 && j ==8) ||  (i == 4 && j == 1 ) ||(i == 4 && j == 2)||(i == 4 && j ==3)|| (i == 4 && j ==4)|| (i == 4 && j ==5)|| (i == 4 && j ==6)|| (i == 4 && j ==7)||(i == 4 && j ==8)  || (i == 1 && j == 9) || (i == 2 && j == 9) || (i == 3 && j == 9))
                        matriz[i][j] = 'P';
                }
            }
        }
    private static Integer ComprobarPosicionEntrada(char [][] parking, int[] coordenadas) {

        try {
            if (parking[coordenadas[0]][coordenadas[1]] == '\0')
                return 0;
            else
                return 1;
        }catch (Exception ex){
            System.out.println("Coordenadas fuera de los límites del parking");
            return 2;
        }
    }
    private static Integer ComprobarPosicionSalida(char [][] parking, int[] coordenadas) {

    try {
        if (parking[coordenadas[0]][coordenadas[1]] == 'C' || parking[coordenadas[0]][coordenadas[1]] == 'M' || parking[coordenadas[0]][coordenadas[1]] == 'A')
            return 0;
        else
            return 1;

    }catch (Exception ex) {
        System.out.println("Coordenadas fuera de los límites del parking");
        return 2;
    }

    }
    private static int[] CogerCoordenadas(int[] coordenadas){
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Introduzca fila [1-3]: ");
            coordenadas[0] = teclado.nextInt();
            System.out.print("Introduzca columna[1-8]: ");
            coordenadas[1] = teclado.nextInt();
            return coordenadas;
        }catch (InputMismatchException ex) {
        System.out.println("Introduce valores numéricos");
        return coordenadas;
        }
    }

    private static void Añadirmoto (Motos motos[], int contador){

        try {
        System.out.println("Introduce la matrícula");
        motos[contador].setMatricula(escaner.nextLine());
        System.out.println("Introduce la marca: ");
        motos[contador].setMarca(escaner.nextLine());
        System.out.println("Introduce el modelo: ");
        motos[contador].setModelo(escaner.nextLine());
        System.out.println("Introduce la cilindrada: ");
        motos[contador].setCilindrada(escaner.nextInt());
        contador++;
        }catch (Exception ex) { System.out.println("Valor inválido");}
    }

    private static void Añadircoche (Coches coches[], int contador){


try{
    System.out.println("Introduce la matrícula: ");
    coches[contador].setMatricula(escaner.nextLine());
    System.out.println("Introduce la marca: ");
    coches[contador].setMarca(escaner.nextLine());
    System.out.println("Introduce el modelo: ");
    coches[contador].setModelo(escaner.nextLine());
    System.out.println("Introduce tu DNI: ");
    coches[contador].setDni(escaner.nextLine());
    System.out.println("¿Es un coche eléctrico? (true=electrico, false=combustión)");
    coches[contador].setElectrico(escaner.nextBoolean());
    contador++;
    }catch ( Exception ex) {
    System.out.println("Valor invalido");
}

}

    private static void Añadirautobus (Autobus autobuses[], int contador){
        try {
        System.out.println("Introduce la matrícula: ");
        autobuses[contador].setMatricula(escaner.nextLine());
        System.out.println("Introduce la marca: ");
        autobuses[contador].setMarca(escaner.nextLine());
        System.out.println("Introduce el modelo: ");
        autobuses[contador].setModelo(escaner.nextLine());
        System.out.println("Introduce la compañía: ");
        autobuses[contador].setCompañía(escaner.nextLine());
        System.out.println("Introduce el número de plazas: ");
        autobuses[contador].setNumero_plazas(escaner.nextInt());
        contador++;
        }catch (Exception ex) { System.out.println("Valor inválido");}
    }


}











