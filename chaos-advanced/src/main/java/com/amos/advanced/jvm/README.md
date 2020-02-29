# JVM

## 启动流程（run process）
.java >>> find jvm config >>> find jvm.dll by this config >>> init jvm and get JNIEnv >>> run main

## 运行时数据区
- JVM数据区：程序计数器、本地方法栈、JVM栈、堆
    - 其中【程序计数器、本地方法栈、JVM栈】是线程隔离的
- 本地内存：元数据区、直接内存

## heap 堆
- 可通过-Xmx -Xms参数来指定最大堆和最小堆
- Young Generation（1/3 heap 堆空间）
    - 8/10 Eden     
    - 1/10 Survivor
    - 1/10 Survivor
- Old Generation（2/3 heap 堆空间）
- MetaData Space（直接内存）

## stack 栈
- 请求的 stack depth（深度） 超出范围，会抛出StackOverFlowError
- 无法申请到内存空间，会抛出OutOfMemoryError，可通过-Xss指定栈空间

## 执行引擎 
- 解释器：更快地解释字节码，但执行慢，解释一句执行一句；
- 编译器：jit(just in time) 热点侦测，即时编译

## gc
- 监测对象引用
    - 引用计数
    - 可达性分析

- heap堆是GC主要收集区域
    - Minor GC：新生代空间不足时收集
    - Full GC：老年代空间不足时收集，占用内存空间大，回收效率低

### GC 算法
- 按回收策略可分为
    - 标记-清除算法
    - 标记-整理算法
    - 复制算法

- 按分区对待可分为
    - 增量收集：实时垃圾回收
    - 分代收集：生命周期划分为：新生代、老年代、元空间，不同生命周期使用不同的算法

- 按系统线程可分为
    - 串行收集：单线程垃圾回收，需暂停用户线程
    - 并发收集：多线程垃圾回收，需暂停用户线程
    - 并行收集：垃圾回收线程和用户线程同时执行

## GC 收集器
- Serial收集器
    - 主要针对新生代收集，串行收集，采用复制算法
- Serial Old收集器
    - 主要针对老年代收集，串行收集，采用标记-整理算法

- ParNew收集器
    - 主要针对新生代收集，Serial的多线程版本，并行收集，响应优先，采用复制算法

- Parallel Scavenger收集器
    - 主要针对新生代收集，并行收集，吞吐优先；
    - 可控吞吐量和停顿时间，吞吐量 = 运行用户代码时间 / （运行用户代码时间 + 垃圾收集时间）
- Parallel Old收集器
    -  主要针对老年代收集，并行收集，吞吐优先，采用标记-整理算法

- Current MarkSweep（CMS）收集器
    - 主要针对老年代收集，并发收集，以最短停顿时间为目标，采用标记-清除算法

- G1收集器
    - 新生代类似ParNew，并行收集，采用复制算法；
    - 老年代类似CMS，并发收集，采用标记-整理算法；
    - 并行 + 并发的收集器，能充分利用CPU、多核环境，可预测停顿时间
    - 不是之前的常见的Eden、Survivor、Tenured模型，而是Eden、Survivor、Old、Humongous

- CMS收集器相比G1收集器
1. 空间整合, 采用标记整理，不会有内存空间碎片。
大对象直接进Humongous，不用直接进老年代，避免Full GC的大量开销；
2. 可预测停顿，降低停顿时间，几乎达到Java实时系统（RTSJ）级垃圾收集器；
3. G1将Java Heap划分为多个大小相等的独立区域（Region），虽保留新生代和老年代概念，但已不是物理隔阂；
他们都是可以不连续的集合。

