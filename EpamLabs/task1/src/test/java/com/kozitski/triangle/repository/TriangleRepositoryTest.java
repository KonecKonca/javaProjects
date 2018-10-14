package com.kozitski.triangle.repository;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.register.TriangleRegister;
import com.kozitski.triangle.util.search.SearchRequirement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kozitski.triangle.util.sort.SortRequirements.*;
import static org.testng.Assert.*;

public class TriangleRepositoryTest {
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
    public void searchByIdTest() {
        TriangleRepository repository = TriangleRepository.getTriangleRepository();

        SearchRequirement requirement = new SearchRequirement.Builder().setId(2).build();
        List<Triangle> list = repository.query(requirement.ALL_WITH_EQUALS_ID);

        Triangle actual = triangles.get(1);
        Triangle expected = list.get(0);

        assertEquals(actual, expected);

    }
    @Test
    public void searchInSquareRangeTest() {
        TriangleRepository repository = TriangleRepository.getTriangleRepository();

        SearchRequirement requirement = new SearchRequirement.Builder().setMinSquare(0.1).setMaxSquare(1.6).build();
        List<Triangle> list = repository.query(requirement.ALL_WITH_SQUARE_IN_RANGE);

        Triangle actual = triangles.get(4);
        Triangle expected = list.get(0);

        assertEquals(actual, expected);

    }
    @Test
    public void searchWithFirstCoordinateTest() {
        TriangleRepository repository = TriangleRepository.getTriangleRepository();

        SearchRequirement requirement = new SearchRequirement.Builder().setFirstXCoordinate(10).setFirstYCoordinate(10).build();
        List<Triangle> list = repository.query(requirement.ALL_WITH_FIRST_COORDINATE);

        Triangle actual = triangles.get(5);
        Triangle expected = list.get(0);

        assertEquals(actual, expected);

    }

    @Test(dataProvider = "dataForPutGet")
    public void putGetTest(Triangle actual, Triangle triangle) {
        TriangleRepository repository = TriangleRepository.getTriangleRepository();
        repository.add(triangle);

        Triangle expected = repository.get(repository.size() - 1);

        repository.remove(triangle);

        assertEquals(actual, expected);
    }
    @DataProvider(name = "dataForPutGet")
    public Object[][] dataForTrueValidation(){
        return new Object[][]{
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 1), PointForTriangle.getInstance(1, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 1), PointForTriangle.getInstance(1, 0))},
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 2), PointForTriangle.getInstance(2, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 2), PointForTriangle.getInstance(2, 0))},
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 3), PointForTriangle.getInstance(3, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 3), PointForTriangle.getInstance(3, 0))},
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 4), PointForTriangle.getInstance(4, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 4), PointForTriangle.getInstance(4, 0))},
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 5), PointForTriangle.getInstance(5, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 5), PointForTriangle.getInstance(5, 0))},
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 6), PointForTriangle.getInstance(6, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 6), PointForTriangle.getInstance(6, 0))},
                {Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 7), PointForTriangle.getInstance(7, 0)),
                        Triangle.getInstance(PointForTriangle.getInstance(0, 0), PointForTriangle.getInstance(0, 7), PointForTriangle.getInstance(7, 0))}
        };
    }

}
