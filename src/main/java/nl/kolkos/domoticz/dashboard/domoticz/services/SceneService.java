package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Scene;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.SceneRepository;
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
}
