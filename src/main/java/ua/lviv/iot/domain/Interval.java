package ua.lviv.iot.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`interval`", schema = "`weather_station`")
public class Interval implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinterval", nullable = false)
    private Integer idinterval;
    
    @Basic
    @Column(name = "setting", nullable = true)
    private Integer setting;
    
    @Basic
    @Column(name = "general", nullable = true)
    private Integer general;

    public Interval(Integer idinterval, Integer setting, Integer general) {
        this.idinterval = idinterval;
        this.setting = setting;
        this.general = general;
    }

    public Interval() {
    }

    
    
    public Integer getIdinterval() {
        return idinterval;
    }

    public void setIdinterval(Integer idinterval) {
        this.idinterval = idinterval;
    }

    
    public Integer getSetting() {
        return setting;
    }

    public void setSetting(Integer setting) {
        this.setting = setting;
    }

   
    public Integer getGeneral() {
        return general;
    }

    public void setGeneral(Integer general) {
        this.general = general;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Interval other = (Interval) obj;
        if (!Objects.equals(this.idinterval, other.idinterval)) {
            return false;
        }
        if (!Objects.equals(this.setting, other.setting)) {
            return false;
        }
        if (!Objects.equals(this.general, other.general)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idinterval);
        hash = 71 * hash + Objects.hashCode(this.setting);
        hash = 71 * hash + Objects.hashCode(this.general);
        return hash;
    }

    @Override
    public String toString() {
        return "IntervalEntity{" + "idinterval=" + idinterval
                + ", setting=" + setting + ", general=" + general + '}';
    }

}
