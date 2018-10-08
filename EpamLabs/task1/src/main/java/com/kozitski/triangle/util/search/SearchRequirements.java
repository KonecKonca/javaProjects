package com.kozitski.triangle.util.search;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.repository.Specification;

public class SearchRequirements{
    private long maxId = 100;
    private long minId = 1;
    private long id = 1;

    private double xCoordinate = 2;
    private double YCoordinate = 2;
    private double xMinCoordinate = -10;
    private double xMaxCoordinate = 10;
    private double yMinCoordinate = -10;
    private double yMaxCoordinate = 10;

    private double perimeter = 10;
    private double square = 10;
    private double minPerimeter = 1;
    private double maxPerimeter = 100;
    private double minSquare = 1;
    private double maxSquare = 100;

    private static final double xStartOfCoordinate = 0;
    private static final double yStartOfCoordinate = 0;
    private double minDistance = 10;
    private double maxDistance = 100;

    public static final Specification<Triangle> ALL_ = t -> t.getTriangleId() > 0;

    public static class Builder{
        public Builder() {

        }

    }


}
