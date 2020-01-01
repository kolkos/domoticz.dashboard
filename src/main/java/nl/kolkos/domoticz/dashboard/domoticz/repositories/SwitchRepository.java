package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;

import javax.transaction.Transactional;

@Transactional
public interface SwitchRepository extends DeviceRepository<Switch> {
}
