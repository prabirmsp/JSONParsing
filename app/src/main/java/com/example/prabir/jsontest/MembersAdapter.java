package com.example.prabir.jsontest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by prabir on 2/16/15.
 */

public class MembersAdapter extends ArrayAdapter<TeamMember> {
    protected Context mContext;

    public MembersAdapter(Context context, ArrayList<TeamMember> users) {
        super(context, 0, users);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TeamMember teamMember = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_member, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvYear = (TextView) convertView.findViewById(R.id.tvYear);
        TextView tvRole = (TextView) convertView.findViewById(R.id.tvRole);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
        // Populate the data into the template view using the data object
        tvName.setText(teamMember.name);
        tvYear.setText(teamMember.year);
        tvRole.setText(teamMember.role);
        if (teamMember.image.equals("http://www.cs.grinnell.edu/~owusumic17/img/android-round.png"))
            imageView.setImageDrawable(mContext.getResources().getDrawable(R.drawable.avatar));
        else
            Picasso.with(this.getContext()).load(teamMember.image).into(imageView);
        // Return the completed view to render on screen
        return convertView;
    }
}