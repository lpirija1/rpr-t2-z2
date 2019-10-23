package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetak;
    private double kraj;
    private boolean pripada1;
    private boolean pripada2;

    public Interval(double pocetak, double kraj, boolean pripada1, boolean pripada2){
        if(pocetak>kraj) throw new IllegalArgumentException();
        this.pocetak=pocetak;
        this.kraj=kraj;
        this.pripada1=pripada1;
        this.pripada2=pripada2;
    }

    public Interval(){
        this.pocetak=0;
        this.kraj=0;
        this.pripada1=false;
        this.pripada2=false;
    }

    public double getPocetak() {
        return pocetak;
    }

    public void setPocetak(double pocetak) {
        this.pocetak = pocetak;
    }

    public double getKraj() {
        return kraj;
    }

    public void setKraj(double kraj) {
        this.kraj = kraj;
    }

    public boolean getPripada2() {
        return pripada2;
    }

    public void setPripada2(boolean pripada2) {
        this.pripada2 = pripada2;
    }

    public boolean getPripada1() {
        return pripada1;
    }

    public void setPripada1(boolean pripada1) {
        this.pripada1 = pripada1;
    }

    public boolean isNull(){
        if(Double.compare(pocetak, 0.)!=0 || Double.compare(kraj, 0.)!=0) return false;
        return true;
    }


    public boolean isIn(double v) {
        if(v>pocetak && v<kraj) return true;
        if((Double.compare(v,pocetak)==0 && pripada1==true) || (Double.compare(v,kraj)==0 && pripada2==true)) return true;
        return false;
    }

    public Interval intersect(Interval interval) {
        Interval i=new Interval();
        if(this.pocetak>interval.pocetak && this.pocetak<interval.kraj) {
            i.setPocetak(this.pocetak);
            if(this.pripada1==true) i.setPripada1(true);
        }
        else if(interval.pocetak>this.pocetak && interval.pocetak<this.kraj) {
            i.setPocetak(interval.pocetak);
            if(interval.pripada1==true) i.setPripada1(true);
        }
        if(this.kraj<interval.kraj && this.kraj>i.pocetak) {
            i.setKraj(this.kraj);
            if(this.pripada2==true) i.setPripada2(true);
        }
        else if(interval.kraj<this.kraj && interval.kraj>i.pocetak) {
            i.setKraj(interval.kraj);
            if(interval.pripada2==true) i.setPripada2(true);
        }
return i;
    }

    public static Interval intersect(Interval i, Interval i2) {
        Interval vrati=new Interval();
        if(i.pocetak>i2.pocetak && i.pocetak<i2.kraj) {
            vrati.setPocetak(i.pocetak);
            if(i.pripada1==true) vrati.setPripada1(true);
        }
        else if(i2.pocetak>i.pocetak && i2.pocetak<i.kraj) {
            vrati.setPocetak(i2.pocetak);
            if(i2.pripada1==true) vrati.setPripada1(true);
        }
        if(i.kraj<i2.kraj && i.kraj>vrati.pocetak) {
            vrati.setKraj(i.kraj);
            if(i.pripada2==true) vrati.setPripada2(true);
        }
        else if(i2.kraj<i.kraj && i2.kraj>vrati.pocetak) {
            vrati.setKraj(i2.kraj);
            if(i2.pripada2==true) vrati.setPripada2(true);
        }
        return vrati;
    }


    @Override
    public String toString() {
        if(this.isNull()==true) return "()";
        if(pripada1==true && pripada2==true) return "["+pocetak+","+kraj+"]";
        if(pripada1==true && pripada2==false) return "["+pocetak+","+kraj+")";
        if(pripada1==false && pripada2==true) return "("+pocetak+","+kraj+"]";
        if(pripada1==false && pripada2==false) return "("+pocetak+","+kraj+")";
        return " ";
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Interval)) return false;
        Interval i=(Interval) o;
        return (Double.compare(pocetak, i.pocetak)==0 && Double.compare(kraj, i.kraj)==0 && pripada1==i.pripada1 && pripada2==i.pripada2);
    }
}
