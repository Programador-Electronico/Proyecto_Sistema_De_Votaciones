
import java.io.File;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author programador
 */
public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("");
        System.out.println("-----------SISTEMA DE VOTACIONES-----------");
        System.out.println("-------------------------------------------");
        File archivo = new File("archivo_texto.txt");

        System.out.print("\nIngrese la contraseña: ");
        String contraseña = teclado.next();
        if (contraseña.equals("1")) {

            int opcion;
            //un bucle para sistema general 
            do {

                System.out.println("\nBienvenido! ");
                System.out.println("1. Registro de Usuario ");
                System.out.println("2. Registro de votante ");
                System.out.println("3. Administracion de elecciones ");
                System.out.println("4. Acceso de votante al Sistema ");
                System.out.println("5. Interfaz de votacion ");
                System.out.println("6. Conteo de Votos ");
                System.out.println("7. Salir del programa ");
                System.out.print("\nIngrese una Opcion: ");
                opcion = teclado.nextInt();

                //Primer switch para para cada caso que desee hacer el usuario 
                switch (opcion) {

                    //1 Registro del Usuario 
                    case 1:
                        int opcion2;
                        do {
                            System.out.println("\n1. Crear usuario del Sistema ");
                            System.out.println("2. Modificar Usuario del Sistema ");
                            System.out.println("3. Reiciar Contraseña ");
                            System.out.println("4. Deshabilitar usuario ");
                            System.out.println("5. Regresar al menu principal ");
                            System.out.print("\nIngrese una opcion: ");

                            opcion2 = teclado.nextInt();
                            switch (opcion2) {

                                //Crea el usuario
                                case 1:

                                    //En este caso manda a llamar al constructor lo cual es el registro del usario 
                                    RegistroUsuario regUser = new RegistroUsuario();
                                    regUser.obtenerDatosUsuario();
                                    regUser.CrearUsuario();

                                    break;

                                //Modifica el usuario
                                case 2:
                                    RegistroUsuario modUser = new RegistroUsuario();
                                    modUser.ModificarUsuario();

                                    break;
                                //Reinicio de Contraseña
                                case 3:
                                    RegistroUsuario reinPass = new RegistroUsuario();
                                    reinPass.ReiniciarContraseña();

                                    break;
                                //Regresa al menu principal
                                case 4:
                                    RegistroUsuario deshUser = new RegistroUsuario();
                                    deshUser.DeshabilitarUsuario();
                                    break;

                                case 5:
                                    opcion2 = 5;
                                    break;

                                default:
                                    System.out.println("\nIngrese una opcion valida");

                            }//llave final del primer switch

                        } while (opcion2 != 5);

                        break;

                    //2 Registro del Votante
                    case 2:
                        int opcion3;
                        do {
                            System.out.println("\n1. Agregar Votante ");
                            System.out.println("2. Modificar Votante ");
                            System.out.println("3. Reiciar Contraseña de votante ");
                            System.out.println("4. Registrar fallecimiento del Votante ");
                            System.out.println("5. Regresar al menu principal ");
                            System.out.print("\nIngrese una Opcion: ");

                            opcion3 = teclado.nextInt();

                            switch (opcion3) {
                                //Agrega un nuevo votante
                                case 1:
                                    RegistroDeVotante regVotante = new RegistroDeVotante();
                                    regVotante.obtenerDatosUsuario();
                                    regVotante.CrearVotante();
                                    break;

                                //Modifica al votante
                                case 2:

                                    break;

                                //Reinicio de Contraseña del votante
                                case 3:
                                    break;

                                //Registra el fallecimiento del Votante
                                case 4:
                                    break;

                                //Regresa al menu principal
                                case 5:
                                    opcion3 = 5;
                                    break;

                                default:
                                    System.out.println("Ingrese una opcion valida ");

                            }

                        } while (opcion3 != 5);

                        break;

                    //3 Administracion de Elecciones
                    case 3:
                        int opcion4;
                        do {
                            System.out.println("1. Gestionar Elecciones  ");
                            System.out.println("2. Gestionar Candidatos ");
                            System.out.println("3. Configurar opciones de eleccion ");
                            System.out.println("4. Regresar al menu principal ");
                            System.out.print("\nIngrese una opcion: ");
                            opcion4 = teclado.nextInt();

                            switch (opcion4) {
                                //Gestiona las elecciones
                                case 1:
                                    break;
                                //Gestiona a los candidatos
                                case 2:
                                    break;
                                //Opciones de las elecciones
                                case 3:
                                    break;
                                //regresa al menu principal
                                case 4:
                                    opcion4 = 4;
                                    break;
                                default:
                                    System.out.println("Ingrese una opcion valida ");
                            }
                            break;

                        } while (opcion4 != 4);

                        break;

                    //4 Acceso de votante al Sistema
                    case 4:
                        System.out.println("Ingrese el Correo Electronico:");
                        System.out.println("Ingresar la Contraseña: ");
                        System.out.println("IngresarCUI:");

                        break;

                    //5 Interfaz de votacion 
                    case 5:
                        int opcion5;
                        do {
                            System.out.println("1. Eleccion Uno ");
                            System.out.println("2. Eleccion Dos ");
                            System.out.println("3. Eleccion Tres ");
                            System.out.println("4. Regresar al menu principal ");
                            System.out.print("\nIngrese una opcion: ");

                            opcion5 = teclado.nextInt();

                            switch (opcion5) {
                                //Es para la primera eleccion 
                                case 1:
                                    break;
                                //Es para la segunda eleccion 
                                case 2:
                                    break;
                                //Es para la tercera eleccion
                                case 3:
                                    break;
                                //regresa al menu principal 
                                case 4:
                                    opcion5 = 5;
                                    break;
                                default:
                                    System.out.println("Ingrese una opcion valida ");

                            }
                            break;

                        } while (opcion5 != 4);

                        break;

                    //6 Conteo de votos
                    case 6:

                        break;

                    //7 Salir del programa
                    case 7:
                        opcion = 7;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida!");
                }//llave final del primer swithc
            } while (opcion != 7);
        } else {
            System.out.println("Contraseña incorrecta! ");
        }

    }

}
