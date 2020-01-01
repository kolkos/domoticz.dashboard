package nl.kolkos.domoticz.dashboard.domoticz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomoticzResponse {
    private String status;
    private String title;
    private StatusResult[] result;
}
