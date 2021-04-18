package br.com.cariuska.qrcode.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

@ApiModel
public class Result<T> {
    @ApiModelProperty(value = "Return information status code")
    private int code = 101;

    @ApiModelProperty(value = "returned messages")
    private String msg = "";

    @ApiModelProperty(value = "data")
    private Map<String, T> data = new HashMap<String, T>();

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }

    public static Result ok() {
        return new Result() {
            {
                setMsg("Successful operation");
                setCode(200);
            }
        };
    }

    public static Result ok(Map<String, Object> data) {
        return new Result() {
            {
                setMsg("Successful operation");
                setCode(200);
                setData((data == null) ? new HashMap<String, Object>() : data);
            }
        };
    }

    public static Result okForStringMap(Map<String, String> data) {
        return new Result() {
            {
                setMsg("Successful operation");
                setCode(100);
                setData((data == null) ? new HashMap<String, String>() : data);
            }
        };
    }

    public static Result error() {
        return new Result() {
            {
                setCode(101);
                setMsg("Unknown error");
            }
        };
    }

    public static Result error(int errorCode, String msg) {
        return new Result() {
            {
                setCode(errorCode);
                setMsg(msg);
            }
        };
    }

    public static Result error(String msg) {
        return new Result() {
            {
                setCode(101);
                setMsg(msg);
            }
        };
    }
}
