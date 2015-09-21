package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import app.ics.westtabs.com.govassurance.R;
import pojo.Assurance;

/**
 * Created by eit on 9/14/15.
 */
public class AssurancesAdapter extends ArrayAdapter<Assurance> {

    private Context context;
    private List<Assurance> assuranceList;

    public AssurancesAdapter(Context ctx, List<Assurance> assuranceList) {
        super(ctx, android.R.layout.simple_list_item_1, assuranceList);

        this.assuranceList = assuranceList;
        this.context = ctx;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.assurance_row_list, null);
        }

        Assurance a = assuranceList.get(position);

        TextView titleTextView = (TextView) v.findViewById(R.id.titleTextView);
        titleTextView.setText(a.getTitle());

        TextView statusTextView = (TextView) v.findViewById(R.id.statusTextView);
        statusTextView.setText(a.getStatus());

        TextView startDate = (TextView) v.findViewById(R.id.startDateTextView);
        startDate.setText(a.getStartDate());

        TextView commentCount = (TextView) v.findViewById(R.id.commentCountTextView);
        commentCount.setText(a.getCommentCount());

        TextView summaryTextView = (TextView) v.findViewById(R.id.summaryTextView);
        summaryTextView.setText(a.getSummary());

        return v;
    }
}
