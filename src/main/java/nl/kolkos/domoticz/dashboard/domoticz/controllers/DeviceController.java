package nl.kolkos.domoticz.dashboard.domoticz.controllers;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import nl.kolkos.domoticz.dashboard.domoticz.services.DimmerService;
import nl.kolkos.domoticz.dashboard.domoticz.services.HeaterService;
import nl.kolkos.domoticz.dashboard.domoticz.services.SceneService;
import nl.kolkos.domoticz.dashboard.domoticz.services.SwitchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class DeviceController {

    private final SceneService sceneService;
    private final SwitchService switchService;
    private final DimmerService dimmerService;
    private final HeaterService heaterService;

    @GetMapping("/create/switch")
    public Switch createSwitch(@RequestParam int gid, @RequestParam String name) {
        Switch aSwitch = new Switch();
        aSwitch.setName(name);
        aSwitch.setGid(gid);

        return switchService.save(aSwitch);
    }

}
