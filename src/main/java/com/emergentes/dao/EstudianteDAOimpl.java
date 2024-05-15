package com.emergentes.dao;

import com.emergentes.modelo.Estudiante;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAOimpl extends ConexionDB implements EstutianteDAO {

    @Override
    public void insert(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("insert into estudiantes(nombres, apellidos, seminario, confirmacion, fecha) \n"
                    + "	values(?, ?,?, ?, ?)");
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getSeminario());
            ps.setBoolean(4, estudiante.getConfirmacion());
            ps.setString(5, estudiante.getFecha());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Estudiante estudiante) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE estudiantes set nombres=?, apellidos=?, seminario=?, confirmacion=?,fecha=?  where id = ?");
            ps.setString(1, estudiante.getNombres());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getSeminario());
            ps.setBoolean(4, estudiante.getConfirmacion());
            ps.setString(5, estudiante.getFecha());
            ps.setInt(6, estudiante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM estudiantes WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();

        }
    }

    @Override
    public Estudiante getById(int id) throws Exception {
        Estudiante avi = new Estudiante();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes WHERE id = ? limit 1");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setId(rs.getInt("id"));
                avi.setNombres(rs.getString("nombres"));
                avi.setApellidos(rs.getString("apellidos"));
                avi.setSeminario(rs.getString("seminario"));
                avi.setConfirmacion(rs.getBoolean("confirmacion"));
                avi.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
            return avi;
        }
    }

    @Override
    public List<Estudiante> getAll() throws Exception {
        List<Estudiante> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM estudiantes");
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Estudiante>();
            while (rs.next()) {
                Estudiante avi = new Estudiante();
                avi.setId(rs.getInt("id"));
                avi.setNombres(rs.getString("nombres"));
                avi.setApellidos(rs.getString("apellidos"));
                avi.setSeminario(rs.getString("seminario"));
                avi.setConfirmacion(rs.getBoolean("confirmacion"));
                avi.setFecha(rs.getString("fecha"));
                lista.add(avi);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
}
