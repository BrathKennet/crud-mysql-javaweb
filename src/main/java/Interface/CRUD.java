package Interface;

import model.Alumno;

import java.util.List;

public interface CRUD {
    public List listar();
    public Alumno list(String id);

    public boolean add(Alumno al);
    public boolean edit(Alumno al, String id);
    public boolean delete(String id);
}
