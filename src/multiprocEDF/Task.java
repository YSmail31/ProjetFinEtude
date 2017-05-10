package multiprocEDF;


public class Task 
{

    static void initialise() {
        nbTask = 0;
    }
    protected long id;
    protected long c,d,t;
    private static int nbTask;
    @Override
    public String toString() {
		return "[Processus= P" + id + ", Temps d'exécution =" + c + ", Echéance =" + d + ", Période =" + t + ", Utilisation =" + (double)c/t + "]";
	}
    public Task(long c, long d, long t) {
        id = nbTask;
        nbTask++;
        this.c = c;
        this.d = d;
        this.t = t;
    }
    public Task(long id, String c, String d, String t) {
        this.id = id;
        this.c = Long.valueOf(c);
        this.d = Long.valueOf(d);
        this.t = Long.valueOf(t);
    }
    public Task(long id, long c, long d, long t) {
		this.id = id;
		this.c = c;
		this.d = d;
		this.t = t;
	}
    public long getId() {
		return id;
	}
    public long getC() {
		return c;
	}
    public long getD() {
		return d;
	}
    public long getT() {
		return t;
	}
    public double computeUtil(){
		return c/(double)t;
	}
    public double computeDensity(){
		return c/(double)d;
	}
    public void setId(long id) {
        this.id = id;
    }
    public void setC(long c) {
        this.c = c;
    }
    public void setD(long d) {
        this.d = d;
    }
    public void setT(long t) {
        this.t = t;
    }
}
