package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimmerRepository extends JpaRepository<Dimmer, Long> {
}
