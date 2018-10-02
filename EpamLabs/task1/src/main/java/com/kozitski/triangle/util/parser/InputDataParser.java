package com.kozitski.triangle.util.parser;

import com.kozitski.triangle.entity.AllEnteredPoints;
import com.kozitski.triangle.entity.PointForTriangle;
import com.kozitski.triangle.entity.Triangle;
import com.kozitski.triangle.exception.LessThanNecessaryPoints;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputDataParser {
    private static AllEnteredPoints allEnteredPoints;

    private static final Logger LOGGER = LogManager.getLogger(InputDataParser.class);

    public static AllEnteredPoints getAllPoints(String path){
        allEnteredPoints = new AllEnteredPoints();

        List<String> list = new ArrayList<>();

        try {
            list.addAll(Files.readAllLines(Paths.get(path)));
        } catch (IOException e) {
            LOGGER.fatal("file exists");
        }

        for(String str : list){
            List<String> currentPoint = new ArrayList<>(Arrays.asList(str.split(" ")));
            try {
                double x = Double.parseDouble(currentPoint.get(0));
                double y = Double.parseDouble(currentPoint.get(1));
                allEnteredPoints.addPoint(PointForTriangle.getInstance(x, y));
            }
            catch (NumberFormatException | IndexOutOfBoundsException e){
                allEnteredPoints.addInvalidStrings(currentPoint.toString());
            }
        }

        LOGGER.info(allEnteredPoints);
        if(allEnteredPoints.invalidStringsSize() > 0){
            LOGGER.error(allEnteredPoints.allInvalidsToString());
        }

        return allEnteredPoints;
    }
    public static Triangle getTriangle() throws LessThanNecessaryPoints{
        if(allEnteredPoints != null){
            if(allEnteredPoints.pointsSize() >= 3){
                return Triangle.getInstance(allEnteredPoints.getPoint(0), allEnteredPoints.getPoint(1), allEnteredPoints.getPoint(2));
            }
        }
        LOGGER.error("Less than 3 point");
        throw  new LessThanNecessaryPoints("Less than 3 points");
    }

}
