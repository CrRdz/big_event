# Large Event Interface Document-V1.0

## 1. User-related interfaces

### 1.1 Register

#### 1.1.1 Basic Information

> Request path: /user/register
>
> Request method: POST
>
> Interface description: This interface is used to register new users



#### 1.1.2 Request parameters

Request parameter format: x-www-form-urlencoded

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| -------- | ------ | ------ | -------- | -------------- |
| username | username | string | Yes | 5~16-bit non-empty characters |
| password | password | string | Yes | 5~16-bit non-empty characters |

Request data sample:

```shell
username=zhangsan&password=123456
```



#### 1.1.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 1.2 Login

#### 1.2.1 Basic information

> Request path: /user/login
>
> Request method: POST
>
> Interface description: This interface is used for login

#### 1.2.2 Request parameters

Request parameter format: x-www-form-urlencoded

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| -------- | ------ | ------ | -------- | -------------- |
| username | username | string | Yes | 5~16-bit non-empty characters |
| password | password | string | Yes | 5~16-bit non-empty characters |

Request data sample:

```shell
username=zhangsan&password=123456
```



#### 1.2.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | string | Must | | Returned data, jwt token | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiaWQiOjUsInVzZXJuYW1lIjoid2FuZ2JhIn0sImV4cCI6MTY5MzcxNTk3OH0.pE_RATcoF7Nm9KEp9eC3CzcBbKWAFOL0IsuMNjnZ95M"
}
```



#### 1.2.4 Notes

> After the user logs in successfully, the system will automatically issue the JWT token. Then, in each subsequent request, the browser needs to carry it to the server in the request header. The name of the request header is Authorization and the value is the JWT token issued when logging in.
>
> If the user is not logged in, the http response status code is 401



### 1.3 Get user details

#### 1.3.1 Basic information

> Request path: /user/userInfo
>
> Request method: GET
>
> Interface description: This interface is used to obtain detailed information of currently logged in user

#### 1.3.2 Request parameters

none

#### 1.3.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | Must | | Returned data | |
| \|-id | number | non-necessary | | primary key ID | |
| \|-username | srting | Non-essential | | Username | |
| \|-nickname | string | non-necessary | | nickname | |
| \|-email | string | non-necessary | | Email | |
| \|-userPic | string | Non-essential | | Avatar Address | |
| \|-createTime | string | Non-necessary | | Creation time | |
| \|-updateTime | string | non-necessary | | update time | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "id": 5,
        "username": "wangba",
        "nickname": "",
        "email": "",
        "userPic": "",
        "createTime": "2023-09-02 22:21:31",
        "updateTime": "2023-09-02 22:21:31"
    }
}
```



### 1.4 Update user basic information

#### 1.4.1 Basic information

> Request path: /user/update
>
> Request method: PUT
>
> Interface description: This interface is used to update the basic information of the logged-in user (except for avatar and password)

#### 1.4.2 Request parameters

Request parameter format: application/json

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| -------- | ------ | ------ | -------- | -------------- |
| id | primary key ID | number | Yes | |
| username | username | string | No | 5~16-bit non-empty characters |
| nickname | nickname | string | Yes | 1~10 non-empty characters |
| email | email | string | Yes | meet the format of the email |

Request data sample:

```shell
{
    "id":5,
    "username":"wangba",
    "nickname":"wb",
    "email":"wb@itcast.cn"
}
```

#### 1.4.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 1.5 Update user avatar

#### 1.5.1 Basic information

> Request path: /user/updateAvatar
>
> Request method: PATCH
>
> Interface description: This interface is used to update the avatar of the logged-in user

#### 1.5.2 Request parameters

Request parameter format: queryString

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| --------- | -------- | ------ | -------- | ------- |
| avatarUrl | avatar address | string | Yes | url address |

Request data sample:

```shell
avatarUrl=
https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png
```

#### 1.5.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 1.6 Update user password

#### 1.6.1 Basic information

> Request path: /user/updatePwd
>
> Request method: PATCH
>
> Interface description: This interface is used to update the password of the logged-in user

#### 1.6.2 Request parameters

Request parameter format: application/json

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| -------- | ---------- | ------ | -------- | ---- |
| old_pwd | original password | string | Yes | |
| new_pwd | new password | string | Yes | |
| re_pwd | Confirm new password | string | Yes | |

Request data sample:

```json
{
    "old_pwd":"123456",
    "new_pwd":"234567",
    "re_pwd":"234567"
}
```

#### 1.6.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



## 2. Article classification related interfaces

### 2.1 Added article classification

#### 2.1.1 Basic information

> Request path: /category
>
> Request method: POST
>
> Interface description: This interface is used to add new article classification

#### 2.1.2 Request parameters

Request parameter format: application/json

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| ------------- | -------- | ------ | -------- | ---- |
| categoryName | CategoryName | string | Yes | |
| categoryAlias ​​| CategoryAlias ​​| string | Yes | |

Request data sample:

```json
{
    "categoryName":"人文",
    "categoryAlias":"rw"
}
```

#### 2.1.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 2.2 Article classification list

