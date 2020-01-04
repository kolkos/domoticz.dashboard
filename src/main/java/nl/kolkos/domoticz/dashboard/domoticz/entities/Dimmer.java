package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.models.Level;
import nl.kolkos.domoticz.dashboard.domoticz.models.PossibleActions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Dimmer extends Device{

    private int minLevel;
    private int maxLevel;

    public String on() {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=On", this.gid);
    }

    public String off() {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=Off", this.gid);
    }

    public String setLevel(Level level) {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=Set Level&level=%d", this.gid, level.getLevelToSet());
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=devices&rid=%d", this.gid);
    }

    @Override
    public List<PossibleActions> getPossibleActions() {
        return Arrays.asList(PossibleActions.ON, PossibleActions.OFF, PossibleActions.SET_LEVEL, PossibleActions.GET_STATUS);
    }

    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.DIMMER;
    }
}
