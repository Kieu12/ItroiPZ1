package airplane.additions;

import airplane.service.AirplaneServiceRestImpl;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class AirplaneInfoApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(AirplaneServiceRestImpl.class);

        return classes;
    }
}
