//Design a data structure that simulates an in-memory file system. 
//
// Implement the FileSystem class: 
//
// 
// FileSystem() Initializes the object of the system. 
// List<String> ls(String path)
// 
// If path is a file path, returns a list that only contains this file's name. 
// If path is a directory path, returns the list of file and directory names in 
//this directory. 
// 
// The answer should in lexicographic order. 
// void mkdir(String path) Makes a new directory according to the given path. 
//The given directory path does not exist. If the middle directories in the path do 
//not exist, you should create them as well. 
// void addContentToFile(String filePath, String content)
// 
// If filePath does not exist, creates that file containing given content. 
// If filePath already exists, appends the given content to original content. 
// 
// 
// String readContentFromFile(String filePath) Returns the content in the file 
//at filePath. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"]
//
//[[], ["/"], ["/a/b/c"], ["/a/b/c/d", "hello"], ["/"], ["/a/b/c/d"]]
//Output
//[null, [], null, null, ["a"], "hello"]
//
//Explanation
//FileSystem fileSystem = new FileSystem();
//fileSystem.ls("/");                         // return []
//fileSystem.mkdir("/a/b/c");
//fileSystem.addContentToFile("/a/b/c/d", "hello");
//fileSystem.ls("/");                         // return ["a"]
//fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length, filePath.length <= 100 
// path and filePath are absolute paths which begin with '/' and do not end 
//with '/' except that the path is just "/". 
// You can assume that all directory names and file names only contain 
//lowercase letters, and the same names will not exist in the same directory. 
// You can assume that all operations will be passed valid parameters, and 
//users will not attempt to retrieve file content or list a directory or file that 
//does not exist. 
// 1 <= content.length <= 50 
// At most 300 calls will be made to ls, mkdir, addContentToFile, and 
//readContentFromFile. 
// 
// Related Topics Hash Table String Design Trie 👍 1093 👎 127


package leetcode.editor.en;

// 2022-05-30 11:54:47

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class P588DesignInMemoryFileSystem {
    
    //leetcode submit region begin(Prohibit modification and deletion)
    class FileSystem {

        class FileNode {

            String name;
            boolean isFile;
            StringBuilder content;
            Map<String, FileNode> subNodes;

            FileNode(String name) {
                this.name = name;
                this.isFile = false;
                this.content = new StringBuilder();
                this.subNodes = new TreeMap<>();
            }

            FileNode get(String name) {
                return this.subNodes.get(name);
            }

            FileNode mkdir(String name) {
                return subNodes.computeIfAbsent(name, FileNode::new);
            }

            void addContent(String c) {
                this.isFile = true;
                this.content.append(c);
            }

            String getContent() {
                return this.content.toString();
            }

            List<String> ls() {
                List<String> filenames = new ArrayList<>();
                if (this.isFile) {
                    filenames.add(name);
                } else {
                    filenames.addAll(subNodes.keySet());
                }
                return filenames;
            }
        }

        private final FileNode root;

        public FileSystem() {
            this.root = new FileNode("");
        }

        public List<String> ls(String path) {
            FileNode node = traverse(root, path);
            return node.ls();
        }

        public void mkdir(String path) {
            mkdir(root, path);
        }

        public void addContentToFile(String filePath, String content) {
            FileNode node = mkdir(root, filePath);
            node.addContent(content);
        }

        public String readContentFromFile(String filePath) {
            FileNode node = traverse(root, filePath);
            return node.getContent();
        }

        private FileNode traverse(FileNode node, String path) {
            String[] names = path.split("/");
            for (int i = 1; i < names.length; i++) {
                node = node.get(names[i]);
            }
            return node;
        }

        private FileNode mkdir(FileNode node, String path) {
            String[] names = path.split("/");
            for (int i = 1; i < names.length; i++) {
                node = node.mkdir(names[i]);
            }
            return node;
        }
    }

    /**
     * Your FileSystem object will be instantiated and called as such:
     * FileSystem obj = new FileSystem();
     * List<String> param_1 = obj.ls(path);
     * obj.mkdir(path);
     * obj.addContentToFile(filePath,content);
     * String param_4 = obj.readContentFromFile(filePath);
     */
    //leetcode submit region end(Prohibit modification and deletion)
    public static void main(String[] args) {
        String s = "/a/b/c";
        String[] array = s.split("/");
        for (String e : array){
            System.out.println(e);
        }
    }
}