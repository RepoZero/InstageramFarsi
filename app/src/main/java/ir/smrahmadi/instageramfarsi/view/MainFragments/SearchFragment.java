package ir.smrahmadi.instageramfarsi.view.MainFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.smrahmadi.instageramfarsi.Adapter.AdapterSearch;
import ir.smrahmadi.instageramfarsi.App;
import ir.smrahmadi.instageramfarsi.R;

import static ir.smrahmadi.instageramfarsi.App.*;


/**
 * Created by lincoln on 3/13/18.
 */

public class SearchFragment extends Fragment {



    @BindView(R.id.gridSearch)protected GridView gridSearch;
    @BindView(R.id.edtSearch)protected EditText edtSearch;

    AdapterSearch  adapterSearch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        ButterKnife.bind(this,view);






        userIdSearch.clear();
        postIdSearch.clear();
        imgUrlSearch.clear();

        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);


        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);


        imgUrlSearch.add("https://www2.cs.arizona.edu/solar/solar.512.512.gif");
        imgUrlSearch.add("https://umbra.nascom.nasa.gov/eit/images/eclipse/eit_20010621_0834_171_half.gif");
        imgUrlSearch.add("https://digiro.ir/wp-content/uploads/2017/09/iPhone-8.jpg");
        imgUrlSearch.add("https://www.apple-nic.com/images/blog/nic-content/6066/iPhone-8.jpg");



        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);


        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);


        imgUrlSearch.add("https://www2.cs.arizona.edu/solar/solar.512.512.gif");
        imgUrlSearch.add("https://umbra.nascom.nasa.gov/eit/images/eclipse/eit_20010621_0834_171_half.gif");
        imgUrlSearch.add("https://digiro.ir/wp-content/uploads/2017/09/iPhone-8.jpg");
        imgUrlSearch.add("https://www.apple-nic.com/images/blog/nic-content/6066/iPhone-8.jpg");


        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);


        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);


        imgUrlSearch.add("https://www2.cs.arizona.edu/solar/solar.512.512.gif");
        imgUrlSearch.add("https://umbra.nascom.nasa.gov/eit/images/eclipse/eit_20010621_0834_171_half.gif");
        imgUrlSearch.add("https://digiro.ir/wp-content/uploads/2017/09/iPhone-8.jpg");
        imgUrlSearch.add("https://www.apple-nic.com/images/blog/nic-content/6066/iPhone-8.jpg");


        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);


        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);


        imgUrlSearch.add("https://www2.cs.arizona.edu/solar/solar.512.512.gif");
        imgUrlSearch.add("https://umbra.nascom.nasa.gov/eit/images/eclipse/eit_20010621_0834_171_half.gif");
        imgUrlSearch.add("https://digiro.ir/wp-content/uploads/2017/09/iPhone-8.jpg");
        imgUrlSearch.add("https://www.apple-nic.com/images/blog/nic-content/6066/iPhone-8.jpg");


        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);


        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);


        imgUrlSearch.add("https://www2.cs.arizona.edu/solar/solar.512.512.gif");
        imgUrlSearch.add("https://umbra.nascom.nasa.gov/eit/images/eclipse/eit_20010621_0834_171_half.gif");
        imgUrlSearch.add("https://digiro.ir/wp-content/uploads/2017/09/iPhone-8.jpg");
        imgUrlSearch.add("https://www.apple-nic.com/images/blog/nic-content/6066/iPhone-8.jpg");


        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);
        userIdSearch.add(1);


        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);
        postIdSearch.add(1);


        imgUrlSearch.add("https://www2.cs.arizona.edu/solar/solar.512.512.gif");
        imgUrlSearch.add("https://umbra.nascom.nasa.gov/eit/images/eclipse/eit_20010621_0834_171_half.gif");
        imgUrlSearch.add("https://digiro.ir/wp-content/uploads/2017/09/iPhone-8.jpg");
        imgUrlSearch.add("https://www.apple-nic.com/images/blog/nic-content/6066/iPhone-8.jpg");

        adapterSearch = new AdapterSearch(getActivity(),userIdSearch,postIdSearch,imgUrlSearch);

        gridSearch.setAdapter(adapterSearch);




        return view;

    }


}

