package com.shopee;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

public class ConnectFacebookInstagramActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private CallbackManager callbackManager;
    private LoginButton fbLoginButton;
    private LoginButton youtubeBtn;
    private LoginButton twitterBtn;
    private LoginButton loginInsta;
    private TextView nameFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_facebook_instagram);
        nameFacebook = findViewById(R.id.facebookName);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        fbLoginButton = findViewById(R.id.login_button);
        youtubeBtn = findViewById(R.id.loginYoutube);
        twitterBtn = findViewById(R.id.loginTwitter);
        loginInsta = findViewById(R.id.loginInsta);

        fbLoginButton.setLoginText("LIÊN KẾT");
        fbLoginButton.setLogoutText("HỦY LIÊN KẾT");
        fbLoginButton.setBackgroundColor(Color.WHITE);
        fbLoginButton.setTextColor(Color.RED);

        youtubeBtn.setLoginText("LIÊN KẾT");
        youtubeBtn.setLogoutText("HỦY LIÊN KẾT");
        youtubeBtn.setBackgroundColor(Color.WHITE);
        youtubeBtn.setTextColor(Color.RED);

        twitterBtn.setLoginText("LIÊN KẾT");
        twitterBtn.setLogoutText("HỦY LIÊN KẾT");
        twitterBtn.setBackgroundColor(Color.WHITE);
        twitterBtn.setTextColor(Color.RED);

        loginInsta.setLoginText("LIÊN KẾT");
        loginInsta.setLogoutText("HỦY LIÊN KẾT");
        loginInsta.setBackgroundColor(Color.WHITE);
        loginInsta.setTextColor(Color.RED);

        //https://developers.facebook.com/docs/facebook-login/permissions#reference
        fbLoginButton.setReadPermissions("email");

        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "======Facebook login success======");
                Log.d(TAG, "Facebook Access Token: " + loginResult.getAccessToken().getToken());
                getFbInfo();
            }

            @Override
            public void onCancel() {
                Toast.makeText(ConnectFacebookInstagramActivity.this, "Login Facebook cancelled.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "======Facebook login error======");
                Log.e(TAG, "Error: " + error.toString());
                Toast.makeText(ConnectFacebookInstagramActivity.this, "Login Facebook error.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void getFbInfo() {
        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(final JSONObject me, GraphResponse response) {
                            if (me != null) {
                                Log.i("Login: ", me.optString("name"));
                                Log.i("ID: ", me.optString("id"));
                                nameFacebook.setText(me.optString("name"));
                            } else {
                                nameFacebook.setText("Liên kết tài khoản Facebook");
                            }
                        }
                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link");
            request.setParameters(parameters);
            request.executeAsync();
        } else {
            nameFacebook.setText("Liên kết tài khoản Facebook");
        }
    }
}