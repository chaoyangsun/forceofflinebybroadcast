package safeadmin.cs.com.forceofflinebybroadcast.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charming-yin on 2017/4/26.
 */
public class ActivityContainer {

    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity){
        activityList.add(activity);
    }

    public static void deleteActivity(Activity activity){
        activityList.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity :activityList){
            //判断activity是否被干掉了
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
