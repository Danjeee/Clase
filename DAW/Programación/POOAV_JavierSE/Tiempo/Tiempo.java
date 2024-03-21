package Tiempo;
public class Tiempo {
    public int horas;
    public int minutos;
    public int segundos;

    public void mostrar() {
        String tiempo = "";
        tiempo += Integer.toString(this.horas);
        tiempo += "h ";
        tiempo += Integer.toString(this.minutos);
        tiempo += "m ";
        tiempo += Integer.toString(this.segundos);
        tiempo += "s";
        System.out.println(tiempo);
    }

    public void restar(int h, int m, int s) {
        this.segundos -= s;
        if (this.segundos - m < 0) {
            while (s > 0) {
                m -= this.segundos;
                this.segundos = 0;
                this.minutos--;
                this.segundos += 60;
            }
        }
        if (this.minutos - m < 0) {
            while (m > 0) {
                m -= this.minutos;
                this.minutos = 0;
                this.horas--;
                this.minutos += 60;
            }
        }
        this.horas -= h;
    }

    public void sumar(int h, int m, int s) {
        this.segundos += s;
        if (this.segundos >= 60) {
            this.segundos -= 60;
            this.minutos++;
        }
        this.minutos += m;
        if (this.minutos >= 60) {
            this.minutos -= 60;
            this.horas++;
        }
        this.horas += h;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public Tiempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
}
