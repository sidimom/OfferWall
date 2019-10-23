package my.test.testtask.API;

import java.util.List;

import io.reactivex.Single;
import my.test.testtask.Responces.ListNotesResponce;
import my.test.testtask.Responces.NoteResponce;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListAPI {

    @GET("trending")
    Single<List<ListNotesResponce>> getAllNotes();

    @GET("object/{id}")
    Single<NoteResponce> getNoteById(@Path("id") int id);
}
