package com.kozitski.triangle.util;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.service.TriangleOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

public class TriangleUtils {

    private static final Logger LOGGER = LogManager.getLogger(TriangleUtils.class);

    public static List<Double> getSides(PointForTriangle point1, PointForTriangle point2, PointForTriangle point3){
        return new ArrayList<>(Arrays.asList(
                sqrt(pow((point1.getCoordinateX() - point2.getCoordinateX()), 2) + pow((point1.getCoordinateY() - point2.getCoordinateY()), 2)),
                sqrt(pow((point1.getCoordinateX() - point3.getCoordinateX()), 2) + pow((point1.getCoordinateY() - point3.getCoordinateY()), 2)),
                sqrt(pow((point2.getCoordinateX() - point3.getCoordinateX()), 2) + pow((point2.getCoordinateY() - point3.getCoordinateY()), 2))
        ));
    }
    public static List<Double> getAngles(double side1, double side2, double side3){

        return new ArrayList<Double>(Arrays.asList(
                acos((pow(side2, 2) + pow(side3, 2) - pow(side1, 2)) / (2 * side2 * side3)),
                acos((pow(side1, 2) + pow(side3, 2) - pow(side2, 2)) / (2 * side1 * side3)),
                acos((pow(side1, 2) + pow(side2, 2) - pow(side3, 2)) / (2 * side1 * side2))

        ));
    }
    public static boolean isCanBeTriangle(PointForTriangle point1, PointForTriangle point2,PointForTriangle point3){
        if((point1.getCoordinateX() == point2.getCoordinateX() && point1.getCoordinateX() == point3.getCoordinateX()) ||
                (point1.getCoordinateY() == point2.getCoordinateY() && point1.getCoordinateY() == point3.getCoordinateY())){
            LOGGER.info("Current combination of points can NOT be triangle");
            return false;
        }
        LOGGER.info("Current combination of points can be triangle");
        return true;
    }

}
