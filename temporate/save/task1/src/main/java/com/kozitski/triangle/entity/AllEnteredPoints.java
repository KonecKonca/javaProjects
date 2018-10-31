package com.kozitski.triangle.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AllEnteredPoints {
    private List<PointForTriangle> points;
    private List<String> invalidStrings;

    public AllEnteredPoints() {
        points = new ArrayList<>();
        invalidStrings = new ArrayList<>();
    }

    public PointForTriangle getPoint(int index) {
        return points.get(index);
    }
    public PointForTriangle setPoint(int index, PointForTriangle element) {
        return points.set(index, element);
    }
    public boolean addAllPoint(Collection<? extends PointForTriangle> c) {
        return points.addAll(c);
    }
    public boolean addPoint(PointForTriangle point) {
        return points.add(point);
    }
    public int pointsSize() {
        return points.size();
    }

    public String getInvalidString(int index) {
        return invalidStrings.get(index);
    }
    public void addInvalidStrings(String element) {
        invalidStrings.add(element);
    }
    public boolean addAllInvalidStrings(Collection<? extends String> c) {
        return invalidStrings.addAll(c);
    }
    public int invalidStringsSize() {
        return invalidStrings.size();
    }
    public String allInvalidsToString(){
        return  invalidStrings.toString();
    }

    @Override
    public String toString() {
        return "AllEnteredPoints{" +
                "points=" + points +
                ", invalidStrings=" + invalidStrings +
                '}';
    }
}
