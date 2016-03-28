package project.dade.cn.bst.mvp.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;

import project.dade.cn.bst.mvp.NetRespon;

/**
 * Created by computer on 2016/3/28.
 */
public class WeatherModel {

    public void loadWeather(Context context,final NetRespon netRespon){
        StringRequest stringRequest=new StringRequest(Request.Method.GET,"http://www.weather.com.cn/adat/sk/101010100.html", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("VOEELRY",response);
                netRespon.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOEELRY","VOEELRY ERROR");
                netRespon.failed();
            }
        }
        );
        Volley.newRequestQueue(context).add( stringRequest);
    }
}
