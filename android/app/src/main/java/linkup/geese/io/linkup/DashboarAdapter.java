package linkup.geese.io.linkup;

import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import linkup.geese.io.linkup.data.Link;

/**
 * Created by yash on 2017-09-17.
 */

public class DashboarAdapter extends RecyclerView.Adapter<DashboarAdapter.ViewHolder>  {

    private ArrayList<Link> dataSet;
    private Integer[] images;
    private String[] kickers;
    private DashboardActivity ref;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.link_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.name.setText(dataSet.get(position).getCandidate().getFirstName() + " " + dataSet.get(position).getCandidate().getLastName());
        holder.kicker.setText(kickers[position % this.kickers.length]);
        Calendar c = Calendar.getInstance(Locale.ENGLISH);
        c.setTimeInMillis(dataSet.get(position).getCreatedAt());
        holder.date.setText(DateFormat.format("dd-MM-yyyy", c).toString());
        holder.image.setImageResource(this.images[position % this.images.length]);
        holder.lc_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.openProfile(dataSet.get(position).getCandidate().getmUserId());
            }
        });
        holder.lc_right_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref.openProfile(dataSet.get(position).getCandidate().getmUserId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name, kicker, date;
        public ImageView image;
        public ConstraintLayout lc_container, lc_right_container;
        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.link_name);
            kicker = (TextView) v.findViewById(R.id.link_kicker);
            date = (TextView) v.findViewById(R.id.link_date);
            image = (ImageView) v.findViewById(R.id.lc_image);
            lc_container = (ConstraintLayout) v.findViewById(R.id.lc_container);
            lc_right_container = (ConstraintLayout) v.findViewById(R.id.lc_right_container);
        }
    }


    public DashboarAdapter(ArrayList<Link> dataSet, Integer[] images, DashboardActivity ref) {
        this.dataSet = dataSet;
        this.images = images;
        this.kickers = new String[]{
                "Senior Product Manager at Facebook",
                "Software Engineer at Whatsapp",
                "Business Analyst at RBC",
                "UX Researcher and Designer at Apple"
        };
        this.ref = ref;
    }

}
