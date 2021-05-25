package main.java.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem implements IFileSystem {

  public static final String ROOT_DIR_PATH = "/";
  public static final String FILE_SEPARATOR = "/";
  Dir root;
  private List<String> listOfFiles = new ArrayList<>();

  public FileSystem() {
    root = new Dir();
  }

  @Override
  public List<String> ls(String path) {

    Dir t = root;
    List<String> list = new ArrayList<>();

    if (!path.equals(ROOT_DIR_PATH)) {

      String[] d = path.split(FILE_SEPARATOR);
      for (int i = 1; i < d.length - 1; i++) {
        t = t.dirs.get(d[i]);
      }

      if (t.dirs.containsKey(d[d.length - 1])) {
        t = t.dirs.get(d[d.length - 1]);
      } else {
        list.add(d[d.length - 1]);
        return list;
      }

    }
    list.addAll(new ArrayList<>(t.dirs.keySet()));
    list.addAll(new ArrayList<>(t.files.keySet()));
    Collections.sort(list);
    return list;
  }

  @Override
  public void addContent(String filePath, String content) {

    String[] d = filePath.split(ROOT_DIR_PATH);
    Dir t = root;
    for (int i = 1; i < d.length - 1; i++) {
      t = t.dirs.get(d[i]);
    }

    t.files.put(
        d[d.length - 1],
        t.files.getOrDefault(d[d.length - 1], "") + content
    );

  }

  @Override
  public String getContent(String filePath) {
    String[] d = filePath.split(FILE_SEPARATOR);
    Dir t = root;
    for (int i = 1; i < d.length - 1; i++) {
      t = t.dirs.get(d[i]);
    }

    return t.files.get(d[d.length - 1]);
  }

  @Override
  public void mkDir(String path) {

    String[] d = path.split(FILE_SEPARATOR);
    Dir t = root;
    for (int i = 1; i < d.length; i++) {
      if (!t.dirs.containsKey(d[i])) {
        t.dirs.put(d[i], new Dir());
      }
      t = t.dirs.get(d[i]);
    }

  }

  @Override
  public List<String> tree(String path) {

    Dir t = root;

    if (!path.equals(ROOT_DIR_PATH)) {

      String[] d = path.split(FILE_SEPARATOR);
      for (int i = 1; i < d.length - 1; i++) {
        t = t.dirs.get(d[i]);
      }

      if (t.dirs.containsKey(d[d.length - 1])) {
        t = t.dirs.get(d[d.length - 1]);
      } else {
        listOfFiles.add(d[d.length - 1]);
        return listOfFiles;
      }

    }
    findAllInTree(t, path);
    return listOfFiles;
  }

  private void findAllInTree(Dir dir, String currentPath) {

    if (dir.dirs.keySet().size() == 0 && dir.files.keySet().size() == 0) {
      return;
    }

    for (Map.Entry<String, Dir> entry : dir.dirs.entrySet()) {
      findAllInTree(entry.getValue(), currentPath + "/" + entry.getKey());
      listOfFiles.add(currentPath + "/" + entry.getKey());
      if (entry.getValue().files != null) {
        for (Map.Entry<String, String> files : entry.getValue().files.entrySet()) {
          listOfFiles.add(currentPath + "/" + entry.getKey() + "/" + files.getKey());
        }
      }
    }
  }

  static class Dir {

    HashMap<String, Dir> dirs = new HashMap<>();
    HashMap<String, String> files = new HashMap<>();
  }
}
