
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
public class RegistroDeVotante {

    String nombreVotante, apellidoVotante, sexoVotante, fNacimientoVotante, direccionVotante;
    String departamentoVotante, mpioResidenciaVotante, paisVotante, emailVotante;
    String cuiVotante, contraseña;
    double gererarContraseña;

    Scanner teclado = new Scanner(System.in);

    public void obtenerDatosUsuario() {
        System.out.println("Escriba nombre completo ");
        nombreVotante = teclado.nextLine();
        System.out.println("Escriba apellido completo ");
        apellidoVotante = teclado.nextLine();
        System.out.println("Ingrese el CUI del votante ");
        cuiVotante = teclado.nextLine();
        System.out.println("Escriba el sexo  ");
        sexoVotante = teclado.nextLine();
        System.out.println("Escriba la fecha de nacimiento ");
        fNacimientoVotante = teclado.nextLine();
        System.out.println("Escriba la direccion de residencia ");
        direccionVotante = teclado.nextLine();
        System.out.println("Escriba el municipio de residencia ");
        mpioResidenciaVotante = teclado.nextLine();
        System.out.println("Escriba el departamento de residencia ");
        departamentoVotante = teclado.nextLine();
        System.out.println("Escriba el pais de Origen ");
        paisVotante = teclado.nextLine();
        System.out.println("Ingrese el correo electronico ");
        emailVotante = teclado.nextLine();
        gererarContraseña = Math.random();
        contraseña = gererarContraseña + "";

    }

    File archivo2 = new File("archivo_texto.txt");
    //Crea un votante en el sistema
    public void CrearVotante() {

        try {
            FileWriter fw = new FileWriter(archivo2, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(cuiVotante + "|" + nombreVotante + "|" + apellidoVotante + "|" + sexoVotante + "|" + fNacimientoVotante + "|" + direccionVotante + "|" + mpioResidenciaVotante + "|" + departamentoVotante + "|" + paisVotante + "|" + emailVotante + "|" + contraseña + "\n");
            bw.close();

        } catch (IOException ex) {
            System.out.println("Error! " + ex + "\n");
        }
        System.out.println("\nVotante creado! ");

    }

    //Modifica al votante creado
    public void ModificarVotante() {

        try {

            FileReader fr = new FileReader(archivo2);
            BufferedReader br = new BufferedReader(fr);
            
            File archivoCopia2 = new File("archivo_texto_copia.txt");
            FileWriter fw = new FileWriter(archivoCopia2);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;

            System.out.println("Ingrese el CUI del votante ");
            cuiVotante = teclado.next();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                //Solo algunos campos se pueden modificar 
                if (datos[0].equals(cuiVotante)) {
                    System.out.println("Escriba la direccion de residencia ");
                    direccionVotante = teclado.nextLine();
                    datos[5] = direccionVotante;
                    System.out.println("Escriba el municipio de residencia ");
                    mpioResidenciaVotante = teclado.nextLine();
                    datos[6] = mpioResidenciaVotante;
                    System.out.println("Escriba el departamento de residencia ");
                    departamentoVotante = teclado.nextLine();
                    datos[7] = departamentoVotante;
                    System.out.println("Escriba el pais de Origen ");
                    paisVotante = teclado.nextLine();
                    datos[8] = paisVotante; 
                    System.out.println("Ingrese el correo electronico ");
                    emailVotante = teclado.nextLine();
                    datos[9] = emailVotante;

                    linea = String.join("|", datos);

                    System.out.println("\nListo Votante Modificado ");

                } else {
                    System.out.println("El No. de CUI no existe ");
                }

                bw.write(linea + "\n");

            }
            br.close();
            bw.close();

            Files.move(archivo2.toPath(), archivoCopia2.toPath(), REPLACE_EXISTING);

        } catch (FileNotFoundException ex) {
            System.out.println("Error " + ex);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }

    }

    //Reinica la contrasena del votante en caso que la pierda 
    public void ReiniciarContrasena() {

        try {
            FileReader fr = new FileReader(archivo2);
            BufferedReader br = new BufferedReader(fr);

            File archivoCopia2 = new File("archivo_texto_copia.txt");
            FileWriter fw = new FileWriter(archivoCopia2);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;

            System.out.println("Ingrese el correo electronico ");
            emailVotante = teclado.nextLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");
                double generarNuevaContrasena = Math.random();
                String nuevaContrasena = generarNuevaContrasena + "";

                if (datos[9].equals(emailVotante)) {
                    datos[10] = nuevaContrasena;
                    linea = String.join("|", datos);
                    System.out.println("\nContrasena reiniciada con exito! ");

                } else {
                    System.out.println("El correo que ingreso no existe! ");
                }
                bw.write(linea + "\n");

            }
            br.close();
            bw.close();

            Files.move(archivo2.toPath(), archivoCopia2.toPath(), REPLACE_EXISTING);

        } catch (FileNotFoundException ex) {
            System.out.println("Error! " + ex);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }

    }

    //Registra el fallecimiento del votante eliminando su registro
    public void RegistrarFalllecimiento() {
        try {
            FileReader fr = new FileReader(archivo2);
            BufferedReader br = new BufferedReader(fr);
            File archivoCopia2 = new File("archivo_texto_copia.txt");

            FileWriter fw = new FileWriter(archivoCopia2);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;

            System.out.println("Ingrese el CUI del votante ");
            cuiVotante = teclado.nextLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                if (datos[0].equals(cuiVotante)) {
                    System.out.println("\nListo se registro el fallecimieto del votante ");
                } else {
                    System.out.println("\nNo se pudo registrar el falleciento ya que el CUI no existe ");
                }
                bw.write(linea + "\n");
            }
            br.close();
            bw.close();

            Files.move(archivo2.toPath(), archivoCopia2.toPath(), REPLACE_EXISTING);
        } catch (FileNotFoundException ex) {
            System.out.println("Error! " + ex);
        } catch (IOException ex) {
            System.out.println("Error! " + ex);
        }

    }

}
