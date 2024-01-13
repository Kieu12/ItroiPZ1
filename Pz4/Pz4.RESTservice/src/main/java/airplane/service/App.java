package airplane.service;

import airplane.service.rest.JSONMessageBodyWriter;
import airplane.service.rest.ServiceExceptionMapper;
import airplane.service.rest.TextPlainMessageBodyWriter;
import airplane.service.rest.XMLItemMessageBodyWriter;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath(Constants.APPLICATION_PATH)
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(AirplaneServiceRestImpl.class);
        classes.add(XMLItemMessageBodyWriter.class);
        classes.add(TextPlainMessageBodyWriter.class);
        classes.add(JSONMessageBodyWriter.class);
        classes.add(ServiceExceptionMapper.class);
        return Collections.unmodifiableSet(classes);
    }
}
