package ar.edu.utnfrc.backend;


import ar.edu.utnfrc.backend.entities.Estudiante;
import ar.edu.utnfrc.backend.entities.Tipo;
import ar.edu.utnfrc.backend.repository.EstudianteRepository;
import ar.edu.utnfrc.backend.repository.TipoRepository;
import ar.edu.utnfrc.backend.service.EstudianteService;
import ar.edu.utnfrc.backend.service.InasistenciaService;
import ar.edu.utnfrc.backend.service.TipoService;

import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void cargarDatos(){
        try {
            InputStream is = Main.class.getResource("/inasistencias.csv").openStream();
            Scanner scanner = new Scanner(is);
            scanner.nextLine();

            EstudianteService estudianteService = new EstudianteService();
            TipoService tipoService = new TipoService();
            InasistenciaService inasistenciaService = new InasistenciaService();

            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] campos = line.split(",",-1);
                String estudianteNombre = campos[0];
                Estudiante estudiante=estudianteService.buscarBD(estudianteNombre);
                String tipoNombre = campos[1];
                Tipo tipo=tipoService.buscarBD(tipoNombre);
                try {
                    int justificada = Integer.parseInt(campos[2].trim()); // Convertir a entero
                    double cantidad = Double.parseDouble(campos[3].trim()); // Convertir a double
                    inasistenciaService.cargarInasistencia(justificada,cantidad,estudiante,tipo);

                } catch (NumberFormatException e) {
                    System.err.println("Valor inválido en la línea: " + line);
                }

            }

            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar datos: " + e.getMessage(), e);
        }
    }



    public static void main(String[] args) {

        //funcion para cargar datos
        cargarDatos();



    }
}