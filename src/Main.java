import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        Scanner escaner = new Scanner(System.in);
        int filas = 5;
        int columnas = 10;
        int n_switch = 0;
        int recaudacion = 0;
        int [] coordenadas = new int[2];
        char [][] parking = new char[filas][columnas];
        int parking_lleno = 0;


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

        System.out.print("Introduce el número de opción: ");
        n_switch = escaner.nextInt();

        switch (n_switch){
            case 1:
                System.out.println();
                System.out.println();

                imprimirParking(parking,filas,columnas);
                break;
            case 2:
                CogerCoordenadas(coordenadas);
                if(ComprobarPosicionEntrada(parking, coordenadas)) {
                    parking[coordenadas[0]][coordenadas[1]] = 'C';
                    recaudacion += 5;
                    parking_lleno ++;
                }

                else
                    System.out.println("Posicion ocupada por vehículo o columnas");

                break;
            case 3:
                CogerCoordenadas(coordenadas);
                if(ComprobarPosicionEntrada(parking, coordenadas)) {
                    parking[coordenadas[0]][coordenadas[1]] = 'M';
                    recaudacion += 3;
                    parking_lleno++;
                }

                else
                    System.out.println("Posicion ocupada por vehículo o columnas");
                break;
            case 4:
                CogerCoordenadas(coordenadas);
                if(parking_lleno <= 24){
                if(ComprobarPosicionEntrada(parking, coordenadas)) {

                    parking[coordenadas[0]][coordenadas[1]] = 'A';
                    recaudacion += 10;
                    parking_lleno++;
                }
                else
                    System.out.println("Posicion ocupada por vehículo o columnas");}

                    else
                        System.out.println("PARKING LLENO INTENTE TRAS SACAR ALGÚN VEHÍCULO");

                break;
            case 5:
                CogerCoordenadas(coordenadas);
                if(ComprobarPosicionSalida(parking,coordenadas)){
                    parking[coordenadas[0]][coordenadas[1]] = '\0';
                }
                else
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
    private static boolean ComprobarPosicionEntrada(char [][] parking, int[] coordenadas) {

            if (parking[coordenadas[0]][coordenadas[1]] == '\0')
                return true;
            else
                return false;



    }

    private static boolean ComprobarPosicionSalida(char [][] parking, int[] coordenadas) {

        if ( parking[coordenadas[0]][coordenadas[1]] == 'C' || parking[coordenadas[0]][coordenadas[1]] == 'M' || parking[coordenadas[0]][coordenadas[1]] == 'A')
            return true;
        else
            return false;



    }


    private static int[] CogerCoordenadas(int[] coordenadas){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca fila [1-3]: ");
         coordenadas[0] = teclado.nextInt();
        System.out.print("Introduzca columna[1-8]: ");
        coordenadas[1] = teclado.nextInt();
        return coordenadas;

    }






    }




