package in.galaxyofandroid.spinerdialog;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Md Farhan Raja on 2/23/2017.
 */

public class SpinnerDialog {
    ArrayList<IdentifiableObject> items;
    Activity context;
    String dTitle;
    private int dialogImageRes;
    private int titleImageRes;
    OnSpinerItemClick onSpinerItemClick;
    AlertDialog alertDialog;
    int pos;
    int style;


    public SpinnerDialog(Activity activity, ArrayList<IdentifiableObject> items, String dialogTitle, @DrawableRes int dialogImageRes, @DrawableRes int titleImageRes) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.dialogImageRes = dialogImageRes;
        this.titleImageRes = titleImageRes;
    }

    public SpinnerDialog(Activity activity, ArrayList<IdentifiableObject> items, String dialogTitle, int style, @DrawableRes int dialogImageRes, @DrawableRes int titleImageRes) {
        this.items = items;
        this.context = activity;
        this.dTitle = dialogTitle;
        this.style = style;
        this.dialogImageRes = dialogImageRes;
        this.titleImageRes = titleImageRes;
    }

    public void bindOnSpinerListener(OnSpinerItemClick onSpinerItemClick1) {
        this.onSpinerItemClick = onSpinerItemClick1;
    }

    public void showSpinerDialog() {
        AlertDialog.Builder adb = new AlertDialog.Builder(context);
        View v = context.getLayoutInflater().inflate(R.layout.dialog_layout, null);
        TextView rippleViewClose = (TextView) v.findViewById(R.id.close);
        TextView title = (TextView) v.findViewById(R.id.spinerTitle);
        ImageView titleImage = (ImageView) v.findViewById(R.id.title_image);
        ImageView dialogImage = (ImageView) v.findViewById(R.id.dialog_image);

        titleImage.setImageResource(titleImageRes);
        dialogImage.setImageResource(dialogImageRes);

        title.setText(dTitle);
        final ListView listView = (ListView) v.findViewById(R.id.list);
        final EditText searchBox = (EditText) v.findViewById(R.id.searchBox);
        final IdentifierObjAdapter adapter = new IdentifierObjAdapter(context, items, alertDialog, new OnSpinerItemClick() {
            @Override
            public void onClick(IdentifiableObject item, int position) {
                onSpinerItemClick.onClick(item, position);
                alertDialog.dismiss();
            }
        });
        listView.setAdapter(adapter);
        adb.setView(v);
        alertDialog = adb.create();
        alertDialog.getWindow().getAttributes().windowAnimations = style;//R.style.DialogAnimations_SmileWindow;
        alertDialog.setCancelable(false);

        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.getFilter().filter(searchBox.getText().toString());
            }
        });

        rippleViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }


}
