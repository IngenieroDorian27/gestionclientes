/*
 * 
 */
package Control;

import database.conexion;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 */
public class AdmCliente {

    private static AdmCliente adm;

    private AdmCliente() {
    }

    public static AdmCliente getAdm() {
        if (adm == null) {
            adm = new AdmCliente();
        }
        return adm;
    }

    public void ingresar(java.sql.Date fecharegistro, String nombre, String cedula, String email, String direccion, String pago) {

        String sql = "INSERT INTO gestion_clientes (fecha_registro, nombre_cliente, cedula_cliente, email_cliente, direccion_cliente, tipo_pago) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, fecharegistro);
            stmt.setString(2, nombre);
            stmt.setString(3, cedula);
            stmt.setString(4, email);
            stmt.setString(5, direccion);
            stmt.setString(6, pago);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro correcto");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de registro: " + e.getMessage());
        }

    }

    public void editar(int idCliente, java.sql.Date fecharegistro, String nombre, String cedula, String email, String direccion, String pago) {

        String sql = "UPDATE gestion_clientes SET fecha_registro = ?, nombre_cliente = ?, cedula_cliente = ?, email_cliente = ?, direccion_cliente = ?, tipo_pago = ? WHERE id_cliente = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, fecharegistro);
            stmt.setString(2, nombre);
            stmt.setString(3, cedula);
            stmt.setString(4, email);
            stmt.setString(5, direccion);
            stmt.setString(6, pago);
            stmt.setInt(7, idCliente);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacion correcta");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de actualizacion: " + e.getMessage());
        }

}

public void llenarTabla(JTable tblCliente, JLabel lblTotal) {
        String sql = "SELECT * FROM gestion_clientes";
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        try (Connection conn = conexion.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            int fila = 0;
            while (rs.next()) {
                modelo.addRow(new Object[1]);
                tblCliente.setValueAt(rs.getInt("id_cliente"), fila, 0);
                tblCliente.setValueAt(rs.getDate("fecha_registro").toLocalDate(), fila, 1);
                tblCliente.setValueAt(rs.getString("nombre_cliente"), fila, 2);
                tblCliente.setValueAt(rs.getString("cedula_cliente"), fila, 3);
                tblCliente.setValueAt(rs.getString("email_cliente"), fila, 4);
                tblCliente.setValueAt(rs.getString("direccion_cliente"), fila, 5);
                tblCliente.setValueAt(rs.getString("tipo_pago"), fila, 6);
                fila++;
            }
            lblTotal.setText(fila + "");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar datos");
        }
    }

    public void filtrarNombre(String nombre, JTable tblCliente, JLabel lblTotal) {

        String sql = "SELECT * FROM gestion_clientes WHERE nombre_cliente = ?";
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                int fila = 0;
                while (rs.next()) {
                    modelo.addRow(new Object[1]);
                    tblCliente.setValueAt(rs.getInt("id_cliente"), fila, 0);
                    tblCliente.setValueAt(rs.getDate("fecha_registro").toLocalDate(), fila, 1);
                    tblCliente.setValueAt(rs.getString("nombre_cliente"), fila, 2);
                    tblCliente.setValueAt(rs.getString("cedula_cliente"), fila, 3);
                    tblCliente.setValueAt(rs.getString("email_cliente"), fila, 4);
                    tblCliente.setValueAt(rs.getString("direccion_cliente"), fila, 5);
                    tblCliente.setValueAt(rs.getString("tipo_pago"), fila, 6);
                    fila++;
                }
                lblTotal.setText(fila + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error nombre");
        }
    }

    public void filtroFecha(Date fecha, JTable tblCliente, JLabel lblTotal) {
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        String sql = "SELECT * FROM gestion_clientes WHERE fecha_registro = ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, fecha);
            try (ResultSet rs = stmt.executeQuery()) {
                int fila = 0;
                while (rs.next()) {
                    modelo.addRow(new Object[1]);
                    tblCliente.setValueAt(rs.getInt("id_cliente"), fila, 0);
                    tblCliente.setValueAt(rs.getDate("fecha_registro").toLocalDate(), fila, 1);
                    tblCliente.setValueAt(rs.getString("nombre_cliente"), fila, 2);
                    tblCliente.setValueAt(rs.getString("cedula_cliente"), fila, 3);
                    tblCliente.setValueAt(rs.getString("email_cliente"), fila, 4);
                    tblCliente.setValueAt(rs.getString("direccion_cliente"), fila, 5);
                    tblCliente.setValueAt(rs.getString("tipo_pago"), fila, 6);
                    fila++;
                }
                lblTotal.setText(fila + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    public void filtrarCedula(String cedula, JTable tblCliente, JLabel lblTotal) {

        String sql = "SELECT * FROM gestion_clientes WHERE cedula_cliente = ?";
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cedula);
            try (ResultSet rs = stmt.executeQuery()) {
                int fila = 0;
                while (rs.next()) {
                    modelo.addRow(new Object[1]);
                    tblCliente.setValueAt(rs.getInt("id_cliente"), fila, 0);
                    tblCliente.setValueAt(rs.getDate("fecha_registro").toLocalDate(), fila, 1);
                    tblCliente.setValueAt(rs.getString("nombre_cliente"), fila, 2);
                    tblCliente.setValueAt(rs.getString("cedula_cliente"), fila, 3);
                    tblCliente.setValueAt(rs.getString("email_cliente"), fila, 4);
                    tblCliente.setValueAt(rs.getString("direccion_cliente"), fila, 5);
                    tblCliente.setValueAt(rs.getString("tipo_pago"), fila, 6);
                    fila++;
                }
                lblTotal.setText(fila + "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public void eliminar(JTable tblCliente, JLabel lblTotal) {
        int fila = tblCliente.getSelectedRow();
        if (fila >= 0) {
            int idCliente = (Integer) tblCliente.getValueAt(fila, 0);
            String sql = "DELETE FROM gestion_clientes WHERE id_cliente = ?";

            try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, idCliente);
                stmt.executeUpdate();
                ((DefaultTableModel) tblCliente.getModel()).removeRow(fila);
                lblTotal.setText(tblCliente.getRowCount() + "");
                JOptionPane.showMessageDialog(null, "Fila eliminada correctamente");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al eliminar fila");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado una fila para eliminar");
        }
    }

}
