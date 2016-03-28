package project.dade.cn.bst.mvp.model;

import project.dade.cn.bst.mvp.NetRespon;
import project.dade.cn.bst.mvp.bean.UserBean;

/**
 * Created by computer on 2016/3/28.
 */
public class UserModel implements IUserModel {

    @Override
    public void login(final String username, final String password,final NetRespon netRespon) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password)) {
                    UserBean user = new UserBean();
                    user.userName = username;
                    user.password = password;
                    netRespon.success("");
                } else {
                    netRespon.failed();
                }
            }
        }.start();
    }
}
