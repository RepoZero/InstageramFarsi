package ir.smrahmadi.instageramfarsi.CustomViews;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import ir.smrahmadi.instageramfarsi.Constants;
import ir.smrahmadi.instageramfarsi.R;
import ir.smrahmadi.instageramfarsi.interfaces.AuthentcationListener;

/**
 * Created by lincoln on 3/13/18.
 */

public class AuthenticationDialog extends Dialog {


    private AuthentcationListener listener ;
    private Context context ;
    private WebView webView ;


    private final String url = Constants.BASE_URL
            + "oauth/authorize/?client_id="
            + Constants.INSTAGRAM_CLIENT_ID
            + "&redirect_uri="
            + Constants.REDIRECT_URI
            + "&response_type=token"
            + "&display=touch&scope=basic+public_content+follower_list+likes+comments+relationships";

    public AuthenticationDialog(@NonNull Context context, AuthentcationListener listener) {
        super(context);

        this.context=context;
        this.listener=listener;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView( R.layout.auth_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initializeWebView();
    }

    private void initializeWebView() {
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl(url);
        webView.zoomOut();
        webView.zoomOut();
        webView.setWebViewClient(new WebViewClient(){

            String access_token ;
            boolean authComplete ;

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

               if(url.contains("#access_token=") && !authComplete){
                   Uri uri = Uri.parse(url);
                   access_token = uri.getEncodedFragment();
                   access_token = access_token.substring(access_token.lastIndexOf("="));
                   Log.e("access token :: ",access_token);
                   authComplete=true;
                   listener.onCodeRecived(access_token);
                   dismiss();

               }else if(url.contains("?error")) {
                dismiss();
                Log.e("access token :: ","getting error access token fetching");

               }
            }
        });

    }
}
