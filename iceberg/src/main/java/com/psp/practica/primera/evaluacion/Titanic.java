package com.psp.practica.primera.evaluacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Titanic {
    public static final String[] COMANDOS = { "java", "com.psp.primera.evaluacion.practica.obligatoria.Botes" };
    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";
    public static final String ID = "B";

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
            i=i+0;
        String conteo = desplegar(COMANDOS);
        System.out.println(conteo);
        }
    }

    public static String desplegar(String[] COMANDOS) {
    Random random = new Random();
    StringBuilder output = new StringBuilder();

    try {
        // Ejecuta el proceso
        Process process = Runtime.getRuntime().exec(COMANDOS);

        // Captura la salida estándar
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        // Captura la salida de error
        BufferedReader errorReader = new BufferedReader(
                new InputStreamReader(process.getErrorStream()));
        StringBuilder errorOutput = new StringBuilder();
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
            errorOutput.append(errorLine).append("\n");
        }

        // Espera a que termine el proceso
        int exitVal = process.waitFor();

        if (exitVal == 0) {
            // Proceso correcto, imprime salida normal
            System.out.println("Salida del proceso:");
            System.out.println(output);
        } else {
            // Proceso con error
            System.out.println(MSG_ERROR);
            System.out.println("Error del proceso:");
            System.out.println(errorOutput);
        }

        // Pausa aleatoria entre 2 y 6 segundos
        int espera = 2000 + random.nextInt(4001);
        Thread.sleep(espera);

    } catch (IOException | InterruptedException e) {
        System.err.println("Excepción al ejecutar el comando:");
        e.printStackTrace();
        System.exit(34);
    }

    return output.toString();
}

             private static void informe(BufferedWriter bw, String archivo, int varones, int mujeres, int ninos, int total, int i) throws IOException {
        }
    }
    
