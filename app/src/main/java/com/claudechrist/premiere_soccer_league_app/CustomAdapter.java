package com.claudechrist.premiere_soccer_league_app;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Match> {

    private final Context context;
    private final ArrayList<Match> matches;
    private ImageView myCheckICon;
    private ConstraintLayout listItemLayout;

    public CustomAdapter(Context context, ArrayList<Match> matches) {
        super(context, -1, matches);
        this.context = context;
        this.matches = matches;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.match_row, parent, false);

        TextView matchScoreTextView = rowView.findViewById(R.id.match_score_textview);
        TextView matchLabelTextView = rowView.findViewById(R.id.match_label_textview);
        TextView dateTextView = rowView.findViewById(R.id.date_textview);
        myCheckICon = rowView.findViewById(R.id.ic_check);
        listItemLayout = rowView.findViewById(R.id.list_layout_constraint_layout);

        Match match = matches.get(position);
        String score = match.getTeamA() + " " + match.getScoreA() + ":" + match.getScoreB() + " " + match.getTeamB();
        String date = match.getDate();
        String label = match.getLabel();
        matchScoreTextView.setText(score);
        matchLabelTextView.setText(label);
        dateTextView.setText(date);

        return rowView;
    }


    public void setItemSelectedState(boolean active) {
        if (active) {
            myCheckICon.setVisibility(View.VISIBLE);
            listItemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorDark));
        } else {
            myCheckICon.setVisibility(View.INVISIBLE);
            listItemLayout.setBackgroundColor(context.getResources().getColor(R.color.colorLight));
        }
    }
}
