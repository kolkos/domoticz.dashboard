package nl.kolkos.domoticz.dashboard.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.kolkos.domoticz.dashboard.models.Level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Dimmer {

    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

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

}
