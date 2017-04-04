package lining20170.bawe.com.testyuecc;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Lenovo on 2017/4/1.
 * author ：李宁
 * 类注释：
 */

public class Myapp extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(aDefault);
    }
}
