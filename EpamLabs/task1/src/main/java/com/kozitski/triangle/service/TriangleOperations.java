package com.kozitski.triangle.service;

import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import org.apache.log4j.Logger;

import static java.lang.Math.*;


public class TriangleOperations {

    private static final Logger logger = Logger.getLogger(TriangleOperations.class);

    public static double perimeter(Triangle triangle){
        return (triangle.getSide(0) + triangle.getSide(1) + triangle.getSide(2));
    }
    public static double square(Triangle triangle){
        double p = perimeter(triangle)/2;
        return sqrt(p * (p - triangle.getSide(0)) * (p - triangle.getSide(1)) * (p - triangle.getSide(2)));
    }

    public static boolean isRectangular(Triangle triangle){
        if((Math.round(Math.toDegrees(triangle.getAngle(0))) == 90)
            || (Math.round(Math.toDegrees(triangle.getAngle(1))) == 90)
                ||(Math.round(Math.toDegrees(triangle.getAngle(2))) == 90)){
            logger.debug("isRectangular = true");
         return true;
        }
        logger.debug("isRectangular = false");
        return false;
    }
    public static boolean isEquilateral(Triangle triangle){
        if((Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(1))) &&
                (Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(2)))){
            logger.debug("isEquilateral = true");
            return true;
        }
        logger.debug("isEquilateral = false");
        return false;
    }
    public static boolean isIsosceles(Triangle triangle){
        if(
                (Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(1))) ||
                        (Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(2))) ||
                        (Math.round(triangle.getSide(1)) == Math.round(triangle.getSide(2)))

        ){
            logger.debug("isIsosceles = true");
            return true;
        }
        logger.debug("isIsosceles = false");
        return false;
    }
    public static boolean isObtuse(Triangle triangle){
        if((Math.round(Math.toDegrees(triangle.getAngle(0))) > 90)
                || (Math.round(Math.toDegrees(triangle.getAngle(1))) > 90)
                ||(Math.round(Math.toDegrees(triangle.getAngle(2))) > 90)){
            logger.debug("isObtuse = true");
            return true;
        }
        logger.debug("isObtuse = false");
        return false;
    }

}
