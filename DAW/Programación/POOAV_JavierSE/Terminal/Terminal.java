package Terminal;

public class Terminal {
    public String num;
    public int t = 0;
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public int getT() {
        return t;
    }
    public void setT(int t) {
        this.t = t;
    }
    public Terminal(String num) {
        this.num = num;
    }
    public void llama(Terminal t2, int ti){
        t2.t += ti;
        this.t += ti;
    }
    public void print(){
        System.out.println("Nº " +this.num + " - " +t +"s de conversacion");
    }

}
