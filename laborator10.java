// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        Angajat a1=new AngajatCuSalarFix("ana",1001);
        Angajat a2=new AngajatCuSalarFix("dariu",4000);
        Angajat b1=new AngajatCuOra("mara",20000);
        Angajat b2=new AngajatCuOra("mada",10000);
        ((AngajatCuOra)b1).adaugaOre(3.0);
        ((AngajatCuOra)b2).adaugaOre(2.0);
        Firma f=new Firma();
        System.out.println(f.angajeaza(a1));
        System.out.println(f.angajeaza(b1));
        System.out.println(f.angajeaza(a2));
        System.out.println(f.angajeaza(b2));
        System.out.println(f.salarMediu());
        System.out.println(f.angajeaza(a1));
        ((AngajatCuSalarFix)a1).schimbaSalarFix(1.0);
        System.out.println(f.salarMediu());
        
    }
}
abstract class Angajat{
    protected String nume;
    public abstract double calculSalar();
    public boolean equals(Object o){
        if(o instanceof Angajat){
            Angajat y=(Angajat)o;
            return nume==y.nume;
        }
        return false;
    }
}
class AngajatCuSalarFix extends Angajat{
    private double salarfix;
    public AngajatCuSalarFix(String nume,double salarfix){
        this.nume=nume;
        this.salarfix=salarfix;
    }
    public double calculSalar(){
        return this.salarfix;
    }
    public void schimbaSalarFix(double salar){
        this.salarfix=salar;
    }
}
class AngajatCuOra extends Angajat{
    private double salarora;
    private double[] ore;
    private int cnt=0;
    public AngajatCuOra(String nume,double salarora){
        this.nume=nume;
        this.salarora=salarora;
        ore=new double[31];
    }
    public void adaugaOre(double ora){
        if(cnt<31){
            ore[cnt]=ora;
            cnt++;
        }
        else System.out.println("nu se mai pot adauga ore");
    }
    public double calculSalar(){
        double sum=0;
        int i;
        if(cnt==0){
            return this.salarora;
        }
        else {
            for(i=0;i<cnt;i++){
                sum=sum+ore[i];
            }
            return this.salarora*sum;
        }
    }
    public void schimbaSalarPeOra(double salar){
        this.salarora=salar;
    }
    
    
}
class Firma{
    private Angajat[] angajati;
    private int cnt=0;
    public Firma(){
        angajati=new Angajat[1024];
    }
    public int angajeaza(Angajat a){
        if(cnt<1024){
            int i;
            for(i=0;i<cnt;i++){
                if(a.equals(angajati[i])){
                    return -2;
                }
            }
            angajati[cnt]=a;
            cnt++;
            
            
        }
        else return -1;
        return 0;
        
    }
    public double salarMediu(){
        double sum=0;
        int i;
        if(cnt==0){
            return 0;
        }
        else {
            for(i=0;i<cnt;i++){
                sum=sum+angajati[i].calculSalar();
            }
            return sum/cnt;
        }
    }
}


