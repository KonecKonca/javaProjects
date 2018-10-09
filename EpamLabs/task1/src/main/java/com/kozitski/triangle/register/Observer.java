package com.kozitski.triangle.register;

import com.kozitski.triangle.entity.Triangle;

public interface Observer {
    void handleEvent(Triangle triangle);
}
