package ir.smrahmadi.instageramfarsi.view.SplashLoginFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import ir.smrahmadi.instageramfarsi.R;

/**
 * Created by lincoln on 3/13/18.
 */

public class First extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);




        YoYo.with(Techniques.RotateIn)
                .duration(1500)
                .playOn(view.findViewById(R.id.imgSetup1));

        return view;

    }
}

