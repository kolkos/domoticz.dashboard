package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Device;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import nl.kolkos.domoticz.dashboard.domoticz.exceptions.DeviceNotFoundException;
import nl.kolkos.domoticz.dashboard.domoticz.models.StatusResult;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.SwitchRepository;
import nl.kolkos.domoticz.dashboard.domoticz.util.Constants;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SwitchService {
    private final SwitchRepository switchRepository;

    public Switch save(Switch aSwitch) {
        log.info("Saving switch to the database: {}", aSwitch);
        return switchRepository.save(aSwitch);
    }

    public Iterable<Switch> findAll() {
        return switchRepository.findAll();
    }

    public Switch getById(int gid) throws DeviceNotFoundException {
        String errorMessage = String.format(Constants.DEVICE_NOT_FOUND_ERROR_MESSAGE_TEMPLATE, "Switch", gid);
        return switchRepository.getByGid(gid).orElseThrow(() -> new DeviceNotFoundException(errorMessage));
    }

    public Device createSwitch(StatusResult statusResult) {
        Switch aSwitch = new Switch();
        aSwitch.setName(statusResult.getName());
        aSwitch.setGid(statusResult.getIdx());
        return this.save(aSwitch);
    }
}
