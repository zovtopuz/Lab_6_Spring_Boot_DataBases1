package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.domain.Station;
import ua.lviv.iot.repository.StationRepository;

@Service
public class StationService {

    @Autowired
    StationRepository stationRepository;

    public List<Station> findAll() throws Exception {
        List<Station> stations = new LinkedList<>(stationRepository.findAll());
        if (stations.isEmpty()) {
            return null;
        }
        return stations;
    }

    public Station findById(Integer id) throws Exception {
        if (stationRepository.findById(id).isPresent()) {
            return stationRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Station entity) throws Exception {
        if (entity != null) {
            stationRepository.save(entity);
        }
    }

    @Transactional
    public void update(Station entity) throws Exception {
        stationRepository.findById(entity.getIdstation())
                .map(oldEntity -> {
                    oldEntity.setCountry(entity.getCountry());
                    oldEntity.setHeight(entity.getHeight());
                    oldEntity.setInstallation_date(entity.getInstallation_date());
                    oldEntity.setInterval_idinterval(entity.getInterval_idinterval());
                    oldEntity.setLatitude(entity.getLatitude());
                    oldEntity.setLongtitude(entity.getLongtitude());
                    oldEntity.setManufacturer_id(entity.getManufacturer_id());
                    return stationRepository.save(oldEntity);
                })
                .orElseGet(() -> stationRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (stationRepository.findById(id).isPresent()) {
            stationRepository.deleteById(id);
        }
    }
}
