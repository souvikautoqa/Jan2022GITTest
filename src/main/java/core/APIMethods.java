package core;

public class APIMethods {

    public static APIMethod CREATE_MOVIE = new APIMethod(Config.getProperty("apiurl"), "movie", HttpMethod.POST);
    public static APIMethod UPDATE_MOVIE = new APIMethod(Config.getProperty("apiurl"), "movie/@@param", HttpMethod.PUT);
    public static APIMethod GET_MOVIE = new APIMethod(Config.getProperty("apiurl"), "movies", HttpMethod.GET);
    public static APIMethod DELETE_MOVIE = new APIMethod(Config.getProperty("apiurl"), "movie/@@param", HttpMethod.DELETE);

}
