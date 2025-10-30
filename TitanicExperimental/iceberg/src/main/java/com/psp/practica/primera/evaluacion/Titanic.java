package com.psp.practica.primera.evaluacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Titanic {
    public static final String[] COMANDOS = {
    "java",
    "-cp", "target/classes",
    "com.psp.practica.primera.evaluacion.Botes"
};

    public static final String MSG_ERROR = "Se ha producido un error al ejecutar el comando";
    public static final String ID = "B";

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++){
        String conteo = desplegar(COMANDOS);
        System.out.println(conteo);
        }
    }

    public static String desplegar(String[] COMANDOS) {
        Random random = new Random();
        StringBuilder output = new StringBuilder();
        try {
            // Usa classpath absoluto
            String classpath = new java.io.File("target/classes").getAbsolutePath();
            String[] comandosExec = new String[] {"java", "-cp", classpath, "com.psp.practica.primera.evaluacion.Botes"};
            ProcessBuilder pb = new ProcessBuilder(comandosExec);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }
            int exitVal = process.waitFor();
            if (exitVal != 0) {
                output.append(MSG_ERROR).append("\n");
            }
            // Pausa aleatoria entre 2 y 6 segundos
            int espera = 2000 + random.nextInt(4001);
            Thread.sleep(espera);
        } catch (IOException | InterruptedException e) {
            output.append("Excepción al ejecutar el comando:\n");
            output.append(e.getMessage()).append("\n");
        }
        return output.toString();
    }

             private static void informe(BufferedWriter bw, String archivo, int varones, int mujeres, int ninos, int total, int i) throws IOException {
        }
    }

