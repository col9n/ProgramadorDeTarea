package modelos;




import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Reloj extends Label {
    private Evento evento;

    private String pattern="HH:mm:ss";
    private Boolean formato24H=true;

    private ArrayList<Tarea> listaTarea=new ArrayList<Tarea>();

    static final String patro_formato24 = "HH:mm:ss";
    static final String patro_formato12 = "hh:mm:ss";

    public Reloj(Boolean formato24H) {
        setFormato24H(formato24H);

    }

    public Reloj() {


    }

    public Boolean getFormato24H() {
        return formato24H;
    }

    public void setFormato24H(Boolean formato24H) {
        if(formato24H)
        {
            this.pattern = patro_formato24;
        }
        else
            this.pattern = patro_formato12;
        this.formato24H=formato24H;
    }

    private void actualizarHora() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());


        setText(date);

    }

    public void startSec() {
        Timer timer = new Timer();


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        actualizarHora();
                       comprobar();


                    }
                });
            }
        }, 1000, 1000);
    }

    private void comprobar() {
        Tarea tareaAdevolver=null;
        LocalDate today = LocalDate.now();
       Date time= new Date();
        int hour = time.getHours();
        int min = time.getMinutes();

        for(Tarea tarea : listaTarea)
        {
            if(tarea.getRealizado()!=true) {
                if (tarea.getFecha().equals(today)) {
                    if (tarea.getHora() == hour) {
                        if (tarea.getMin() == min) {
                            tareaAdevolver = tarea;
                            tarea.setRealizado(true);
                            borrarTarea(tarea);
                            evento.inicioTarea(tareaAdevolver);
                        }
                    }
                }
            }

        }

    }

    public void registrarTarea(Tarea tarea){
        listaTarea.add(tarea);
    }
    public void borrarTarea(Tarea tarea){
        listaTarea.remove(tarea);
    }

    public void addEvento(Evento evento) {
        this.evento = evento;
    }


}
