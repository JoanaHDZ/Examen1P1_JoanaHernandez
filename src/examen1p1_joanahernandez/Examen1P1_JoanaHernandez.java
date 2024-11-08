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
                  descifrar();
                  break;
                case 2:
                 rotacionCircular();
                default:
                    break;
            }
        } while (opcion != 4);
        if (opcion == 4) {
            System.out.println("Gracias por participar");
        }
    } // fin main
    
    public static void descifrar() {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        System.out.println("Seleccione la dificultad");
        System.out.println("1. Facil");
        System.out.println("2. medio");
        System.out.println("3. dificil");
        int d = sc.nextInt();
        boolean vdd = true;
        String arreglo = "";
        
        int intentos;
        
        switch (d) {
            case 1:
               intentos = 22;
                crearcombinacion();
                break;
            case 2:
                intentos = 20;
                crearcombinacion();
                break;
            default:
                intentos = 18;
                arreglo = "10";
                crearcombinacion();
                break;
        }
        System.out.println("Ingrese un caracter: ");
        char c = sc.next().charAt(0);
    }
    
    public static void crearcombinacion () {
        String z = "abcdefghijklmnopqrstuvwxyz";
        String cadena = "";
        int v = 6;
        int j = 8;
        int m = 10;
        
        if (v == 6) {
        for (int x = 0; x < 6; x++) {
                 int i = 6;
                 char c = z.charAt(i);
                    cadena += c;
                   }
        }
        
        if (j == 8) {
            for (int x = 0; x < 8; x++) {
                 int i = 8;
                 char c = z.charAt(i);
                    cadena += c;
            }   
        }
        
        if (m == 10) {
            for (int x = 0; x < 10; x++) {
                 int i = 10;
                 char c = z.charAt(i);
                    cadena += c;
        }
        // fin metodo
     }
    }
    
   public static void rotacionCircular() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese el tamano del arreglo (mayor a 5): ");
        int x = sc.nextInt();
        
        int[] arreglo = new int[x];
        for (int i = 0; i < x; i++) {
            arreglo[i] = random.nextInt(100) + 1;
        }
 
        System.out.print("Ingrese dirección y posiciones (i/d:posiciones en numeros): ");
        String a = sc.next();
        String[] b = a.split(":");
        char direccion = b[0].charAt(0);
        int posiciones = Integer.parseInt(b[1]);
    
        int[] arregloRotado = rotarArreglo(arreglo, direccion, posiciones);
        System.out.println("Arreglo rotado: ");
        System.out.println(mostrarArreglo(arregloRotado));
}
   public static int[] rotarArreglo(int[] arreglo, char direccion, int posiciones) {
        int tamaño = arreglo.length;
        int[] resultado = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            int nuevaPosicion = (direccion == 'i') 
                ? (i - posiciones + tamaño) % tamaño 
                : (i + posiciones) % tamaño;
            resultado[nuevaPosicion] = arreglo[i];
        }
        return resultado;
    }

    public static void mostrarArreglo(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}  
    //fin clase
