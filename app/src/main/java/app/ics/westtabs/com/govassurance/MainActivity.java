package app.ics.westtabs.com.govassurance;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import adapters.AssurancesAdapter;
import pojo.Assurance;
import pojo.Official;

public class MainActivity extends AppCompatActivity {
    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Assurance json url
    private static final String url = "http://admin.assurances.gov.gh:80/api/v1.0/assurances/";

    private ListView listView;
    private AssurancesAdapter adapter;
    private ProgressDialog pDialog;
    private List<Assurance> assuranceList = new ArrayList<Assurance>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.assuranceListView);

        adapter = new AssurancesAdapter(this, assuranceList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Assurance assurance = assuranceList.get(position);

                Intent intent = new Intent(MainActivity.this, AssuranceDetailActivity.class);
                intent.putExtra("assurance", assurance);

                startActivity(intent);
            }
        });

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // Creating volley request obj
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject responseObject) {
                        pDialog.hide();
                        try {
                            int count = responseObject.getInt("count");

                            if (count > 0) {
                                JSONArray jsonArray = responseObject.getJSONArray("results");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject assuranceJsonObject = jsonArray.getJSONObject(i);
                                    JSONObject officialJsonObject = assuranceJsonObject.getJSONObject("official");

                                    Official official = new Official();
                                    official.setId(officialJsonObject.getInt("id"));
                                    /*official.setUser(user);*/

                                    Assurance assurance = new Assurance();
                                    assurance.setId(assuranceJsonObject.getInt("id"));
                                    assurance.setTitle(assuranceJsonObject.getString("title"));
                                    assurance.setSource(assuranceJsonObject.getString("source"));
                                    assurance.setStatus(assuranceJsonObject.getString("get_status"));
                                    assurance.setSummary(assuranceJsonObject.getString("details"));
                                    assurance.setSourceUrl(assuranceJsonObject.getString("source_url"));
                                    assurance.setStartDate(assuranceJsonObject.getString("date"));
                                    assurance.setCompletionDate(assuranceJsonObject.getString("completion"));
                                    assurance.setEnableFeedback(assuranceJsonObject.getString("enable_feedback"));
                                    // official
//                                    assurance.setOfficial(official);
                                    assurance.setCommentCount(assuranceJsonObject.getString("comment_count"));

                                    assuranceList.add(assurance);
                                }
                                // notifying list adapter about data changes
                                // so that it renders the list view with updated data
                                adapter.notifyDataSetChanged();
                                Log.e(TAG, assuranceList.toString());
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.e(TAG, String.valueOf(error));
//                        pDialog.hide();
                    }
                });

        // Access the RequestQueue through your singleton class.
        AppController.getInstance().addToRequestQueue(jsObjRequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
