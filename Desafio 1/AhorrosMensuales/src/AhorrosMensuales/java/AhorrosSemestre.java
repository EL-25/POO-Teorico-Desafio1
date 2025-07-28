package AhorrosMensuales.java;

import java.util.Scanner;

public class AhorrosSemestre {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Paso 1: Pido el nombre de la persona
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        //Paso 2: Creo un arreglo que almacene 6 meses
        double[] ahorros = new double[6];
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        double total = 0;

        //Variables que rastrean el mayor y meno ahorro
        double mayor = Double.MIN_VALUE;
        double menor = Double.MAX_VALUE;
        int mesMayor = -1;
        int mesMenor = -1;

        //Paso 3: Solicito el monto del ahorro por cada mes
        for (int i = 0; i < 6; i++) {
            System.out.printf("Ahoro en %s: $", meses[i]);
            double monto = scanner.nextDouble();

            //Valido que el monto sea mayor a cero
            if (monto <= 0) {
                System.out.println("El monto debe ser mayor a cero. Intente nuevamente.");
                i--; //Repito el mismo mes
                continue;
            }

            ahorros[i] = monto;
            total += monto;

            // Verifico si es el mayor
            if (monto > mayor) {
                mayor = monto;
                mesMayor = i;
            }

            // Verifico si es el menor
            if (monto < menor) {
                menor = monto;
                mesMenor = i;
            }
        }

        // Paso 4: Muestro los resultados
        System.out.println("\nResumen de ahorro de " + nombre + ":");

        for (int i = 0; i < 6; i++) {
            System.out.printf("%s: $%.2f\n", meses[i], ahorros[i]);
        }

        System.out.printf("\nTotal ahorrado en el semestre: $%.2f\n", total);
        System.out.println("Mes con mayor ahorro: " + meses[mesMayor] + " ($" + mayor + ")");
        System.out.println("Mes con menor ahorro: " + meses[mesMenor] + " ($" + menor + ")");

        // Paso 5: Mensaje de Felicitación si el usuario supera $1000
        if (total > 1000) {
            System.out.println("\n¡Felicidades " + nombre + "! Superaste los $1000 en ahorros");
        }

        scanner.close();
    }
}
