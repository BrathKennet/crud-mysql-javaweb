package modeldao;

import Interface.CRUD;
import config.Connect;
import model.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlumnoDAO implements CRUD {

    Connect cn = new Connect();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Alumno a = new Alumno();


    @Override
    public List listar() {
        ArrayList<Alumno> list = new ArrayList<>();
        String sql = "select * from alumnos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alumno al = new Alumno();
                al.setId(rs.getString("id_Alumno"));
                al.setNombre(rs.getString("nombre_Alumno"));
                al.setApellido_P(rs.getString("apellido_P_Alumno"));
                al.setApellido_M(rs.getString("apellido_M_Alumno"));
                al.setDireccion(rs.getString("direccion_Alumno"));
                al.setTel(rs.getString("tel_Alumno"));
                al.setDni(rs.getString("dni_Alumno"));
                al.setSemestre(rs.getString("semestre_Alumno"));
                al.setCodigo(rs.getString("codigo_Alumno"));
                list.add(al);
            }
            list.sort(Comparator.comparing(Alumno::getApellido_P));
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public Alumno list(String id) {
        String sql = "select * from alumnos where id_Alumno='"+id+"'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                a.setId(rs.getString("id_Alumno"));
                a.setNombre(rs.getString("nombre_Alumno"));
                a.setApellido_P(rs.getString("apellido_P_Alumno"));
                a.setApellido_M(rs.getString("apellido_M_Alumno"));
                a.setDireccion(rs.getString("direccion_Alumno"));
                a.setTel(rs.getString("tel_Alumno"));
                a.setDni(rs.getString("dni_Alumno"));
                a.setSemestre(rs.getString("semestre_Alumno"));
                a.setCodigo(rs.getString("codigo_Alumno"));
            }
        } catch (Exception e) {

        }
        return a;
    }

    @Override
    public boolean add(Alumno al) {
        String sql = "insert into alumnos(id_Alumno,nombre_Alumno,apellido_P_Alumno,apellido_M_Alumno,direccion_Alumno,tel_Alumno,dni_Alumno,semestre_Alumno,codigo_Alumno) VALUES ('" + al.getId() + "','"+ al.getNombre()+"','"+al.getApellido_P()+"','"+al.getApellido_M()+"','"+al.getDireccion()+"','"+al.getTel()+"','"+al.getDni()+"','"+al.getSemestre()+"','"+al.getCodigo()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean edit(Alumno al, String id) {
        String sql = "update alumnos set codigo_Alumno='" + al.getCodigo() + "',nombre_Alumno='"+ al.getNombre()+"',apellido_P_Alumno='"+al.getApellido_P()+"',apellido_M_Alumno='"+al.getApellido_M()+"',direccion_Alumno='"+al.getDireccion()+"',tel_Alumno='"+al.getTel()+"',dni_Alumno='"+al.getDni()+"',semestre_Alumno='"+al.getSemestre()+"' where id_Alumno='"+id+"'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from alumnos where id_Alumno='"+id+"'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }
}
