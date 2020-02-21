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
        DomoticzResponse responseLights = listLightDevices();
        DomoticzResponse responseTemp = listTempDevices();

        DomoticzResponse response = new DomoticzResponse();
        response.setStatus(responseTemp.getStatus());
        response.setTitle(responseTemp.getTitle());
        response.appendToStatusResult(responseLights.getResult());
        response.appendToStatusResult(responseTemp.getResult());


        return response;
    }

    public List<Device> syncDevices() {
        DomoticzResponse devices = listAllDevicesInDomoticz();

        return deviceFactory.createDevicesFromDomoticzResponse(devices);

    }


    private DomoticzResponse listLightDevices() {
        String endpoint = "/json.htm?type=devices&filter=light&used=true&order=Name";
        String url = createUrl(endpoint);
        return callDomoticz(url);
    }

    private DomoticzResponse listTempDevices() {
        String endpoint = "/json.htm?type=devices&filter=temp&used=true&order=Name";
        String url = createUrl(endpoint);
        return callDomoticz(url);
    }

    private String createUrl(String endpoint) {
        String domoticzHost = domoticzConfiguration.getBaseUrl();
        return String.format("%s%s", domoticzHost, endpoint);
    }

    private DomoticzResponse callDomoticz(String url) {
        String response = restClient.callUrl(url);
        DomoticzResponse respObject = jsonTransformService.transformDomoticzResponse(response);
        log.info(respObject);

        return respObject;
    }




}
