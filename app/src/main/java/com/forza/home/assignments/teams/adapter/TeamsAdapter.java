package com.forza.home.assignments.teams.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forza.home.assignments.teams.R;
import com.forza.home.assignments.teams.model.object.Team;
import com.forza.home.assignments.teams.view.MuseoTextView;

import java.util.List;

/**
 * Created by Pouria on 2/9/2018.
 */

public class TeamsAdapter extends Adapter<TeamsAdapter.ViewHolder> {
    private List<Team> _teamsList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public MuseoTextView teamTitle;
        public MuseoTextView teamNational;
        public MuseoTextView teamCountry;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            teamTitle = (MuseoTextView) v.findViewById(R.id.team_title);
            teamNational = (MuseoTextView) v.findViewById(R.id.team_national);
            teamCountry = (MuseoTextView) v.findViewById(R.id.team_country);
        }
    }

    public TeamsAdapter(List<Team> _teamsList) {
        this._teamsList = _teamsList;
    }

    @Override
    public TeamsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.team_row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(TeamsAdapter.ViewHolder holder, final int position) {
        final String teamTitle = _teamsList.get(position).getName();
        final String teamCountry = _teamsList.get(position).getCountryName();
        final String teamNational = (_teamsList.get(position).getNational()?"National":"Club");
        holder.teamTitle.setText(teamTitle);
        holder.teamCountry.setText(teamCountry);
        holder.teamNational.setText(teamNational);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                remove(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return _teamsList.size();
    }
    public void add(int position, Team item) {
        _teamsList.add(position, item);
        notifyItemInserted(position);
        notifyDataSetChanged();
    }

    public void remove(int position) {
        _teamsList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

}
