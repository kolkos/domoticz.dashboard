package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;

import javax.transaction.Transactional;

@Transactional
public interface DimmerRepository extends DeviceRepository<Dimmer> {
}
