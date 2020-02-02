package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.configurations.DomoticzConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger LOGGER = LogManager.getLogger(RestClient.class);

    public String callUrl(String url) {
        HttpHeaders headers = createHeaders(domoticzConfiguration.getUsername(), domoticzConfiguration.getPassword());


        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);


        return response.getBody();

    }

    private HttpHeaders createHeaders(String username, String password) {
        String plainCredentials = String.format("%s:%s", username, password);

        byte[] plainCredentialsBytes = plainCredentials.getBytes();
        byte[] base64CredentialsBytes = Base64.encodeBase64(plainCredentialsBytes);
        String base64Credentials = new String(base64CredentialsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        LOGGER.info(headers);

        return headers;
    }

}
