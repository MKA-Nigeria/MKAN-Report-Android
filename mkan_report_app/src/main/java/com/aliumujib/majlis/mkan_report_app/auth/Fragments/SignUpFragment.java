package com.aliumujib.majlis.mkan_report_app.auth.fragments;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alium.mkan_report_data.models.Profile;
import com.aliumujib.majlis.mkan_report_app.R;
import com.aliumujib.majlis.mkan_report_app.auth.Tools.MyTimeUtils;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.galaxyofandroid.spinerdialog.IdentifiableObject;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends BaseAuthFragment {
    @BindView(R.id.profile_picture)
    ImageView profilePicture;
    @BindView(R.id.back_button)
    LinearLayout backButton;
    @BindView(R.id.text_layout)
    LinearLayout textLayout;
    @BindView(R.id.photo_button)
    LinearLayout photoButton;
    @BindView(R.id.user_icon)
    ImageView userIcon;
    @BindView(R.id.username_edittext)
    EditText usernameEdittext;
    @BindView(R.id.name_layout)
    RelativeLayout nameLayout;
    @BindView(R.id.email_icon)
    ImageView emailIcon;
    @BindView(R.id.email_edittext)
    EditText emailEdittext;
    @BindView(R.id.email_layout)
    RelativeLayout emailLayout;
    @BindView(R.id.password_icon)
    ImageView passwordIcon;
    @BindView(R.id.password_edittext)
    EditText passwordEdittext;
    @BindView(R.id.password_layout)
    RelativeLayout passwordLayout;
    @BindView(R.id.ilaqa_layout_icon)
    ImageView ilaqaLayoutIcon;
    @BindView(R.id.ilaqa_edittext)
    EditText ilaqaEdittext;
    @BindView(R.id.ilaqa_layout)
    RelativeLayout ilaqaLayout;
    @BindView(R.id.dila_icon)
    ImageView dilaIcon;
    @BindView(R.id.dila_edittext)
    EditText dilaEdittext;
    @BindView(R.id.dila_layout)
    RelativeLayout dilaLayout;
    @BindView(R.id.muqami_icon)
    ImageView muqamiIcon;
    @BindView(R.id.muqami_edittext)
    EditText muqamiEdittext;
    @BindView(R.id.muqami_layout)
    RelativeLayout muqamiLayout;
    @BindView(R.id.birthday_icon)
    ImageView birthdayIcon;
    @BindView(R.id.birthday_edittext)
    EditText birthdayEdittext;
    @BindView(R.id.clickable_birthday_layout)
    LinearLayout clickableBirthdayLayout;
    @BindView(R.id.birthday_layout)
    RelativeLayout birthdayLayout;
    @BindView(R.id.form_container)
    LinearLayout formContainer;
    @BindView(R.id.myTextView)
    TextView myTextView;
    @BindView(R.id.sign_up_button_overlay)
    LinearLayout signUpButton;
    @BindView(R.id.signin_layout)
    RelativeLayout signinLayout;
    @BindView(R.id.content_sign_up)
    RelativeLayout contentSignUp;
    private ImageView imageView;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ok = true;
                if (usernameEdittext.getText().length() == 0) {
                    usernameEdittext.setError(getString(R.string.empty));
                    ok = false;
                }
                if (passwordEdittext.getText().length() == 0) {
                    passwordEdittext.setError(getString(R.string.empty));
                    ok = false;
                }
                if (emailEdittext.getText().length() == 0) {
                    emailEdittext.setError(getString(R.string.empty));
                    ok = false;
                }
                if (ok) {
                    Profile profile = new Profile(usernameEdittext.getText().toString(), passwordEdittext.getText().toString());
                    profile.setmEmail(emailEdittext.getText().toString());
                    mAuthActivityView.getPresenter().signUp(profile);
                }
            }
        });

    }

    public void birthDayClick() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        Calendar temp = Calendar.getInstance();
                        temp.set(Calendar.YEAR, year);
                        temp.set(Calendar.MONTH, monthOfYear);
                        temp.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        ((TextView) getView().findViewById(R.id.birthday_edittext)).setText(MyTimeUtils.formatDate(temp.getTimeInMillis(), MyTimeUtils.REPORT_DATE_FORMAT));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dpd.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:
                if (resultCode == getActivity().RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);
                }

                break;
            case 1:
                if (resultCode == getActivity().RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    imageView.setImageURI(selectedImage);
                }
                break;
        }
    }

    public void imageButtonClick() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, 1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.ilaqa_edittext, R.id.dila_edittext, R.id.muqami_edittext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //TODO MOVE THIS CODE TO PRESENTER
            case R.id.ilaqa_edittext:
                mAuthActivityView.getPresenter().getDenimationsService().getIlaqaList().subscribe(ilaqaList -> {
                    SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), (ArrayList<IdentifiableObject>) ilaqaList, "", R.style.DialogAnimations_SmileWindow, R.drawable.ic_domain_white_24dp, R.drawable.ic_domain_white_24dp);

                    spinnerDialog.bindOnSpinerListener((item, position) -> {
                        Toast.makeText(getActivity(), item.getTitle() + "  " + item.getRecourseId() + "", Toast.LENGTH_SHORT).show();
                        ilaqaEdittext.setText(item.getTitle() + " Position: " + item.getSubtitle());
                    });

                    spinnerDialog.showSpinerDialog();
                }, Throwable::printStackTrace);
                break;
            case R.id.dila_edittext:
                mAuthActivityView.getPresenter().getDenimationsService().getDilaList().subscribe(dilas -> {
                    SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), (ArrayList<IdentifiableObject>) dilas, "", R.style.DialogAnimations_SmileWindow, R.drawable.ic_ethernet_white_24dp, R.drawable.ic_ethernet_white_24dp);

                    spinnerDialog.bindOnSpinerListener((item, position) -> {
                        Toast.makeText(getActivity(), item.getTitle() + "  " + item.getRecourseId() + "", Toast.LENGTH_SHORT).show();
                        dilaEdittext.setText(item.getTitle() + " Position: " + item.getSubtitle());
                    });

                    spinnerDialog.showSpinerDialog();
                }, Throwable::printStackTrace);
                break;
            case R.id.muqami_edittext:
                mAuthActivityView.getPresenter().getDenimationsService().getMuqamiList().subscribe(muqamis -> {
                    SpinnerDialog spinnerDialog = new SpinnerDialog(getActivity(), (ArrayList<IdentifiableObject>) muqamis, "", R.style.DialogAnimations_SmileWindow, R.drawable.ic_bulletin_board_white_24dp, R.drawable.ic_bulletin_board_white_24dp);

                    spinnerDialog.bindOnSpinerListener((item, position) -> {
                        Toast.makeText(getActivity(), item.getTitle() + "  " + item.getRecourseId() + "", Toast.LENGTH_SHORT).show();
                        muqamiEdittext.setText(item.getTitle() + " Position: " + item.getSubtitle());
                    });

                    spinnerDialog.showSpinerDialog();
                }, Throwable::printStackTrace);
                break;

        }
    }
}
