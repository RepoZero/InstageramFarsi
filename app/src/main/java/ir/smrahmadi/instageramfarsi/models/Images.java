package ir.smrahmadi.instageramfarsi.models;

/**
 * Created by lincoln on 3/13/18.
 */

public class Images {
    private standardResolution standardResolution;

    public standardResolution getStandardResolution(){
        return standardResolution ;
    }

    public class standardResolution{
        private String url ;
        public String getUrl(){
             return url;
        }
    }

}
