package com.aliumujib.majlis.mkanreport.auth.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.aliumujib.majlis.mkanreport.R;
import com.aliumujib.majlis.mkanreport.auth.view.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResetPasswordFragment extends BaseAuthFragment {


    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reset_password, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getView().findViewById(R.id.reset_password_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ok = true;
                if (((EditText) getView().findViewById(R.id.email_edittext)).getText().length() == 0) {
                    ((EditText) getView().findViewById(R.id.email_edittext)).setError(getString(R.string.empty));
                    ok = false;
                }
                if (ok)
                    ((LoginActivity) getActivity()).resetPasswordButtonClicked();
            }
        });
    }
}
