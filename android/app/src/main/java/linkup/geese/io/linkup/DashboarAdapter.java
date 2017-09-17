package linkup.geese.io.linkup;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;

import linkup.geese.io.linkup.data.Link;

/**
 * Created by yash on 2017-09-17.
 */

public class DashboarAdapter extends RecyclerView.Adapter<DashboarAdapter.ViewHolder>  {

    private ArrayList<Link> dataSet;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.link_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;


    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(dataSet.get(position).getCandidate().getFirstName() + " " + dataSet.get(position).getCandidate().getLastName());
        holder.kicker.setText(dataSet.get(position).getCandidate().getmUserId());
        holder.date.setText(dataSet.get(position).getCreatedAt().toString());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name, kicker, date;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.link_name);
            kicker = (TextView) v.findViewById(R.id.link_kicker);
            date = (TextView) v.findViewById(R.id.link_date);
        }
    }


    public DashboarAdapter(ArrayList<Link> dataSet) {
        this.dataSet = dataSet;
    }

}
