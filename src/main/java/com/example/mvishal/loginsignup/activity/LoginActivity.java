package com.example.mvishal.loginsignup.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvishal.loginsignup.R;
import com.example.mvishal.loginsignup.ShakeAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    @BindView(R.id.login_text_view_register)
    TextView mLogin_text_view_register;
    @BindView(R.id.login_text_view_forgot_password)
    TextView mLogin_text_view_forgot_password;

    @BindView(R.id.login_edit_text_email)
    TextView mEmailView;

    @BindView(R.id.login_edit_text_password)
    TextView mPasswordView;
    @BindView(R.id.login_button_email_password_login)
    TextView mLogin_button_email_password_login;
    @BindView(R.id.login_image_view_logo_dummpy)
    ImageView mLogin_image_view_logo_dummy;
    @BindView(R.id.login_image_view_logo)
    ImageView mLogin_image_view_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(LoginActivity.this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorApp));
        }



        animations();
    }

    @OnClick(R.id.login_text_view_register)
    public void login_tv_register() {
        Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intentRegister);
    }


    @OnClick(R.id.login_button_email_password_login)
    public void login_button_email_password_login() {
        if (mEmailView.getText().toString().equalsIgnoreCase("")) {
            ShakeAnimation.shakeAnim(mEmailView);
        } else if (mPasswordView.getText().toString().equalsIgnoreCase("")) {
            ShakeAnimation.shakeAnim(mPasswordView);
        } else {
            Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intentRegister);
        }
    }


    // perform animation for all the views in login screen.
    private void animations() {
        Animation logoAnim = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.center_to_top_animation);
        mLogin_image_view_logo_dummy.startAnimation(logoAnim);

        logoAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onAnimationEnd(Animation animation) {
                mLogin_image_view_logo_dummy.setVisibility(View.GONE);
                mLogin_image_view_logo.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Animation mEmailAnim = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.center_to_top_animation_for_email);
        mEmailView.startAnimation(mEmailAnim);

        Animation mPasswordEditTextAnim = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.center_to_top_animation_for_password);
        mPasswordView.startAnimation(mPasswordEditTextAnim);

        Animation mLoginEditTextAnim = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.center_to_top_animation_for_login);
        mLogin_button_email_password_login.startAnimation(mLoginEditTextAnim);

        Animation mForgetPassAnim = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.center_to_top_animation_for_forgot);
        mLogin_text_view_forgot_password.startAnimation(mForgetPassAnim);

        Animation mRegisterAnim = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.center_to_top_animation_for_register);
        mLogin_text_view_register.startAnimation(mRegisterAnim);


    }

}

