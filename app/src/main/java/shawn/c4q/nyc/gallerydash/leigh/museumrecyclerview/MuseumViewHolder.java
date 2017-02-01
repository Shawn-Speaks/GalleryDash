package shawn.c4q.nyc.gallerydash.leigh.museumrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumProperties;


/**
 * Created by leighdouglas on 1/31/17.
 */

public class MuseumViewHolder extends RecyclerView.ViewHolder {
    private TextView museumTitle;

    public MuseumViewHolder(View itemView) {
        super(itemView);
        museumTitle = (TextView) itemView.findViewById(R.id.museum_name);
    }

    public void bind(MuseumData museumData){
        museumTitle.setText(museumData.getProperties().getName());

    }
}
