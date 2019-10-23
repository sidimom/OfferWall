package my.test.testtask.API;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListAPI {

    @GET("trending")
    Single<List<String>> getAllNotes();

    @GET("object/{id}")
    Single<String> getNoteById(@Path("id") int id);
}
