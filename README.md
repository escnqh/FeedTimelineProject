# 这个Demo没有使用第三方库
#### 这个Demo没有使用第三方库
1. 网络访问：经过封装的HttpUrlConnection，使用AsyncTask抛出新的线程执行异步操作，或者直接同步请求
    - 自定义拦截器，使用`URLConnection.setContentHandlerFactory(new ContentHandlerFactoryImpl());`方法,把自定义的ContentFactory（拦截器）替换原来的方法，这样getContent方法返回的将是已经处理好的对象。
    - 应当注意：`URLConnection.setContentHandlerFactory(new ContentHandlerFactoryImpl());`方法在一个application中只能调用一次！
2. 数据解析部分：使用反射的方法将实体类的set方法取出，根据这些方法的参数判断对象类型并且解析放入实体类中。
