package ir.smrahmadi.instageramfarsi.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ir.smrahmadi.instageramfarsi.R;

/**
 * Created by lincoln on 3/17/18.
 */

public class AdapterSearch extends BaseAdapter {

    private Activity context ;
    private ArrayList<Integer> userID = new ArrayList<>();
    private ArrayList<Integer> postID = new ArrayList<>();
    private ArrayList<String> imgUrl = new ArrayList<>();

    public AdapterSearch(FragmentActivity activity, ArrayList<Integer> userIdSearch, ArrayList<Integer> postIdSearch, ArrayList<String> imgUrlSearch) {
        context=activity;
        userID=userIdSearch;
        postID=postIdSearch;
        imgUrl=imgUrlSearch;
    }


    @Override
    public int getCount() {
        return userID.size();
    }

    @Override
    public Object getItem(int position) {
        return postID.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userID.get(position);
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.grid_search,parent,false);

        ImageView grid_image = convertView.findViewById(R.id.grid_image);

        Picasso.get().load(imgUrl.get(position)).into(grid_image);



        return convertView;
    }


}
