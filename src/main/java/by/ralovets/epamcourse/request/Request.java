package by.ralovets.epamcourse.request;

import java.util.EnumMap;

public class Request {

    private final EnumMap<ParameterType, Object> params = new EnumMap<>(ParameterType.class);

    public Request(EnumMap<ParameterType, Object> params) {
    }

    public void addParam(ParameterType type, Object object) {
        params.put(type, object);
    }

    public Object getParam(ParameterType type) {
        return params.get(type);
    }
}
