package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.ServiceStation;

@Repository
public interface ServiceRepository  extends JpaRepository<ServiceStation, Integer> {
}