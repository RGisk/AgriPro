/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import static categorias.VentanaFrutas.modelo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jquesadaabeijon
 */
public class Metodos {

    static Connection con = null;
    static Statement s = null;
    public static String db = "base.db";
    public static String url = "jdbc:sqlite:" + db;

    public static Connection conectar() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("El driver es " + meta.getDriverName());
            System.out.println("Estás conectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void crearClientes() {

        String sql = "CREATE TABLE IF NOT EXISTS clientes (\n"
                + "	usuario text PRIMARY KEY,\n"
                + "     contraseña text NOT NULL,\n"
                + "	nombre text NOT NULL,\n"
                + "	apellido text NOT NULL,\n"
                + "     direccion text NOT NULL,\n"
                + "     telefono text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearEmpresas() {
        String sql = "CREATE TABLE IF NOT EXISTS empresas (\n"
                + "	usuario text PRIMARY KEY,\n"
                + "     contraseña text NOT NULL,\n"
                + "	empresa text NOT NULL,\n"
                + "	cif text NOT NULL,\n"
                + "     direccion text NOT NULL,\n"
                + "     telefono text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void crearProductos() {
        String sql = "CREATE TABLE IF NOT EXISTS productos (\n"
                + "	id integer PRIMARY KEY,\n"
                + "     categoria text NOT NULL,\n"
                + "	empresa text NOT NULL,\n"
                + "	producto text NOT NULL,\n"
                + "     cantidad text NOT NULL,\n"
                + "     precio text NOT NULL,\n"
                + "     preciokilo text NOT NULL\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tablaFrutas() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='frutas'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modelo.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
