# QRCode

## QrCode generator.

---

### Requirements
- Mavem 3.6.3
- Java 11
- Docker

---

## Build
```
docker build -t qrcode .
```

---

## Run
```
docker run -d -p 8080:8080 -t qrcode
```

---

## Use

Endpoints are available at http://127.0.0.1:8080

### Generate Image

```
http://127.0.0.1:8080/createQrCodeImage?contents=https://github.com/cariuska
```

### Result

![qrCode Image](https://github.com/cariuska/qrcode/blob/master/images/qrcode.jpg?raw=true)

---

### Generate Json

```
http://127.0.0.1:8080/createQrCode?contents=https://github.com/cariuska
```
### Result
```
{
    "code": 200,
    "msg": "Successful operation",
    "data": {
        "qrCode": "/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLD..."
    }
}
```