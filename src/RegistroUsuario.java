
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author programador
 */
public class RegistroUsuario {

    String nombreUsuario, apellidoUsuario, emailUsuario, contraseña, idUser;
    double gererarContraseña;
    int generarID;
    //String idUser;
    //String contraseña;
    Scanner teclado = new Scanner(System.in);

    //Solicitamos los datos al usuario para crear un nuevo usuario
    public void obtenerDatosUsuario() {
        //Solicita el nombre del usuario
        System.out.println("Escriba el Nombre del Usuario! ");
        nombreUsuario = teclado.next();
        //solicita el apellido del usuario 
        System.out.println("Escriba el Apellido del Usuario! ");
        apellidoUsuario = teclado.next();
        //Solicita el correo electronico del usuario 
        System.out.println("Digite el Correo del Usuario! ");
        emailUsuario = teclado.next();
        //Genera una contraseña ramdom de 16 caracteres 
        gererarContraseña = Math.random();
        //Comvertimos nuestra contraseña en una cadena 
        contraseña = gererarContraseña + "";
        //Gerera un Id ramdom y lo multiplico por 100 para obtener un ID entero
        generarID = (int) (Math.random() * 100);
        //El id se lo asignamos a una nueva variable de tipo String para obtener una cadena
        idUser = "User" + generarID;

    }

    //Creamos nuestro archivo File para accerder al fichero 
    File archivo = new File("archivo_texto.txt");

    //Crea un usuario y lo guarda en un archivo txt  
    public void CrearUsuario() {
        try {
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(idUser + "|" + nombreUsuario + "|" + apellidoUsuario + "|" + emailUsuario + "|" + contraseña + "\n");
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error! " + ex + "\n");

        }

        System.out.println("\nUsuario Creado! ");
    }

    //Modifica los datos del usuario guardado en un archivo txt
    public void ModificarUsuario() {

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            File archivoCopia = new File("archivo_texto_copia.txt");
            FileWriter fw = new FileWriter(archivoCopia);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea = "";

            System.out.println("Ingresa id del usuario! ");
            idUser = teclado.next();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                if (datos[0].equals(idUser)) {
                    System.out.println("Escriba el Nombre del Usuario! ");
                    nombreUsuario = teclado.next();
                    datos[1] = nombreUsuario;
                    System.out.println("Escriba el Apellido del Usuario! ");
                    apellidoUsuario = teclado.next();
                    datos[2] = apellidoUsuario;
                    System.out.println("Digite el Correo del Usuario! ");
                    emailUsuario = teclado.next();
                    datos[3] = emailUsuario;

                    linea = String.join("|", datos);
                    System.out.println("\nListo usuario modificado ");

                } else {
                    System.out.println("Usuario no encontrado ");
                }
                bw.write(linea + "\n");

            }
            br.close();
            bw.close();

            Files.move(archivoCopia.toPath(), archivo.toPath(), REPLACE_EXISTING);

        } catch (FileNotFoundException ex) {
            System.out.println("Error! " + ex);

        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }

    }

    //Reicia la contraseña de un usuario solicitando unicamente el correo electronico 
    public void ReiniciarContraseña() {

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            File archivoCopia = new File("archivo_texto_copia.txt");
            FileWriter fw = new FileWriter(archivoCopia);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;

            System.out.println("Ingrese el correo electronico del usuario ");
            emailUsuario = teclado.next();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                double generarNuevaContraseña = Math.random();
                String nuevaContraseña = generarNuevaContraseña + "";
                if (datos[3].equals(emailUsuario)) {
                    datos[4] = nuevaContraseña;
                    linea = String.join("|", datos);
                    System.out.println("\nContrasena reinciada con exito! ");
                } else {
                    System.out.println("El correo electronico que ingreso no existe! ");
                }
                bw.write(linea + "\n");
            }
            br.close();
            bw.close();

            Files.move(archivoCopia.toPath(), archivo.toPath(), REPLACE_EXISTING);
        } catch (FileNotFoundException ex) {
            System.out.println("Error! " + ex);

        } catch (IOException ex) {
            System.out.println("Error! " + ex);

        }

    }

    public void DeshabilitarUsuario() {
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            File archivoCopia = new File("archivo_texto_copia.txt");
            FileWriter fw = new FileWriter(archivoCopia);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;

            System.out.println("Ingrese el id del usuario ");
            idUser = teclado.next();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos[0].equals(idUser)) {

                    System.out.println("\nListo usuario deshabilitado ");
                } else {
                    System.out.println("\nID del Usuario no existe ");
                    bw.write(linea + "\n");
                }

            }
            br.close();
            bw.close();

            Files.move(archivoCopia.toPath(), archivo.toPath(), REPLACE_EXISTING);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
            System.out.println("Error! " + ex);

        }

    }
}
