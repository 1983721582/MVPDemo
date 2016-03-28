package project.dade.cn.bst.mvp.presenter;

import android.os.Handler;

import project.dade.cn.bst.mvp.NetRespon;
import project.dade.cn.bst.mvp.model.IUserModel;
import project.dade.cn.bst.mvp.model.UserModel;
import project.dade.cn.bst.mvp.view.IUserLoginViiew;

/**
 * Created by computer on 2016/3/28.
 */
public class UserLoginPresenter implements NetRespon {

    private IUserModel iUserModel;
    private IUserLoginViiew iUserLoginViiew;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginViiew iUserLoginViiew) {
        this.iUserLoginViiew = iUserLoginViiew;
        iUserModel = new UserModel();
    }

    public void login() {
        iUserLoginViiew.showloading();
        iUserModel.login(iUserLoginViiew.getUserName(), iUserLoginViiew.getPassword(), this);
    }

    @Override
    public void success(String s) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                iUserLoginViiew.hideLoading();
                iUserLoginViiew.toMainAcrivity();
            }
        });

    }

    @Override
    public void failed() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                iUserLoginViiew.hideLoading();
                iUserLoginViiew.showError();
            }
        });

    }
}
