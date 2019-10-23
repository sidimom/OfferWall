package my.test.testtask.MVP;

import java.util.List;

import my.test.testtask.AdditionalClasses.RestCallback;
import my.test.testtask.MainActivity;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MyPresenter implements RestCallback {

    private MainActivity view;
    private MyModel model;
    private Retrofit retrofit;
    private List<String> notes;

    public void attachView(MainActivity activity){
        view = activity;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demo0040494.mockable.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        model = new MyModel(retrofit);

        model.getAllNotes(this);

    }

    public void detachView(){
        view = null;
        model = null;
        retrofit = null;
    }

    @Override
    public void onAllNotesAreReceived(List<String> listNotes) {
        /*notes = listNotes;
        if (notes == null
            | notes.size() == 0){
            view.showToast("List is empty!");
        }else{
            model.getNoteById(this, Integer.parseInt(notes.get(0)));
        }*/
        view.showToast("List is received. Size = " + listNotes.size());
    }

    @Override
    public void onNoteIsReceived(String note) {
        view.showToast(note);
    }

    @Override
    public void onError(String textError) {
        view.showToast(textError);
    }
}
