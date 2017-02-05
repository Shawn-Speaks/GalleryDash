package shawn.c4q.nyc.gallerydash.leigh.galleryrecyclerview;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import shawn.c4q.nyc.gallerydash.R;

/**
 * Created by leighdouglas on 2/4/17.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder>{
    ArrayList<Drawable> badges = new ArrayList<>();

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_viewholder, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        Drawable badge = badges.get(position);
        holder.bind(badge);
    }

    @Override
    public int getItemCount() {
        return badges.size();
    }
}
