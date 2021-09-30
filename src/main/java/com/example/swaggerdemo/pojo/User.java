package com.example.swaggerdemo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//ApiModel作用是给实体类注释在swagger中
@ApiModel("用户实体类")
public class User {
    //ApiModelProperty作用是给字段注释
    @ApiModelProperty("用户名")
    public String userName;
    @ApiModelProperty("密码")
    public String password;

}
