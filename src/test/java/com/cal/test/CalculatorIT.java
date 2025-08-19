package com.cal.test;

import com.cal.Calculator;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static java.lang.String.format;

public class CalculatorIT {

    private Calculator c;
    private File outFile;

    @BeforeClass
    public void setUp() throws IOException {
        c = new Calculator();

        // Output file in target/it-results
        File outDir = new File(System.getProperty("user.dir"), "target/it-results");
        if (!outDir.exists()) {
            outDir.mkdirs();
        }
        outFile = new File(outDir, "calculator-results.txt");
    }

    @Test
    public void endToEnd_writeResultsToFile() throws IOException {
        // Calculate results
        double add = c.add(10.0, 20.0);
        double sub = c.sub(10.0, 20.0);
        double mul = c.mul(10.0, 20.0);
        double div = c.div(10.0, 2.0);
        double divByZero = c.div(10.0, 0.0); // returns 0.0 in current implementation

        // Prepare lines
        List<String> lines = Arrays.asList(
            format(Locale.ENGLISH, "add(10.0,20.0)=%.6f", add),
            format(Locale.ENGLISH, "sub(10.0,20.0)=%.6f", sub),
            format(Locale.ENGLISH, "mul(10.0,20.0)=%.6f", mul),
            format(Locale.ENGLISH, "div(10.0,2.0)=%.6f", div),
            format(Locale.ENGLISH, "div(10.0,0.0)=%.6f", divByZero)
        );

        // Write lines in one step using Apache Commons IO
        FileUtils.writeLines(outFile, lines);

        // Verify file exists and content matches
        Assert.assertTrue(outFile.exists(), "Output file should exist");
        List<String> actual = FileUtils.readLines(outFile, StandardCharsets.UTF_8);
        Assert.assertEquals(actual, lines, "File content mismatch");
    }
}
