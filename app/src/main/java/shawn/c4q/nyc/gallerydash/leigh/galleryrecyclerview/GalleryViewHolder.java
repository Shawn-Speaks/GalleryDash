package shawn.c4q.nyc.gallerydash.leigh.galleryrecyclerview;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import shawn.c4q.nyc.gallerydash.R;

/**
 * Created by leighdouglas on 2/4/17.
 */

public class GalleryViewHolder extends RecyclerView.ViewHolder {
    private ImageView badgeImg;
    private TextView badgeText;

    public GalleryViewHolder(View itemView) {
        super(itemView);
        badgeImg = (ImageView) itemView.findViewById(R.id.badge_name_image);
    }

    public void bind() {
       badgeImg.setImageResource(R.drawable.trophy2);
    }
}
