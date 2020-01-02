package nl.kolkos.domoticz.dashboard;

import nl.kolkos.domoticz.dashboard.domoticz.configurations.DomoticzConfiguration;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Contact;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Scene;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import nl.kolkos.domoticz.dashboard.domoticz.models.CommandRunner;
import nl.kolkos.domoticz.dashboard.domoticz.models.Level;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.contact.ContactGetStatusCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.dimmer.DimmerGetStatusCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.dimmer.DimmerSetLevelCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.heater.HeaterGetStatusCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.heater.HeaterSetTemperatureCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.light.SwitchOffCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.light.SwitchOnCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.scene.SceneGetStatusCommand;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.scene.SceneOnCommand;
import nl.kolkos.domoticz.dashboard.domoticz.services.ContactService;
import nl.kolkos.domoticz.dashboard.domoticz.services.DimmerService;
import nl.kolkos.domoticz.dashboard.domoticz.services.HeaterService;
import nl.kolkos.domoticz.dashboard.domoticz.services.RestClient;
import nl.kolkos.domoticz.dashboard.domoticz.services.SceneService;
import nl.kolkos.domoticz.dashboard.domoticz.services.SwitchService;
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
    public CommandLineRunner demo(SwitchService switchService, DimmerService dimmerService, DomoticzConfiguration domoticzConfiguration, RestClient restClient, HeaterService heaterService, SceneService sceneService, ContactService contactService) {
        return (args) -> {
            CommandRunner commandRunner = new CommandRunner(domoticzConfiguration, restClient);


            Switch light1 = createSwitch1();
            Switch light2 = createSwitch2();
            Dimmer dimmer = createDimmer();
            Heater heater = createHeater();
            Contact contact = createContact();
            Scene scene = createScene();


            switchService.save(light1);
            switchService.save(light2);
            dimmerService.save(dimmer);
            heaterService.save(heater);
            contactService.save(contact);
            sceneService.save(scene);


            Command switchLight1On = createSwitchOnCommand(light1);
            Command switchLight2Off = createSwitchOffCommand(light2);

            Command switchSceneOn = new SceneOnCommand(scene);
            Command sceneGetStatusCommand = new SceneGetStatusCommand(scene);

            Command dimmerSetLevelCommand = createDimmerLevelCommand(4, 25, dimmer);
            Command dimmerGetStatusCommand = new DimmerGetStatusCommand(dimmer);

            Command contactGetStatusCommand = new ContactGetStatusCommand(contact);


            Command heaterSetTemperatureCommand = new HeaterSetTemperatureCommand(15.5, heater);
            Command heaterGetStatusCommand = new HeaterGetStatusCommand(heater);


            commandRunner.setCommand(switchLight1On);
            commandRunner.run();

            commandRunner.setCommand(switchLight2Off);
            commandRunner.run();

            commandRunner.setCommand(dimmerSetLevelCommand);
            commandRunner.run();

            commandRunner.setCommand(dimmerGetStatusCommand);
            commandRunner.run();

            commandRunner.setCommand(switchSceneOn);
            commandRunner.run();

            commandRunner.setCommand(sceneGetStatusCommand);
            commandRunner.run();

            commandRunner.setCommand(heaterSetTemperatureCommand);
            commandRunner.run();

            commandRunner.setCommand(contactGetStatusCommand);
            commandRunner.run();

            commandRunner.setCommand(heaterGetStatusCommand);
            commandRunner.run();


        };
    }

    private Switch createSwitch(int gid, String name) {
        Switch aSwitch = new Switch();
        aSwitch.setGid(gid);
        aSwitch.setName(name);

        return aSwitch;
    }

    private Scene createScene() {
        Scene scene = new Scene();
        scene.setGid(1);
        scene.setName("Test scene");

        return scene;
    }

    private Contact createContact() {
        Contact contact = new Contact();
        contact.setGid(3);
        contact.setName("Contact #1");

        return contact;
    }


    private Switch createSwitch1() {
        return createSwitch(1, "Light #1");
    }

    private Switch createSwitch2() {
        return createSwitch(4, "Light #2");
    }

    private Dimmer createDimmer() {
        Dimmer dimmer = new Dimmer();
        dimmer.setGid(6);
        dimmer.setName("Hal");
        dimmer.setMinLevel(0);
        dimmer.setMaxLevel(13);

        return dimmer;
    }

    private Command createSwitchOnCommand(Switch aSwitch) {
        return new SwitchOnCommand(aSwitch);
    }

    private Command createSwitchOffCommand(Switch aSwitch) {
        return new SwitchOffCommand(aSwitch);
    }

    private Level createDimmerLevel(int level, int percentage) {
        return Level.builder()
                .levelToSet(level)
                .percentage(percentage)
                .build();
    }

    private DimmerSetLevelCommand createDimmerLevelCommand(int level, int percentage, Dimmer dimmer) {
        Level dimmerLevel = createDimmerLevel(level, percentage);
        return new DimmerSetLevelCommand(dimmerLevel, dimmer);
    }

    private Heater createHeater() {
        Heater heater = new Heater();
        heater.setGid(7);
        heater.setName("Thermostat #1");

        return heater;
    }

}
