package lining20170.bawe.com.testyuecc;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lenovo on 2017/4/1.
 * author ：李宁
 * 类注释：
 */

public class Httpok {

    public  static String okget(String url) throws IOException {
       /* OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder().url(url).build();
        Response execute = client.newCall(build).execute();
        return  execute.body().string();*/

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response execute = client.newCall(request).execute();
        return  execute.body().string();
    }
}
