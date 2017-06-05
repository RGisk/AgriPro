/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import static categorias.VentanaAceites.modeloAce;
import static categorias.VentanaBebidas.modeloBeb;
import static categorias.VentanaCarne.modeloCar;
import static categorias.VentanaCereales.modeloCer;
import static login.Registro_Productos.modeloReg;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static categorias.VentanaFrutas.modeloFrut;
import static categorias.VentanaLacteos.modeloLac;
import static categorias.VentanaPan.modeloPan;
import static categorias.VentanaVerduras.modeloVerd;

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

    public void tablaMod() {
        String sql = "SELECT id, categoria, empresa, producto, cantidad, precio, preciokilo FROM productos";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloReg.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"), rs.getString("empresa"), rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tablaFrutas() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Frutas'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloFrut.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void tablaVerduras() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Verduras'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloVerd.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tablaCereales() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Cereales'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloCer.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void tablaCarnes() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Carnes'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloCar.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tablaPan() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Pan'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloPan.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tablaLacteos() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Lacteos'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloLac.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tablaAceites() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Aceites'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloAce.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tablaBebidas() {
        String sql = "SELECT producto,cantidad,precio,preciokilo FROM productos WHERE categoria='Bebidas'";

        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                modeloBeb.addRow(new Object[]{rs.getString("producto"), rs.getString("cantidad"), rs.getString("precio"), rs.getString("preciokilo")});
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
