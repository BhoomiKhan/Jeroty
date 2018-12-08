package max.pawras.jeroty.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import max.pawras.jeroty.R;


public class CustomSpinnerAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<String> districtList;

    public CustomSpinnerAdapter(Context context, ArrayList<String> districtList) {
        mContext = context;
        this.districtList = districtList;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return districtList.size();
    }

    @Override
    public Object getItem(int position) {
        return districtList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_spinner, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.district_list);
        name.setText(districtList.get(position));
        return convertView;
    }
}