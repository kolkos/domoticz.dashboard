package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public abstract class Device {
    @Id
    @GeneratedValue
    long id;
    int gid;
    String name;

    abstract boolean filter(DeviceType deviceType);

    abstract String getStatus();
}