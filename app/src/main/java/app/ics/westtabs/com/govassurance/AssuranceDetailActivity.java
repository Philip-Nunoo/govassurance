package app.ics.westtabs.com.govassurance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import pojo.Assurance;

public class AssuranceDetailActivity extends AppCompatActivity {

    private TextView titleTextView;
    private Assurance assurance;
    private TextView sourceTextView, statusTextView, detailsTextView, sourceUrlTextView,
            dateTextView, completionTextView, officialTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assurance_detail);

        Intent intent = getIntent();
        this.assurance = (Assurance) intent.getSerializableExtra("assurance");

        this.initViews();
//        Toast.makeText(AssuranceDetailActivity.this, assurance.getTitle(), Toast.LENGTH_LONG).show();

        titleTextView.setText(assurance.getTitle());
        sourceTextView.setText(assurance.getSource());
        statusTextView.setText(assurance.getStatus());
        detailsTextView.setText(assurance.getSummary());
        sourceUrlTextView.setText(assurance.getSourceUrl());
        dateTextView.setText(assurance.getStartDate());
        completionTextView.setText(assurance.getCompletionDate());
        /*officialTextView.setText(assurance.getOfficial().toString());*/

    }

    private void initViews(){
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        sourceTextView = (TextView) findViewById(R.id.sourceTextView);
        statusTextView = (TextView) findViewById(R.id.statusTextView);
        detailsTextView = (TextView) findViewById(R.id.detailsTextView);
        sourceUrlTextView = (TextView) findViewById(R.id.sourceUrlTextView);
        dateTextView = (TextView) findViewById(R.id.dateTextView);
        completionTextView = (TextView) findViewById(R.id.completionTextView);
        // official user
        officialTextView = (TextView) findViewById(R.id.officialTextView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_assurance_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
