package ua.lviv.iot.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`station`", schema = "`weather_station`")
public class Station implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstation", nullable = false)
    private Integer idstation;
    
    @Basic
    @Column(name = "manufacturer_id", nullable = false)
    private Integer manufacturer_id;
    
    @Basic
    @Column(name = "interval_idinterval", nullable = false)
    private Integer interval_idinterval;
   
    @Basic
    @Column(name = "installation_date", nullable = false)
    private Date installation_date;
    
    @Basic
    @Column(name = "latitude", nullable = false)
    private float latitude;
    
    @Basic
    @Column(name = "longtitude", nullable = false)
    private float longtitude;
    
    @Basic
    @Column(name = "height", nullable = false)
    private float height;
    
    @Basic
    @Column(name = "country", nullable = false, length = 45)
    private String country;
    
    /////////
//    @OneToMany(mappedBy = "station", fetch = FetchType.EAGER)
//    private Collection<Station> stations;
//    
    
    
    

    public Station(Integer idstation, Integer manufacturer_id, Integer interval_idinterval, Date installation_date, float latitude, float longtitude, float height, String country) {
        this.idstation = idstation;
        this.manufacturer_id = manufacturer_id;
        this.interval_idinterval = interval_idinterval;
        this.installation_date = installation_date;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.height = height;
        this.country = country;
    }

    public Station() {
    }

    
    
  
    public Integer getIdstation() {
        return idstation;
    }

    public void setIdstation(Integer idstation) {
        this.idstation = idstation;
    }
    
    
    public Integer getManufacturer_id() {
        return manufacturer_id;
    }

    public void setManufacturer_id(Integer manufacturer_id) {
        this.manufacturer_id = manufacturer_id;
    }

    
    public Integer getInterval_idinterval() {
        return interval_idinterval;
    }

    public void setInterval_idinterval(Integer interval_idinterval) {
        this.interval_idinterval = interval_idinterval;
    }

    
    
    public Date getInstallation_date() {
        return installation_date;
    }

    public void setInstallation_date(Date installation_date) {
        this.installation_date = installation_date;
    }

    
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    
    public float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(float longtitude) {
        this.longtitude = longtitude;
    }

    
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.manufacturer_id);
        hash = 97 * hash + Objects.hashCode(this.interval_idinterval);
        hash = 97 * hash + Objects.hashCode(this.installation_date);
        hash = 97 * hash + Float.floatToIntBits(this.latitude);
        hash = 97 * hash + Float.floatToIntBits(this.longtitude);
        hash = 97 * hash + Float.floatToIntBits(this.height);
        hash = 97 * hash + Objects.hashCode(this.country);
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
        final Station other = (Station) obj;
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longtitude) != Float.floatToIntBits(other.longtitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.height) != Float.floatToIntBits(other.height)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer_id, other.manufacturer_id)) {
            return false;
        }
        if (!Objects.equals(this.interval_idinterval, other.interval_idinterval)) {
            return false;
        }
        return Objects.equals(this.installation_date, other.installation_date);
    }

    @Override
    public String toString() {
        return "StationEntity{" + "idstation=" + idstation + ", manufacturer_id="
                + manufacturer_id + ", interval_idinterval=" + interval_idinterval
                + ", installation_date=" + installation_date + ", latitude="
                + latitude + ", longtitude=" + longtitude + ", height=" + height
                + ", country=" + country + '}';
    }

//    public Collection<Station> getStations() {
//        return stations;
//    }
//
//    public void setStations(Collection<Station> stations) {
//        this.stations = stations;
//    }

}

//Integer idstation, Integer manufacturer_id, Integer interval_idinterval, Date installation_date, 
        //    float latitude, float longtitude, float height, String country
