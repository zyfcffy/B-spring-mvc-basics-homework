# Spring MVC Basics Homework

## 作业描述

开发一个 Spring Boot Web Application，提供 API 供前端 app 调用，以实现注册登录功能。

不用引入数据库，在内存中保存数据即可，数据保存形式请自行组织。

请统一使用默认的 8080 端口，无需使用 HTTPS。

在最终提交前，请保证使用curl或Postman充分测试通过。

## API 列表
### 注册
#### ENDPOINT

`POST http://localhost:8080/register`

#### REQUEST
提供 User 对象的以下字段：
| 字段     | 是否必需 | 说明                                                         |
| :------- | -------- | :----------------------------------------------------------- |
| username | 是       | 用户名，不可重复，只能由字母、数字或下划线组成，并且长度为3到10位 |
| password | 是       | 密码，长度为5到12位                                          |
| email    | 否       | 邮箱，需要符合邮箱的格式                                     |

示例：

```json
{
    "username": "Tom",
    "password": "12345",
    "email": "tom@qq.com"
}
```
#### RESPONSE

注册成功无返回

注册失败的错误信息可能有：

- 用户名是必须的
- 密码是必须的
- 用户名不合法
- 密码不合法
- 邮箱不合法
- 用户已存在

### 登录
#### ENDPOINT
`GET http://localhost:8080/login?username=foo&password=bar`

#### REQUEST
| 字段     | 是否必需 | 说明                                                    |
| :------- | -------- | :------------------------------------------------------ |
| username | 是       | 用户名，只能由字母、数字或下划线组成，并且长度为3到10位 |
| password | 是       | 密码，长度为5到12位                                     |

#### RESPONSE

登录成功会返回该用户的所有字段：
| 字段     | 说明   |
| :------- | :----- |
| id       | 用户ID |
| username | 用户名 |
| password | 密码   |
| email    | 邮箱   |

示例：

```json
{
    "id": 1,
    "username": "Tom",
    "password": "12345",
    "email": "tom@qq.com"
}
```

登录失败的错误信息可能有：

- 用户名不合法
- 密码不合法
- 用户名或密码错误

### 返回结果说明

需要返回合适的 HTTP Status Code
| HTTP Status Code    | Summary                                                  |
| ------------------- | -------------------------------------------------------- |
| 200 - OK            | 操作成功                                                 |
| 201 - Created       | 创建对象成功                                             |
| 400 - Bad Request   | 请求参数不符合要求，通常是因为参数格式不正确或参数缺失。 |
| 404 - Not Found     | 请求的资源不存在。                                       |
| 500 - Server Errors | 服务端错误                                               |

对于出错的情况，还需要返回 Error 对象：
| 字段    | 说明                            |
| :------ | :------------------------------ |
| code    | 错误码，与HTTP Status Code 一致 |
| message | 错误信息                        |
