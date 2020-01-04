package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;
import nl.kolkos.domoticz.dashboard.domoticz.exceptions.DeviceNotFoundException;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.HeaterRepository;
import nl.kolkos.domoticz.dashboard.domoticz.util.Constants;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeaterService {
    private final HeaterRepository heaterRepository;

    public Heater save(Heater heater) {
        return heaterRepository.save(heater);
    }

    public Iterable<Heater> findAll() {
        return heaterRepository.findAll();
    }

    public Heater getById(int gid) throws DeviceNotFoundException {
        String errorMessage = String.format(Constants.DEVICE_NOT_FOUND_ERROR_MESSAGE_TEMPLATE, "Heater", gid);
        return heaterRepository.getByGid(gid).orElseThrow(() -> new DeviceNotFoundException(errorMessage));
    }

}
