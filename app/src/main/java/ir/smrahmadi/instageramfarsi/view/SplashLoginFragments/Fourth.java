package ir.smrahmadi.instageramfarsi.view.SplashLoginFragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ir.smrahmadi.instageramfarsi.CustomViews.AuthenticationDialog;
import ir.smrahmadi.instageramfarsi.R;
import ir.smrahmadi.instageramfarsi.interfaces.AuthentcationListener;
import ir.smrahmadi.instageramfarsi.util.SharedPreferencesConnector;
import ir.smrahmadi.instageramfarsi.view.Main;

import static ir.smrahmadi.instageramfarsi.Constants.ACCESS_TOKEN_KEY;

/**
 * Created by lincoln on 3/13/18.
 */

public class Fourth extends Fragment implements AuthentcationListener {


    @BindView(R.id.btn_login)
    Button btnLogin;


    private String token;
    private AuthenticationDialog authDialog ;

    View view ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_fourth, container, false);
        ButterKnife.bind(this, view);







        return view;

    }

    @OnClick(R.id.btn_login)
    public void clickLogin(){


        authDialog = new AuthenticationDialog(getActivity(),this);
        authDialog.setCancelable(true);

        YoYo.with(Techniques.Flash)
                .duration(1500)
                .repeat(2)
                .playOn(view.findViewById(R.id.btn_login));

        Toast.makeText(getContext(), "وارد اکانت اینستاگرام خود شوید", Toast.LENGTH_LONG).show();
        authDialog.show();





    }

    @Override
    public void onCodeRecived(String authToken) {

        if(authToken==null)
            return;

        SharedPreferencesConnector.writeString(getContext(),ACCESS_TOKEN_KEY,authToken);
        startActivity(new Intent(getContext(),Main.class));
        getActivity().finish();



    }
}
