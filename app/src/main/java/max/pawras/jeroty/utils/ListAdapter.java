package max.pawras.jeroty.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import max.pawras.jeroty.R;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<Model> listItems=null;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView item;

        public MyViewHolder(View view) {
            super(view);
            item = (TextView) view.findViewById(R.id.item);
        }
    }

    public ListAdapter(List<Model> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext=mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
          holder.item.setText(listItems.get(position).getItem());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}