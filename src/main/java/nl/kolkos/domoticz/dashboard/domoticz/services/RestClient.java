package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.configurations.DomoticzConfiguration;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class RestClient {
    private final RestTemplate restTemplate;
    private final DomoticzConfiguration domoticzConfiguration;

    public String callUrl(String url) {
        HttpHeaders headers = createHeaders(domoticzConfiguration.getUsername(), domoticzConfiguration.getPassword());


        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);


        return response.getBody();

    }

    private HttpHeaders createHeaders(String username, String password) {
        String plainCreds = String.format("%s:%s", username, password);

        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        return headers;
    }

}
