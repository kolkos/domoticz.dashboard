package nl.kolkos.domoticz.dashboard.domoticz.services;

import com.google.gson.Gson;
import nl.kolkos.domoticz.dashboard.domoticz.models.DomoticzResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class JsonTransformService {

    private static final Logger LOGGER = LogManager.getLogger(JsonTransformService.class);

    public DomoticzResponse transformDomoticzResponse(String response) {
        LOGGER.info("Transforming response:\n{}", response);

        Gson gson = new Gson();
        return gson.fromJson(response, DomoticzResponse.class);
    }


}
