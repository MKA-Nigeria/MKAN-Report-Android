package in.galaxyofandroid.spinerdialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdulmujibaliu on 7/16/17.
 */


public class IdentifierObjAdapter extends ArrayAdapter<IdentifiableObject> {
    private final Context context;
    private List<IdentifiableObject> values;
    private AlertDialog alertDialog;
    private OnSpinerItemClick spinerItemClick;
    private String TAG = getClass().getSimpleName();
    private List<IdentifiableObject> orig;

    public IdentifierObjAdapter(Context context, List<IdentifiableObject> values, AlertDialog alertDialog, OnSpinerItemClick spinerItemClick) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.alertDialog = alertDialog;
        this.spinerItemClick = spinerItemClick;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.items_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.text1);
        TextView textView2 = (TextView) rowView.findViewById(R.id.text2);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.right_icon);

        textView.setText(values.get(position).getTitle());
        textView2.setText(values.get(position).getSubtitle());

        // change the icon for Windows and iPhone
        if (values.get(position).getRecourseId()>0) {
            imageView.setImageResource(values.get(position).getRecourseId());
        } else {
            imageView.setVisibility(View.INVISIBLE);
        }

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinerItemClick.onClick(values.get(position), position);
            }
        });

        return rowView;
    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<IdentifiableObject> results = new ArrayList<>();
                if (orig == null)
                    orig = values;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final IdentifiableObject g : orig) {
                            if (g.getTitle().toLowerCase()
                                    .contains(constraint.toString().toLowerCase()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                                          FilterResults results) {
                values = (ArrayList<IdentifiableObject>) results.values;
                Log.d(TAG, " " + values.size());
                notifyDataSetChanged();
            }
        };
    }

}