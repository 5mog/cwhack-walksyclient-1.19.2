package net.walksy.client.config.settings;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    public final Object defaultValue;
    public Object value;

    private Object max = null, min = null;

    /**
     * Checks if the value is a numerical value
     * @return true if the value is a numerical value
     */
    public boolean isNumerical() {
        return (this.value instanceof Number);
    }

    /**
     * Gets if the value has a range
     * @return true if the value has a range
     */
    public boolean hasRange() {
        // Check the value is numerical
        if (!this.isNumerical()) return false;

        // Check we have a max and min
        return max != null && min != null;
    }

    public void setMax(Number max) {
        this.max = max;
    }

    public void setMin(Number min) {
        this.min = min;
    }

    public Object getMax() {
        return max;
    }

    public Object getMin() {
        return min;
    }

    public final String name;

    /**
     * Describes what the setting is used for.
     */
    private String description = "";

    /**
     * Gets the description of the setting
     * @return the description of the setting
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the setting
     * @param description the description of the setting
     */
    public void setDescription(String description) {
        this.description = description;
    }

    private List<String> suggestions = new ArrayList<>();

    public List<String> getSuggestions() {
        return this.suggestions;
    }

    public Setting(String name, Object defaultValue, String... valueSuggestions) {
        this(name, defaultValue);

        for (String sug : valueSuggestions) {
            this.suggestions.add(sug);
        }
    }

    public Setting(String name, Object defaultValue) {
        this.defaultValue = defaultValue;
        this.name = name;

        this.value = defaultValue;
        this.suggestions.add(defaultValue.toString());
    }

    /**
     * Gets a menu tool tip for a given setting
     * @return
     */
    public String getToolTip() {
        return this.getDescription().isBlank() 
            ? String.format("No Description. (default: %s)", this.defaultValue.toString())
            : String.format("%s. (default: %s)", this.getDescription(), this.defaultValue.toString());
    }

    /**
     * Gets if the setting should be shown in the menu
     * @return true if the setting should be shown in the menu, false otherwise
     */
    public boolean shouldShow() {
        return true;
    }

    protected String category = null;

    /**
     * Gets the category of the setting
     * @return the category of the setting
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the setting
     * @param category the category of the setting
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Checks if the setting has a category
     * @return true if the setting has a category, false otherwise
     */
    public boolean hasCategory() {
        return this.category != null;
    }

    /**
     * Gets the name of the setting in a more human readable format
     * @return setting nice name
     */
    public String getNiceName() {
        String name = this.name;

        // Separate the CamelCase with spaces
        name = name.replaceAll(
            String.format("%s|%s|%s",
                "(?<=[A-Z])(?=[A-Z][a-z])",
                "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"
            ),
            " "
        );

        return name;
    }
}
