package com.thc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.thc.myapplication.util.MNetWorkUtil;
import com.thc.myapplication.util.MThreadManager;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText accountNameView;
    EditText accountPswView;
    EditText authCodeInputView;

    ImageView clearAccountNameView;
    ImageView clearAccountPswView;
    ImageView clearAuthCodeView;

    TextView authCodeView;
    TextView authCodeRefreshView;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEven();
    }
    private void initView(){
        accountNameView= (EditText) findViewById(R.id.view_accountName);
        accountPswView= (EditText) findViewById(R.id.view_accountPsw);
        authCodeInputView= (EditText) findViewById(R.id.view_cuthCode_input);
        clearAuthCodeView= (ImageView) findViewById(R.id.view_clear_authCodeInput);
        clearAccountNameView= (ImageView) findViewById(R.id.view_clear_accountName);
        clearAccountPswView= (ImageView) findViewById(R.id.view_clear_accountPsw);
        authCodeView= (TextView) findViewById(R.id.view_authCode);
        authCodeRefreshView= (TextView) findViewById(R.id.view_refresh_authCode);
        loginButton= (Button) findViewById(R.id.view_login);

        String authCode=StringUtils.getRandomString(4);
        authCodeView.setText(authCode);
    }
    private void initEven(){
        clearAuthCodeView.setOnClickListener(this);
        clearAccountNameView.setOnClickListener(this);
        clearAccountPswView.setOnClickListener(this);
        authCodeRefreshView.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.view_refresh_authCode:{
                String authCode=StringUtils.getRandomString(4);
                authCodeView.setText(authCode);
            }
                break;
            case R.id.view_clear_accountPsw:{
                accountPswView.setText("");
            }
                break;
            case R.id.view_clear_accountName:{
                accountNameView.setText("");
            }
                break;
            case R.id.view_clear_authCodeInput:{
                authCodeInputView.setText("");
            }
                break;
            case R.id.view_login:{
                String accuntName=accountNameView.getText().toString();
                String accuntPsw=accountPswView.getText().toString();
                String authCodeInputStr=authCodeInputView.getText().toString();
                String authCodeFinaStr=authCodeView.getText().toString();
                if(TextUtils.isEmpty(accuntName) || TextUtils.isEmpty(accuntPsw)){
                    Toast.makeText(this,"请输入用户名或密码",Toast.LENGTH_SHORT).show();
                    return;
                }else if(!authCodeInputStr.equalsIgnoreCase(authCodeFinaStr)){
                    Toast.makeText(this,"验证码输入联正确",Toast.LENGTH_SHORT).show();
                    String authCode=StringUtils.getRandomString(4);
                    authCodeView.setText(authCode);
                    return;
                }
                httpLogin(accuntName,accuntPsw);
            }
            break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    /**
     * 登录
     * @param accountName
     * @param accountPsw
     */
    private void httpLogin(String accountName,String accountPsw){
//    -1 请输入账号 1密码连续错误3次，请等5分钟后再试
//        2 账号被锁定
//    -2  账号或密码错误
        final HashMap<String,String> params=new HashMap<>();
        params.put("account",accountName);
        params.put("password",accountPsw);
        final String url="http://66ht.66thj.com/ht/api/login_chk.php";
        MThreadManager.getInstant().run(new Runnable() {
            @Override
            public void run() {
                String jsonStr=MNetWorkUtil.getInstant().httpSubmitPostData(url,params);
                Log.i(LoginActivity.class.getName(),"服务请返回JSON结果:"+jsonStr);
            }
        });

        Intent intent =new Intent(this,ShopActivity.class);
        startActivity(intent);
    }
    public void paraJson(){

    }

}

