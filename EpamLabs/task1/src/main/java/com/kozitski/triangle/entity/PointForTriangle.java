package com.kozitski.triangle.entity;

import com.kozitski.triangle.exception.InvalidCoordinateException;
import com.kozitski.triangle.service.generators.PointForTriangleIdGenerator;
import com.kozitski.triangle.validator.PointForTriangleValidator;

import java.util.Objects;

public class PointForTriangle {
    private long id;
    private double coordinateX;
    private double coordinateY;

    private PointForTriangle() { }

    public static PointForTriangle getInstance(double coordinateX, double coordinateY){
        PointForTriangle point = new PointForTriangle();
        point.id = PointForTriangleIdGenerator.getId();

        PointForTriangleValidator validator = new PointForTriangleValidator();
        try {
            validator.validate(coordinateX, coordinateY);
        } catch (InvalidCoordinateException e) {

            // here must be logger

            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            illegalArgumentException.addSuppressed(e);
            throw illegalArgumentException;
        }

        point.coordinateX = coordinateX;
        point.coordinateY = coordinateY;
        return point;
    }

    public double getCoordinateX() {
        return coordinateX;
    }
    public double getCoordinateY() {
        return coordinateY;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointForTriangle)) return false;
        PointForTriangle that = (PointForTriangle) o;
        return getCoordinateX() == that.getCoordinateX() &&
                getCoordinateY() == that.getCoordinateY();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCoordinateX(), getCoordinateY());
    }

    @Override
    public String toString() {
        return "PointForTriangle{" +
                "id=" + id +
                ", coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }
}
