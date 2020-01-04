package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.exceptions.DeviceNotFoundException;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.DimmerRepository;
import nl.kolkos.domoticz.dashboard.domoticz.util.Constants;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DimmerService {
    private final DimmerRepository dimmerRepository;

    public Dimmer save(Dimmer dimmer) {
        return dimmerRepository.save(dimmer);
    }

    public Iterable<Dimmer> findAll() {
        return dimmerRepository.findAll();
    }

    public Dimmer getById(int gid) throws DeviceNotFoundException {
        String errorMessage = String.format(Constants.DEVICE_NOT_FOUND_ERROR_MESSAGE_TEMPLATE, "Dimmer", gid);
        return dimmerRepository.getByGid(gid).orElseThrow(() -> new DeviceNotFoundException(errorMessage));
    }

}
