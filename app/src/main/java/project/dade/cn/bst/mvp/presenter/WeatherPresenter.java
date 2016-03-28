package project.dade.cn.bst.mvp.presenter;

import android.content.Context;

import project.dade.cn.bst.mvp.NetRespon;
import project.dade.cn.bst.mvp.model.WeatherModel;
import project.dade.cn.bst.mvp.view.IWeatherView;

/**
 * Created by computer on 2016/3/28.
 */
public class WeatherPresenter {
    private IWeatherView iWeatherView;
    private WeatherModel weatherModel;

    public WeatherPresenter(IWeatherView iWeatherView){
        this.iWeatherView=iWeatherView;
        weatherModel=new WeatherModel();
    }

    public void loadData(Context context,NetRespon netRespon){
        iWeatherView.showLoading();
        weatherModel.loadWeather(context,netRespon);
    }

}
