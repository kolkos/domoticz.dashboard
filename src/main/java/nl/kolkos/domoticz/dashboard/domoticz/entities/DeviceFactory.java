package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.models.DomoticzResponse;
import nl.kolkos.domoticz.dashboard.domoticz.models.StatusResult;
import nl.kolkos.domoticz.dashboard.domoticz.services.ContactService;
import nl.kolkos.domoticz.dashboard.domoticz.services.DimmerService;
import nl.kolkos.domoticz.dashboard.domoticz.services.HeaterService;
import nl.kolkos.domoticz.dashboard.domoticz.services.SceneService;
import nl.kolkos.domoticz.dashboard.domoticz.services.SwitchService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DeviceFactory {

    private final ContactService contactService;
    private final DimmerService dimmerService;
    private final HeaterService heaterService;
    private final SceneService sceneService;
    private final SwitchService switchService;


    public List<Device> createDevicesFromDomoticzResponse(DomoticzResponse domoticzResponse) {
        return Arrays.stream(domoticzResponse.getResult())
                .map(this::handleStatusResult)
                .collect(Collectors.toList());
    }

    private Device handleStatusResult(StatusResult statusResult) {
        Device device = null;

        switch (determineDeviceType(statusResult)) {
            case "Door Contact":
            case "Contact":
                device = contactService.createContact(statusResult);
                break;
            case "Dimmer":
                device = dimmerService.createDimmer(statusResult);
                break;
            case "On/Off":
                device = switchService.createSwitch(statusResult);
                break;
            case "Temp + Humidity":
            case "Temp":
                break;
        }

        return device;
    }

    private String determineDeviceType(StatusResult statusResult) {
        String deviceType = statusResult.getType();
        if(statusResult.getSwitchType() != null) {
            deviceType = statusResult.getSwitchType();
        }
        return deviceType;
    }





}
