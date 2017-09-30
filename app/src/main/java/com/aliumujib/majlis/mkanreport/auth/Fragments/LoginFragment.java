package com.aliumujib.majlis.mkanreport.auth.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.alium.mkan_report_data.models.Profile;
import com.aliumujib.majlis.mkanreport.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseAuthFragment {


    @Bind(R.id.email_icon)
    ImageView emailIcon;
    @Bind(R.id.email_edittext)
    EditText emailEdittext;
    @Bind(R.id.email_layout)
    RelativeLayout emailLayout;
    @Bind(R.id.password_icon)
    ImageView passwordIcon;
    @Bind(R.id.password_edittext)
    EditText passwordEdittext;
    @Bind(R.id.password_layout)
    RelativeLayout passwordLayout;
    @Bind(R.id.login_button)
    LinearLayout loginButton;
    @Bind(R.id.button_layout)
    RelativeLayout buttonLayout;
    @Bind(R.id.forgot_layout)
    RelativeLayout forgotLayout;
    @Bind(R.id.content_login)
    RelativeLayout contentLogin;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginButton.setOnClickListener(view1 -> {
            boolean ok = true;
            if (emailEdittext.getText().length() == 0) {
                emailEdittext.setError(getString(R.string.empty));
                ok = false;
            }
            if (emailEdittext.getText().length() == 0) {
                emailEdittext.setError(getString(R.string.empty));
                ok = false;
            }
            if (ok)
            {
                mAuthActivityView.getPresenter().login(new Profile(emailEdittext.getText().toString(), passwordEdittext.getText().toString()));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
