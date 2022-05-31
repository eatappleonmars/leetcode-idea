package leetcode.editor.en;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class P588DesignInMemoryFileSystemTest {

    //  ["/"], ["/a/b/c"], ["/a/b/c/d", "hello"], ["/"], ["/a/b/c/d"]]

    P588DesignInMemoryFileSystem.FileSystem fileSystem;

    @BeforeEach
    public void setUp() {
        this.fileSystem = new P588DesignInMemoryFileSystem().new FileSystem();
    }

    @Test
    public void test1() {
        List<String> ls1 = fileSystem.ls("/");
        assertTrue(ls1.isEmpty());

        fileSystem.mkdir("/a/b/c");

        fileSystem.addContentToFile("/a/b/c/d", "hello");
        assertEquals("hello", fileSystem.readContentFromFile("/a/b/c/d"));

        fileSystem.addContentToFile("/a/b/c/d", "hello");
        assertEquals("hellohello", fileSystem.readContentFromFile("/a/b/c/d"));

        List<String> ls2 = fileSystem.ls("/");
        assertEquals(List.of("a"), ls2);


    }
}