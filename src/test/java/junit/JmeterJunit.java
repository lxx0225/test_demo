package junit;


import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JmeterJunit {
    public String urlPath = "http://www.mocky.io/v2/572ee171120000332519491b";
    public HttpURLConnection connection = null;
    public OutputStream output = null;
    public BufferedReader reader = null;
    public static String request = "{ \"type\": \"getName\"}";

    @Before
    public void setUp() throws Exception {
        URL url = new URL(urlPath);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        connection.setUseCaches(false);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("Content-encoding", "UTF-8");
        connection.setRequestProperty("Accept", "application/json");
        connection.connect();
    }

    @After
    public void tearDown() throws Exception {
        if (null != output) {
            try {
                output.close();
            } catch (IOException e) {
                throw e;
            }
        }
        if (null != reader) {
            try {
                reader.close();
            } catch (IOException e) {
                throw e;
            }
        }
        if (null != connection) {
            connection.disconnect();
        }
    }

    public void sendRequest(String request) throws Exception {
        output = connection.getOutputStream();
        output.write(request.getBytes());
        output.flush();
    }

    public String getResponse() throws Exception {
        reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String st;
        StringBuffer stb = new StringBuffer();
        while (null != (st = reader.readLine())) {
            stb.append(st);
        }
        return stb.toString();
    }

    @SuppressWarnings("deprecation")
    public void checkResponse(String response,String name) throws Exception {
        boolean actualResult = response.contains(name);
        assertTrue("the expected status is " + name
                + ", but now it's not", actualResult);
    }

    @Test
    public void test1() throws Exception {
        sendRequest(request);
        checkResponse(getResponse(),"Brett");
    }

    @Test
    public void test2() throws Exception {
        sendRequest(request);
        checkResponse(getResponse(),"Jason");
    }

    @Test
    public void test3() throws Exception {
        sendRequest(request);
        checkResponse(getResponse(),"Elliotte");
    }



}