package com.example.nghia.thanlo;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by nghia on 8/1/17.
 */

public class KetQuaFragment extends Fragment {
    View ketQuaView;
    WebView webView;
    String url = "http://ketqua.net";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ketQuaView=  inflater.inflate(R.layout.ket_qua,container,false);
        webView =ketQuaView.findViewById(R.id.webview);
        new Title().execute();
        return ketQuaView;
    }

    private class Title extends AsyncTask<Void, Void, Void> {
        String title;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                Elements elementButton=document.select("button");
                elementButton.remove();
                // Get the html document title
                Elements description = document.select("table[id=result_tab_mb]");

                title= description.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            // TextView txttitle = (TextView) findViewById(R.id.tvContent);
            // txttitle.setText(title);
            WebView wv = (WebView)ketQuaView.findViewById(R.id.webview);
            title="<head>\n" +
                    "<style type=\"text/css\">\n" +
                    "table, th, td { border: 1px solid black;}\n" +
                    "</style>\n" +
                    "</head>"+title;
            wv.getSettings().setJavaScriptEnabled(true);
            wv.loadDataWithBaseURL(null, title, "text/html", "utf-8", null);
        }
    }

}
