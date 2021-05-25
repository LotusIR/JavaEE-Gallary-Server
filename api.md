[toc]

# Response

格式如下：
```
{"code":200,"message":null,"obj":["新年"]}
其中code为200时请求成功，为500时请求失败。
如有特殊返回code会在接口中说明。
message为返回的信息。
obj为返回的对象。
如果没有标注则无message和特殊code。
```

# UserController

### 登录
```
url: "/user/login"
请求方式: post
请求参数: {userId:"",password:""}
无对象返回
```

### 推荐分类
```
url: "/user/recommendCategories"
请求方式: get
请求参数: userId
返回obj: [{"categoryName":"动物","weight":70},{"categoryName":"人物","weight":60}]

返回一个列表，按weight降序排序，weight越高则推荐度越高，categoryName为分类名
```

# PictureController

### 获取图片信息
```
url: "/picture/getInfo"
请求方式：get
请求参数：pictureId
返回obj：{"pictureId":1,"pictureName":"年兽","categoryName":"动物","uploaderId":1,"uploaderName":"LCH","pictureUrl":"none","viewTime":1,"publishTime":"2021-05-24T05:00:00.000+00:00"}

返回一个对象，包含该pictureId的基本信息，其中viewTime为点击次数，publishTime为上传时间
```

### 获取tags
```
url: "/picture/getTags"
请求方式：get
请求参数：pictureId
返回obj：["新年"]

返回一个列表，包含该pictureId的所有tag
```

### 根据分类获取图片
```
url: "/picture/getPictures"
请求方式：get
请求参数：
    category：图片分类
    page：页数，一页30张图片
    method：请求方式，有如下选择
        'latest' 请求最新的图片（按上传时间降序）
        'hottest' 请求最热门的图片（按点击次数降序）
    如果不填写method则默认按id升序
返回obj：[{"pictureId":2,"pictureName":"猫","categoryName":"动物","uploaderId":1,"uploaderName":"LCH","pictureUrl":"none","viewTime":0,"publishTime":"2021-05-25T05:00:00.000+00:00"},{"pictureId":1,"pictureName":"年兽","categoryName":"动物","uploaderId":1,"uploaderName":"LCH","pictureUrl":"none","viewTime":1,"publishTime":"2021-05-24T05:00:00.000+00:00"}]

返回一个列表，列表中每一个对象是一个图片的信息
```


