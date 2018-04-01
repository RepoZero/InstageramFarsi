package ir.smrahmadi.instageramfarsi.Adapter;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import com.ablanco.zoomy.Zoomy;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;


import ir.smrahmadi.instageramfarsi.R;



/**
 * Created by lincoln on 3/14/18.
 */

public class AdapterListPost extends BaseAdapter {


    private Activity context ;
    private ArrayList<Integer> userIDs = new ArrayList<Integer>();
    private ArrayList<Integer> postIDs = new ArrayList<Integer>();
    private ArrayList<String> profileImgUrls = new ArrayList<String>();
    private ArrayList<String> contentUrls = new ArrayList<String>();
    private ArrayList<String> names = new ArrayList<String>();
    private ArrayList<String> desc = new ArrayList<String>();
    private ArrayList<Integer> type = new ArrayList<Integer>();


    private boolean like = false ;
    private boolean bookmark = false ;


    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;


    private int tap=0;

    public AdapterListPost(Activity context ,
                           ArrayList<Integer> userIDs,
                            ArrayList<Integer> postIDs,
                           ArrayList<String> profileImgUrls,
                           ArrayList<String> contentUrls,
                           ArrayList<String> names,
                           ArrayList<String> desc,
                           ArrayList<Integer> type){


        this.context=context;
        this.userIDs=userIDs;
        this.postIDs=postIDs;
        this.profileImgUrls=profileImgUrls;
        this.contentUrls=contentUrls;
        this.names=names;
        this.desc=desc;
        this.type=type;

    }




    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userIDs.get(position);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//
//        if(position==0){
//            convertView = LayoutInflater.from(context).inflate(R.layout.stories, parent, false);
//
//
//
//            RecyclerView lsStorie = convertView.findViewById(R.id.lst_stories);
//
//
//            LinearLayoutManager horizontalLayoutManagaer
//                    = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//            lsStorie.setLayoutManager(horizontalLayoutManagaer);
//
//
//
//            userIdStorie.clear();
//            profileImgUrlStorie.clear();
//
//            userIdStorie.add(1);
//            userIdStorie.add(1);
//            userIdStorie.add(1);
//
//
//
//            profileImgUrlStorie.add("https://pbs.twimg.com/profile_images/929030268043845633/ilS1ri2v_400x400.jpg");
//            profileImgUrlStorie.add("https://pbs.twimg.com/profile_images/929030268043845633/ilS1ri2v_400x400.jpg");
//
//            AdapterStories adapterStories  = new AdapterStories((FragmentActivity) context,userIdStorie,profileImgUrlStorie);
//
//            lsStorie.setAdapter(adapterStories);
//
//
//        }




        int typeC = type.get(position);



//        if( position !=0) {

            if (typeC == TYPE_1) {
                convertView = LayoutInflater.from(context).inflate(R.layout.lst_list_post_image, parent, false);
            } else if (typeC == TYPE_2) {
                convertView = LayoutInflater.from(context).inflate(R.layout.lst_list_post_video, parent, false);
            }


            TextView txtName = null;
            TextView txtDesc = null;
            ImageView imgProfile = null;
            ImageView lst_post_imgLike = null;
            ImageView lst_post_imgComments = null;
            ImageView lst_post_imgSend = null;
            ImageView lst_post_imgDownload = null;
            ImageView lst_post_imgBookmark = null;
            ImageView lst_post_imgMenu = null;


