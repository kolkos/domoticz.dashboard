package nl.kolkos.domoticz.dashboard.models;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.configurations.DomoticzConfiguration;
import nl.kolkos.domoticz.dashboard.models.commands.Command;
import nl.kolkos.domoticz.dashboard.services.RestClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandRunner {
    private final DomoticzConfiguration domoticzConfiguration;
    private final RestClient restClient;

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void run() {
        String url = domoticzConfiguration.getBaseUrl() + command.execute();
        System.out.println("Calling url: " + url);
        String response = restClient.callUrl(url);
        System.out.println(response);


    }

}