## GC日志
- Minor GC 日志
    - PSYoungGen：新生代；
    - Minor GC前内存占用 -> Minor GC后内存占用（PSYoungGen总的内存大小）；
    - Minor GC前JVM堆内存使用 -> Minor GC前JVM堆内存使用（JVM堆可用内存大小）；
    - [GC [PSYoungGen: 8192K->1000K(9216K)] 16004K->14604K(29696K), 0.0317424 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
- Full GC 日志
    - PSYoungGen：新生代；ParOldGen：老年代；
    - Full GC前内存占用 -> Full GC后内存占用（*总的内存大小）；
    - Full GC前JVM堆内存使用 -> Full GC前JVM堆内存使用（JVM堆可用内存大小）；
    - Metaspace：元数据区；
    - [Full GC [PSYoungGen: 8192K->8192K(9216K)] [ParOldGen: 20435K->20435K(20480K)] 28627K->28627K(29696K), [Metaspace: 8469K->8469K(1056768K)], 0.1307495 secs] [Times: user=0.50 sys=0.00, real=0.13 secs]

## 常见异常
- StackOverflowError:（栈溢出）
- OutOfMemoryError: Java heap space（堆空间不足）
- OutOfMemoryError: GC overhead limit exceeded  （GC花费的时间超过 98%, 并且GC回收的内存少于 2%）

## GC 参数
```text
堆栈设置
-Xss:每个线程的栈大小
-Xms:初始堆大小，默认物理内存的1/64
-Xmx:最大堆大小，默认物理内存的1/4
-Xmn:新生代大小
-XX:NewSize:设置新生代初始大小
-XX:NewRatio:默认2表示新生代占年老代的1/2，占整个堆内存的1/3。
-XX:SurvivorRatio:默认8表示一个survivor区占用1/8的Eden内存，即1/10的新生代内存。
-XX:MaxMetaspaceSize:设置元空间最大允许大小，默认不受限制，JVM Metaspace会进行动态扩展。
垃圾回收统计信息
-XX:+PrintGC
-XX:+PrintGCDetails
-XX:+PrintGCTimeStamps
-Xloggc:filename
收集器设置
-XX:+UseSerialGC:设置串行收集器
-XX:+UseParallelGC:设置并行收集器
-XX:+UseParallelOldGC:老年代使用并行回收收集器
-XX:+UseParNewGC:在新生代使用并行收集器
-XX:+UseParalledlOldGC:设置并行老年代收集器
-XX:+UseConcMarkSweepGC:设置CMS并发收集器
-XX:+UseG1GC:设置G1收集器
-XX:ParallelGCThreads:设置用于垃圾回收的线程数
并行收集器设置
-XX:ParallelGCThreads:设置并行收集器收集时使用的CPU数。并行收集线程数。
-XX:MaxGCPauseMillis:设置并行收集最大暂停时间
-XX:GCTimeRatio:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)
CMS收集器设置
-XX:+UseConcMarkSweepGC:设置CMS并发收集器
-XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
-XX:ParallelGCThreads:设置并发收集器新生代收集方式为并行收集时，使用的CPU数。并行收集线程数。
-XX:CMSFullGCsBeforeCompaction:设定进行多少次CMS垃圾回收后，进行一次内存压缩
-XX:+CMSClassUnloadingEnabled:允许对类元数据进行回收
-XX:UseCMSInitiatingOccupancyOnly:表示只在到达阀值的时候，才进行CMS回收
-XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况
-XX:ParallelCMSThreads:设定CMS的线程数量
-XX:CMSInitiatingOccupancyFraction:设置CMS收集器在老年代空间被使用多少后触发
-XX:+UseCMSCompactAtFullCollection:设置CMS收集器在完成垃圾收集后是否要进行一次内存碎片的整理
G1收集器设置
-XX:+UseG1GC:使用G1收集器
-XX:ParallelGCThreads:指定GC工作的线程数量
-XX:G1HeapRegionSize:指定分区大小(1MB~32MB，且必须是2的幂)，默认将整堆划分为2048个分区
-XX:GCTimeRatio:吞吐量大小，0-100的整数(默认9)，值为n则系统将花费不超过1/(1+n)的时间用于垃圾收集
-XX:MaxGCPauseMillis:目标暂停时间(默认200ms)
-XX:G1NewSizePercent:新生代内存初始空间(默认整堆5%)
-XX:G1MaxNewSizePercent:新生代内存最大空间
-XX:TargetSurvivorRatio:Survivor填充容量(默认50%)
-XX:MaxTenuringThreshold:最大任期阈值(默认15)
-XX:InitiatingHeapOccupancyPercen:老年代占用空间超过整堆比IHOP阈值(默认45%),超过则执行混合收集
-XX:G1HeapWastePercent:堆废物百分比(默认5%)
-XX:G1MixedGCCountTarget:参数混合周期的最大总次数(默认8) 
```

## 性能分析和监控工具
```text
Jps：虚拟机进程状况工具
Jstat：虚拟机统计信息监视工具
Jinfo：虚拟机配置信息工具
Jmap：内存映像工具
Jhat：虚拟机堆转储快照分析工具
Jstack：堆栈跟踪工具
JConsole：java监视与管理控制台
VisualVM：故障处理工具
```