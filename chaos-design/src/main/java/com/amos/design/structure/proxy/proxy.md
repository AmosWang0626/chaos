# 代理模式（结构型）
> 代码实现中用了一个例子<br>
F1赛车手, 通过经纪公司参赛, 比赛后接受采访<br>
为增加实现难度，加入自动驾驶参赛<br>
1. 经纪公司 XXX 预约赛程
2. 驾驶车完成比赛
   1. 赛车手 AAA 驾驶 FFF 完成比赛
   2. 自动驾驶 FFF 完成比赛
3. 赛程数据统计
4. 赛后采访

## 三种常见实现方式
### 1.静态代理
> 参照项目中的实现
- 1个接口
  - [驾驶接口 DriveInterface](common/Drive.java)
- 2个实现类
  - [真人驾驶 RealDriver](common/RealDriver.java)
  - [虚拟驾驶 VirtualDriver](common/VirtualDriver.java)
- 代理类&测试启动类 [StaticMain](main/StaticMain.java)
  - 接收要代理对象
  - 执行代理对象要代理的方法

### 2.动态代理（JDK原生）
> 参照项目中的实现
- 1个接口
  - [驾驶接口 DriveInterface](common/Drive.java)
- 2个实现类
  - [真人驾驶 RealDriver](common/RealDriver.java)
  - [虚拟驾驶 VirtualDriver](common/VirtualDriver.java)
- 代理类&测试启动类 [JdkMain](main/JdkMain.java)
  - Proxy.newProxyInstance(ClassLoader, Interfaces, InvocationHandler);
  - 可在InvocationHandler接口实现类中实现核心逻辑
- 注意：JDK原生代理不能代理普通的Java类, 只能代理接口实现类（表述或有些牵强）
  
### 3.动态代理（CGLIB）
> 参照项目中的实现<br>
> [这篇文章讲得非常好 cglib-api](https://zjcscut.github.io/2018/12/16/cglib-api)
- 2个普通Java类
  - [真人驾驶 RealDriver](common/RealDriver.java)
  - [虚拟驾驶 VirtualDriver](common/VirtualDriver.java)
- 代理类&测试启动类 [CgLibMain](main/CgLibMain.java)
  - Enhancer既能够代理普通的Java类，也能够代理接口
  - 功能相对JDK原生也相对多点, 例如指定不同类型的callback