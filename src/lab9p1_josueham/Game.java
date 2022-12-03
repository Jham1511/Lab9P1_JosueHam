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
            System.out.print(Print(coordenadas));
            System.out.println("");
            System.out.println("Ronda: "+i);
            System.out.println("Celulas vivas: " + coordenadas);
            nextGen();
        }
    }

    public void nextGen() {
        coordenadas.clear();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (tablero[i][j] == 1 && getVecinos(i, j) < 2) {
                    next[i][j] = 0;
                } else if (tablero[i][j] == 1 && getVecinos(i, j) > 3) {
                    next[i][j] = 0;
                } else if (tablero[i][j] == 0 && getVecinos(i, j) == 3) {
                    next[i][j] = 1;
                } else if (tablero[i][j] == 1 && getVecinos(i,j)== 2){
                    next[i][j] = tablero[i][j];
                }//Fin else
                if (next[i][j] == 1) {
                    coordenadas.add(Integer.toString(i) + ":" + Integer.toString(j));
                }
            }//Fin for j
            
            int[][] temp= tablero;
            tablero = next;
            next = temp;
        }//Fin del for de i
    }//Fin metodo nextGen

    public static String Print(ArrayList<String> coordenadas) {
        String output = "";
        int[][] temp = new int[10][10];
        for (int i = 0; i < coordenadas.size() ; i++) {
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
        int cont = -1;
        for (int k = -1; k <= 1; k++) {
            if (i + k > -1 && i + k < 10 && j - 1 > -1) {
                if (tablero[i + k][j - 1] == 1 && i+k!=i) {
                    cont++;
                }
            }
        }
        for (int k = -1; k <= 1; k++) {
            if (i + k > -1 && i + k < 10 && j + 1 < 10) {
                if (tablero[i + k][j + 1] == 1 && i+k!=i) {
                    cont++;
                }
            }
        }
        for (int k = -1; k <= 1; k++) {
            if (j+k > -1 && j + k < 10 && i - 1 > -1) {
                if (tablero[i-1][j+k]== 1 && i+k!=j) {
                    cont++;
                }
            }
        }
        for (int k = -1; k <= 1; k++) {
            if (j+k > -1 && j + k < 10 && i + 1 < 10) {
                if (tablero[i+1][j+k]== 1 && i+k!=j) {
                    cont++;
                }
            }
        }
        return cont;
    }//Fin metodo vecinos

}//Fin de la clase 

