package ua.lviv.iot.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`service`", schema = "`weather_station`")
public class ServiceStation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Basic
    @Column(name = "station_idstation", nullable = false)
    private Integer station_idstation;
    
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    
    @Basic
    @Column(name = "description", nullable = false, length = 300)
    private String description;

    public ServiceStation(Integer id, Integer station_idstation, Date date, String description) {
        this.id = id;
        this.station_idstation = station_idstation;
        this.date = date;
        this.description = description;
    }

    public ServiceStation() {
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public Integer getStation_idstation() {
        return station_idstation;
    }

    public void setStation_idstation(Integer station_idstation) {
        this.station_idstation = station_idstation;
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.station_idstation);
        hash = 13 * hash + Objects.hashCode(this.date);
        hash = 13 * hash + Objects.hashCode(this.description);
        return hash;
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
        final ServiceStation other = (ServiceStation) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.station_idstation, other.station_idstation)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ServiceEntity{" + "id=" + id + ", station_idstation=" + station_idstation + ", date=" + date + ", description=" + description + '}';
    }

}


//Integer id, Integer station,  Date date, String description
