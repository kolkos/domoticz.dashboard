package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.configurations.DomoticzConfiguration;
import nl.kolkos.domoticz.dashboard.domoticz.models.DomoticzResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomoticzService {

    private final RestClient restClient;
    private final DomoticzConfiguration domoticzConfiguration;
    private final JsonTransformService jsonTransformService;

    private static final Logger LOGGER = LogManager.getLogger(DomoticzService.class);


    public DomoticzResponse listAllDevicesInDomoticz() {
        String domoticzHost = domoticzConfiguration.getBaseUrl();
        String endpoint = "/json.htm?type=devices&filter=light&used=true&order=Name";


        String url = String.format("%s%s", domoticzHost, endpoint);

        String response = restClient.callUrl(url);
        DomoticzResponse respObject = jsonTransformService.transformDomoticzResponse(response);

        LOGGER.info(respObject);
        return respObject;
    }

}