#### 2.2.1 Basic information

> Request path: /category
>
> Request method: GET
>
> Interface description: This interface is used to obtain all article categories created by the currently logged in user

#### 2.2.2 Request parameters

none

#### 2.2.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ---------------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | array | Must | | Returned data | |
| \|-id | number | non-necessary | | primary key ID | |
| \|-categoryName | string | Non-essential | | Category Name | |
| \|-categoryAlias ​​| string | non-essential | | Category Name | |
| \|-createTime | string | Non-necessary | | Creation time | |
| \|-updateTime | string | non-necessary | | modification time | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": [
        {
            "id": 3,
            "categoryName": "美食",
            "categoryAlias": "my",
            "createTime": "2023-09-02 12:06:59",
            "updateTime": "2023-09-02 12:06:59"
        },
        {
            "id": 4,
            "categoryName": "娱乐",
            "categoryAlias": "yl",
            "createTime": "2023-09-02 12:08:16",
            "updateTime": "2023-09-02 12:08:16"
        },
        {
            "id": 5,
            "categoryName": "军事",
            "categoryAlias": "js",
            "createTime": "2023-09-02 12:08:33",
            "updateTime": "2023-09-02 12:08:33"
        }
    ]
}
```



### 2.3 Get article classification details

#### 2.3.1 Basic information

> Request path: /category/detail
>
> Request method: GET
>
> Interface description: This interface is used to obtain article classification details based on ID

#### 2.3.2 Request parameters

Request parameter format: queryString

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| -------- | ------ | ------ | -------- | ---- |
| id | primary key ID | number | Yes | |

Request data sample:

```shell
id=6
```

#### 2.3.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ---------------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | Must | | Returned data | |
| \|-id | number | non-necessary | | primary key ID | |
| \|-categoryName | string | Non-essential | | Category Name | |
| \|-categoryAlias ​​| string | non-essential | | Category Name | |
| \|-createTime | string | Non-necessary | | Creation time | |
| \|-updateTime | string | non-necessary | | modification time | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "id": 6,
        "categoryName": "风土人情",
        "categoryAlias": "ftrq",
        "createTime": "2023-09-03 11:07:13",
        "updateTime": "2023-09-03 11:13:39"
    }
}
```



### 2.4 Update article classification

#### 2.4.1 Basic information

> Request path: /category
>
> Request method: PUT
>
> Interface description: This interface is used to update article classification

#### 2.4.2 Request parameters

Request parameter format: application/json

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| ------------- | -------- | ------ | -------- | ---- |
| id | primary key ID | number | Yes | |
| categoryName | CategoryName | string | Yes | |
| categoryAlias ​​| CategoryAlias ​​| string | Yes | |

Request data sample:

```json
{
    "id":6,
    "categoryName":"风土人情",
    "categoryAlias":"ftrq"
}
```

#### 2.4.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 2.5 Delete article classification

#### 2.5.1 Basic information

> Request path: /category
>
> Request method: DELETE
>
> Interface description: This interface is used to delete article classification based on ID

#### 2.5.2 Request parameters

Request parameter format: queryString

Request parameter description:

| Parameter name | Description | Type | Necessary | Note |
| -------- | ------ | ------ | -------- | ---- |
| id | primary key ID | number | Yes | |

Request data sample:

```shell
id=6
```

#### 2.5.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



## 3. Article management-related interfaces

### 3.1 New articles

#### 3.1.1 Basic information

> Request path: /article
>
> Request method: POST
>
> Interface description: This interface is used to add new articles (post articles)

#### 3.1.2 Request parameters

Request parameter format: application/json

Request parameter description:

| Parameter name | Description | Type | Necessary | Note | |
| ---------- | ------------ | ------ | -------- | -------------- | ---- |
| title | Article title | string | Yes | 1~10 non-empty characters | |
| content | Article text | string | Yes | | |
| coverImg | cover image address | string | Yes | Must be url address | |
| state | Published Status | string | Yes | Published \| Draft | |
| categoryId | Article CategoryID | number | Yes | | |

Request data sample:

```json
{
  "title": "陕西旅游攻略",
  "content": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
  "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
  "state": "草稿",
  "categoryId": 2
}
```

#### 3.1.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```



### 3.2 Article list (conditional pagination)

#### 3.2.1 Basic information

> Request path: /article
>
> Request method: GET
>
> Interface description: This interface is used to query articles based on conditions, with paging

#### 3.2.2 Request parameters

Request parameter format: queryString

Request parameter description:

| Parameter name | Description | Type | Necessary | Note | |
| ---------- | ---------- | ------ | -------- | -------------- | ---- |
| pageNum | Current page number | number | Yes | | |
| pageSize | Number per page | number | Yes | | |
| categoryId | Article CategoryID | number | No | | | |
| state | Published Status | string | No | Published \| Draft | |

Request data sample:

```shell
pageNum=1&pageSize=3&categoryId=2&state=草稿
```

