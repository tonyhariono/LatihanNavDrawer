package id.co.imastudio.latihannavdrawer;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;

public class WebActivity extends AppCompatActivity {

    WebView web;
    ProgressBar progressBar;

    AutoCompleteTextView txtUrl;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        //munculin tombol balik
        getSupportActionBar().setHomeButtonEnabled(true);

        //bisa klik balik
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        web=(WebView) findViewById(R.id.webview);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setBuiltInZoomControls(true);
        web.getSettings().setAllowFileAccess(true);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);

        progressBar.setMax(100);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setIndeterminate(true);

        txtUrl=(AutoCompleteTextView) findViewById(R.id.txtUrl);
        btnOk=(Button) findViewById(R.id.btnOk);

        web.setWebViewClient(new WebViewClient(){
            //generate ovveride method
            //onPageFinished


            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // loading start
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                // loading hide
                getSupportActionBar().setTitle(web.getTitle());
                progressBar.setVisibility(View.INVISIBLE);
                            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl("http://" + txtUrl.getText().toString());
            }
        });

//        web.loadUrl("http://www.facebook.com");
    }

    //back ke halaman web sebelumnya
    //generate override method onBackPressed

    @Override
    public void onBackPressed() {
        if(web.canGoBack()){
            web.goBack();
        } else {
            super.onBackPressed();
        }
            }

    //langkah kedua generate ovveride method dengan nama onConfigurationChanged
    //supaya kalau dipindah landscape, tampilan tidak reload ulang
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
