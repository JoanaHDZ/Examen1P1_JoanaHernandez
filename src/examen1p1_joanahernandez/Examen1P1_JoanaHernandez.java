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
            
            switch(opcion) {
                case 1:
                   // descifrarCombinacion();
                    break;
                case 2:
                    rotacionCircular();
                    break;
                case 3:
                    bono();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion  inválida.");
            }
        } while (opcion != 4);
        
    } // fin main
    
    public static void descifrarCombinacion() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. Fácil (6 caracteres, 22 intentos)");
        System.out.println("2. Medio (8 caracteres, 20 intentos)");
        System.out.println("3. Difícil (10 caracteres, 18 intentos)");
        int dificultad = sc.nextInt();

        int tamaño = 0, intentos = 0;
        switch (dificultad) {
            case 1: tamaño = 6; intentos = 22; break;
            case 2: tamaño = 8; intentos = 20; break;
            case 3: tamaño = 10; intentos = 18; break;
            default: System.out.println("Dificultad no válida."); return;
        }

        char[] combinacion = crearCombinacion(tamaño);
        char[] progreso = new char[tamaño];
        for (int i = 0; i < tamaño; i++) progreso[i] = '-';

        while (intentos > 0) {
            System.out.print("Intentos restantes: " + intentos + ". Estado actual: ");
            System.out.println(progreso);
            System.out.print("Ingrese un carácter: ");
            char intento = sc.next().charAt(0);

            char[] nuevoProgreso = actualizarProgreso(combinacion, progreso, intento);
            if (String.valueOf(nuevoProgreso).equals(String.valueOf(combinacion))) {
                System.out.println("¡Felicidades! Has descifrado la combinación.");
                return;
            }
            progreso = nuevoProgreso;
            intentos--;
        }
        System.out.println("La bomba ha explotado. La combinación era: " + String.valueOf(combinacion));
    }

    public static char[] crearCombinacion(int tamaño) {
        Random random = new Random();
        char[] combinacion = new char[tamaño];
        for (int i = 0; i < tamaño; i++) {
            combinacion[i] = (char) (random.nextInt(26) + 'a');
        }
        return combinacion;
    }

    public static char[] actualizarProgreso(char[] combinacion, char[] progreso, char intento) {
        char[] nuevoProgreso = progreso.clone();
        for (int i = 0; i < combinacion.length; i++) {
            if (combinacion[i] == intento) {
                nuevoProgreso[i] = intento;
            }
        }
        return nuevoProgreso;
    }
    
    public static void rotacionCircular() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese el tamano del arreglo (mayor a 5): ");
        int a = scanner.nextInt();
        if (a <= 5) {
            System.out.println("Numero invalido");
            return;
        }
        
        int[] arreglo = new int[a];
        for (int i = 0; i < a; i++) {
            arreglo[i] = random.nextInt(100) + 1;
        }

        System.out.print("Ingrese direccion y posiciones (i/d:posiciones) posiciones en numeros): ");
        String resp = scanner.next();
        String[] partes = resp.split(":");
        char x = partes[0].charAt(0);
        int k = Integer.parseInt(partes[1]);

        int[] arregloRotado = rotarArreglo(arreglo, x, k);
        System.out.println("Arreglo original: ");
        printing(arreglo);
        System.out.println("Arreglo rotado: ");
        printing(arregloRotado);
    }
    
    public static int[] rotarArreglo(int[] arreglo, char direccion, int posiciones) {
        int i, j, x;
        int tamaño = arreglo.length;
        int[] resultado = new int[tamaño];
        for (i = 0; i < arreglo.length - 1; i++) {
            for (j = 0; j < arreglo.length - i - 1; j++) {                                                              
                if (arreglo[j + 1] < arreglo[j]) {
                    x = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = x;
                }
            }
        }
        return resultado;
    }

    public static void printing(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
        // fin metodo
    
    public static void bono() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese primer numero: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese segundo numero: ");
        int num2 = sc.nextInt();

        int[] bin1 = dec2bin(num1);
        int[] bin2 = dec2bin(num2);
        System.out.print("Binario de " + num1 + ": ");
        printing(bin1);
        System.out.print("Binario de " + num2 + ": ");
        printing(bin2);

        int[] sumaBinaria = sumaBinaria(bin1, bin2);
        System.out.print("Suma binaria: ");
        printing(sumaBinaria);
    } 
    
    public static int[] dec2bin(int numero) {
        int[] binario = new int[8];
        for (int i = 7; i >= 0; i--) {
            binario[i] = numero % 2;
            numero /= 2;
        }
        return binario;
    }

    public static int[] sumaBinaria(int[] bin1, int[] bin2) {
        int[] resultado = new int[8];
        int x = 0;
        for (int i = 7; i >= 0; i--) {
            int suma = bin1[i] + bin2[i] + x;
            resultado[i] = suma % 2;
            x = suma / 2;
        }
        return resultado;
    }
}  
    //fin clase
