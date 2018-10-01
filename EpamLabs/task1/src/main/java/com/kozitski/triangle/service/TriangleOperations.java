package com.kozitski.triangle.service;

import com.kozitski.triangle.entity.Triangle;

import static java.lang.Math.*;

public class TriangleOperations {

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
         return true;
        }
        return false;
    }
    public static boolean isEquilateral(Triangle triangle){
        if((Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(1))) &&
                (Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(2)))){
            return true;
        }
        return false;
    }
    public static boolean isIsosceles(Triangle triangle){
        if(
                (Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(1))) ||
                        (Math.round(triangle.getSide(0)) == Math.round(triangle.getSide(2))) ||
                        (Math.round(triangle.getSide(1)) == Math.round(triangle.getSide(2)))

        ){
            return true;
        }
        return false;
    }
    public static boolean isObtuse(Triangle triangle){
        if((Math.round(Math.toDegrees(triangle.getAngle(0))) > 90)
                || (Math.round(Math.toDegrees(triangle.getAngle(1))) > 90)
                ||(Math.round(Math.toDegrees(triangle.getAngle(2))) > 90)){
            return true;
        }
        return false;
    }

}
