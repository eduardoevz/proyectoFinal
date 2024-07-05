import java.util.Scanner;

public class Gastos {
    private double[] gastosSemanales;
    private double gastoTotal;

    public Gastos() {
        this.gastosSemanales = new double[4]; // 4 semanas en un mes
        this.gastoTotal = 0;
    }

    public void registrarGastos(Scanner scanner) {
        for (int i = 0; i < 4; i++) {
            System.out.print("Ingrese el gasto de la semana " + (i + 1) + ": ");
            gastosSemanales[i] = scanner.nextDouble();
            gastoTotal += gastosSemanales[i];
        }
    }

    public String mostrarResultadosTxt() {
        String resultados = "resultados de gastos";
        System.out.println("Resultados de gastos:");
        for (int i = 0; i < 4; i++) {
            System.out.println("  Semana " + (i + 1) + ": " + gastosSemanales[i] + " pesos");
        }
        System.out.println("  Total de gastos: " + gastoTotal + " pesos");
        return resultados;
    }
}

