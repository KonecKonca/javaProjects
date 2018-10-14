package com.kozitski.triangle.util.sort;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.repository.TriangleRepository;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kozitski.triangle.util.sort.SortRequirements.X_FIRST_POINT_FUNCTION;
import static com.kozitski.triangle.util.sort.SortRequirements.Y_FIRST_POINT_FUNCTION;
import static org.testng.Assert.assertEquals;

public class TriangleSortByFirstPointTest {
    public List<Triangle> triangles;

    @BeforeClass
    public void init(){
        triangles = new ArrayList<>();
        Triangle triangle1 = Triangle.getInstance(PointForTriangle.getInstance(1, 0),
                PointForTriangle.getInstance(32, 34), PointForTriangle.getInstance(20, 43));
        Triangle triangle2 = Triangle.getInstance(PointForTriangle.getInstance(2, 0),
                PointForTriangle.getInstance(32, 34), PointForTriangle.getInstance(20, 43));
        Triangle triangle3 = Triangle.getInstance(PointForTriangle.getInstance(1, 34),
                PointForTriangle.getInstance(2, 54), PointForTriangle.getInstance(2, 3));
        Triangle triangle4 = Triangle.getInstance(PointForTriangle.getInstance(1, 27),
                PointForTriangle.getInstance(22, 54), PointForTriangle.getInstance(2, 3));
        Triangle triangle5 = Triangle.getInstance(PointForTriangle.getInstance(0, 0),
                PointForTriangle.getInstance(0, 1), PointForTriangle.getInstance(1, 0));
        Triangle triangle6 = Triangle.getInstance(PointForTriangle.getInstance(10, 10),
                PointForTriangle.getInstance(5, 4), PointForTriangle.getInstance(32, 3));
        triangles.add(triangle1);
        triangles.add(triangle2);
        triangles.add(triangle3);
        triangles.add(triangle4);
        triangles.add(triangle5);
        triangles.add(triangle6);
    }


    @Test
    public void sortByFirstPointTest(){
        TriangleRepository repository = TriangleRepository.getTriangleRepository();
        repository.sortTriangles(X_FIRST_POINT_FUNCTION, Y_FIRST_POINT_FUNCTION);
        List<Triangle> expected = repository.getAllTriangles();

        List<Triangle> actual = new ArrayList<>();
        actual.add(triangles.get(4));
        actual.add(triangles.get(0));
        actual.add(triangles.get(3));
        actual.add(triangles.get(2));
        actual.add(triangles.get(1));
        actual.add(triangles.get(5));

        assertEquals(actual, expected);
    }


}
