package Application;

public class film
{

    private int fid;
    private String fname;
    private int fyear;
    private String flang;
    private int frating;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getFyear() {
        return fyear;
    }

    public void setFyear(int fyear) {
        this.fyear = fyear;
    }

    public String getFlang() {
        return flang;
    }

    public void setFlang(String flang) {
        this.flang = flang;
    }

    public int getFrating() {
        return frating;
    }

    public void setFrating(int frating) {
        this.frating = frating;
    }

    public film() {
    }

    public film( String fname, int fyear, String flang, int frating) {
        this.fname = fname;
        this.fyear = fyear;
        this.flang = flang;
        this.frating = frating;
    }
}
