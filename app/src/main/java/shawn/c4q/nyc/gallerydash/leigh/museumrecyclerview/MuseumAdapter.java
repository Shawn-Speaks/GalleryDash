package shawn.c4q.nyc.gallerydash.leigh.museumrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import shawn.c4q.nyc.gallerydash.R;
import shawn.c4q.nyc.gallerydash.leigh.models.MuseumData;

/**
 * Created by leighdouglas on 1/31/17.
 */

public class MuseumAdapter extends RecyclerView.Adapter<MuseumViewHolder> {

    private List<MuseumData> museumList = new ArrayList<>();

    @Override
    public MuseumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.museum_viewholder, parent, false);
        return new MuseumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MuseumViewHolder holder, int position) {
        MuseumData museumData = museumList.get(position);
        holder.bind(museumData);
    }

    @Override
    public int getItemCount() {
        return museumList.size();
    }

    public void setMuseumList(ArrayList<MuseumData> museumList){
        this.museumList = museumList;
        notifyDataSetChanged();
    }
}
