package my.test.testtask.MVP;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import my.test.testtask.API.ListAPI;
import my.test.testtask.AdditionalClasses.RestCallback;
import retrofit2.Retrofit;

class MyModel {

    private Retrofit retrofit;
    private ListAPI listAPI;

    MyModel(Retrofit _retrofit) {
        retrofit = _retrofit;
        listAPI = retrofit.create(ListAPI.class);
    }

    void getAllNotes(final RestCallback callback){
        listAPI.getAllNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<String>>() {
                    @Override
                    public void onSuccess(List<String> notes) {
                        callback.onAllNotesAreReceived(notes);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError("Error: " + e.toString());
                    }
                });
    }

    void getNoteById(final RestCallback callback, int id){
        listAPI.getNoteById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<String>() {
                    @Override
                    public void onSuccess(String note) {
                        callback.onNoteIsReceived(note);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError("Error: " + e.toString());
                    }
                });
    }



}
