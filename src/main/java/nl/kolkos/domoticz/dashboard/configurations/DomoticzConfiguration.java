package nl.kolkos.domoticz.dashboard.configurations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class DomoticzConfiguration {
    @Value("${domoticz.url.base}")
    private String baseUrl;

}
