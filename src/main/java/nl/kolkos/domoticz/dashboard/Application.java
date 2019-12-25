package nl.kolkos.domoticz.dashboard;

import nl.kolkos.domoticz.dashboard.configurations.DomoticzConfiguration;
import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.entities.Switch;
import nl.kolkos.domoticz.dashboard.models.CommandRunner;
import nl.kolkos.domoticz.dashboard.models.Level;
import nl.kolkos.domoticz.dashboard.models.commands.Command;
import nl.kolkos.domoticz.dashboard.models.commands.dimmer.DimmerSetLevelCommand;
import nl.kolkos.domoticz.dashboard.models.commands.light.SwitchOffCommand;
import nl.kolkos.domoticz.dashboard.models.commands.light.SwitchOnCommand;
import nl.kolkos.domoticz.dashboard.services.DimmerService;
import nl.kolkos.domoticz.dashboard.services.RestClient;
import nl.kolkos.domoticz.dashboard.services.SwitchService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(SwitchService switchService, DimmerService dimmerService, DomoticzConfiguration domoticzConfiguration, RestClient restClient) {
        return (args) -> {
            CommandRunner commandRunner = new CommandRunner(domoticzConfiguration, restClient);

            Switch light1 = new Switch();
            light1.setGid(1001);
            light1.setName("Light #1");

            Switch light2 = new Switch();
            light2.setGid(2002);
            light2.setName("Light #2");

            Dimmer dimmer = Dimmer.builder()
                    .gid(3003)
                    .name("Random dimmer")
                    .minLevel(0)
                    .maxLevel(13)
                    .build();

            switchService.save(light1);
            switchService.save(light2);
            dimmerService.save(dimmer);

            Command switchLight1On = new SwitchOnCommand(light1);
            Command switchLight2Off = new SwitchOffCommand(light2);

            Level dimmerLevel50 = Level.builder()
                    .levelToSet(6)
                    .percentage(50)
                    .build();
            Command dimmerSetLevelCommand = new DimmerSetLevelCommand(dimmerLevel50, dimmer);

            commandRunner.setCommand(switchLight1On);
            commandRunner.run();

            commandRunner.setCommand(switchLight2Off);
            commandRunner.run();

            commandRunner.setCommand(dimmerSetLevelCommand);
            commandRunner.run();


        };
    }

}
