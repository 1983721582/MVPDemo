package project.dade.cn.bst.mvp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import project.dade.cn.bst.mvp.presenter.UserLoginPresenter;
import project.dade.cn.bst.mvp.presenter.WeatherPresenter;
import project.dade.cn.bst.mvp.view.IUserLoginViiew;
import project.dade.cn.bst.mvp.view.IWeatherView;

/**
 *
 */
public class WeatherActivity extends AppCompatActivity implements IWeatherView, NetRespon {

    private TextView tv_temp;
    private TextView tv_time;
    private ProgressBar login_progress;
    private WeatherPresenter weatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        // Set up the login form.
        tv_temp = (TextView) findViewById(R.id.tv_temp);
        tv_time = (TextView) findViewById(R.id.tv_time);
        login_progress = (ProgressBar) findViewById(R.id.login_progress);
        weatherPresenter = new WeatherPresenter(this);
        weatherPresenter.loadData(this, this);
    }


    @Override
    public void showLoading() {
        login_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void dissLoading() {
        login_progress.setVisibility(View.GONE);
    }

    @Override
    public void showData(String data) {
        try {
            JSONObject response = new JSONObject(data);
            JSONObject weatherinfo = response.getJSONObject("weatherinfo");
            tv_temp.setText(weatherinfo.getString("temp"));
            tv_time.setText(weatherinfo.getString("time"));
        } catch (Exception e) {
            Toast.makeText(this,"JSON解析异常",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError() {
        login_progress.setVisibility(View.GONE);
    }

    @Override
    public void success(String s) {
        dissLoading();
        showData(s);
    }

    @Override
    public void failed() {
        showError();
    }
}

