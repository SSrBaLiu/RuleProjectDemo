package demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

@RestController
@Slf4j
public class XmlController {
    @RequestMapping(value="/notify/order/result.do",produces = "text/json; charset=UTF-8")
    @ResponseBody
    public String resultNotify(HttpServletRequest request, HttpServletResponse response, String a) {

        log.info("体检结果推送接口");
        InputStream ins = null;
        try {
            ins = request.getInputStream();
            byte[] rebyte = readStream(ins);
            String remess = new String(rebyte);
            System.out.println("XML报文内容为：" + remess);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return "SUCCESS";
    }

    /**
     * @功能 读取流
     * @param inStream
     * @return 字节数组
     * @throws Exception
     */
    public static byte[] readStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

}
