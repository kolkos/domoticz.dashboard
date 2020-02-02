package nl.kolkos.domoticz.dashboard.domoticz.controllers;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.models.DomoticzResponse;
import nl.kolkos.domoticz.dashboard.domoticz.services.DomoticzService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DomoticzController {

    private final DomoticzService domoticzService;

    @GetMapping("/list")
    public DomoticzResponse getAllDomoticzDevices() {
        return domoticzService.listAllDevicesInDomoticz();
    }

}
