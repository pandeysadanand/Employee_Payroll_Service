package com.bl.EmployeePayrollService;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NIOFileAPITest {
    private static final String HOME = System.getProperty("user.home");
    private static final String PLAY_WITH_NIO = "PlayGround";

    @Test
    public void givenPathName_WhenChecked_ThenConfirm() throws IOException {
        // check file exists
        Path homePath = Paths.get(HOME);
        Assert.assertTrue(Files.exists(homePath));

        // Delete File and Check File Not Exist
        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        if (Files.exists(playPath))
            FileUtil.deleteFile(playPath.toFile());
        Assert.assertTrue(Files.notExists(playPath));

        // Create Directory
        Files.createDirectory(playPath);
        Assert.assertTrue(Files.exists(playPath));

        // Create File
        IntStream.range(1, 10).forEach(ctr -> {
            Path tempFile = Paths.get(playPath + "/temp" + ctr);
            Assert.assertTrue(Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException e) {
                Assert.assertTrue(Files.exists(tempFile));
            }
        });

        // List Files, Directories as well as Files with Extension
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path -> path.toFile().isFile() &&
                path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
