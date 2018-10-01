package com.kozitski.triangle.validator;

import com.kozitski.triangle.exception.InvalidAngleException;
import com.kozitski.triangle.exception.InvalidSideException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TriangleValidator {
    private Properties properties;

    public TriangleValidator() {
        properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/main/resources/config/validationConfigurations.properties")){
            properties.load(fileInputStream);
        } catch (IOException e) {

            //  here must be logger

        }
    }

    public void validateSides(double side1, double side2, double side3) throws InvalidSideException {
        int minSide =  Integer.parseInt(properties.getProperty("sidesLoverBound"));
        int maxSide = Integer.parseInt(properties.getProperty("sidesHigherBound"));

        if((side1 < minSide || side2 < minSide || side3 < minSide) ||
                (side1 > maxSide || side2 > maxSide || side3 > maxSide) ||
                    checkSidesAdditionalCondition(side1, side2, side3)){
            throw new InvalidSideException("Input values are invalid: " + side1 + ", " + side2 + ", " + side3);
        }
    }
    // here mathematics conditions
    private boolean checkSidesAdditionalCondition(double side1, double side2, double side3){
        return !(((side1 + side2) > side3) || ((side1 + side3) > side2) || ((side3 + side2) > side1));
    }

    public void validateAngles(double angle1, double angle2, double angle3) throws InvalidAngleException {
        int minAngle =  Integer.parseInt(properties.getProperty("anglesLoverBound"));
        int maxAngle = Integer.parseInt(properties.getProperty("anglesHigherBound"));

        if((angle1 < minAngle || angle2 < minAngle || angle3 < minAngle) ||
                (angle1 > maxAngle || angle2 > maxAngle || angle3 > maxAngle) /*||
                    !checkAnglesAdditionalCondition(angle1, angle2, angle3)*/
                    ){
            throw new InvalidAngleException("Input values are invalid: " + angle1 + ", " + angle2 + ", " + angle3);
        }
    }
    // here mathematics conditions
    private boolean checkAnglesAdditionalCondition(double angle1, double angle2, double angle3){
        if(Math.toDegrees((angle1 + angle2 + angle3)) > 180){
            return false;
        }
        return true;
    }

}
