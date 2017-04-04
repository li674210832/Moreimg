package lining20170.bawe.com.testyueb;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lenovo on 2017/3/31.
 * author ：李宁
 * 类注释：
 */

public class Httpok {



    public  static String okHttp(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response execute = client.newCall(request).execute();

        return  execute.body().string();
    }
}
