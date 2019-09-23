package com.rikkei.training.appbrower;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.rikkei.training.appbrower.databinding.FragmentWebviewBinding;

public class WebViewFragment extends Fragment {
    private FragmentWebviewBinding binding;
    private String url;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_webview, container, false);
        return binding.getRoot();
    }

    public String getUrl() {
        String url = binding.edtUrl.getText().toString();
        this.url = url;
        return url;
    }

    public void loadURL() {
        binding.textNewTab.setVisibility(View.INVISIBLE);
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.show();
        binding.webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dialog.dismiss();
            }
        });
        if (url.startsWith("https://")) {
            binding.webView.loadUrl(url);
        } else {
            binding.webView.loadUrl("https://" + url);
        }
    }
}
