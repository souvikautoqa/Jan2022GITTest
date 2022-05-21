package core;

public interface EndPoint {
    String getRestMethodPath();

    String getHostUrl();

    HttpMethod getRestHttpMethodType();

    ParametersType getRestParametersType();

}
