数据优化整合

一、大容量数据
大容量数据（1000W或100G） 查询维度大 采用分库分表

垂直切分，水平切分原理   https://www.cnblogs.com/sunshine-long/p/11688021.html
同时带来一些问题
1事务一致性问题
2跨节点关联查询
3

实例    
https://cloud.tencent.com/developer/article/1343106?from=information.detail.%E5%88%86%E5%BA%93%E5%88%86%E8%A1%A8%E5%AE%9E%E4%BE%8B


二小容量优化
https://www.cnblogs.com/liliuguang/p/11015964.html
https://blog.csdn.net/qq_42214953/article/details/106061179
1、选取最适用的字段属性  **
2、 索引 **  https://www.cnblogs.com/hyd1213126/p/5828937.html    （由浅入深了解、以及）
3、优化的查询语句   **
4、使用连接（JOIN）来代替子查询(Sub-Queries) **  https://www.cnblogs.com/Renyi-Fan/p/11671006.html（多表查询及优化）


5、使用外键
6、事务
7、锁定表
8、使用联合(UNION)来代替手动创建的临时表
