package SalarioEmpleado.java;

import java.util.Scanner;

public class SalarioEmpleado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Paso 1: Pregunto cuantos empleados se inscribieron
        System.out.println("¿Cuántos empleados se inscribieron? ");
        int cantidad = scanner.nextInt();

        //Valido que el dato sea mayor a cero
        if (cantidad <= 0){
            System.out.println("La cantidad debe ser mayor a cero. ");
            return; // Sale del programa
        }

        // Almaceno la suma de los salarios
        double sumaSalariosNetos = 0;

        //Paso 2: Reviso cada empleado
        for (int i = 1; i <= cantidad; i++){
            System.out.println("\nEmpleado #" + i);

            //Leo el nombre
            System.out.println("Nombre: ");
            scanner.nextLine(); // Vacio la entrada antes que se lea el nombre
            String nombre = scanner.nextLine();

            //Leo el salario y lo valido
            System.out.println("Salario: $");
            double salario = scanner.nextDouble();

            if (salario <= 0){
                System.out.println("El salario debe ser mayor a cero. ");
                i--; //Repito este empleado
                continue;
            }

            //Paso 3: Calculo las deducciones
            double isss = salario * 0.03;
            double afp = salario * 0.075;
            double renta = (salario > 700) ? salario * 0.10 : 0;

            //Calculo el salario
            double salarioNeto = salario - (isss + afp + renta);
            sumaSalariosNetos += salarioNeto;

            //Muestro los resultados
            System.out.printf("Empleado: %s\n", nombre);
            System.out.printf("Salario bruto: $%.2f\n", salario);
            System.out.printf("Salario neto: $%.2f\n", salarioNeto);
        }

        //Paso 4: Muestro el promedio
        double promedio = sumaSalariosNetos / cantidad;
        System.out.printf("\nPromedio de salarios netos: $%.2f\n", promedio);

        scanner.close();
    }
}
