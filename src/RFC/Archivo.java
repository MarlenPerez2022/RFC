/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RFC;

/**
 *
 * @author Len
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

    // Método para crear un archivo con un nombre específico y una ruta específica
    public static void crearArchivo(String ruta, String nombreArchivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "/" + nombreArchivo));
            writer.close();
            System.out.println("Archivo '" + nombreArchivo + "' creado con éxito en la ruta '" + ruta + "'.");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    // Método para editar el contenido de un archivo existente en una ruta específica
    public static void editarArchivo(String ruta, String nombreArchivo, String nuevoContenido) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "/" + nombreArchivo, true));
            writer.write(nuevoContenido);
            writer.close();
            System.out.println("Contenido del archivo '" + nombreArchivo + "' editado con éxito en la ruta '" + ruta + "'.");
        } catch (IOException e) {
            System.err.println("Error al editar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String ruta = "C:\\Users\\Len\\Documents\\RFC\\src\\RFC";
        String nombreArchivo = "datos.txt";
        crearArchivo(ruta, nombreArchivo);
        editarArchivo(ruta, nombreArchivo, "Este es el nuevo contenido del archivo.");
    }
}
//crear , eliminar, reciban parametros la ruta , para buscar el archivo , para leeerlo que sea la ruta , edite que sea ruta 
//