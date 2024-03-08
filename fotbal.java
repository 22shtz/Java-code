// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Random;
import java.util.Date;
class HelloWorld {
    public static void main(String[] args) {
        Joc j=new Joc("barca","real");
        j.simuleaza();
        System.out.println(j.toString());
    }
}
class Minge{
    private int x;
    private int y;
    private Random randomGenerator;
    public Minge(int x,int y){
        this.x=x;
	    this.y=y;
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
    }
     public int getX(){
	    return x;
    }
    public int getY(){
	    return y;
    }
    public int generateX(){
    	int a=randomGenerator.nextInt(101);
    	if(a<5){
    	    a=0;
    	}else if(a>95){
    	    a=100;
    	}else{
    	    a=randomGenerator.nextInt(99)+1;
    	}
    	return a;
    }
   public int generateY(){
    	int b=randomGenerator.nextInt(101);
    	if(b<5){
    	    b=0;
    	}else if(b>95){
    	    b=50;
    	}else{
    	    b=randomGenerator.nextInt(49)+1;
    	}
    	return b;
    }
    public void suteaza() throws Out,Gol,Corner{
        this.x=generateX();
        this.y=generateY();
        if(y==0 || y==50){
            throw new Out("out");
        }
        else if((x==0 || x==100) && y>=20 && y<=300){
            throw new Gol("gol");
        }
        else if(x==0 || x==100){
            throw new Corner("corner");
        }

    }

}
class Out extends Exception{
    public Out(String mesaj){
        super(mesaj);
    }
}
class Gol extends Exception{
    public Gol(String mesaj){
        super(mesaj);
    }
}
class Corner extends Exception{
    public Corner(String mesaj){
        super(mesaj);
    }
}
class Joc{
    private String e1;
    private String e2;
    public Joc(String e1, String e2){
        this.e1=e1;
        this.e2=e2;
    }
    private int out=0;
    private int gol_e1=0;
    private int gol_e2=0;
    private int corner=0;
    public void simuleaza(){
        Minge m=new Minge(25,50);
        int i;
        for(i=0;i<100;i++){
            try{
                m.suteaza();
            }catch(Out o){
                int x=m.getX();
                int y=m.getY();
                if(y==0)
                {
                    m=new Minge(x,y+1);
                }
                else m=new Minge(x,y-1);
                out++;
            }catch(Gol g){
                int x=m.getX();
                int y=m.getY();
                if(x==0){
                    gol_e1++;
                    m=new Minge(25,50);
                }else{
                    gol_e2++;
                    m=new Minge(25,50);
                }

            }
            catch(Corner c){
                int x=m.getX();
                int y=m.getY();
                if(x==0){
                    if(y<=20){
                        m=new Minge(1,1);
                    }
                    else m=new Minge(1,50);
                }else{
                    if(y<=20){
                        m=new Minge(100,1);
                    }
                    else m=new Minge(100,100);
                }
                corner++;
            }
        }
    }
    public String toString(){
        return e1+" "+e2+" "+ out+" "+gol_e1+" "+gol_e2+" "+corner;
    }

}




