package gyvenimoGeimas;

import java.awt.*;

public class Gridas {
    private Color spalva;
    private int plotis;
    public Gridas(Color c, int plotis) {
        this.spalva=c;
        this.plotis=plotis;

    }
    public void GridoPiesimas(Graphics g, int x, int y, double plotis) {
       g.setColor(this.spalva);
        g.drawRect(x, y, (int) plotis, (int) plotis);

    }
    public void GridoUzpildymas(Graphics g, int x, int y, double plotis,Color c){
        g.setColor(c);
        g.fillRect(x, y, (int) plotis, (int) plotis);


    }
    public void GridoTrynimas(Graphics g, int x, int y, double plotis) {
        g.clearRect(x, y,(int) plotis,(int) plotis);
    }
}
