package lab9p1_josueham;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Lab9P1_JosueHam {

    public static Scanner leer = new Scanner(System.in);
    public static Random aleatorio = new Random();
    static Game p1 = new Game();

    public static void main(String[] args) {

        int opcion = Menu();

        while (opcion != 2) {

            switch (opcion) {

                case 1: {
                    
                    System.out.println("Ingrese las rondas que desea: ");
                    int Turnos = leer.nextInt();

                    ArrayList<String> coordenadas = new ArrayList<>();
                    int[][] tablero = new int[10][10];
                    int[][] next = new int[10][10];
                    p1.setTablero(lectura(tablero, next, coordenadas));
                    p1.setNext(next);
                    p1.setTurnos(Turnos);
                    p1.jugar(Turnos);
                   
                }//Fin case 1
                break;

                default:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;
            }//Fin del switch
            opcion = Menu();
        }//Fin del while 

    }//Fin del main 

    public static int Menu() {
        String menu = "----- Bienvenido al menu del programa -----"
                + "\n1 -> Ejercicio 1 (Game of Life)"
                + "\n2 -> Salir del programa"
                + "\nIngrese la opcion que desea: ";
        System.out.println(menu);
        int opcion = leer.nextInt();
        return opcion;
    }//Metodo menu

    public static int[][] lectura(int[][] tablero, int[][] next, ArrayList<String> coordenadas) {
       for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i == 0 || j == 0 || i == tablero.length-1 || j == tablero[0].length-1)) {
                    tablero[i][j] = 0;
                } else {
                    tablero[i][j] = aleatorio.nextInt(2);
                    if (tablero[i][j] == 1) {
                        coordenadas.add(i + ":" + j);
                    }
                }
            }//Fin for j
        }//Fin for i
        System.out.print("Celulas Vivas: " + coordenadas);
        System.out.println();
       for (int i = 0; i < 10; i++) {
            
            for (int j = 0; j < 10; j++) {
                System.out.print("["+tablero[i][j]+"]");
            }
            System.out.println("");
        }
        p1.setCoordenadas(coordenadas);
        return tablero;
    } //Fin del metodo crear matriz

}//Fin de la clase
