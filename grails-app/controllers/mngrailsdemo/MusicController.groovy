package mngrailsdemo

import org.springframework.beans.factory.annotation.Autowired

class MusicController {

    @Autowired
    ItunesSearch itunesSearch

    def index(String searchTerm) {
        if(searchTerm) {
            List<Album> searchResults = itunesSearch.search(searchTerm)

            [searchTerm: searchTerm, searchResults: searchResults]
        }
    }
}
