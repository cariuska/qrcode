package br.com.cariuska.qrcode.controller;

import br.com.cariuska.qrcode.service.QrCodeService;
import br.com.cariuska.qrcode.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/qrCode/")
@Slf4j
public class QrCodeController {

    @Autowired
    private QrCodeService qrCodeService;

    @RequestMapping(value = "createQrCodeImage", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> createQrCodeImage(String contents) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            headers.setContentType(MediaType.IMAGE_JPEG);

            byte[] media = qrCodeService.createQrCodeImage(contents);

            ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);

            return responseEntity;

        } catch (Exception e) {
            log.error("Create QR code picture abnormal" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "createQrCode", method = RequestMethod.GET)
    @ResponseBody
    public Result createQrCode(String contents) {
        try {
            return qrCodeService.createQrCode(contents);
        } catch (Exception e) {
            log.error("Create QR code picture abnormal" + e.getMessage());
            e.printStackTrace();
            return Result.error("Create QR code picture abnormal");
        }
    }
}
