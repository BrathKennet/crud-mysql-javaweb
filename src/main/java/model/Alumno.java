package model;

public class Alumno {
    String id;
    String nombre;
    String apellido_P;
    String apellido_M;
    String direccion;
    String tel;
    String dni;
    String semestre;
    String codigo;

    public Alumno() {

    }

    public Alumno(String nombre, String apellido_P, String apellido_M, String direccion, String tel, String dni, String semestre, String codigo) {
        this.nombre = nombre;
        this.apellido_P = apellido_P;
        this.apellido_M = apellido_M;
        this.direccion = direccion;
        this.tel = tel;
        this.dni = dni;
        this.semestre = semestre;
        this.codigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_P() {
        return apellido_P;
    }

    public void setApellido_P(String apellido_P) {
        this.apellido_P = apellido_P;
    }

    public String getApellido_M() {
        return apellido_M;
    }

    public void setApellido_M(String apellido_M) {
        this.apellido_M = apellido_M;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String generateId() {
        long date = System.currentTimeMillis();
        String aleatorio = Long.toString(Math.round(Math.random() * 10000000000L), 36);
        return (Long.toString(date, 36) + aleatorio);
    }
}
