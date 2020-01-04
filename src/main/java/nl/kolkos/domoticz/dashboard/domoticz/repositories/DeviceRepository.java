package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DeviceRepository<T extends Device> extends JpaRepository<T, Long> {
    T getByGid(int gid);
}
