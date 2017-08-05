package com.example.nghia.thanlo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nghia on 8/1/17.
 */

public class LaySoFragment extends Fragment {
    View laySoView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        laySoView=  inflater.inflate(R.layout.lay_so,container,false);
        return laySoView;

    }


}
