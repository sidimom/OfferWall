package my.test.testtask.MVP;

import java.util.List;

import my.test.testtask.AdditionalClasses.RestCallback;
import my.test.testtask.MainActivity;
import my.test.testtask.Responces.ListNotesResponce;
import my.test.testtask.Responces.NoteResponce;
import my.test.testtask.AdditionalClasses.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class MyPresenter implements RestCallback {

    private MainActivity view;
    private MyModel model;
    private Retrofit retrofit;
    private List<ListNotesResponce> notes;
    private int currentId;

    public void attachView(MainActivity activity){
        view = activity;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.REQUEST_LINK)
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
    public void onAllNotesAreReceived(List<ListNotesResponce> listNotes) {
        notes = listNotes;
        if (notes == null
            | notes.size() == 0){
            view.showToast("List is empty!");
        }else{
            currentId = 0;
            getNoteById();
            //model.getNoteById(this, notes.get(currentId).getId());
        }
        //view.showToast("List is received. Size = " + listNotes.size());
    }

    public void changeItem() {
        currentId++;
        if (currentId == notes.size()){
            currentId = 0;
        }
        getNoteById();
    }

    private void getNoteById() {
        model.getNoteById(this, notes.get(currentId).getId());
    }

    @Override
    public void onNoteIsReceived(NoteResponce note) {

        switch (note.getType()){
            case Constants.OPTION_WEB:
                view.setTextNote("");
                view.setWebView(note.getUrl());
                return;
            case Constants.OPTION_TEXT:
                view.setTextNote(note.getContents());
                view.setWebView("about:blank");
                return;
            default:
                view.setTextNote("");
                view.setWebView("about:blank");
        }
    }

    @Override
    public void onError(String textError) {
        view.showToast(textError);
    }


}
