package com.kozitski.triangle.entity;

import com.kozitski.triangle.exception.InvalidCoordinateException;
import com.kozitski.triangle.service.generators.PointForTriangleIdGenerator;
import com.kozitski.triangle.validator.PointForTriangleValidator;
import com.kozitski.triangle.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class PointForTriangle {
    private long id;
    private double coordinateX;
    private double coordinateY;

    private static final Logger logger = LogManager.getLogger(PointForTriangle.class);

    private PointForTriangle() { }

    public static PointForTriangle getInstance(double coordinateX, double coordinateY){
        PointForTriangle point = new PointForTriangle();
        point.id = PointForTriangleIdGenerator.getId();

        PointForTriangleValidator validator = new PointForTriangleValidator();
        try {
            validator.validate(coordinateX, coordinateY);
        } catch (InvalidCoordinateException e) {

            logger.error("Validation of PointForTriangle was failed: " + e);

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
