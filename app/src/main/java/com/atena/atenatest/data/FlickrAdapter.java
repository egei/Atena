package com.atena.atenatest.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.atena.atenatest.R;

/**
 * Created by Eric on 3/13/2017.
 */
public class FlickrAdapter extends ArrayAdapter<FlickrBase> {
    private final Context context;
    private final FlickrBase[] flickrBases;

    public FlickrAdapter(Context context, FlickrBase[] resource) {
        super(context, -1, resource);
        this.context = context;
        flickrBases = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.list_element, parent, false);
        TextView title = (TextView) rowView.findViewById(R.id.title);
        TextView width = (TextView) rowView.findViewById(R.id.width);
        TextView height = (TextView) rowView.findViewById(R.id.height);
        title.setText(flickrBases[position].getTitle());
        width.setText(flickrBases[position].getFlickrDescription().getWidth());
        height.setText(flickrBases[position].getFlickrDescription().getHeight());
        return rowView;
    }
}
