package test.java.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import main.java.practice.arrays.FileSystem;
import main.java.practice.arrays.IFileSystem;
import org.junit.jupiter.api.Test;

class FileSystemTest {

  /**
   * Your FileSystem object will be instantiated and called as such:
   * FileSystem obj = new FileSystem();
   * List<String> param_1 = obj.ls(path);
   * obj.mkdir(path);
   * obj.addContentToFile(filePath,content);
   * String param_4 = obj.readContentFromFile(filePath);
   */

  IFileSystem fileSystem = new FileSystem();

  @Test
  void testFileSystem() {

    setUpFileSystem();

    String path = "/Personal/Movies/English/Horror/";
    List<String> list = fileSystem.ls(path);
    System.out.println(list);
    assertEquals(4, list.size());
  }

  @Test
  void ls() {
    setUpFileSystem();
    String path = "/Personal/Movies/English/";
    List<String> files = fileSystem.ls(path);
    System.out.println(files);
    assertEquals(2, files.size());
  }

  @Test
  void addContent() {

    setUpFileSystem();

    String filePath = "/Personal/Movies/English/Horror/Conjuring1/part1.mov";
    String content = "Part 1 starts!";
//    fileSystem.addContent(filePath, content);
    assertEquals(content, fileSystem.getContent(filePath));
  }

  @Test
  void getContent() {
  }

  @Test
  void mkDir() {
  }

  @Test
  void tree() {
    setUpFileSystem();
    String path = "/Personal/Movies/English";
    List<String> list = fileSystem.tree(path);
    assertEquals(9, list.size());
  }

  private void setUpFileSystem() {
    String path1 = "/Personal/Movies/English/Horror/Conjuring1";
    String path2 = "/Personal/Movies/English/Horror/Conjuring2";
    String path3 = "/Personal/Movies/English/Horror/Insidious1";
    String path4 = "/Personal/Movies/English/Horror/Insidious2";
    String path5 = "/Personal/Movies/English/Comedy/DumbAndDumber1";
    String path6 = "/Personal/Movies/English/Comedy/DumbAndDumber2";

    fileSystem.mkDir(path1);
    fileSystem.mkDir(path2);
    fileSystem.mkDir(path3);
    fileSystem.mkDir(path4);
    fileSystem.mkDir(path5);
    fileSystem.mkDir(path6);

    String filePath = "/Personal/Movies/English/Horror/Conjuring1/part1.mov";
    String content = "Part 1 starts!";
    fileSystem.addContent(filePath, content);
  }
}