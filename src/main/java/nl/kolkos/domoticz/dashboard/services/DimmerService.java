package nl.kolkos.domoticz.dashboard.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.repositories.DimmerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DimmerService {
    private final DimmerRepository dimmerRepository;

    public Dimmer save(Dimmer dimmer) {
        return dimmerRepository.save(dimmer);
    }

}
