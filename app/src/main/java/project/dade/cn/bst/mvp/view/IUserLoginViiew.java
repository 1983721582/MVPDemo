package project.dade.cn.bst.mvp.view;

/**
 * Created by computer on 2016/3/28.
 */
public interface IUserLoginViiew {
    public String getUserName();

    public String getPassword();

    public void showloading();

    public void hideLoading();

    public void showError();

    public void toMainAcrivity();
}
