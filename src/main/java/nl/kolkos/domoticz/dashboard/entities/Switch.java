package nl.kolkos.domoticz.dashboard.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Switch {
    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

    public void on(){
        System.out.println("Switch LIGHT on");
    }

    public void off(){
        System.out.println("Switch LIGHT off");
    }

}
