import com.google.gson.Gson;
import com.udacityclass.android.popularmovies.PopularMovieResponse;
import com.udacityclass.android.popularmovies.Movie;
import com.udacityclass.android.popularmovies.utility.NetworkUtils;

import org.json.JSONObject;
import org.junit.Test;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class SimpleTest {
    @Test
    public void testSth()throws Exception{
        URL url = NetworkUtils.buildUrl();
        String rawJson = NetworkUtils.getResponseFromHttpUrl(url);

        Gson gson = new Gson();
        PopularMovieResponse response = gson.fromJson(rawJson, PopularMovieResponse.class);
        Movie[] movies = response.getResults();
        Arrays.asList(movies).forEach(i -> System.out.println(i.getPoster_path()));

        assertTrue(true);
    }
    Test
    @
    public void testGetAllImagePath() throws Exception{
        List<Movie> movies= NetworkUtils.getMovieDataFromJson(NetworkUtils.getResponseFromHttpUrl(NetworkUtils.buildUrl()));
        movies.forEach(i -> System.out.println(i.getPoster_path()));
    }
}
