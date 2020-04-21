package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.domain.Weather;
import ua.lviv.iot.repository.WeatherRepository;

@Service
public class WeatherService {

    @Autowired
    WeatherRepository weatherRepository;

    public List<Weather> findAll() throws Exception {
        List<Weather> weathers = new LinkedList<>(weatherRepository.findAll());
        if (weathers.isEmpty()) {
            return null;
        }
        return weathers;
    }

    public Weather findById(Integer id) throws Exception {
        if (weatherRepository.findById(id).isPresent()) {
            return weatherRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Weather entity) throws Exception {
        if (entity != null) {
            weatherRepository.save(entity);
        }
    }

    @Transactional
    public void update(Weather entity) throws Exception {
        weatherRepository.findById(entity.getId())
                .map(oldEntity -> {
                    
                    oldEntity.setDate(entity.getDate());
                    oldEntity.setHumidity(entity.getHumidity());
                    oldEntity.setPressure(entity.getPressure());
                    oldEntity.setStation_idstation(entity.getStation_idstation());
                    oldEntity.setTemperature(entity.getTemperature());
                    oldEntity.setWind_direction(entity.getWind_direction());
                    oldEntity.setWind_speed(entity.getWind_speed());
                    return weatherRepository.save(oldEntity);
                })
                .orElseGet(() -> weatherRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (weatherRepository.findById(id).isPresent()) {
            weatherRepository.deleteById(id);
        }
    }
}
