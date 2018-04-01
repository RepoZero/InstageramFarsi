package ir.smrahmadi.instageramfarsi.view;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import eu.long1.spacetablayout.SpaceTabLayout;
import ir.smrahmadi.instageramfarsi.R;
import ir.smrahmadi.instageramfarsi.view.MainFragments.AddFragment;
import ir.smrahmadi.instageramfarsi.view.MainFragments.HomeFragment;
import ir.smrahmadi.instageramfarsi.view.MainFragments.LikeFragment;
import ir.smrahmadi.instageramfarsi.view.MainFragments.PersonFragment;
import ir.smrahmadi.instageramfarsi.view.MainFragments.SearchFragment;


public class Main extends AppCompatActivity {

    @BindView(R.id.viewPager) protected ViewPager viewPager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        final List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new SearchFragment());
        fragmentList.add(new AddFragment());
        fragmentList.add(new LikeFragment());
        fragmentList.add(new PersonFragment());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        final SpaceTabLayout tabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);

        //we need the savedInstanceState to get the position
        tabLayout.initialize(viewPager, getSupportFragmentManager(),
                fragmentList, savedInstanceState);


        tabLayout.setTabFourIcon(getResources().getDrawable(R.drawable.heart));
        tabLayout.setTabFiveIcon(getResources().getDrawable(R.drawable.person));








    }

}
