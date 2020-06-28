import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileSystem {

    private final Directory root = new Directory("/");

    public FileSystem() {
    }

    public List<String> ls(String path) {
        Directory dir = root;
        for (String p : path.split("/")) {
            if (dir.isDirectory(p)) {
                dir = dir.getDirectory(p);
            } else if (dir.isFile(p)) {
                return Collections.singletonList(p);
            }
        }
        return Stream.concat(dir.getAllDirectories().stream().map(Directory::getName), dir.getAllFiles().stream().map(File::getName))
                .sorted()
                .collect(Collectors.toList());
    }

    public void mkdir(String path) {
        Directory dir = root;
        for (String p : path.substring(1).split("/")) {
            if (!dir.isDirectory(p)) {
                dir.addDirectory(new Directory(p));
            }
            dir = dir.getDirectory(p);
        }
    }

    public void addContentToFile(String filePath, String content) {
        Directory dir = root;
        for (String p : filePath.substring(1).split("/")) {
            if (dir.isDirectory(p)) {
                dir = dir.getDirectory(p);
            } else if (dir.isFile(p)) {
                dir.getFile(p).appendContent(content);
            } else {
                dir.addFile(new File(p, content));
            }
        }
    }

    public String readContentFromFile(String filePath) {
        Directory dir = root;
        for (String p : filePath.substring(1).split("/")) {
            if (dir.isDirectory(p)) {
                dir = dir.getDirectory(p);
            } else if (dir.isFile(p)) {
                return dir.getFile(p).getContents();
            }
        }
        return null;
    }

}

class Directory {
    final String name;
    final Map<String, Directory> dirs = new TreeMap<>();
    final Map<String, File> files = new TreeMap<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addDirectory(Directory dir) {
        dirs.put(dir.name, dir);
    }

    public void addFile(File file) {
        files.put(file.name, file);
    }

    public Directory getDirectory(String name) {
        return dirs.get(name);
    }

    public File getFile(String name) {
        return files.get(name);
    }

    public Collection<Directory> getAllDirectories() {
        return dirs.values();
    }

    public Collection<File> getAllFiles() {
        return files.values();
    }

    public boolean isDirectory(String name) {
        return dirs.containsKey(name);
    }

    public boolean isFile(String name) {
        return files.containsKey(name);
    }

    public String getName() {
        return name;
    }
}

class File {
    final String name;
    final StringBuilder contents = new StringBuilder();

    public File(String name) {
        this.name = name;
    }

    public File(String name, String content) {
        this.name = name;
        appendContent(content);
    }

    public void appendContent(String content) {
        contents.append(content);
    }

    public String getContents() {
        return contents.toString();
    }

    public String getName() {
        return name;
    }
}