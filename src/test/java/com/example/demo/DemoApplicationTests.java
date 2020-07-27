package com.example.demo;

import com.example.demo.core.PositionManagementTest;
import com.example.demo.core.ShipmentManamentTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        try {

            new PositionManagementTest().testHandleInput();

            new ShipmentManamentTest().testShipNode();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
