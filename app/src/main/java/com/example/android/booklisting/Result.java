package com.example.android.booklisting;

/**
 * {@link Result} represents an attraction in a city
 * It contains a name, opening days and picture.
 */
public class Result {
    /** Result title */
    private String mTitle;

    /** Result publisher */
    private String mPublisher;

    /** Result published date */
    private String mPublishedDate;
    /**
     * Create a new Result object.
     *
     * @param title is the result title
     * @param publisher is the result publisher
     */
    public Result(String title, String publisher, String publishedDate) {
        mTitle = title;
        mPublisher = publisher;
        mPublishedDate = publishedDate;
    }

    /**
     * Get the result title.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the result publisher.
     */
    public String getPublisher() {
        return mPublisher;
    }

    /**
     * Get the result published date.
     */
    public String getPublishedDate() {
        return mPublishedDate;
    }
}