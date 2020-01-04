package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import nl.kolkos.domoticz.dashboard.domoticz.exceptions.DeviceNotFoundException;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.SwitchRepository;
import nl.kolkos.domoticz.dashboard.domoticz.util.Constants;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SwitchService {
    private final SwitchRepository switchRepository;

    public Switch save(Switch aSwitch) {
        return switchRepository.save(aSwitch);
    }

    public Iterable<Switch> findAll() {
        return switchRepository.findAll();
    }

    public Switch getById(int gid) throws DeviceNotFoundException {
        String errorMessage = String.format(Constants.DEVICE_NOT_FOUND_ERROR_MESSAGE_TEMPLATE, "Switch", gid);
        return switchRepository.getByGid(gid).orElseThrow(() -> new DeviceNotFoundException(errorMessage));
    }
}
