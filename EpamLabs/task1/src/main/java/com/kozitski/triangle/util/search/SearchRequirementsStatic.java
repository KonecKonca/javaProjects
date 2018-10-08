package com.kozitski.triangle.util.search;

import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.repository.Specification;
import com.kozitski.triangle.service.TriangleOperation;

import java.util.Comparator;

public class SearchRequirementsStatic {

    // expressions for search

    public static final Specification<Triangle> ALL_RECTANGULAR_TRIANGLES = TriangleOperation::isRectangular;
    public static final Specification<Triangle> ALL_EQUILATERAL_TRIANGLES = TriangleOperation::isEquilateral;
    public static final Specification<Triangle> ALL_ISOSCELES_TRIANGLES = TriangleOperation::isIsosceles;
    public static final Specification<Triangle> ALL_OBTUSE_TRIANGLES = TriangleOperation::isObtuse;

}
