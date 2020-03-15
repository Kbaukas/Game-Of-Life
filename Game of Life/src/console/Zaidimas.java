package console;

import gyvenimoGeimas.GyvybesLangelis;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Zaidimas extends javax.swing.JPanel {

    public static void main(String[] args) throws IOException, InterruptedException {
        int ilgis = 50;
        int aukstis = 100;
        int[][] masyvasPerduoti = generuojamZaidimoLanga(ilgis, aukstis);
        int[][] tarpinis = new int[aukstis][ilgis];
        List<List<GyvybesLangelis>> galutinis = kitasLangas(masyvasPerduoti);

        Zaidimas zaidimas = new Zaidimas();

        String test = "0x9632";
        Charset utf8Charset = Charset.forName("UTF-8");
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println(defaultCharset);
        // charset is windows-1252

//        String kvadratas = "\u25FC";
        String kvadratas = "\u25A9";

        int symbol = 0x9632;
        for (int i = 0; i < 10000; i++) {
            int k = 0;

            // galutinis = kitasLangas(masyvasPerduoti);
            for (List<GyvybesLangelis> glistas : galutinis
            ) {
                int m = 0;
//                System.out.print("|");
                for (GyvybesLangelis g : glistas
                ) {
                    //Thread.sleep(1);
                    if (g.getArGyvas() < 1)
                        System.out.print("   ");
                    else System.out.print(" " + kvadratas + " ");

                    tarpinis[k][m] = g.getArGyvas();
//                    System.out.print(" "+g.getArGyvas()+" ");
                    m++;
                }
//
                k++;
                System.out.println();
                System.out.print("\r                    \r");

            }
//            System.out.flush();
           // Thread.sleep(1);
            galutinis = kitasLangas(tarpinis);
//            masyvasPerduoti=tarpinis;
            k = 0;
            System.out.println();
        }


        for (int i = tarpinis.length - 1; i >= 0; i--) {
            for (int j = tarpinis[i].length - 1; j >= 0; j--) {
//                System.out.print(" "+tarpinis[i][j]+"");
            }
            //System.out.println();
        }
    }
//    generuojam pradini langa
    public static int[][] generuojamZaidimoLanga(int x, int y) {
        int[][] zaidimoLangeliai = new int[y][x];
        System.out.println();
        System.out.print("-------------------------------------------------------------");
        System.out.println();
        for (int i = 0; i < zaidimoLangeliai.length; i++) {
            System.out.print("|");
            for (int j = 0; j < zaidimoLangeliai[i].length; j++) {
                int pradinis = (int)(Math.random()*100);
                if(pradinis<10)
                zaidimoLangeliai[i][j]=pradinis;
                else zaidimoLangeliai[i][j]=0;
                System.out.print(" " + zaidimoLangeliai[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print("-------------------------------------------------------------");
        System.out.println();
        return zaidimoLangeliai;
    }

    public static List<List<GyvybesLangelis>> kitasLangas(int[][] buvesMasyvas) {
//        List<GyvybesLangelis> gyvybesLangelisList=new ArrayList<>();\
        GyvybesLangelis gyvybesLangelis = new GyvybesLangelis(0, 0, 0, 20);
        List<List<GyvybesLangelis>> gyvybesLangelisList = new ArrayList<List<GyvybesLangelis>>();
        int sum = 0;
        int argyvas = gyvybesLangelis.getArGyvas();
        int[][] tarpinis = buvesMasyvas.clone();

        for (int i = 0; i < buvesMasyvas.length - 1; i++) {
            gyvybesLangelisList.add(new ArrayList<GyvybesLangelis>());
            for (int j = 0; j < buvesMasyvas[i].length - 1; j++) {
                gyvybesLangelis = new GyvybesLangelis(0, 0, 0, 20);
                if (i > 0 && i < buvesMasyvas.length && j > 0 && j < buvesMasyvas[i].length) {
                    sum = buvesMasyvas[i + 1][j] + buvesMasyvas[i + 1][j - 1] + buvesMasyvas[i + 1][j + 1] + buvesMasyvas[i][j + 1] + buvesMasyvas[i][j - 1] + buvesMasyvas[i - 1][j - 1] + buvesMasyvas[i - 1][j] + buvesMasyvas[i - 1][j + 1];
                } else if (i == 0 && j != 0 && j < buvesMasyvas[i].length) {
                    sum = buvesMasyvas[i + 1][j] + buvesMasyvas[i + 1][j - 1] + buvesMasyvas[i + 1][j + 1] + buvesMasyvas[i][j + 1] + buvesMasyvas[i][j - 1];
                } else if (i == 0 && j == 0) {
                    sum = buvesMasyvas[i + 1][j] + buvesMasyvas[i][j + 1] + buvesMasyvas[i + 1][j + 1];
                } else if (i != 0 && i < buvesMasyvas.length && j == 0) {
                   // sum = buvesMasyvas[i + 1][j] + buvesMasyvas[i][j + 1] + buvesMasyvas[i + 1][j + 1] + buvesMasyvas[i - 1][j + 1] + buvesMasyvas[i - 1][j];
                    sum=2;
                } else if (i == buvesMasyvas.length && j != buvesMasyvas[i].length) {
                    sum = buvesMasyvas[i][j + 1] + buvesMasyvas[i][j - 1] + buvesMasyvas[i - 1][j - 1] + buvesMasyvas[i - 1][j] + buvesMasyvas[i - 1][j + 1];
//                    sum=2;
                } else if (i != buvesMasyvas.length && j == buvesMasyvas[i].length) {
                    sum = buvesMasyvas[i + 1][j] + buvesMasyvas[i + 1][j - 1] + buvesMasyvas[i][j - 1] + buvesMasyvas[i - 1][j - 1] + buvesMasyvas[i - 1][j];
                  //  sum=2;
                } else if (i == buvesMasyvas.length && j == buvesMasyvas[i].length) {
//                    sum = +buvesMasyvas[i][j - 1] + buvesMasyvas[i - 1][j - 1] + buvesMasyvas[i - 1][j];
                    sum=2;
                }
                if (sum == 2) {
                    argyvas=argyvas;
                } else if (sum == 3) {
                    argyvas = 1;
//                    gyvybesLangelisList.get(i).add(j)=1;
                } else if (sum < 2) argyvas = 0;
                else if (sum > 3) argyvas = 0;
                tarpinis[i][j] = argyvas;
                // System.out.println("argyvas "+argyvas);
                gyvybesLangelis.setArGyvas(argyvas);
                gyvybesLangelisList.get(i).add(gyvybesLangelis);
                //   System.out.println(gyvybesLangelis.getArGyvas());
            }
            //  System.out.println("tarpinis"+ Arrays.toString(tarpinis[i]));

        }
        return gyvybesLangelisList;
    }

   /* public void freimas() {
        JFrame f = new JFrame("Figuros");
        JTextField text = new JTextField();
        JButton button = new JButton("Mygtukas");

        f.getContentPane().add(new Zaidimas());
        add(button);
        add(button);
//         f.getContentPane().add(text);
        setLayout(new FlowLayout());
        f.setSize(1800, 1000);
        f.setLocation(0, 0);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }*/
}
