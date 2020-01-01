package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Device {
    @Id
    @GeneratedValue
    long id;
    @NotNull
    int gid;
    @NotNull
    String name;

    abstract boolean filter(DeviceType deviceType);

    abstract String getStatus();
}