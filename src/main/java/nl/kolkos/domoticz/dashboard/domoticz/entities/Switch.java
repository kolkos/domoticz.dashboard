package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Switch {
    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

    public String on() {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=On", this.gid);
    }

    public String off() {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=Off", this.gid);
    }

}
