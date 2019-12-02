package com.example.ZZW.mobileshop.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.ZZW.mobileshop.R;
import com.example.ZZW.mobileshop.common.BaseActivity;
import com.example.ZZW.mobileshop.common.Constants;
import com.example.ZZW.mobileshop.http.ProgressDialogSubscriber;
import com.example.ZZW.mobileshop.http.entity.MemberEntity;
import com.example.ZZW.mobileshop.http.presenter.MemberPresenter;
import com.example.ZZW.mobileshop.utils.SystemCofig;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.iv_back)
    void close() {
        finish();
    }

    @OnClick(R.id.bt_login)
    void login() {
        String userName = etUsername.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            toastShort("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            toastShort("请输入密码");
            return;
        }

        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemCofig.setLogin(true);
                toastShort("登录成功");

                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);

                sendLoginBroadcast();
                setResult(RESULT_OK);
                finish();
            }
        }, userName, pwd);
    }

    private void sendLoginBroadcast() {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_LOGIN);
        intent.putExtra("my_data","这是数据");
        sendBroadcast(intent);
    }

}
