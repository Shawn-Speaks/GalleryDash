package shawn.c4q.nyc.gallerydash.leigh.museumrecyclerview;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;

/**
 * Created by leighdouglas on 1/31/17.
 */

public class MuseumViewHolder extends RecyclerView.ViewHolder {
    private TextView museumTitle;

    public MuseumViewHolder(View itemView) {
        super(itemView);
        museumTitle = (TextView) itemView.findViewById(R.id.museum_name);
        Typeface lanenar = Typeface.createFromAsset(museumTitle.getContext().getApplicationContext().getAssets(), "fonts/lanenar.ttf");
        museumTitle.setTypeface(lanenar);
    }

    public void bind(MuseumData museumData){
        museumTitle.setText(museumData.getProperties().getName());

    }
}
