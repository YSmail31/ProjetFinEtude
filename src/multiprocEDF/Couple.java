package multiprocEDF;

class Couple {
    private long td,qt,tf;

    public Couple(long td) {
        this.td = td;
        tf=0;
        qt=0;
    }

    @Override
    public String toString() {
        return "Q([" + td + "," + tf + "[) = " + qt;
    }

    public long getTf() {
        return tf;
    }

    public void setTf(long tf) {
        this.tf = tf;
    }

    
    public void setTd(long td) {
        this.td = td;
    }

    public void setQt(long qt) {
        this.qt = qt;
    }

    public long getTd() {
        return td;
    }

    public long getQt() {
        return qt;
    }
    
}
