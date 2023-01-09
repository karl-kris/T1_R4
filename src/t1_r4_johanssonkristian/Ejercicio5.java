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
                        mostrarGeneral(conexion.getConectar());
                        break;
                    case 2:
                        mostrarInfoTablas(conexion.getConectar());
                        break;
                    case 3:
                        mostrarTabla(conexion.getConectar());
                        break;
                    case 4:
                        mostrarColumnasTabla(conexion.getConectar());
                        break;
                    case 5:
                        mostrarPKTabla(conexion.getConectar());
                        break;
                    case 6:
                        mostrarFKTabla(conexion.getConectar());
                        break;
                    case 7:
                        mostrarProcedimientosAlmacenados(conexion.getConectar());
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

                            System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla + "\n");

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

                            System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla + "\n");

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

                            System.out.println("Tabla: " + nombreTabla + ", Catálogo: " + catalogoTabla + ", Esquema: " + esquemaTabla + ", Tipo: " + tipoTabla + "\n");

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
               try {

                DatabaseMetaData datos = conexion.getMetaData();

                System.out.println("\tElija una opción (1 - 3 / 0 para salir): \n\n");
                System.out.println("\t1. Mostrar datos tabla alumno.\n");
                System.out.println("\t2. Mostrar datos tabla curso.\n");
                System.out.println("\t3. Mostrar datos tabla matrícula.\n >");

                int num1 = entrada.nextInt();

                switch (num1) {
                    case 1:
                        ResultSet colsAlumno = datos.getTables(null, null, "alumno", null);
                        while (colsAlumno.next()) {
                            String nombreTabla = colsAlumno.getString("TABLE_NAME");
                            String nomColumna = colsAlumno.getString("COLUMN_NAME");
                            String tipoColumna = colsAlumno.getString("TYPE_NAME");
                            int tamColumna = colsAlumno.getInt("COLUMN_SIZE");
                            String esNulo = colsAlumno.getString("IS_NULLABLE");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Tipo: " + tipoColumna + ", Tamaño: " + tamColumna + ", Puede ser nulo: " + esNulo + "\n");

                        }
                        colsAlumno.close();
                        break;
                    case 2:
                        ResultSet colsCurso = datos.getTables(null, null, "curso", null);
                        while (colsCurso.next()) {
                            String nombreTabla = colsCurso.getString("TABLE_NAME");
                            String nomColumna = colsCurso.getString("COLUMN_NAME");
                            String tipoColumna = colsCurso.getString("TYPE_NAME");
                            int tamColumna = colsCurso.getInt("COLUMN_SIZE");
                            String esNulo = colsCurso.getString("IS_NULLABLE");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Tipo: " + tipoColumna + ", Tamaño: " + tamColumna + ", Puede ser nulo: " + esNulo + "\n");

                        }
                        colsCurso.close();
                        break;
                    case 3:
                        ResultSet colsMatricula = datos.getTables(null, null, "matricula", null);
                        while (colsMatricula.next()) {
                            String nombreTabla = colsMatricula.getString("TABLE_NAME");
                            String nomColumna = colsMatricula.getString("COLUMN_NAME");
                            String tipoColumna = colsMatricula.getString("TYPE_NAME");
                            int tamColumna = colsMatricula.getInt("COLUMN_SIZE");
                            String esNulo = colsMatricula.getString("IS_NULLABLE");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Tipo: " + tipoColumna + ", Tamaño: " + tamColumna + ", Puede ser nulo: " + esNulo + "\n");

                        }
                        colsMatricula.close();
                        break;
                }


            } catch (SQLException e) {
                System.out.println("\nHA HABIDO UN ERROR EN LA CONEXIÓN.\n");
            }
        }

    }

    private static void mostrarPKTabla(Connection conexion) {

        if (conexion != null) {
            try {

                DatabaseMetaData datos = conexion.getMetaData();

                System.out.println("\tElija una opción (1 - 3 / 0 para salir): \n\n");
                System.out.println("\t1. Mostrar PK tabla alumno.\n");
                System.out.println("\t2. Mostrar PK tabla curso.\n");
                System.out.println("\t3. Mostrar PK tabla matrícula.\n >");

                int num1 = entrada.nextInt();

                switch (num1) {
                    case 1:
                        ResultSet pkAlumno = datos.getPrimaryKeys(null, null, "alumno");
                        while (pkAlumno.next()) {
                            String nombreTabla = pkAlumno.getString("TABLE_NAME");
                            String nomColumna = pkAlumno.getString("COLUMN_NAME");
                            String pkColumna = pkAlumno.getString("PK_NAME");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Primary Key: " + pkColumna + "\n");

                        }
                        pkAlumno.close();
                        break;
                    case 2:
                        ResultSet pkCurso = datos.getPrimaryKeys(null, null, "alumno");
                        while (pkCurso.next()) {
                            String nombreTabla = pkCurso.getString("TABLE_NAME");
                            String nomColumna = pkCurso.getString("COLUMN_NAME");
                            String pkColumna = pkCurso.getString("PK_NAME");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Primary Key: " + pkColumna + "\n");

                        }
                        pkCurso.close();
                        break;
                    case 3:
                        ResultSet pkMatricula = datos.getPrimaryKeys(null, null, "alumno");
                        while (pkMatricula.next()) {
                            String nombreTabla = pkMatricula.getString("TABLE_NAME");
                            String nomColumna = pkMatricula.getString("COLUMN_NAME");
                            String pkColumna = pkMatricula.getString("PK_NAME");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Primary Key: " + pkColumna + "\n");

                        }
                        pkMatricula.close();
                        break;
                }


            } catch (SQLException e) {
                System.out.println("\nHA HABIDO UN ERROR EN LA CONEXIÓN.\n");
            }
        }

    }

    private static void mostrarFKTabla(Connection conexion) {

        if (conexion != null) {
            try {

                DatabaseMetaData datos = conexion.getMetaData();

                System.out.println("\tElija una opción (1 - 3 / 0 para salir): \n\n");
                System.out.println("\t1. Mostrar FK asociadas tabla alumno.\n");
                System.out.println("\t2. Mostrar FK asociadas tabla curso.\n");
                System.out.println("\t3. Mostrar FK asociadas tabla matrícula.\n >");

                int num1 = entrada.nextInt();

                switch (num1) {
                    case 1:
                        ResultSet pkAlumno = datos.getPrimaryKeys(null, null, "alumno");
                        while (pkAlumno.next()) {
                            String nombreTabla = pkAlumno.getString("PKTABLE_NAME");
                            String nomColumna = pkAlumno.getString("PKCOLUMN_NAME");
                            String fkTabla = pkAlumno.getString("FKTABLE_NAME");
                            String fkColumna = pkAlumno.getString("FKCOLUMN_NAME");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Tabla con FK: " + fkTabla + ", Columna con FK: " + fkColumna + "\n");

                        }
                        pkAlumno.close();
                        break;
                    case 2:
                        ResultSet pkCurso = datos.getPrimaryKeys(null, null, "alumno");
                        while (pkCurso.next()) {
                            String nombreTabla = pkCurso.getString("PKTABLE_NAME");
                            String nomColumna = pkCurso.getString("PKCOLUMN_NAME");
                            String fkTabla = pkCurso.getString("FKTABLE_NAME");
                            String fkColumna = pkCurso.getString("FKCOLUMN_NAME");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Tabla con FK: " + fkTabla + ", Columna con FK: " + fkColumna + "\n");

                        }
                        pkCurso.close();
                        break;
                    case 3:
                        ResultSet pkMatricula = datos.getPrimaryKeys(null, null, "alumno");
                        while (pkMatricula.next()) {
                            String nombreTabla = pkMatricula.getString("PKTABLE_NAME");
                            String nomColumna = pkMatricula.getString("PKCOLUMN_NAME");
                            String fkTabla = pkMatricula.getString("FKTABLE_NAME");
                            String fkColumna = pkMatricula.getString("FKCOLUMN_NAME");

                            System.out.println("Tabla: " + nombreTabla + ", Columna: " + nomColumna + ", Tabla con FK: " + fkTabla + ", Columna con FK: " + fkColumna + "\n");

                        }
                        pkMatricula.close();
                        break;
                }


            } catch (SQLException e) {
                System.out.println("\nHA HABIDO UN ERROR EN LA CONEXIÓN.\n");
            }
        }

    }

    private static void mostrarProcedimientosAlmacenados(Connection conexion) {

        if (conexion != null) {
            try{
                DatabaseMetaData datos = conexion.getMetaData();
                ResultSet procedimientos = datos.getProcedures(null, null, null);
                
                while(procedimientos.next()){
                    String nombreProcedimiento = procedimientos.getString("PROCEDURE_NAME");
                    
                    System.out.println("Procedimiento: " + nombreProcedimiento + "\n");
                }
            
            } catch (SQLException e) {
                System.out.println("\nHA HABIDO UN ERROR EN LA CONEXIÓN.\n");
            }
        }

    }

}
