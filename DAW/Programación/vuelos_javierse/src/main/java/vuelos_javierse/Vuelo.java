package vuelos_javierse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vuelo {
    private String num;
    private String dest;
    private LocalDateTime fec;
    private String dur;
    public static int numVuelos = 0;
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getDest() {
        return dest;
    }
    public void setDest(String dest) {
        this.dest = dest;
    }
    public String getFec() {
        return fec.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    public void setFec(LocalDateTime fec) {
        this.fec = fec;
    }
    public Vuelo(String num, String dest, LocalDateTime fec, String dur) {
        this.num = num;
        this.dest = dest;
        this.fec = fec;
        this.dur = dur;
        Vuelo.numVuelos++;
    }
    public String getDur() {
        return dur;
    }
    public void setDur(String dur) {
        this.dur = dur;
    }
    public static int getNumVuelos() {
        return numVuelos;
    }
    public static void setNumVuelos(int numVuelos) {
        Vuelo.numVuelos = numVuelos;
    }
}
