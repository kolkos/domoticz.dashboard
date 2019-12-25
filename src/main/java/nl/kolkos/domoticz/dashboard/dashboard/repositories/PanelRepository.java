package nl.kolkos.domoticz.dashboard.dashboard.repositories;

import nl.kolkos.domoticz.dashboard.dashboard.entities.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {
}
