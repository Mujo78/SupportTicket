package ptf.rs.models;

import javax.persistence.Entity;

@Entity
public class Agent extends BaseClass {

    private String nazivAgenta;

    public Agent(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    public Agent() {

    }

    public String getNazivAgenta() {
        return nazivAgenta;
    }

    public void setNazivAgenta(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    @Override
    public String toString() {
        return nazivAgenta;
    }
}
