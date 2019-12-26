package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.HeaterRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeaterService {
    private final HeaterRepository heaterRepository;

    public Heater save(Heater heater) {
        return heaterRepository.save(heater);
    }

}
