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
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Descifra la Combinacion");
            System.out.println("2. Rotacion Circular de Arreglo");
            System.out.println("3. Bono");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    descifrarCombinacion();
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
                    System.out.println("Opcion inlida.");
            }
        } while(opcion != 4);

        scanner.close();
    }

    /**
     *
     */
    public static void descifrarCombinacion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. Facil");
        System.out.println("2. Medio");
        System.out.println("3. Dificil");
        int dificultad = scanner.nextInt();

        int tamano = 0, intentos = 0;
        switch (dificultad) {
            case 1: tamano = 6; intentos = 22; break;
            case 2: tamano = 8; intentos = 20; break;
            case 3: tamano = 10; intentos = 18; break;
            default: System.out.println("Dificultad no valida."); return;
        }

        char[] combinacion = crearCombinacion(tamano);
        char[] progreso = new char[tamano];
        for (int i = 0; i < tamano; i++) progreso[i] = '-';

        while (intentos > 0) {
            System.out.print("Intentos restantes: " + intentos + ". Estado actual: ");
            System.out.println(progreso);
            System.out.print("Ingrese un caracter: ");
            char intento = scanner.next().charAt(0);

            char[] nuevoProgreso = actualizarProgreso(combinacion, progreso, intento);
            if (String.valueOf(nuevoProgreso).equals(String.valueOf(combinacion))) {
                System.out.println("combinacion correcta");
                return;
            }
            progreso = nuevoProgreso;
            intentos--;
        }
        System.out.println("La combinacion era: " + String.valueOf(combinacion));
    }

    public static char[] crearCombinacion(int tamano) {
        Random random = new Random();
        char[] combinacion = new char[tamano];
        for (int i = 0; i < tamano; i++) {
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

        System.out.print("Ingrese el tamaño del arreglo (mayor a 5): ");
        int tamano = scanner.nextInt();
        if (tamano <= 5) {
            System.out.println("El tamano debe ser mayor a 5.");
            return;
        }

        int[] arreglo = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = random.nextInt(100) + 1;
        }

        System.out.print("Ingrese direccion y posiciones (i/d:posiciones): ");
        String entrada = scanner.next();
        String[] partes = entrada.split(":");
        char direccion = partes[0].charAt(0);
        int posiciones = Integer.parseInt(partes[1]);

        int[] arregloRotado = rotarArreglo(arreglo, direccion, posiciones);
        System.out.println("Arreglo original: ");
        mostrarArreglo(arreglo);
        System.out.println("Arreglo rotado: ");
        mostrarArreglo(arregloRotado);
    }

    public static int[] rotarArreglo(int[] arreglo, char direccion, int posiciones) {
        int tamano = arreglo.length;
        int[] resultado = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            int nuevaPosicion = (direccion == 'i') 
                ? (i - posiciones + tamano) % tamano 
                : (i + posiciones) % tamano;
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

    public static void bono() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer numero: ");
        int num1 = scanner.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        int num2 = scanner.nextInt();

        if (num1 < 0 || num1 > 255 || num2 < 0 || num2 > 255) {
            System.out.println("Ambos numeros deben estar entre 0 y 255.");
            return;
        }

        int[] bin1 = dec2bin(num1);
        int[] bin2 = dec2bin(num2);
        System.out.print("Binario de " + num1 + ": ");
        mostrarArreglo(bin1);
        System.out.print("Binario de " + num2 + ": ");
        mostrarArreglo(bin2);

        int[] sumaBinaria = sumaBinaria(bin1, bin2);
        System.out.print("Suma binaria: ");
        mostrarArreglo(sumaBinaria);
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
        int carry = 0;
        for (int i = 7; i >= 0; i--) {
            int suma = bin1[i] + bin2[i] + carry;
            resultado[i] = suma % 2;
            carry = suma / 2;
        }
        return resultado;
    }
}
    //fin clase
