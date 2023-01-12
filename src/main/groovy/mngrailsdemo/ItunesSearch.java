package mngrailsdemo;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ItunesSearch {

    private final ItunesClient itunesClient;

    public ItunesSearch(ItunesClient itunesClient) {
        this.itunesClient = itunesClient;
    }

    List<Album> search(String searchTerm) {
        SearchResult searchResult = itunesClient.search(searchTerm);
        return searchResult.getResults();
    }
}
