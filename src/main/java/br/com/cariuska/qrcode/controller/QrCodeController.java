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
    public ResponseEntity<?> createQrCodeImage(String contents) {
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

            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            Result result = Result.error("Create QR code picture abnormal");
            ResponseEntity<Result> responseEntity = new ResponseEntity<>(result, headers, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    @RequestMapping(value = "createQrCode", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> createQrCode(String contents) {
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            Result result = qrCodeService.createQrCode(contents);
            ResponseEntity<Result> responseEntity = new ResponseEntity<>(result, headers, HttpStatus.BAD_REQUEST);

            return responseEntity;

        } catch (Exception e) {
            log.error("Create QR code picture abnormal" + e.getMessage());
            e.printStackTrace();

            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            Result result = Result.error("Create QR code picture abnormal");
            ResponseEntity<Result> responseEntity = new ResponseEntity<>(result, headers, HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }
}
