package ghostapp.africa.incentro.ghostapp.adapter;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import ghostapp.africa.incentro.ghostapp.R;
import ghostapp.africa.incentro.ghostapp.model.Dream;

/**
 * Created by lynnette on 11/3/17.
 */

public class DreamAdapter extends RecyclerView.Adapter<DreamAdapter.MyViewHolder> {

    private Context mContext;
    private List<Dream> dreamList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }


    public DreamAdapter(Context mContext, List<Dream> dreamList) {
        this.mContext = mContext;
        this.dreamList = dreamList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dream_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Dream dream = dreamList.get(position);
        holder.title.setText(dream.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(dream.getThumbnail()).into(holder.thumbnail);


    }


    @Override
    public int getItemCount() {
        return dreamList.size();
    }
}
