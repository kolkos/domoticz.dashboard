package nl.kolkos.domoticz.dashboard.domoticz.controllers;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;
import nl.kolkos.domoticz.dashboard.domoticz.services.HeaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices/heater")
public class HeaterController {

    private final HeaterService heaterService;

    @GetMapping("/listAll")
    public Iterable<Heater> findAll() {
        return heaterService.findAll();
    }

}
