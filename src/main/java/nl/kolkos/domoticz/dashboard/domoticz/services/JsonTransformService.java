package nl.kolkos.domoticz.dashboard.domoticz.services;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.domoticz.dashboard.domoticz.models.DomoticzResponse;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class JsonTransformService {

    public DomoticzResponse transformDomoticzResponse(String response) {
        log.info("Transforming response:\n{}", response);

        Gson gson = new Gson();
        return gson.fromJson(response, DomoticzResponse.class);
    }


}
