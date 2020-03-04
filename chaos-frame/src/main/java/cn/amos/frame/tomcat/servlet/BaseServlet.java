package cn.amos.frame.tomcat.servlet;

import cn.amos.frame.tomcat.utils.TomcatUtils;

/**
 * DESCRIPTION: Servlet
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/4/2020
 */
public abstract class BaseServlet {

    /**
     * Get
     *
     * @param request  request
     * @param response response
     * @throws Exception exception
     */
    public abstract void doGet(MyHttpRequest request, MyHttpResponse response) throws Exception;

    /**
     * Post
     *
     * @param request  request
     * @param response response
     * @throws Exception exception
     */
    public abstract void doPost(MyHttpRequest request, MyHttpResponse response) throws Exception;

    public void service(MyHttpRequest request, MyHttpResponse response) throws Exception {
        if (TomcatUtils.GET.equals(request.getMethod())) {
            doGet(request, response);
        } else if (TomcatUtils.POST.equals(request.getMethod())) {
            doPost(request, response);
        } else {
            System.out.println("ERROR: 请求类型暂不支持");
        }
    }

}
