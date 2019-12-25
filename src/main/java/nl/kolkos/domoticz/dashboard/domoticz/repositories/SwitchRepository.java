package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitchRepository extends JpaRepository<Switch, Long> {
}
