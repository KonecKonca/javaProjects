package com.kozitski.triangle.entity;


import com.kozitski.triangle.exception.InvalidCoordinateException;
import com.kozitski.triangle.service.generators.TriangleIdGenerator;
import com.kozitski.triangle.util.TriangleUtils;
import com.kozitski.triangle.validator.TriangleValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Triangle {
    private long id;
    private List<Double> sides = new ArrayList<>(3);
    private List<Double> angles = new ArrayList<>(3);



    private Triangle(){}
    public static Triangle getInstance(PointForTriangle point1, PointForTriangle point2, PointForTriangle point3){
        TriangleValidator validator = new TriangleValidator();
        try {
            validator.validate(point1, point2, point3);
        } catch (InvalidCoordinateException e) {

            // here must be logger

            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            illegalArgumentException.addSuppressed(e);
            throw illegalArgumentException;
        }

        Triangle triangle = new Triangle();
        triangle.id = TriangleIdGenerator.getId();
        triangle.sides.addAll(TriangleUtils.getSides(point1, point2, point3));
        triangle.angles.addAll(TriangleUtils.getAngles(triangle.sides.get(0), triangle.sides.get(1), triangle.sides.get(2)));

        return triangle;
    }

    public Double getSide(int index) {
        return sides.get(index);
    }
    public Double getAngle(int index) {
        return angles.get(index);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(sides, triangle.sides) &&
                Objects.equals(angles, triangle.angles);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sides, angles);
    }
    @Override
    public String toString() {
        return "Triangle{" +
                "id=" + id +
                ", sides=" + sides +
                ", angles=" + Math.toDegrees(angles.get(0)) + " " + Math.toDegrees(angles.get(1)) + " " + Math.toDegrees(angles.get(2)) +
                '}';
    }
}
