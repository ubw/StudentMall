
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.InputStream;


public class Md5sumTestFoo {

    @Test
    public void md5test() throws Exception {

        InputStream in = new FileInputStream("C:\\Users\\cjwst\\IdeaProjects\\StudentMall\\StudentMall.iml");
        String ret = DigestUtils.md5Hex(in);
        System.out.println(ret);
    }
}
