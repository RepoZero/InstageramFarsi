package ir.smrahmadi.instageramfarsi.Adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;

import ir.smrahmadi.instageramfarsi.R;

/**
 * Created by lincoln on 3/17/18.
 */

public class AdapterStories extends RecyclerView.Adapter<AdapterStories.MyViewHolder> {

    private Activity context;
    private ArrayList<Integer> userId = new ArrayList<>();
    private ArrayList<String> imageUrl = new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgStorie;

        public MyViewHolder(View view) {
            super(view);
            imgStorie = view.findViewById(R.id.imgStorie);

        }
    }

    public AdapterStories(FragmentActivity activity, ArrayList<Integer> userIdStorie, ArrayList<String> profileImgUrlStorie) {
        this.context=activity;
        this.userId=userIdStorie;
        this.imageUrl=profileImgUrlStorie;

    }





    @NonNull
    @Override
    public AdapterStories.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.storie_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterStories.MyViewHolder holder, int position) {

        Log.e("a",imageUrl.get(position));
        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.BLACK)
                .borderWidthDp(1)
                .cornerRadiusDp(1)
                .oval(true)
                .build();


        Picasso.get().load(imageUrl.get(position)).transform(transformation).into(holder.imgStorie);
    }

    @Override
    public int getItemCount() {
        return imageUrl.size();
    }
}
