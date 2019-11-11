package nl.kolkos.domoticz.dashboard.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.entities.Switch;
import nl.kolkos.domoticz.dashboard.repositories.SwitchRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SwitchService {
    private final SwitchRepository switchRepository;

    public Switch save(Switch aSwitch) {
        return switchRepository.save(aSwitch);
    }
}
