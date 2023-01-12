package mngrailsdemo;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {

    private int resultCount;
    private List<Album> results = new ArrayList();

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Album> getResults() {
        return results;
    }

    public void setResults(List<Album> results) {
        this.results = results;
    }
}
