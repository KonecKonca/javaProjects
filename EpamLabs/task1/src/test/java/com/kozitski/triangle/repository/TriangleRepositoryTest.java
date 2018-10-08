package com.kozitski.triangle.repository;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import org.testng.annotations.Test;

import static com.kozitski.triangle.util.sort.SortRequirements.*;
import static org.testng.Assert.*;

public class TriangleRepositoryTest {

    @Test
    public void testGetTriangleRepository() {
        TriangleRepository repository = TriangleRepository.getTriangleRepository();
        System.out.println(repository);
        Triangle triangle1 = Triangle.getInstance(PointForTriangle.getInstance(1, 0),
                PointForTriangle.getInstance(32, 34), PointForTriangle.getInstance(20, 43));
        Triangle triangle2 = Triangle.getInstance(PointForTriangle.getInstance(2, 0),
                PointForTriangle.getInstance(32, 34), PointForTriangle.getInstance(20, 43));
        Triangle triangle3 = Triangle.getInstance(PointForTriangle.getInstance(1, 34),
                PointForTriangle.getInstance(2, 54), PointForTriangle.getInstance(2, 3));
        Triangle triangle4 = Triangle.getInstance(PointForTriangle.getInstance(1, 27),
                PointForTriangle.getInstance(22, 54), PointForTriangle.getInstance(2, 3));
        Triangle triangle5 = Triangle.getInstance(PointForTriangle.getInstance(2, 2),
                PointForTriangle.getInstance(4, 54), PointForTriangle.getInstance(3, 3));
        Triangle triangle6 = Triangle.getInstance(PointForTriangle.getInstance(1, 27),
                PointForTriangle.getInstance(5, 4), PointForTriangle.getInstance(32, 3));

        System.out.println(repository);

        repository.sortTriangles(X_FIRST_POINT_FUNCTION);
        System.out.println(repository);

        repository.sortTriangles(X_FIRST_POINT_FUNCTION, Y_FIRST_POINT_FUNCTION, X_SECOND_POINT_FUNCTION);
        System.out.println(repository);



    }

    @Test
    public void testAdd() {

    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testQuery() {
    }
}