            if (typeC == TYPE_1) {

                ImageView lst_post_img = convertView.findViewById(R.id.lst_postImage_Image);


                Zoomy.Builder builder = new Zoomy.Builder(context).target(lst_post_img);
                builder.register();

                Picasso.get().load(contentUrls.get(position)).into(lst_post_img);


                txtName = convertView.findViewById(R.id.lst_postImage_txtName);
                txtDesc = convertView.findViewById(R.id.lst_postImage_txtDesc);
                imgProfile = convertView.findViewById(R.id.lst_postImage_imgProfile);
                lst_post_imgLike = convertView.findViewById(R.id.lst_postImage_imgLike);
                lst_post_imgComments = convertView.findViewById(R.id.lst_postImage_imgComments);
                lst_post_imgSend = convertView.findViewById(R.id.lst_postImage_imgSend);
                lst_post_imgDownload = convertView.findViewById(R.id.lst_postImage_imgDownload);
                lst_post_imgBookmark = convertView.findViewById(R.id.lst_postImage_imgBookmark);
                lst_post_imgMenu = convertView.findViewById(R.id.lst_postImage_imgMenu);


                final View finalConvertView = convertView;
                final ImageView finalLst_post_imgLike = lst_post_imgLike;
                lst_post_imgLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        like = !like;
                        if (like)
                            finalLst_post_imgLike.setImageDrawable(context.getResources().getDrawable(R.drawable.favorite));
                        else
                            finalLst_post_imgLike.setImageDrawable(context.getResources().getDrawable(R.drawable.favorite_outline));


                        YoYo.with(Techniques.FadeIn)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgLike));
                    }
                });


                final ImageView finalLst_post_imgBookmark = lst_post_imgBookmark;
                lst_post_imgBookmark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bookmark = !bookmark;
                        if (bookmark)
                            finalLst_post_imgBookmark.setImageDrawable(context.getResources().getDrawable(R.drawable.bookmark));
                        else
                            finalLst_post_imgBookmark.setImageDrawable(context.getResources().getDrawable(R.drawable.bookmark_border));


                        YoYo.with(Techniques.FadeIn)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgBookmark));
                    }
                });


                lst_post_imgSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        YoYo.with(Techniques.ZoomOutRight)
                                .duration(700).withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                YoYo.with(Techniques.ZoomInLeft)
                                        .duration(700)
                                        .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgSend));
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgSend));


                    }
                });


                lst_post_imgComments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgComments));

                    }
                });


                lst_post_imgDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.FadeInDown)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgDownload));
                    }
                });


                imgProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.StandUp)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgProfile));

                    }
                });


                lst_post_imgMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.FadeOutDown)
                                .duration(700).withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                YoYo.with(Techniques.FadeInUp)
                                        .duration(700)
                                        .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgMenu));
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                                .playOn(finalConvertView.findViewById(R.id.lst_postImage_imgMenu));
                    }
                });


            } else if (typeC == TYPE_2) {

                VideoView lst_postVideo_Video = convertView.findViewById(R.id.lst_postVideo_Video);

//            MediaController vidControl = new MediaController(context);
//
//            lst_postVideo_Video.setMediaController(vidControl);

                lst_postVideo_Video.setVideoPath(contentUrls.get(position));

                lst_postVideo_Video.start();


                txtName = convertView.findViewById(R.id.lst_postVideo_txtName);
                txtDesc = convertView.findViewById(R.id.lst_postVideo_txtDesc);
                imgProfile = convertView.findViewById(R.id.lst_postVideo_imgProfile);
                lst_post_imgLike = convertView.findViewById(R.id.lst_postVideo_imgLike);
                lst_post_imgComments = convertView.findViewById(R.id.lst_postVideo_imgComments);
                lst_post_imgSend = convertView.findViewById(R.id.lst_postVideo_imgSend);
                lst_post_imgDownload = convertView.findViewById(R.id.lst_postVideo_imgDownload);
                lst_post_imgBookmark = convertView.findViewById(R.id.lst_postVideo_imgBookmark);
                lst_post_imgMenu = convertView.findViewById(R.id.lst_postVideo_imgMenu);


                final View finalConvertView = convertView;
                final ImageView finalLst_post_imgLike = lst_post_imgLike;
                lst_post_imgLike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        like = !like;
                        if (like)
                            finalLst_post_imgLike.setImageDrawable(context.getResources().getDrawable(R.drawable.favorite));
                        else
                            finalLst_post_imgLike.setImageDrawable(context.getResources().getDrawable(R.drawable.favorite_outline));


                        YoYo.with(Techniques.FadeIn)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgLike));
                    }
                });


                final ImageView finalLst_post_imgBookmark = lst_post_imgBookmark;
                lst_post_imgBookmark.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bookmark = !bookmark;
                        if (bookmark)
                            finalLst_post_imgBookmark.setImageDrawable(context.getResources().getDrawable(R.drawable.bookmark));
                        else
                            finalLst_post_imgBookmark.setImageDrawable(context.getResources().getDrawable(R.drawable.bookmark_border));


                        YoYo.with(Techniques.FadeIn)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgBookmark));
                    }
                });


                lst_post_imgSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        YoYo.with(Techniques.ZoomOutRight)
                                .duration(700).withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                YoYo.with(Techniques.ZoomInLeft)
                                        .duration(700)
                                        .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgSend));
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgSend));


                    }
                });


                lst_post_imgComments.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        YoYo.with(Techniques.Tada)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgComments));

                    }
                });


                lst_post_imgDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.FadeInDown)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgDownload));
                    }
                });


                imgProfile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.StandUp)
                                .duration(700)
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgProfile));

                    }
                });


                lst_post_imgMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.FadeOutDown)
                                .duration(700).withListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                YoYo.with(Techniques.FadeInUp)
                                        .duration(700)
                                        .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgMenu));
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        })
                                .playOn(finalConvertView.findViewById(R.id.lst_postVideo_imgMenu));
                    }
                });


            }


            txtName.setText(names.get(position));
            txtDesc.setText(desc.get(position));


            Transformation transformation = new RoundedTransformationBuilder()
                    .borderColor(Color.BLACK)
                    .borderWidthDp(1)
                    .cornerRadiusDp(1)
                    .oval(true)
                    .build();


            Picasso.get().load(profileImgUrls.get(position)).transform(transformation).into(imgProfile);


//        }


        return convertView;
    }



    final GestureDetector gd = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){


        //here is the method for double tap


        @Override
        public boolean onDoubleTap(MotionEvent e) {

            //your action here for double tap e.g.
            //Log.d("OnDoubleTapListener", "onDoubleTap");

            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);

        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }


    });






}
