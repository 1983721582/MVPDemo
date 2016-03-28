package project.dade.cn.bst.mvp.view;

/**
 * Created by computer on 2016/3/28.
 */
public interface IWeatherView {

    public void showLoading();

    public void dissLoading();

    public void showData(String data);

    public void showError();
}
