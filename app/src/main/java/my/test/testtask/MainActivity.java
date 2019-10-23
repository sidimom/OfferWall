package my.test.testtask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import my.test.testtask.MVP.MyPresenter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_note)
    TextView tv_note;

    @BindView(R.id.web_view)
    WebView web_view;

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
        ButterKnife.bind(this);

        presenter = new MyPresenter();
        presenter.attachView(this);
    }

    @OnClick(R.id.btn_changeView)
    void changeView(){
        presenter.changeItem();
    }

    public void showToast(String textError) {
        Toast.makeText(this, textError, Toast.LENGTH_SHORT).show();
    }

    public void setTextNote(String textNote) {
        tv_note.setText(textNote);
    }

    public void setWebView(String url) {
        web_view.loadUrl(url);
    }
}
