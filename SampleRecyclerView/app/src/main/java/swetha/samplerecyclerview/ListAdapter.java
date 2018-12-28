package swetha.samplerecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by swetha on 12/27/18.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {
    private static final String TAG = "ListAdapter";

    ArrayList<String> mTexts = new ArrayList<>();
    ArrayList<String> mImages = new ArrayList<>();
    Context context;

    public ListAdapter(ArrayList<String> texts, ArrayList<String> images, Context context){
        this.mTexts = texts;
        this.mImages = images;
        this.context = context;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ItemViewHolder viewHolder = new ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, final int position) {
        Log.d(TAG+"onBindViewHolder","item "+position+" called");
        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.circleImageView);
        holder.circleImageTextView.setText(mTexts.get(position));
        //onClick on ListItem
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,mTexts.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        CircleImageView circleImageView;
        TextView circleImageTextView;
        RelativeLayout parentLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView);
            circleImageTextView = itemView.findViewById(R.id.textView);
            parentLayout = itemView.findViewById(R.id.listItemLayout);

        }
    }
}
