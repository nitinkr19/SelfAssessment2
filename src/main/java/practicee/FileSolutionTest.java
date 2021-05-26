package main.java.practicee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileSolutionTest {

  FileSolution fileSolution = new FileSolution();

  @Test
  void mkdir() throws Exception {
  }

  @Test
  void testAllFunctionalities() throws Exception {

//    fileSolution.mkdir("/");
    fileSolution.mkdir("/foo/");
    fileSolution.mkdir("/foo/bar/");

    String content = "File Starts!";
    fileSolution.writeFile("/foo/bar/file.txt", content);
    assertEquals(content, fileSolution.readFile("/foo/bar/file.txt"));
  }

  @Test
  void testCaseInvalid1() throws Exception {
    fileSolution.mkdir("/foo/bar");
  }

  @Test
  void testCaseInvalid2() throws Exception {
    fileSolution.readFile("/foo/file.txt");
  }

  @Test
  void testCaseInvalid3() throws Exception {
    fileSolution.writeFile("/foo/file.txt", "sample content");
  }

  @Test
  void testCaseInvalid4() throws Exception {
    fileSolution.mkdir("/foo/");
    fileSolution.mkdir("/foo/bar/");
    fileSolution.mkdir("/foo/bar/");
  }
}