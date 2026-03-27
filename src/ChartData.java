package model;

import java.util.List;

public class ChartData {
    private final String title;
    private final List<Double> values;

    public ChartData(String title, List<Double> values) {
        this.title = title;
        this.values = values;
    }

    public String getTitle() { return title; }
    public List<Double> getValues() { return values; }
}
