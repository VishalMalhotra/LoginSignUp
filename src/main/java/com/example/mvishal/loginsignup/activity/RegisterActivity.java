package com.example.mvishal.loginsignup.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mvishal.loginsignup.R;
import com.example.mvishal.loginsignup.ShakeAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {


    @BindView(R.id.register_button)
    TextView mRegister_button;
    @BindView(R.id.register_edit_text_Passwod)
    TextView mRegister_edit_text_Passwod;
    @BindView(R.id.register_edit_text_confirm_password)
    TextView mRegister_edit_text_confirm_password;
    @BindView(R.id.register_edit_text_email)
    TextView mRegister_edit_text_email;
    @BindView(R.id.register_edit_text_first_name)
    EditText mRegister_edit_text_first_name;
    @BindView(R.id.register_imageview_back_arrow)
    ImageView mRegister_imageview_back_arrow;
    @BindView(R.id.register_edit_imageview_logo)
    ImageView mRegister_edit_imageview_logo;
    @BindView(R.id.register_relLayout)
    RelativeLayout mRelRegister_relLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorApp));
        }

        ButterKnife.bind(RegisterActivity.this);
      //  animations();

    }

    @OnClick(R.id.register_imageview_back_arrow)
    public void register_imageview_back_arrow() {
        onBackPressed();
    }

    @OnClick(R.id.register_button)
    public void register_button() {
        if (mRegister_edit_text_first_name.getText().toString().equalsIgnoreCase("")) {
            ShakeAnimation.shakeAnim(mRegister_edit_text_first_name);
        } else if (mRegister_edit_text_email.getText().toString().equalsIgnoreCase("")) {
            ShakeAnimation.shakeAnim(mRegister_edit_text_email);
        } else if (mRegister_edit_text_Passwod.getText().toString().equalsIgnoreCase("")) {
            ShakeAnimation.shakeAnim(mRegister_edit_text_Passwod);
        } else if (mRegister_edit_text_confirm_password.getText().toString().equalsIgnoreCase("")) {
            ShakeAnimation.shakeAnim(mRegister_edit_text_confirm_password);
        } else {
            // Go back to logiin screen
            onBackPressed();
        }
    }

    // perform animation for all the views in login screen.
    private void animations() {

        Animation mFullNameAnim = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.center_to_top_animation);
        mRegister_edit_text_first_name.startAnimation(mFullNameAnim);

        Animation mEmailAnim = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.center_to_top_animation_for_email);
        mRegister_edit_text_email.startAnimation(mEmailAnim);

        Animation mPasswordEditTextAnim = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.center_to_top_animation_for_password);
        mRegister_edit_text_Passwod.startAnimation(mPasswordEditTextAnim);

        Animation mRegisterAnim = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.center_to_top_animation_for_password_confirm);
        mRegister_edit_text_confirm_password.startAnimation(mRegisterAnim);

        Animation mForgetPassAnim = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.center_to_top_animation_for_forgot);
        mRelRegister_relLayout.startAnimation(mForgetPassAnim);

        Animation mRegisterPassAnim = AnimationUtils.loadAnimation(RegisterActivity.this, R.anim.center_to_top_animation_for_register);
        mRegister_button.startAnimation(mRegisterPassAnim);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);

    }
}
