package modelos;



import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tarea {
    private LocalDate fecha;
    private int hora;
    private int min;
    private String textoTarea;
    private Boolean realizado;

    public Tarea(LocalDate fecha,int hora,int min, String textoTarea,Boolean realizado) {
        this.fecha = fecha;
        this.textoTarea = textoTarea;
        this.hora=hora;
        this.min=min;
        this.realizado=realizado;
    }

    protected LocalDate getFecha() {
        return fecha;
    }

    protected void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    protected int getHora() { return hora; }

    protected void setHora(int hora) { this.hora = hora; }

    protected int getMin() { return min; }

    protected void setMin(int min) { this.min = min; }

    protected String getTextoTarea() {
        return textoTarea;
    }

    protected void setTextoTarea(String textoTarea) {
        this.textoTarea = textoTarea;
    }

    protected Boolean getRealizado() {
        return realizado;
    }

    protected void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }}
