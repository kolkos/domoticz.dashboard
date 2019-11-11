package nl.kolkos.domoticz.dashboard.entities;

import lombok.Data;

@Data
public class Level {
    private long percentage;
    private long levelToSet;
}
