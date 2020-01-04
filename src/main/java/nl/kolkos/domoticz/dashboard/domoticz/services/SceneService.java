package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Scene;
import nl.kolkos.domoticz.dashboard.domoticz.exceptions.DeviceNotFoundException;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.SceneRepository;
import nl.kolkos.domoticz.dashboard.domoticz.util.Constants;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SceneService {
    private final SceneRepository sceneRepository;

    public Scene save(Scene scene) {
        return sceneRepository.save(scene);
    }

    public Iterable<Scene> findAll() {
        return sceneRepository.findAll();
    }

    public Scene getById(int gid) throws DeviceNotFoundException {
        String errorMessage = String.format(Constants.DEVICE_NOT_FOUND_ERROR_MESSAGE_TEMPLATE, "Scene", gid);
        return sceneRepository.getByGid(gid).orElseThrow(() -> new DeviceNotFoundException(errorMessage));
    }
}
