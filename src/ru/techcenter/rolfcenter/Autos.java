package ru.techcenter.rolfcenter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Autos")
public class Autos  {
    @Id
    @Column(name = "CLIENT_ID")
    private int CLIENT_ID;
    @Column(name = "MODEl", nullable =  false)
    private String MODEL;
    @Column(name = "SERIES", nullable =  false)
    private String SERIES;

    public int getCLIENT_ID() {
        return CLIENT_ID;
    }

    public void setCLIENT_ID(int CLIENT_ID) {
        this.CLIENT_ID = CLIENT_ID;
    }

    public String getMODEL() {
        return MODEL;
    }

    public void setMODEL(String MODEL) {
        this.MODEL = MODEL;
    }

    public String getSERIES() {
        return SERIES;
    }

    public void setSERIES(String SERIES) {
        this.SERIES = SERIES;
    }

    @Override
    public String toString() {
        return "Autos{" +
                "CLIENT_ID=" + CLIENT_ID +
                ", MODEL='" + MODEL + '\'' +
                ", SERIES='" + SERIES + '\'' +
                '}';
    }
}
