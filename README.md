# MySSHProject
SSH的项目


## 项目完成了的功能
    一、部门的显示、添加和修改
    1、添加和修改的时候可以判断是否重复和是否为空

    二、职务的显示、添加和修改
    1、是否为空和是否重复
    2、不选择部门的时候提示未选择部门

    三、职员的显示、添加和修改
    1、添加和编辑都是写了对应的验证器（返回input的时候也用通配符，就可以在一个action中返回不同的页面了）
    2、问题：验证器验证入职时间，就算是选了时间也是空的？

    四、高级查询（通过部门id、职务id、员工姓名着三个条件中的任意几项来查询）
    1、三个条件都没选的时候就是查询全部
    2、问题：查询的结果显示在表格中的时候，时间的格式不对，日期和时间中间有一个：T
