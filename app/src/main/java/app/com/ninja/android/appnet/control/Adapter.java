package app.com.ninja.android.appnet.control;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.com.ninja.android.appnet.R;
import app.com.ninja.android.appnet.model.DataItems;
import app.com.ninja.android.appnet.model.Datum;


/**
 * The recyclerView adapter
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


        private ArrayList<DataItems> mDataset;
        private Context context;


    // Providing a reference to the views for each data item

    // providing access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public TextView nameTextView;
        public TextView postTextView;
        public ImageView avatarImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.user_name);
            postTextView = (TextView) itemView.findViewById(R.id.user_post);
            avatarImageView = (ImageView) itemView.findViewById(R.id.user_avatar);

        }
    }

    // constructor (with a context required by Picasso)
    public Adapter(Context context,ArrayList<DataItems> myDataset) {

        this.context = context;
        mDataset = myDataset;
    }

    // Creating the new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // creating a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_content, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replacing the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - getting element from  dataset at this position
        // - replacing the contents of the view with that element

        Datum item = mDataset.listIterator().next().getData().get(position);

        TextView userName = holder.nameTextView;
        userName.setText(item.getUser().getName());

        TextView postText = holder.postTextView;
        postText.setText(item.getText());

        ImageView avatarImage = holder.avatarImageView;
        Picasso.with(context).load(item.getUser().getAvatarImage().getUrl()).into(avatarImage);
    }

    // Returning the size of dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset.iterator().next().getData().size();
    }


    // Cleaning all elements of the recycler
    public void clear() {
        mDataset.clear();
        notifyDataSetChanged();
    }

    // Adding list of items
    public void addAll(List<DataItems> list) {
        mDataset.addAll(list);
        notifyDataSetChanged();
    }

}
