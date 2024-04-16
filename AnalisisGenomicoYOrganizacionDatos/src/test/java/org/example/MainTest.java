package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            fail("Main method threw an exception: " + e.getMessage());
        }
    }
}