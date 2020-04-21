//package ua.lviv.iot.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ua.lviv.iot.domain.Interval;
//import ua.lviv.iot.exception.ExistHotelForCityException;
//import ua.lviv.iot.exception.ExistStopPointForCityException;
//
//import ua.lviv.iot.repository.IntervalRepository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//public class IntervalService {
//
//    @Autowired
//    private IntervalRepository intervalRepository;
//
//    public List<Interval> getAllInterval() {
//        return intervalRepository.findAll();
//    }
//    
//    public Interval getInterval(Integer interval_id) throws Exception {
//        Interval interval = intervalRepository.findById(interval_id).get();
//        if (interval == null) throw new Exception();
//        return interval;
//    }
//
//    @Transactional
//    public void createInterval(Interval interval) {
//        intervalRepository.save(interval);
//    }
//
//    @Transactional
//    public void updateInterval(Interval uInterval, Integer interval_id) throws NoSuchCityException {
//        Interval interval = intervalRepository.findById(interval_id).get();
//        if (interval == null) throw new Exception();
//        //
//        interval.setGeneral(interval.getGeneral());
//        interval.setSetting(interval.getSetting());
//          
//        intervalRepository.save(interval);
//    }
//
//    @Transactional
//    public void deleteInterval(Integer interval_id) throws Exception {
//        Interval interval = intervalRepository.findById(interval_id).get();
//        if (interval == null) throw new Exception();
//        intervalRepository.delete(interval);
//    }
//
//}


package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.domain.Interval;
import ua.lviv.iot.repository.IntervalRepository;

@Service
public class IntervalService {
    @Autowired
    IntervalRepository intervalRepository;
    public List<Interval> findAll() throws Exception {
        List<Interval> intervals = new LinkedList<>(intervalRepository.findAll());
        if (intervals.isEmpty()) {
            return null;
        }
        return intervals;
    }

    public Interval findById(Integer id) throws Exception {
        if (intervalRepository.findById(id).isPresent()) {
            return intervalRepository.findById(id).get();
        }
        return null;
    }

    @Transactional
    public void create(Interval entity) throws Exception {
        if (entity != null) {
            intervalRepository.save(entity);
        }
    }

    @Transactional
    public void update(Interval entity) throws Exception {
        intervalRepository.findById(entity.getIdinterval())
                .map(oldEntity -> {
                    oldEntity.setGeneral(entity.getGeneral());
                    oldEntity.setSetting(entity.getSetting());
                    return intervalRepository.save(oldEntity);
                })
                .orElseGet(() -> intervalRepository.save(entity));
    }

    @Transactional
    public void delete(Integer id) throws Exception {
        if (intervalRepository.findById(id).isPresent()) {
            intervalRepository.deleteById(id);
        }
    }
}
