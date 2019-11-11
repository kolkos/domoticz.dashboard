package nl.kolkos.domoticz.dashboard;

import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.entities.Switch;
import nl.kolkos.domoticz.dashboard.models.CommandRunner;
import nl.kolkos.domoticz.dashboard.models.Level;
import nl.kolkos.domoticz.dashboard.models.commands.Command;
import nl.kolkos.domoticz.dashboard.models.commands.dimmer.DimmerSetLevelCommand;
import nl.kolkos.domoticz.dashboard.models.commands.light.SwitchOffCommand;
import nl.kolkos.domoticz.dashboard.models.commands.light.SwitchOnCommand;
import nl.kolkos.domoticz.dashboard.services.DimmerService;
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
	public CommandLineRunner demo(SwitchService switchService, DimmerService dimmerService) {
		return (args) -> {
			CommandRunner commandRunner = new CommandRunner();

			Switch light1 = Switch.builder()
					.gid(6)
					.name("Light #1")
					.build();

			Switch light2 = Switch.builder()
					.gid(666)
					.name("Light #2")
					.build();

			Dimmer dimmer = Dimmer.builder()
					.gid(5666)
					.name("Random dimmer")
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
