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
请求参数: {userId,password}
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

### 获取收藏图片列表（新增）
```
url: "/user/getFavourites"
请求方式: get
请求参数: userId
返回obj: [{"pictureId":1,"pictureName":"年兽","categoryName":"动物","uploaderId":1,"uploaderName":"LCH","pictureUrl":"none","viewTime":1,"favouritesCount":1,"likesCount":0,"commentCount":2,"publishTime":"2021-05-24T00:00:00.000+00:00"},{"pictureId":2,"pictureName":"猫","categoryName":"动物","uploaderId":1,"uploaderName":"LCH","pictureUrl":"none","viewTime":0,"favouritesCount":1,"likesCount":0,"commentCount":0,"publishTime":"2021-05-25T00:00:00.000+00:00"}]

返回一个列表，每一个对象是被收藏图片的信息
```

### 查询是否点赞某图片（新增）
```
url: "/user/isLike"
请求方式: get
请求参数: userId,pictureId
返回obj: false

返回一个布尔值
```

### 查询是否收藏某图片（新增）
```
url: "/user/isFavourite"
请求方式: get
请求参数: userId,pictureId
返回obj: false

返回一个布尔值
```

### 获取浏览记录（新增）
```
url: "/user/getRecent"
请求方式: get
请求参数: userId
返回obj: [{"userId":1,"pictureId":1,"visitTime":"2021-05-29T21:55:32.000+00:00"}]

返回一个列表，每一项为一个浏览记录，包含图片号以及浏览时间
```


# PictureController

### 获取图片信息（修改）
```
url: "/picture/getInfo"
请求方式：get
请求参数：pictureId
返回obj：{"pictureId":1,"pictureName":"年兽","categoryName":"动物","uploaderId":1,"uploaderName":"LCH","pictureUrl":"none","viewTime":0,"favouritesCount":0,"likesCount":0,"commentCount":2,"publishTime":"2021-05-24T05:00:00.000+00:00"}

返回一个对象，包含该pictureId的基本信息，其中viewTime为点击次数，publishTime为上传时间,likesCount为点赞数量，favouritesCount为收藏数量，commentCount为评论数量
*新增了各个数量
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

返回一个列表，列表中每一个对象是一个图片的信息。
```

### 评论图片（新增）
```
url: "/picture/comment"
请求方式：post
请求参数：{userId,pictureId,content}
    其中content为评论的文本内容
无obj返回，目前一个用户只能对一张图片评论一次，且评论后不能删除评论，有需求可以修改。
```

### 获取图片的所有评论（新增）
```
url: "/picture/getComment"
请求方式：get
请求参数：pictureId
返回obj：[{"userId":1,"pictureId":1,"content":"helloworld"},{"userId":2,"pictureId":1,"content":"helloworld"}]

返回一个列表，包括该图片的所有评论
```

### 获取图片的上传者信息（新增）
```
url: "/picture/getPublisher"
请求方式：get
请求参数：pictureId
返回obj：{"userId":1,"userName":"LCH","userPassword":null,"sex":"男","age":99,"publisher":"否","userEmail":"1231@qq.com"}

返回一个对象，包含上传者的所有基本信息，其中密码为null。
```

### 点赞图片（新增）
```
url: "/picture/likePicture"
请求方式：post
请求参数：{userId,pictureId}
无obj返回。
```

### 取消点赞图片（新增）
```
url: "/picture/dislikePicture"
请求方式：post
请求参数：{userId,pictureId}
无obj返回。
```


### 收藏图片（新增）
```
url: "/picture/favouritePicture"
请求方式：post
请求参数：{userId,pictureId}
无obj返回。
```

### 取消收藏图片（新增）
```
url: "/picture/disFavouritePicture"
请求方式：post
请求参数：{userId,pictureId}
无obj返回。
```

