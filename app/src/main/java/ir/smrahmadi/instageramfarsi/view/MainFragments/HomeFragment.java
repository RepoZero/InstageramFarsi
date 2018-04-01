package ir.smrahmadi.instageramfarsi.view.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.smrahmadi.instageramfarsi.Adapter.AdapterListPost;
import ir.smrahmadi.instageramfarsi.App;
import ir.smrahmadi.instageramfarsi.R;

import static ir.smrahmadi.instageramfarsi.App.*;


/**
 * Created by lincoln on 3/13/18.
 */

public class HomeFragment extends Fragment {


    @BindView(R.id.imgTakeImage)protected ImageView imgTakeImage ;
    @BindView(R.id.imgMessages)protected ImageView imgMessages ;
//    @BindView(R.id.HomeListView)protected ListView lsPost;


    boolean lstIntit =false;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);


        ButterKnife.bind(this,view);

        lsPost = view.findViewById(R.id.HomeListView);


        lsPost.setDivider(null);

        lstIntit=true ;



        userIDs.clear();
        postIDs.clear();
        profileImgUrls.clear();
        contentUrls.clear();
        names.clear();
        desc.clear();
        type.clear();


        userIDs.add(551);
        postIDs.add(551);
        profileImgUrls.add("https://www.fotkaplus.co.uk/wp-content/uploads/2016/04/carousel-profile-4.jpg");
        contentUrls.add("https://as2.cdn.asset.aparat.com/aparat-video/cb6f48eb7f26933f9865f62d758881bb9898661-480p__31898.mp4");
        names.add("M");
        desc.add(getResources().getString(R.string.Lorem_persian));
        type.add(1);

            userIDs.add(551);
            postIDs.add(551);
            profileImgUrls.add("https://kelley.iu.edu/images/vitae/kolba-768.jpg");
            contentUrls.add("https://asayad.com/wp-content/uploads/2014/10/Professional-Programmer.png");
            names.add("Programmer");
            desc.add(getResources().getString(R.string.Lorem_persian));
            type.add(0);

            userIDs.add(551);
            postIDs.add(551);
            profileImgUrls.add("https://pbs.twimg.com/profile_images/929030268043845633/ilS1ri2v_400x400.jpg");
            contentUrls.add("https://cdn01.zoomit.ir/2017/2/c5943041-4b2a-49dc-86d4-7d723256eca6.jpg");
            names.add("reza");
            desc.add(getResources().getString(R.string.Lorem_persian));
            type.add(0);





            userIDs.add(551);
            postIDs.add(551);
            profileImgUrls.add("https://pbs.twimg.com/profile_images/929030268043845633/ilS1ri2v_400x400.jpg");
            contentUrls.add("http://gerdali.com/wp-content/uploads/2015/02/201.jpg");
            names.add("Mohammad Reza");
            desc.add(getResources().getString(R.string.Lorem_english));
            type.add(0);


            userIDs.add(551);
            postIDs.add(551);
            profileImgUrls.add("https://www.fotkaplus.co.uk/wp-content/uploads/2016/04/carousel-profile-4.jpg");
            contentUrls.add("https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/68dd54ca-60cf-4ef7-898b-26d7cbe48ec7/10-dithering-opt.jpg");
            names.add("M");
            desc.add(getResources().getString(R.string.Lorem_persian));
            type.add(0);




        userIDs.add(551);
        postIDs.add(551);
        profileImgUrls.add("https://www.fotkaplus.co.uk/wp-content/uploads/2016/04/carousel-profile-4.jpg");
        contentUrls.add("https://as8.cdn.asset.aparat.com/aparat-video/9ecb703d4c8958d39d6a8c0bd61698b79905102-360p__83400.mp4");
        names.add("M");
        desc.add(getResources().getString(R.string.Lorem_persian));
        type.add(1);





            adapterListPost =  new AdapterListPost(getActivity(),userIDs,postIDs,profileImgUrls,contentUrls,names,desc,type);


            lsPost.setAdapter(adapterListPost);



        imgTakeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeIn)
                        .duration(700)
                        .playOn(view.findViewById(R.id.imgTakeImage));
            }
        });


        imgMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeIn)
                        .duration(700)
                        .playOn(view.findViewById(R.id.imgMessages));
            }
        });

        return view;

    }

    public void setUserVisibleHint(boolean isVisibleToUser){

        if(!isVisibleToUser && lstIntit){
            App.lsPost.setAdapter(null);
        }else if(isVisibleToUser && lstIntit) {
            App.lsPost.setAdapter(adapterListPost);
            lstIntit=false;
        }



    }

}

