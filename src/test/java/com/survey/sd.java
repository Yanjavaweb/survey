package com.survey;


import com.survey.utils.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 闫宏伟
 * @Description:
 */
public class sd {
    @Test
    void test() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        SecretKeySpec paramString23 = new SecretKeySpec(Base64.decode("PVm4KXehFo0E1TUZOeG1KA==", 2), "AES");
        Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        localCipher.init(1, paramString23);
        System.out.println(Base64.encodeToString(localCipher.doFinal("2018212176".getBytes()), 2));
        String s = Base64.encodeToString(localCipher.doFinal("2018212176".getBytes()), 2);

        try{
            HttpURLConnection urlConnection = null;
            URL url = new URL("http://wmjy.cqyti.com/wisdomprovider/router");
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            urlConnection.connect();

            PrintWriter pw = new PrintWriter(urlConnection.getOutputStream());
            long l = System.currentTimeMillis();
//            pw.print("anonymousId=00000000-0000-0000-0000-000000000000&loginId=2018212176&method=wisdom.system.login&deviceBindingId=00000000-18f0-5145-ffff-ffff829eda81&sign=E515794E3365C0019C0C4382EE216F43A99281FC&format=json&tenantCode=cqytxy&deviceId=5027049537413843&password=q%2BL71yfTUiRLIE3s8dizGg%3D%3D&v=2.1&appType=2&appKey=00000001&keyType=1&timestamp="+l);
            pw.print("anonymousId=00000000-0000-0000-0000-000000000000&loginId=2018212176&method=wisdom.system.login&deviceBindingId=d8b5932c-d14b-4aa8-84f5-508eb221cf6c&sign=31EE11827436A9E0673DE18A3993CB371448C8EF&format=json&tenantCode=cqytxy&deviceId=8ad3bc1966c00abb&password=q+L71yfTUiRLIE3s8dizGg==&v=2.1&appType=2&appKey=00000001&keyType=1&timestamp="+l);
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch(Exception e){
            e.getStackTrace();
        }

    }
}
