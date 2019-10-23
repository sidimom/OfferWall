package my.test.testtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import my.test.testtask.MVP.MyPresenter;

public class MainActivity extends AppCompatActivity {

    MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void init() {
        presenter = new MyPresenter();
        presenter.attachView(this);
    }

    public void showToast(String textError) {
        Toast.makeText(this, textError, Toast.LENGTH_SHORT).show();
    }
}
