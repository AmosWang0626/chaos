package cn.amos.simple.thread.proxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Proxy {
    /**
     * 1.声明一段代码<br/>
     * 2.编译代码(JDK Compiler API),产生新的类(代理类)<br/>
     * 3.将这个类load到内存中,产生一个新的对象(代理对象)<br/>
     * 4.return 代理对象
     */

    public static Object newProxyInterface(Class myInterface, InvocationHandler h) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        StringBuilder methodStr = new StringBuilder();

        for (Method m : myInterface.getMethods()) {
            methodStr.append(("\n " +
                    "   @Override\n" +
                    "    public void " + m.getName() + "() {\n" +
                    "        try{\n" +
                    "        Method md = " + myInterface.getName() + ".class.getMethod(\"" + m.getName() + "\");\n" +
                    "        h.invoke(this,md);\n" +
                    "        }catch(Exception e){e.printStackTrace();}\n" +
                    "    }\n").trim());
        }

        String str = "package cn.amos.amos.proxy;\n" +
                "\nimport InvocationHandler;" +
                "\nimport java.lang.reflect.Method;" +
                "\n" +
                "public class $Proxy0 implements " + myInterface.getName() + " {\n" +
                "\n" +
                "    private InvocationHandler h;\n" +
                "\n" +
                "    public $Proxy0(InvocationHandler h) {\n" +
                "        this.h = h;\n" +
                "    }\n" +
                methodStr.toString() +
                "}\n";

        String filename = System.getProperty("user.dir") + "/src/com/amos/proxy/$Proxy0.java";

        File file = new File(filename);

        FileUtils.writeStringToFile(file, str, "utf-8");

        // 获得系统的Java编译器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // 创建一个文件的管理者
        StandardJavaFileManager fileManager = compiler
                .getStandardFileManager(null, null, null);

        // 获取文件
        Iterable units = fileManager.getJavaFileObjects(filename);

        // 编译任务
        JavaCompiler.CompilationTask task = compiler
                .getTask(null, fileManager, null, null, null, units);

        // 进行编译
        task.call();

        // 关闭文件管理者
        fileManager.close();

        Class<?> c = ClassLoader.getSystemClassLoader().loadClass("cn.amos.amos.proxy.$Proxy0");

        // System.out.println(c.getName());

        Constructor constructor = c.getConstructor(InvocationHandler.class);

        return constructor.newInstance(h);
    }

}