#### 3.2.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------------- | ------ | -------- | ------ | --------------------- | ------------ |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | Must | | Returned data | |
| \|-total | number | Must | | Total records | |
| \|-items | array | Must | | Data List | |
| \|-id | number | non-necessary | | primary key ID | |
| \|-title | string | non-essential | | Article title | |
| \|-content | string | non-necessary | | Article text | |
| \|-coverImg | string | Non-essential | | Article cover image address | |
| \|-state | string | Non-essential | | Published Status | Published\|Draft |
| \|-categoryId | number | non-necessary | | Article Category ID | |
| \|-createTime | string | Non-necessary | | Creation time | |
| \|-updateTime | string | non-necessary | | update time | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "total": 1,
        "items": [
            {
                "id": 5,
                "title": "陕西旅游攻略",
                "content": "兵马俑,华清池,法门寺,华山...爱去哪去哪...",
                "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
                "state": "草稿",
                "categoryId": 2,
                "createTime": "2023-09-03 11:55:30",
                "updateTime": "2023-09-03 11:55:30"
            }
        ]
    }
}
```







### 3.3 Get article details

#### 3.3.1 Basic information

> Request path: /article/detail
>
> Request method: GET
>
> Interface description: This interface is used to obtain article details based on ID

#### 3.3.2 Request parameters

Request parameter format: queryString

Request parameter description:

| Parameter name | Description | Type | Necessary | Note | |
| -------- | ------ | ------ | -------- | ---- | ---- |
| id | primary key ID | number | Yes | | |

Request data sample:

```shell
id=4
```

#### 3.3.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------------- | ------ | -------- | ------ | --------------------- | ------------ |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | Must | | Returned data | |
| \|-id | number | non-necessary | | primary key ID | |
| \|-title | string | non-essential | | Article title | |
| \|-content | string | non-necessary | | Article text | |
| \|-coverImg | string | Non-essential | | Article cover image address | |
| \|-state | string | Non-essential | | Published Status | Published\|Draft |
| \|-categoryId | number | non-necessary | | Article Category ID | |
| \|-createTime | string | Non-necessary | | Creation time | |
| \|-updateTime | string | non-necessary | | update time | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": {
        "id": 4,
        "title": "北京旅游攻略",
        "content": "天安门,颐和园,鸟巢,长城...爱去哪去哪...",
        "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
        "state": "已发布",
        "categoryId": 2,
        "createTime": "2023-09-03 11:35:04",
        "updateTime": "2023-09-03 11:40:31"
    }
}
```



### 3.4 Updated article

#### 3.4.1 Basic information

> Request path: /article
>
> Request method: PUT
>
> Interface description: This interface is used to update article information

#### 3.4.2 Request parameters

Request parameter format: application/json

Request parameter description:

| Parameter name | Description | Type | Necessary | Note | |
| ---------- | ------------ | ------ | -------- | -------------- | ---- |
| id | primary key ID | number | Yes | | |
| title | article title | string | Yes | | |
| content | Article text | string | Yes | | |
| coverImg | cover image address | string | Yes | | |
| state | Published Status | string | Yes | Published \| Draft | |
| categoryId | Article CategoryID | number | Yes | | |

Request data sample:

```json
{
    "id":4,
    "title": "北京旅游攻略",
    "content": "天安门,颐和园,鸟巢,长城...爱去哪去哪...",
    "coverImg": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/9bf1cf5b-1420-4c1b-91ad-e0f4631cbed4.png",
    "state": "已发布",
    "categoryId": 2
}
```

#### 3.4.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```





### 3.5 Delete articles

#### 3.5.1 Basic information

> Request path: /article
>
> Request method: DELETE
>
> Interface description: This interface is used to delete articles based on ID

#### 3.5.2 Request parameters

Request parameter format: queryString

Request parameter description:

| Parameter name | Description | Type | Necessary | Note | |
| -------- | ------ | ------ | -------- | ---- | ---- |
| id | primary key ID | number | Yes | | |

Request data sample:

```shell
id=4
```

#### 3.5.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | --------------------- | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | object | non-necessary | | Returned data | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": null
}
```





## 4. Other interfaces

### 4.1 File upload

#### 4.1.1 Basic information

> Request path: /upload
>
> Request method: POST
>
> Interface description: This interface is used to upload files (single file)

#### 4.1.2 Request parameters

Request parameter format: multipart/form-data

Request parameter description:

| Parameter name | Description | Type | Necessary | Note | |
| -------- | ------------------------ | ---- | -------- | ---- | ---- |
| file | Name of file request parameter in form | file | Yes | | |

Request data sample:

none

#### 4.1.3 Response data

Response data type: application/json

Response parameter description:

| Name | Type | Necessary | Default | Notes | Other Information |
| ------- | ------ | -------- | ------ | ------------------------ | -------- |
| code | number | Required | | Response code, 0-success, 1-failed | |
| message | string | non-necessary | | Prompt message | |
| data | string | Must | | Storage address of images on Alibaba Cloud | |

Response data sample:

```json
{
    "code": 0,
    "message": "操作成功",
    "data": "https://big-event-gwd.oss-cn-beijing.aliyuncs.com/b5811871-acc8-4583-8399-cf0dc73591ab.png"
}
```

