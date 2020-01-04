package nl.kolkos.domoticz.dashboard.domoticz.controllers;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.services.DimmerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices/dimmer")
public class DimmerController {

    private final DimmerService dimmerService;

    @GetMapping("/listAll")
    public Iterable<Dimmer> findAll() {
        return dimmerService.findAll();
    }

}
