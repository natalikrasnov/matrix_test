package com.app.matrix_natali.ui.main.placeholder;

import com.app.matrix_natali.data.model.DataListObject;
import com.app.matrix_natali.data.model.DataObjectCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();


    public static void setItems(DataObjectCategory[] dataObj){
        // Add some sample items.
        for (int i = 1; i <= dataObj.length; i++) {
            addItem(createPlaceholderItem(dataObj[i]));
        }
    }

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = ITEMS.size();

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.title, item);
    }

    private static PlaceholderItem createPlaceholderItem(DataObjectCategory obj) {
        return new PlaceholderItem(obj.getCategory().getCTitle(), obj.getDataListCat());
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String title;
        public final DataListObject[] content;

        public PlaceholderItem(String title, DataListObject[] content) {
            this.title = title;
            this.content = content;
        }

        @Override
        public String toString() {
            return title;
        }
    }
}