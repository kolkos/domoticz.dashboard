package nl.kolkos.domoticz.dashboard.entities;

import lombok.Builder;
import lombok.Data;
import nl.kolkos.domoticz.dashboard.models.Level;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Dimmer {

    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

    public void on() {
        System.out.printf("Switching DIMMER '%s' with GID '%d' on%n", this.name, this.gid);
    }

    public void off() {
        System.out.printf("Switching DIMMER '%s' with GID '%d' off%n", this.name, this.gid);
    }

    public void setLvel(Level level) {
        System.out.printf("Switching DIMMER '%s' with GID '%d' to level '%d'%n", this.name, this.gid, level.getLevelToSet());
    }

}
