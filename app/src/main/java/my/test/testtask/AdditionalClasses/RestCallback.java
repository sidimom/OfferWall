package my.test.testtask.AdditionalClasses;

import java.util.List;

public interface RestCallback {

    void onAllNotesAreReceived(List<String> notes);

    void onNoteIsReceived(String note);

    void onError(String textError);
}
