package gyvenimoGeimas;

public class PradiniaiDuomenys {



    public int pradiniaiXYdaugyba(int x,int y){
        if((x^y)%2==0) return 0;
        else return 1;

    }
    public int pradiniaiRandom() {
        int random = (int) (Math.random()*100);

            if (random <10) return 0;
            else return 1;

    }
}
