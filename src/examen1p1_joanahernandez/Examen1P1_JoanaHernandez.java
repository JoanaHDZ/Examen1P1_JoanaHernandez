/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen1p1_joanahernandez;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author joana
 */
public class Examen1P1_JoanaHernandez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("1. Desifrar la combinacion");
            System.out.println("2. Rotacion de arreglo");
            System.out.println("3. Bono");
            System.out.println("4. salir");
            System.out.println("Que quiere hacer?");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    
                default:
                    break;
            }
        } while (opcion != 4);
        if (opcion == 4) {
            System.out.println("Gracias por participar");
        }
    } // fin main
    
    public void descifrar(int [] x) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Seleccione la dificultad");
        System.out.println("1. Facil");
        System.out.println("2. medio");
        System.out.println("3. dificil");
        int d = sc.nextInt();
        
        
        if (d != 1 || d != 2 || d!= 3) {
            System.out.println("Opcion invalida");
        }
        switch (d) {
            case 1:
                
                int[] array = new int[6];
                
                for(int i = 0; i < array.length; i++) {
                array[i] = 1 + ran.nextInt(100);
        }

        }
    }
   
} //fin clase
