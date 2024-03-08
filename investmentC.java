 class InvestmentCompany {
    private Project[] proiecte=new Project[10];
    private int cnt=0;
    void addProject(Project p){
        if(cnt==proiecte.length){
            int i;
            Project[] tmp=new Project[proiecte.length*2];
            for(i=0;i<cnt;i++){
                tmp[i]=proiecte[i];
            }
            proiecte=tmp;
            proiecte[cnt++]=p;
        }
        else{
            proiecte[cnt++]=p;
        }
    }
    public Project getBestInvestment(){
       
        int i;
        int minim=0;
        for(i=0;i<cnt;i++){
            if(proiecte[minim].getRisk()>proiecte[i].getRisk()){
                minim=i;
            }
        }
        return proiecte[minim];
    }
    
    public static void main(String[] args){
	Membru m= new Membru(20,"Ana");
	Comerciale c=new Comerciale("a","a",4,"cc",3);
	c.addMembru(m);
	Membru m1= new Membru(20,"anita");
	c.addMembru(m1);
	System.out.println(c.toString());
	System.out.println(c.getRisk());
	Militare mil=new Militare("ceva","atac",8,"maine","123");
	Membru memb=new Membru(20,"Dariu");
	mil.addMembru(memb);
	System.out.println(mil.toString());
	System.out.println(mil.getRisk());
	InvestmentCompany a=new InvestmentCompany();
	a.addProject(c);
	a.addProject(mil);
	System.out.println(a.getBestInvestment());
	
	
	

    }
    
}
class Membru{
    private int varsta;
    private String nume;
    public Membru(int varsta, String nume){
	this.varsta=varsta;
	this.nume=nume;
    }
    public String getNume(){
        return this.nume;
    }
}
abstract class Project implements IRisky{
    private Membru[] membrii;
    private String titlu;
    private String obiectiv;
    protected long fonduri;
    protected int count=0;
    public Project(String titlu, String obiectiv, long fonduri){
	this.titlu=titlu;
	this.obiectiv=obiectiv;
	this.fonduri=fonduri;
	membrii=new Membru[10];
    }
    public void addMembru(Membru m){
	if(count==membrii.length){
	    Membru[] tmp=new Membru[membrii.length*2];
	    for(int i=0;i<count;i++){
		tmp[i]=membrii[i];
	    }
	    membrii=tmp;
	    membrii[count++]=m;
	}
	else{
	    membrii[count]=m;
	    count++;
	}

    }
    public String toString(){
        int i;
        String b="proiect:"+titlu+" ";
        for(i=0;i<count;i++)
        {
            b=b+membrii[i].getNume()+" ";
        }
        return b;
    }
   
}
interface IRisky{
    public double getRisk();
 
}
class Comerciale extends Project implements IRisky{
    private String deadline;
    private int max_membrii=15;
    private long fonduri_marketing;
    private int nr_echipe;
    public Comerciale(String titlu, String obiectiv, long fonduri,String deadline,int nr_echipe){
	super(titlu,obiectiv,fonduri);
	this.deadline=deadline;
	this.fonduri_marketing=fonduri/2;
	this.nr_echipe=nr_echipe;
	

    }
    public void addMembru(Membru m){
	if(super.count<15){
	    super.addMembru(m);
	}
    }
    public double getRisk(){
	return (double)(nr_echipe*3)/super.count/fonduri_marketing;
    }

}
class Militare extends Project implements IRisky{
     private String deadline;
     private int max_membrii=15;
     private String parola;
     public Militare(String titlu, String obiectiv, long fonduri,String deadline, String parola){
         super(titlu,obiectiv,fonduri);
         this.deadline=deadline;
         this.parola=parola;
     }
    public void addMembru(Membru m){
	if(super.count<15){
	    super.addMembru(m);
	}
    }
     public double getRisk(){
         return (double)super.count/parola.length()/fonduri;
     }
}



