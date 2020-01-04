package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import nl.kolkos.domoticz.dashboard.domoticz.models.PossibleActions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    public abstract boolean filter(DeviceType deviceType);

    public abstract String getStatus();

    public abstract List<PossibleActions> getPossibleActions();
}