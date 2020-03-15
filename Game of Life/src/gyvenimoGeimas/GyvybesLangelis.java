package gyvenimoGeimas;

import java.awt.*;

public class GyvybesLangelis {
   private int arGyvas;
    private int x;
   private int y;
    private  int plotis;
//langelio constructor
    public GyvybesLangelis(int arGyvas, int x, int y, int plotis) {
        this.arGyvas = arGyvas;
        this.x = x;
        this.y = y;
        this.plotis = plotis;
    }


//    langelio piesimas
    public void piestiLangeli(Graphics g, int x, int y, int plotis,Color c) {
        g.setColor(c);
        g.drawRect(x, y, (int) plotis, (int) plotis);
//     g.setColor(Color.RED);
        g.fillRect(x, y, (int) plotis, (int) plotis);
//     g.drawPolygon(new int[]{0, 600, 400}, new int[]{0, 700, 600}, 3);
    }

    public int getArGyvas() {
        return arGyvas;
    }

    public void setArGyvas(int arGyvas) {
        this.arGyvas = arGyvas;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPlotis() {
        return plotis;
    }

    public void setPlotis(int plotis) {
        this.plotis = plotis;
    }
}
