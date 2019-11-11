package nl.kolkos.domoticz.dashboard.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Switch {
    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

    public void on(){
        System.out.printf("Switching SWITCH '%s' with GID '%d' on%n", this.name, this.gid);
    }

    public void off(){
        System.out.printf("Switching SWITCH '%s' with GID '%d' off%n", this.name, this.gid);
    }

}
