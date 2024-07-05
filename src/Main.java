import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de productos: ");
        int numProductos = scanner.nextInt();

        ProductoLacteo[] productos = new ProductoLacteo[numProductos];

        for (int i = 0; i < numProductos; i++) {
            System.out.print("Ingrese el nombre del producto " + (i + 1) + ": ");
            String nombre = scanner.next();
            System.out.print("Ingrese el precio del producto " + (i + 1) + ": ");
            double precio = scanner.nextDouble();
            productos[i] = new ProductoLacteo(nombre, precio);
        }
        Gastos gastos = new Gastos();
        Ventas ventas = new Ventas(productos);

        System.out.println("Registro de ventas:");
        ventas.registrarVentas(scanner);

        System.out.println("Registro de gastos:");
        gastos.registrarGastos(scanner);

        System.out.println("Resultados de ventas:");
        String resultadosVentas = ventas.mostrarResultadosTxt();

        System.out.println("Ventas totales del mes:");
        double resultadosVentasTotales = ventas.mostrarVentasTotalesTxt();

        System.out.println("Resultados de gastos:");
        String resultadosGastos = gastos.mostrarResultadosTxt();

        // Escribir resultados en archivo TXT
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultados.txt"))) {
            writer.println("Resultados de ventas:");
            writer.println(resultadosVentas);
            writer.println("Resultados de gastos:");
            writer.println(resultadosGastos);
            writer.println("Ventas totales del mes:");
            writer.println(resultadosVentasTotales);
        } catch (IOException e) {
            System.err.println("Error al escribir en archivo: " + e.getMessage());

            
        }
    }
}