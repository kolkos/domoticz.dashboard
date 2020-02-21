package nl.kolkos.domoticz.dashboard.domoticz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomoticzResponse {
    private String status;
    private String title;
    private StatusResult[] result;


    public void appendToStatusResult(StatusResult[] result) {
        this.result = ArrayUtils.addAll(this.result, result);
    }

}
