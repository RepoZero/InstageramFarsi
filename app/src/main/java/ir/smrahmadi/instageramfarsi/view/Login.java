package ir.smrahmadi.instageramfarsi.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.smrahmadi.instageramfarsi.CustomViews.AuthenticationDialog;
import ir.smrahmadi.instageramfarsi.R;
import ir.smrahmadi.instageramfarsi.util.SharedPreferencesConnector;
import ir.smrahmadi.instageramfarsi.util.ViewPagerAdapter;
import ir.smrahmadi.instageramfarsi.view.SplashLoginFragments.First;
import ir.smrahmadi.instageramfarsi.view.SplashLoginFragments.Second;
import ir.smrahmadi.instageramfarsi.view.SplashLoginFragments.Third;
import ir.smrahmadi.instageramfarsi.view.SplashLoginFragments.Fourth;

import static ir.smrahmadi.instageramfarsi.Constants.ACCESS_TOKEN_KEY;

public class Login extends AppCompatActivity {

    @BindView(R.id.viewpager)ViewPager viewPager ;
    @BindView(R.id.imgCircleSetup1) ImageView imgsetup1;
    @BindView(R.id.imgCircleSetup2) ImageView imgsetup2;
    @BindView(R.id.imgCircleSetup3) ImageView imgsetup3;
    @BindView(R.id.imgCircleSetup4) ImageView imgsetup4;

    private String token;
    private AuthenticationDialog authDialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);










        token = SharedPreferencesConnector.readString(this,ACCESS_TOKEN_KEY,null);

        if(token!=null){
            startActivity(new Intent(this,Main.class));
            finish();
        }



        setupViewPager(viewPager);



        imgsetup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        imgsetup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        imgsetup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });


        imgsetup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });


        final Drawable drwableBlack = getResources().getDrawable(R.drawable.circle_black) ;
        final Drawable drwableAccent = getResources().getDrawable(R.drawable.circle_accent) ;


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {





                if(position==0){
                    imgsetup1.setImageDrawable(drwableAccent);
                    imgsetup2.setImageDrawable(drwableBlack);
                    imgsetup3.setImageDrawable(drwableBlack);
                    imgsetup4.setImageDrawable(drwableBlack);

                    YoYo.with(Techniques.RotateIn)
                            .duration(1500)
                            .playOn(findViewById(R.id.imgSetup1));

                }else if (position==1){
                    imgsetup1.setImageDrawable(drwableBlack);
                    imgsetup2.setImageDrawable(drwableAccent);
                    imgsetup3.setImageDrawable(drwableBlack);
                    imgsetup4.setImageDrawable(drwableBlack);


                    YoYo.with(Techniques.RotateIn)
                            .duration(1500)
                            .playOn(findViewById(R.id.imgSetup2));

                }else if(position==2){
                    imgsetup1.setImageDrawable(drwableBlack);
                    imgsetup2.setImageDrawable(drwableBlack);
                    imgsetup3.setImageDrawable(drwableAccent);
                    imgsetup4.setImageDrawable(drwableBlack);

                    YoYo.with(Techniques.RotateIn)
                            .duration(1500)
                            .playOn(findViewById(R.id.imgSetup3));

                }else if(position==3) {
                    imgsetup1.setImageDrawable(drwableBlack);
                    imgsetup2.setImageDrawable(drwableBlack);
                    imgsetup3.setImageDrawable(drwableBlack);
                    imgsetup4.setImageDrawable(drwableAccent);


                }
            }





            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

        imgsetup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                imgsetup1.setImageDrawable(drwableAccent);
                imgsetup2.setImageDrawable(drwableBlack);
                imgsetup3.setImageDrawable(drwableBlack);
                imgsetup4.setImageDrawable(drwableBlack);
            }
        });


        imgsetup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                imgsetup1.setImageDrawable(drwableBlack);
                imgsetup2.setImageDrawable(drwableAccent);
                imgsetup3.setImageDrawable(drwableBlack);
                imgsetup4.setImageDrawable(drwableBlack);

            }
        });


        imgsetup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);

                imgsetup1.setImageDrawable(drwableBlack);
                imgsetup2.setImageDrawable(drwableBlack);
                imgsetup3.setImageDrawable(drwableAccent);
                imgsetup4.setImageDrawable(drwableBlack);

            }
        });


        imgsetup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);


                imgsetup1.setImageDrawable(drwableBlack);
                imgsetup2.setImageDrawable(drwableBlack);
                imgsetup3.setImageDrawable(drwableBlack);
                imgsetup4.setImageDrawable(drwableAccent);
            }
        });
    }





    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new First(), "");
        adapter.addFragment(new Second(), "");
        adapter.addFragment(new Third(), "");
        adapter.addFragment(new Fourth(), "");
        viewPager.setAdapter(adapter);

    }



}
