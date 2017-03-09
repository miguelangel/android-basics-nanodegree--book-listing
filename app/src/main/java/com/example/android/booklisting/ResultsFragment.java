package com.example.android.booklisting;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of results.
 */
public class ResultsFragment extends Fragment {
    public ResultsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.results_list, container, false);

        // Get the results in json
        String json = getActivity().getIntent().getStringExtra(getString(R.string.param_results));

        // Create a list of results
        final ArrayList<Result> results = parseResults(json);

        // Create an {@link ResultAdapter}, whose data source is a list of {@link Result}s. The
        // adapter knows how to create list items for each item in the list.
        ResultAdapter adapter = new ResultAdapter(getActivity(), results);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // results_list layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ResultAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Result} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }

    /**
     * @param jsonSearchResponse Search result in json format
     *
     * @return a list of Result object based on the jsonSearchResponse
     */
    private ArrayList<Result> parseResults(String jsonSearchResponse) {
        ArrayList<Result> results = new ArrayList<Result>();
        try {
            JSONObject jsonRootObject = null;

            jsonRootObject = new JSONObject(jsonSearchResponse);

            // Iterate the results in JSON format and create an ArrauList of Result objects
            JSONArray items = jsonRootObject.optJSONArray("items");
            for(int i=0; i < items.length(); i++){
                try {
                    JSONObject volumeInfo =
                            items.getJSONObject(i).getJSONObject(getString(R.string.json_volume_info));

                    String title = volumeInfo.optString(getString(R.string.json_title)).trim();
                    String publisher = volumeInfo.optString(getString(R.string.json_publisher)).trim();
                    String publishedDate = volumeInfo.optString(getString(R.string.json_published_date)).trim();

                    results.add(new Result(title, publisher, publishedDate));
                } catch (JSONException e) {
                    Log.e(MainActivity.class.getSimpleName(), e.toString());
                }
            }
        } catch (JSONException e) {
            Log.e(MainActivity.class.getSimpleName(), e.toString());
        }

        return results;
    }
}