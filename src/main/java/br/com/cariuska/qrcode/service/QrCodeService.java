package br.com.cariuska.qrcode.service;

import br.com.cariuska.qrcode.date20191125.QRCodeUtil;
import br.com.cariuska.qrcode.util.FileUtil;
import br.com.cariuska.qrcode.util.Result;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class QrCodeService {

    public byte[] createQrCodeImage(String contents) throws IOException {
        String pathImages = FileUtil.pathFormat(FileUtil.getPathImages());

        String logo = pathImages  + "/hashiqi_1.jpg";
        byte[] bytes = null;
        try {
            bytes = QRCodeUtil.encode(contents, null, "d:/EWM", true);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return bytes;
    }

    public Result createQrCode(String contents) throws IOException {
        String pathImages = FileUtil.pathFormat(FileUtil.getPathImages());

        String logo = pathImages  + "/hashiqi_1.jpg";
        byte[] bytes = null;
        try {
            bytes = QRCodeUtil.encode(contents, null, "d:/EWM", true);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("qrCode", bytes);
        return Result.ok(map);
    }
}
