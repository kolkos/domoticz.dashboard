package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.domoticz.dashboard.domoticz.configurations.DomoticzConfiguration;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Device;
import nl.kolkos.domoticz.dashboard.domoticz.entities.DeviceFactory;
import nl.kolkos.domoticz.dashboard.domoticz.models.DomoticzResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class DomoticzService {

    private final RestClient restClient;
    private final DomoticzConfiguration domoticzConfiguration;
    private final JsonTransformService jsonTransformService;
    private final DeviceFactory deviceFactory;

    public DomoticzResponse listAllDevicesInDomoticz() {
        String domoticzHost = domoticzConfiguration.getBaseUrl();
        String endpoint = "/json.htm?type=devices&filter=light&used=true&order=Name";


        String url = String.format("%s%s", domoticzHost, endpoint);

        String response = restClient.callUrl(url);
        DomoticzResponse respObject = jsonTransformService.transformDomoticzResponse(response);

        log.info(respObject);
        return respObject;
    }

    public List<Device> syncDevices() {
        DomoticzResponse devices = listAllDevicesInDomoticz();

        return deviceFactory.createDevicesFromDomoticzResponse(devices);

    }

}
