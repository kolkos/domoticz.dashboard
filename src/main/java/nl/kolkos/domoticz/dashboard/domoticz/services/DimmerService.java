package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.DimmerRepository;
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

}
