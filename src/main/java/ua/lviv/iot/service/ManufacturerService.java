package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.domain.Manufacturer;

import ua.lviv.iot.repository.ManufacturerRepository;

@Service
public class ManufacturerService {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() throws Exception {
        List<Manufacturer> manufacturers = new LinkedList<>(manufacturerRepository.findAll());
        if (manufacturers.isEmpty()) {
            return null;
        }
        return manufacturers;
    }

    public Manufacturer findById(Integer id) throws Exception {
        if (manufacturerRepository.findById(id).isPresent()) {
            return manufacturerRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Manufacturer entity) throws Exception {
        if (entity != null) {
            manufacturerRepository.save(entity);
        }
    }

    @Transactional
    public void update(Manufacturer entity) throws Exception {
        manufacturerRepository.findById(entity.getId())
                .map(oldEntity -> {

                    oldEntity.setCountry(entity.getCountry());
                    oldEntity.setName(entity.getName());
                    return manufacturerRepository.save(oldEntity);
                })
                .orElseGet(() -> manufacturerRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (manufacturerRepository.findById(id).isPresent()) {
            manufacturerRepository.deleteById(id);
        }
    }
}
