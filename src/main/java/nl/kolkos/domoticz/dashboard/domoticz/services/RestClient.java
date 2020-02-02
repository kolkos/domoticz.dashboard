package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
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
        String plainCredentials = String.format("%s:%s", username, password);

        byte[] plainCredentialsBytes = plainCredentials.getBytes();
        byte[] base64CredentialsBytes = Base64.encodeBase64(plainCredentialsBytes);
        String base64Credentials = new String(base64CredentialsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        log.info(headers);

        return headers;
    }

}
