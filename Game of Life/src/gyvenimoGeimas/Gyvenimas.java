package gyvenimoGeimas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gyvenimas extends JFrame {


    private int x, y, plotis;
    List<List<GyvybesLangelis>> gyvybesList = new ArrayList<List<GyvybesLangelis>>();
    private int freimoIlgis;
    private int freimoPlotis;

    private Gyvenimas(String title) {

        setTitle(title);


        x = 0;
        y = 0;
        plotis = 10;
    }


    public Gyvenimas(String title, int plotis, int freimoIlgis, int freimoPlotis) throws HeadlessException {
        // super(title);

        this(title);
        this.plotis = plotis;
        this.freimoIlgis = freimoIlgis;
        this.freimoPlotis = freimoPlotis;
        setSize(freimoPlotis, freimoIlgis);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public int getFreimoIlgis() {
        return freimoIlgis;
    }

    public void setFreimoIlgis(int freimoIlgis) {
        this.freimoIlgis = freimoIlgis;
    }

    public int getFreimoPlotis() {
        return freimoPlotis;
    }


    public void setFreimoPlotis(int freimoPlotis) {
        this.freimoPlotis = freimoPlotis;
    }

    public int kaimynuTikrinimas(int i, int j, List<List<GyvybesLangelis>> gyvybesList) {
        int masyvoStulpeliuSkaicius = freimoIlgis / plotis;
        int masyvoEiluciuSkaicius = freimoPlotis / plotis;

        int sum = 0;

        if (j > 0 && i > 0) {

            if (gyvybesList.get(i - 1).get(j - 1).getArGyvas() == 1) sum++;
        }
        if (i > 0 && j < masyvoStulpeliuSkaicius - 1) {
            if (gyvybesList.get(i - 1).get(j + 1).getArGyvas() == 1) sum++;

        }
        if (i < masyvoEiluciuSkaicius - 1 && j > 0) {
            if (gyvybesList.get(i + 1).get(j - 1).getArGyvas() == 1) sum++;

        }
        if (i < masyvoEiluciuSkaicius - 1 && j < masyvoStulpeliuSkaicius - 1) {
            if (gyvybesList.get(i + 1).get(j + 1).getArGyvas() == 1) sum++;

        }
        if (j > 0) {

            if (gyvybesList.get(i).get(j - 1).getArGyvas() == 1) sum++;
        }
        if (j < masyvoStulpeliuSkaicius - 1) {
            if (gyvybesList.get(i).get(j + 1).getArGyvas() == 1) sum++;
        }
        if (i > 0) {

            if (gyvybesList.get(i - 1).get(j).getArGyvas() == 1) sum++;
        }
        if (i < masyvoEiluciuSkaicius - 1) {

            if (gyvybesList.get(i + 1).get(j).getArGyvas() == 1) sum++;
            // else System.out.println("blaaaaaaaaaaaaaaaaaaaaaaa");
        }

        return sum;
    }
//Piesimas
    public void paint(Graphics g) {
        int pradiniaLangeliai;
        PradiniaiDuomenys pradiniaiDuomenys = new PradiniaiDuomenys();
        int masyvoStulpeliuSkaicius = freimoIlgis / plotis;
        int masyvoEiluciuSkaicius = freimoPlotis / plotis;
        int pradinamLanguiCounter = 0;
        Color c = new Color(255, 10, 100);
        Gridas gridas = new Gridas(c, plotis);


        for (int i = 0; i < masyvoEiluciuSkaicius; i++) {

            gyvybesList.add(new ArrayList<GyvybesLangelis>());
            x = 0;

            for (int j = 0; j < masyvoStulpeliuSkaicius; j++) {
                gridas.GridoPiesimas(g, x, y, plotis);


//                Uzpildome grida pradiniais duomenimis pasirenkant kokia funkcja naudosime


              //  pradiniaLangeliai = pradiniaiDuomenys.pradiniaiXYdaugyba(x, y);
                pradiniaLangeliai = pradiniaiDuomenys.pradiniaiRandom();

                if (pradiniaLangeliai == 0) {
                    gridas.GridoUzpildymas(g, x, y, plotis, c);
                    System.out.println("pradiniai " + pradiniaLangeliai);
                    gyvybesList.get(i).add(new GyvybesLangelis(1, x, y, plotis));
                    pradinamLanguiCounter++;


                } else {
//                    gridas.GridoUzpildymas(g,x,y,plotis,Color.white);
                    gyvybesList.get(i).add(new GyvybesLangelis(0, x, y, plotis));
                }


//gera sachmatu lenta gaunasi :D
               /* if(j%2==0&&i%2!=0){
                    Color spalva=new Color(0);
                    gridas.GridoUzpildymas(g,x,y,plotis,spalva);
                }else if(j%2!=0&&i%2==0){
                    Color spalva=new Color(0);
                    gridas.GridoUzpildymas(g,x,y,plotis,spalva);
                }*/

                x += plotis;
            }
            y += plotis;

        }


        int t = 0;

        while (t < 10000) {

            int[][] reiksmesArgyvas = new int[masyvoEiluciuSkaicius][masyvoStulpeliuSkaicius];
//
            int sum = 0;
//          buvesMasyvas= isListoImasyva(gyvybesList);

//            sukam cikla per ilgi il ploti gyvybes 
            for (int i = 0; i < masyvoEiluciuSkaicius; i++) {

                for (int j = 0; j < masyvoStulpeliuSkaicius; j++) {
                    int argyvas = gyvybesList.get(i).get(j).getArGyvas();
                    reiksmesArgyvas[i][j] = argyvas;

                    sum = kaimynuTikrinimas(i, j, gyvybesList);

                    x = gyvybesList.get(i).get(j).getX();
                    y = gyvybesList.get(i).get(j).getY();

                    if (sum < 2) {
                        if (argyvas == 1) {
                            reiksmesArgyvas[i][j] = 0;
                            gridas.GridoTrynimas(g, x, y, plotis);
                            gridas.GridoPiesimas(g, x, y, plotis);


                        }
                    } else if (sum == 3) {
                        if (argyvas == 0) {
                            reiksmesArgyvas[i][j] = 1;
                            gridas.GridoUzpildymas(g, x, y, plotis, c);
                        }

                    } else if (sum > 3) {
                        if (argyvas == 1) {
                            reiksmesArgyvas[i][j] = 0;
                            gridas.GridoTrynimas(g, x, y, plotis);
                            gridas.GridoPiesimas(g, x, y, plotis);

                        }
                    } else {
                        reiksmesArgyvas[i][j] = argyvas;
                    }

//                    System.out.println("Argyvas "+gyvybesList.get(i).get(j).getArGyvas()+" x "+ "y "+ x+" "+y );

                }
                System.out.println();
                System.out.println("masyvas " + Arrays.toString(reiksmesArgyvas[i]));

            }
            for (int i = 0; i < reiksmesArgyvas.length; i++) {
                for (int j = 0; j < reiksmesArgyvas[i].length; j++) {
                    gyvybesList.get(i).get(j).setArGyvas(reiksmesArgyvas[i][j]);
                }
            }
            sleep();

            t++;

        }

    }

    public void sleep() {
        try {

            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println("");
        }
    }

}







