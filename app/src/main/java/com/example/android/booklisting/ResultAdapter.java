package com.example.android.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ResultAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Result} objects.
 */
public class ResultAdapter extends ArrayAdapter<Result>  {
    /**
     * Create a new {@link ResultAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param results is the list of {@link Result}s to be displayed.
     */
    public ResultAdapter(Context context, ArrayList<Result> results) {
        super(context, 0, results);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Result} object located at this position in the list
        Result currentResult = getItem(position);

        // Set the result title for the list item
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentResult.getTitle());

        // Set the publisher for the list item
        TextView publisherTextView = (TextView) listItemView.findViewById(R.id.publisher_text_view);
        publisherTextView.setText(currentResult.getPublisher());

        // Set the published date for the list item
        TextView publishedDateTextView = (TextView) listItemView.findViewById(R.id.published_date_text_view);
        publishedDateTextView.setText(currentResult.getPublishedDate());

        // Return the whole list item layoutso that it can be shown in the ListView.
        return listItemView;
    }
}