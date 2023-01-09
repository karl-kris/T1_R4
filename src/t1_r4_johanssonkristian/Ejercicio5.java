/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t1_r4_johanssonkristian;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ejercicio5 {

    private static Conectar conexion;
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Introduzca sus credenciales de la base de datos: \n");
            entrada = new Scanner(System.in);
            System.out.println("SGDB (Mysql): ");
            String sgdb = entrada.nextLine();
            System.out.println("Nombre de base de datos: ");
            String bd = entrada.nextLine();
            System.out.println("Nombre de usuario: ");
            String usuario = entrada.nextLine();
            System.out.println("Contraseña: ");
            String contrasena = entrada.nextLine();

            String servidor = "jdbc:" + sgdb + "://localhost/" + bd;

            conexion = new Conectar(servidor, usuario, contrasena);
            int num;

            System.out.println("\tElija una opción (1 - 7 / 0 para salir): \n\n");
            System.out.println("\t1. Mostrar datos generales del SGBD y la base de datos.\n");
            System.out.println("\t2. Mostrar datos de todas las tablas.\n");
            System.out.println("\t3. Mostrar los datos de una tabla.\n");
            System.out.println("\t4. Mostrar las columnas de una tabla.\n");
            System.out.println("\t5. Mostrar las claves primarias de una tabla.\n");
            System.out.println("\t6. Mostrar las claves externas asociadas a la clave primaria de una tabla.\n");
            System.out.println("\t7. Mostrar los procedimientos almacenados a la base de datos conectada.\n >");
            num = entrada.nextInt();

            while (num != 0) {

                int num1 = entrada.nextInt();
                num = num1;

                switch (num) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                }

                System.out.println("\tElija una opción (1 - 7 / 0 para salir): \n\n");
                System.out.println("\t1. Mostrar datos generales del SGBD y la base de datos.\n");
                System.out.println("\t2. Mostrar datos de todas las tablas.\n");
                System.out.println("\t3. Mostrar los datos de una tabla.\n");
                System.out.println("\t4. Mostrar las columnas de una tabla.\n");
                System.out.println("\t5. Mostrar las claves primarias de una tabla.\n");
                System.out.println("\t6. Mostrar las claves externas asociadas a la clave primaria de una tabla.\n");
                System.out.println("\t7. Mostrar los procedimientos almacenados a la base de datos conectada.\n >");

            }

            entrada.close();
            conexion.getConectar().close();
        } catch (SQLException e) {
            System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");
        }

    }

    private static void mostrarGeneral(Connection conexion) {

        try {
            if (conexion != null) {
                DatabaseMetaData datos = conexion.getMetaData();
                String nombre = datos.getDatabaseProductName();
                String driver = datos.getDriverName();
                String url = datos.getURL();
                String usuario = datos.getUserName();

                System.out.println("INFORMACIÓN GENERAL\n==========================\n\n");
                System.out.println("Nombre: " + nombre);
                System.out.println("Driver: " + driver);
                System.out.println("URL: " + url);
                System.out.println(" Usuario: " + usuario);

            }
        } catch (SQLException e) {
            System.out.println("\nNO SE HA PODIDO CONECTAR A LA BASE DE DATOS.\nCOMPRUEBA TU CONEXIÓN.\n");
        }

    }

    private static void mostrarInfoTablas(Connection conexion) {

        if (conexion != null) {

            try {

                DatabaseMetaData datos = conexion.getMetaData();

                ResultSet tablas = datos.getTables(null, null, null, null);

                while (tablas.next()) {
                    String nombreTabla = tablas.getString("TABLE_NAME");
                    String catalogoTabla = tablas.getString("TABLE_CAT");
                    String esquemaTabla = tablas.getString("TABLE_SCHEM");
                    String tipoTabla = tablas.getString("TABLE_TYPE");

                    System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla);

                }

                tablas.close();

            } catch (SQLException e) {
                System.out.println("\nHA HABIDO UN ERROR EN LA CONEXIÓN.\n");
            }
        }

    }

    private static void mostrarTabla(Connection conexion) {

        if (conexion != null) {

            try {

                DatabaseMetaData datos = conexion.getMetaData();

                System.out.println("\tElija una opción (1 - 3 / 0 para salir): \n\n");
                System.out.println("\t1. Mostrar datos tabla alumno.\n");
                System.out.println("\t2. Mostrar datos tabla curso.\n");
                System.out.println("\t3. Mostrar datos tabla matrícula.\n >");

                int num1 = entrada.nextInt();

                switch (num1) {
                    case 1:
                        ResultSet tablaAlumno = datos.getTables(null, null, "alumno", null);
                        while (tablaAlumno.next()) {
                            String nombreTabla = tablaAlumno.getString("TABLE_NAME");
                            String catalogoTabla = tablaAlumno.getString("TABLE_CAT");
                            String esquemaTabla = tablaAlumno.getString("TABLE_SCHEM");
                            String tipoTabla = tablaAlumno.getString("TABLE_TYPE");

                            System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla);

                        }
                        tablaAlumno.close();
                        break;
                    case 2:
                        ResultSet tablaCurso = datos.getTables(null, null, "curso", null);
                        while (tablaCurso.next()) {
                            String nombreTabla = tablaCurso.getString("TABLE_NAME");
                            String catalogoTabla = tablaCurso.getString("TABLE_CAT");
                            String esquemaTabla = tablaCurso.getString("TABLE_SCHEM");
                            String tipoTabla = tablaCurso.getString("TABLE_TYPE");

                            System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla);

                        }
                        tablaCurso.close();
                        break;
                    case 3:
                        ResultSet tablaMatricula = datos.getTables(null, null, "matricula", null);
                        while (tablaMatricula.next()) {
                            String nombreTabla = tablaMatricula.getString("TABLE_NAME");
                            String catalogoTabla = tablaMatricula.getString("TABLE_CAT");
                            String esquemaTabla = tablaMatricula.getString("TABLE_SCHEM");
                            String tipoTabla = tablaMatricula.getString("TABLE_TYPE");

                            System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla);

                        }
                        tablaMatricula.close();
                        break;
                }


            } catch (SQLException e) {
                System.out.println("\nHA HABIDO UN ERROR EN LA CONEXIÓN.\n");
            }
        }

    }

    private static void mostrarColumnasTabla(Connection conexion) {

        if (conexion != null) {

        }

    }

    private static void mostrarPKTabla(Connection conexion, String nomTabla) {

        if (conexion != null) {

        }

    }

    private static void mostrarFKTabla(Connection conexion, String nomTabla) {

        if (conexion != null) {

        }

    }

    private static void mostrarProcedimientosAlmacenados(Connection conexion) {

        if (conexion != null) {

        }

    }

}
