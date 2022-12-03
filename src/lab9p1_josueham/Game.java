package lab9p1_josueham;

import java.util.ArrayList;

/**
 *
 * @author skxka
 */
public class Game {

    public int[][] tablero;
    public int[][] next;
    public ArrayList<String> coordenadas;
    public int Turnos;

    public Game() {
    }

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int[][] getNext() {
        return next;
    }

    public void setNext(int[][] next) {
        this.next = next;
    }

    public ArrayList<String> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(ArrayList<String> coordenadas) {
        this.coordenadas = coordenadas;
    }

    public int getTurnos() {
        return Turnos;
    }

    public void setTurnos(int Turnos) {
        this.Turnos = Turnos;
    }

    public void jugar(int Turnos) {
        for (int i = 0; i < Turnos; i++) {
            nextGen();
            System.out.println("");
            System.out.println("Ronda: " + i);
            System.out.println("Celulas vivas: " + coordenadas);
            System.out.print(Print(coordenadas));
            System.out.println("");

        }
    }

    public void nextGen() {
        coordenadas.clear();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int Vecinos = getVecinos(i, j);
                if (tablero[i][j] == 1) {
                    if (Vecinos < 2 || Vecinos > 3)
                        next[i][j] = 0;
                    else if (Vecinos == 2)
                        next[i][j] = tablero[i][j];
                }
                else
                    if (Vecinos == 3)
                        next[i][j] = 1;
                if (next[i][j] == 1)
                    coordenadas.add(Integer.toString(i) + ":" + Integer.toString(j));
            }
        } //Fin del for de i

        int[][] temp = tablero;
        tablero = next;
        next = temp;
    }//Fin metodo nextGen

    public static String Print(ArrayList<String> coordenadas) {
        String output = "";
        int[][] temp = new int[10][10];
        for (int i = 0; i < coordenadas.size(); i++) {
            String[] cords = coordenadas.get(i).split(":");
            temp[Integer.parseInt(cords[0])][Integer.parseInt(cords[1])] = 1;
        }//Fin for i
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                output += "[" + temp[j][k] + "]";
            }//Fin for k
            output += "\n";
        }//Fin for j
        return output;
    }//Fin del print

    public int getVecinos(int i, int j) {
      int cont = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                if (tablero[i+k][j+l] == 1)
                    cont++;
            }
        }
        if (tablero[i][j] == 1)
            cont--;
        return cont;
    }//Fin metodo vecinos

}//Fin de la clase 

