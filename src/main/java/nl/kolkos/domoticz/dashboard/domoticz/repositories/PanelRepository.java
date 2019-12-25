package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {
}
