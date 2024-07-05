import java.util.Scanner;

public class ProductoLacteo {
    private String nombre;
    private double precio;
    private double[] cantidadVendidaSemanales;
    private double cantidadVendidaTotal;

    public ProductoLacteo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadVendidaSemanales = new double[4]; // 4 semanas en un mes
        this.cantidadVendidaTotal = 0;
    }

    public void vender(int semana, double cantidad) {
        this.cantidadVendidaSemanales[semana - 1] += cantidad;
        this.cantidadVendidaTotal += cantidad;
    }

    public double getCantidadVendidaSemanales(int semana) {
        return cantidadVendidaSemanales[semana - 1];
    }

    public double getCantidadVendidaTotal() {
        return cantidadVendidaTotal;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}

class Ventas {
    private ProductoLacteo[] productos;

    public Ventas(ProductoLacteo[] productos) {
        this.productos = productos;
    }

    public void registrarVentas(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            System.out.println("Semana " + (i + 1));
            for (ProductoLacteo producto : productos) {
                System.out.print("Ingrese la cantidad de " + producto.getNombre() + " vendida (en libras): ");
                producto.vender(i + 1, scanner.nextDouble());
            }
        }
    }

    public String mostrarResultadosTxt() {
        String resultados = "resultado de ventas";
        System.out.println("Resultados de ventas:");
        for (ProductoLacteo producto : productos) {
            System.out.println(producto.getNombre() + ":");
            for (int i = 0; i < 4; i++) {
                System.out.println("  Semana " + (i + 1) + ": " + producto.getCantidadVendidaSemanales(i + 1) + " libras vendidas, valor: " + producto.getCantidadVendidaSemanales(i + 1) * producto.getPrecio() + " pesos");
            }
            System.out.println("  Ventas totales: " + producto.getCantidadVendidaTotal() + " libras vendidas, valor: " + producto.getCantidadVendidaTotal() * producto.getPrecio() + " pesos");
        }
        return resultados;
    }

    public double mostrarVentasTotalesTxt() {
        double totalVentas = 0;
        double totalValor = 0;
        for (ProductoLacteo producto : productos) {
            totalVentas += producto.getCantidadVendidaTotal();
            totalValor += producto.getCantidadVendidaTotal() * producto.getPrecio();
        }
        System.out.println("Ventas totales del mes:");
        System.out.println("  Total ventas: " + totalVentas + " libras vendidas");
        System.out.println("  Total valor: " + totalValor + " pesos");

        return totalVentas;
        
       
    }
}
