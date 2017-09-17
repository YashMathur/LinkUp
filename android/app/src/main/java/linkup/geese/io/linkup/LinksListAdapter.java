package linkup.geese.io.linkup;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import linkup.geese.io.linkup.cache.IDataLoadedCallable;
import linkup.geese.io.linkup.data.Link;
import linkup.geese.io.linkup.data.User;

/**
 * Created by yash on 2017-09-17.
 */

public class LinksListAdapter extends ArrayAdapter<Link> implements View.OnClickListener{

    private ArrayList<Link> dataSet;
    private int lastPosition = -1;
    Context mContext;

    private static class ViewHolder {
        TextView txtName;
        TextView txtKicker;
        TextView txtDate;
        ImageView image;
    }

    public LinksListAdapter(@NonNull ArrayList<Link> dataSet, @NonNull Context context) {
        super(context, R.layout.links_list_row_item, dataSet);
        this.dataSet = dataSet;
        this.mContext = context;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("FUUUU", "CALLLLs ");
        Link dataModel = getItem(position);

        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.links_list_row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.llri_name);
            viewHolder.txtKicker = (TextView) convertView.findViewById(R.id.llri_kicker);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.llri_date);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.llri_image);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getCandidate().getFirstName() + " " + dataModel.getCandidate().getLastName());
        viewHolder.txtKicker.setText("ss");
        viewHolder.txtDate.setText(dataModel.getCreatedAt().toString());
        viewHolder.image.setOnClickListener(this);
        viewHolder.image.setTag(position);

        Log.d("name", viewHolder.txtName.getText().toString());
        Log.d("name should be", dataModel.getCandidate().getFirstName() + " " + dataModel.getCandidate().getLastName());

        return convertView;
    }
}
