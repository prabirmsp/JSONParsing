package com.example.prabir.jsontest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prabir on 2/16/15.
 */

public class MembersAdapter extends ArrayAdapter<TeamMember> {
    public MembersAdapter(Context context, ArrayList<TeamMember> users) {
        super(context, 0, users);
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
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvYear);
        // Populate the data into the template view using the data object
        tvName.setText(teamMember.name);
        tvHome.setText(teamMember.year);
        // Return the completed view to render on screen
        return convertView;
    }
}