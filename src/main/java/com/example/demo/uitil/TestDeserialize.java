package com.example.demo.uitil;

import com.sun.deploy.net.HttpRequest;
import junit.framework.TestCase;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaohe on 2017/7/6.
 */
public class TestDeserialize extends TestCase {
    public void testDeserialize() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        BigInteger bi = new BigInteger("0");
        oos.writeObject(bi);
        byte[] str = baos.toByteArray();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(str)));
        Object obj = ois.readObject();
        assertNotNull(obj);
        assertEquals(obj.getClass().getName(),"java.math.BigInteger");
        assertEquals(((BigInteger)obj).intValue(), 0);
    }
}
