package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.repository.ServiceRepository;
import ua.lviv.iot.domain.ServiceStation;

@Service
public class ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<ServiceStation> findAll() throws Exception {
        List<ServiceStation> services = new LinkedList<>(serviceRepository.findAll());
        if (services.isEmpty()) {
            return null;
        }
        return services;
    }

    public ServiceStation findById(Integer id) throws Exception {
        if (serviceRepository.findById(id).isPresent()) {
            return serviceRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(ServiceStation entity) throws Exception {
        if (entity != null) {
            serviceRepository.save(entity);
        }
    }

    @Transactional
    public void update(ServiceStation entity) throws Exception {
        serviceRepository.findById(entity.getId())
                .map(oldEntity -> {
                    oldEntity.setDate(entity.getDate());
                    oldEntity.setDescription(entity.getDescription());
                    oldEntity.setStation_idstation(entity.getStation_idstation());
                    return serviceRepository.save(oldEntity);
                })
                .orElseGet(() -> serviceRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (serviceRepository.findById(id).isPresent()) {
            serviceRepository.deleteById(id);
        }
    }
}
