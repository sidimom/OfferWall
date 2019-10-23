package my.test.testtask.AdditionalClasses;

import java.util.List;

import my.test.testtask.Responces.ListNotesResponce;
import my.test.testtask.Responces.NoteResponce;

public interface RestCallback {

    void onAllNotesAreReceived(List<ListNotesResponce> notes);

    void onNoteIsReceived(NoteResponce note);

    void onError(String textError);
}
