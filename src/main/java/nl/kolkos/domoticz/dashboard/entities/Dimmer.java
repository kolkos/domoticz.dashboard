package nl.kolkos.domoticz.dashboard.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Dimmer {

    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

    public void on() {
        System.out.println("Switching DIMMER on");
    }

    public void off() {
        System.out.println("Switching DIMMER off");
    }

    public void setLvel(Level level) {
        System.out.println("Setting DIMMER level to " + level.getLevelToSet());
    }

}
