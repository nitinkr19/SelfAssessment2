package main.java.practicee;

import java.util.HashMap;

public class FileSolution {

  /*

  mkdir:

  Method : POST
  Path : "fileSystem/directory/create"
  Data : { "absoluteDirPath" : "/foo/bar/" }
  Headers : ContentType : APPLICATION-JSON
  Response.Ok { "success" : true/false , "error" : { "code" : "E50" , "message" : "Directory Exists!!!" } }

  writeFile:

  Method : POST
  Path : "fileSystem/file/createOrUpdate"
  Data : { "absoluteFilePath" : "/foo/bar/file.txt", "fileContent" : "Sample Content" }
  Headers : ContentType : APPLICATION-JSON
  Response.Ok { "success" : true/false, "error" : { "code" : "E51" , "message" : "File Path Invalid!!!",
  "status" :"Created"/"Appended"/"Failed" }}

  readFile:

  Method : GET
  Path : "fileSystem/file/read"
  Data : { "absoluteFilePath" : "/foo/bar/file.txt" }
  Headers : ContentType : APPLICATION-JSON
  Response : { "fileContent" : "Sample Content", "success" : true/false }

   */

  public static final String FILE_SEPARATOR_SLASH = "/";
  Directory root;

  public FileSolution(){
    this.root = new Directory();
  }

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */

  }

  /*
   It should not create all sub dirs in the path if not present
   Throw exception.
  */
  public void mkdir(String path) throws Exception {

    String[] dirs = path.split("/");
    Directory localRoot = root;
    for (int i = 1; i < dirs.length - 1; i++) {
      if (localRoot.dirs != null) {
        localRoot = localRoot.dirs.get(dirs[i]);
      } else {
        throw new Exception("Invalid Dir Path");
      }
    }

    if(localRoot != null) {
      if(localRoot.dirs.containsKey(dirs[dirs.length - 1])){
        throw new Exception("Directory already exists!!!");
      }
      localRoot.dirs.put(dirs[dirs.length - 1], new Directory());
    } else {
      throw new Exception("Invalid Dir Path");
    }
  }

  /*
    /foo/bar/file.txt
    file.txt
    "file.txt" -> "prevContent content"
   */
  public void writeFile(String filePath, String content) throws Exception {

    String[] dirs = filePath.split(FILE_SEPARATOR_SLASH);
    Directory localRoot = root;
    for (int i = 1; i < dirs.length - 1; i++) {
      if (localRoot.dirs != null) {
        localRoot = localRoot.dirs.get(dirs[i]);
      } else {
        throw new Exception("Invalid File Path");
      }
    }

    if(localRoot != null) {
      localRoot.files.put(
          dirs[dirs.length - 1],
          localRoot.files.getOrDefault(dirs[dirs.length - 1], "") + content
      );
    } else {
      throw new Exception("Invalid File Path");
    }

  }

  /*
    /foo/bar/file.txt
    file.txt
    "file.txt" -> "content"
   */
  public String readFile(String filePath) throws Exception {
    String[] dirs = filePath.split(FILE_SEPARATOR_SLASH);
    Directory localRoot = root;
    for (int i = 1; i < dirs.length - 1; i++) {
      if (localRoot.dirs != null) {
        localRoot = localRoot.dirs.get(dirs[i]);
      } else {
        throw new Exception("Invalid File Path");
      }
    }

    if(localRoot != null) {
      return localRoot.files.get(dirs[dirs.length - 1]);
    } else {
      throw new Exception("Invalid File Path");
    }
  }

  static class Directory {

    public HashMap<String, Directory> dirs = new HashMap<>();
    public HashMap<String, String> files = new HashMap<>();
  }
}