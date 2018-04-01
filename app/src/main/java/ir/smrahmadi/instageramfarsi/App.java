package ir.smrahmadi.instageramfarsi;

import android.app.Application;
import android.widget.ListView;

import java.util.ArrayList;

import ir.smrahmadi.instageramfarsi.Adapter.AdapterListPost;

/**
 * Created by lincoln on 3/15/18.
 */

public class App extends Application {

    public static ListView lsPost;
    public static AdapterListPost adapterListPost;

    public static ArrayList<Integer> userIDs = new ArrayList<>();
    public static ArrayList<Integer> postIDs = new ArrayList<>();
    public static ArrayList<String> profileImgUrls = new ArrayList<>();
    public static ArrayList<String> contentUrls = new ArrayList<>();
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> desc = new ArrayList<>();
    public static ArrayList<Integer> type = new ArrayList<>();


    public static ArrayList<Integer> userIdSearch = new ArrayList<>();
    public static ArrayList<Integer> postIdSearch = new ArrayList<>();
    public static ArrayList<String> imgUrlSearch = new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();

    }
}
