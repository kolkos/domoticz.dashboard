package nl.kolkos.domoticz.dashboard.domoticz.models;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.domoticz.dashboard.domoticz.configurations.DomoticzConfiguration;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;
import nl.kolkos.domoticz.dashboard.domoticz.services.JsonTransformService;
import nl.kolkos.domoticz.dashboard.domoticz.services.RestClient;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Log4j2
public class CommandRunner {
    private final DomoticzConfiguration domoticzConfiguration;
    private final RestClient restClient;
    private final JsonTransformService jsonTransformService;

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public DomoticzResponse run() {
        String url = domoticzConfiguration.getBaseUrl() + command.execute();

        String response = restClient.callUrl(url);
        DomoticzResponse respObject = jsonTransformService.transformDomoticzResponse(response);

        log.info("Calling url: {}", url);
        log.info("Response from Domoticz:\n{}", response);
        log.info("Response object: {}", respObject);

        return respObject;
    }

}
