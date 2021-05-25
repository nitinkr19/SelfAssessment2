package main.java.practice.arrays;

import java.util.List;

public interface IFileSystem {

  List<String> ls(String path);

  void addContent(String filePath, String content);

  String getContent(String filePath);

  void mkDir(String path);

  List<String> tree(String path);
}
