//Timestamp date, Integer station_idstation, float temperature,
//          float humidity, float pressure, String wind_direction, float wind_speed
package ua.lviv.iot.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`weather`", schema = "`weather_station`")
public class Weather implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    
    @Basic
    @Column(name = "station_idstation", nullable = false)
    private Integer station_idstation;
    
    @Basic
    @Column(name = "temperature", nullable = false)
    private float temperature;
    
    @Basic
    @Column(name = "humidity", nullable = false)
    private float humidity;
    
    @Basic
    @Column(name = "pressure", nullable = false)
    private float pressure;
    
    @Basic
    @Column(name = "wind_direction", nullable = false)
    private String wind_direction;
    
    @Basic
    @Column(name = "wind_speed", nullable = false)
    private float wind_speed;

    public Weather(Integer id, Timestamp date, Integer station_idstation, float temperature, float humidity, float pressure, String wind_direction, float wind_speed) {
        this.id = id;
        this.date = date;
        this.station_idstation = station_idstation;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind_direction = wind_direction;
        this.wind_speed = wind_speed;
    }

    public Weather() {
    }

   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    
    public Integer getStation_idstation() {
        return station_idstation;
    }

    public void setStation_idstation(Integer station_idstation) {
        this.station_idstation = station_idstation;
    }

    
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    
    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    
    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    
    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

   
    public float getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(float wind_speed) {
        this.wind_speed = wind_speed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Float.floatToIntBits(this.temperature);
        hash = 71 * hash + Float.floatToIntBits(this.humidity);
        hash = 71 * hash + Float.floatToIntBits(this.pressure);
        hash = 71 * hash + Objects.hashCode(this.wind_direction);
        hash = 71 * hash + Float.floatToIntBits(this.wind_speed);
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
        final Weather other = (Weather) obj;
        if (Float.floatToIntBits(this.temperature) != Float.floatToIntBits(other.temperature)) {
            return false;
        }
        if (Float.floatToIntBits(this.humidity) != Float.floatToIntBits(other.humidity)) {
            return false;
        }
        if (Float.floatToIntBits(this.pressure) != Float.floatToIntBits(other.pressure)) {
            return false;
        }
        if (Float.floatToIntBits(this.wind_speed) != Float.floatToIntBits(other.wind_speed)) {
            return false;
        }
        if (!Objects.equals(this.wind_direction, other.wind_direction)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WeatherEntity{" + "id=" + id + ", date=" + date
                + ", station_idstation=" + station_idstation + ", temperature="
                + temperature + ", humidity=" + humidity + ", pressure="
                + pressure + ", wind_direction=" + wind_direction
                + ", wind_speed=" + wind_speed + '}';
    }

}
