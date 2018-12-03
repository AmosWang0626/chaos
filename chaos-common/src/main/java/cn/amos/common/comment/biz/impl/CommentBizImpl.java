package cn.amos.common.comment.biz.impl;

import cn.amos.common.comment.biz.CommentBiz;
import cn.amos.common.comment.bo.CommentBO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/12/3
 */
@Component("commentBiz")
public class CommentBizImpl implements CommentBiz {

    private static final String BLOG_ID = "BLOG-18333338888";

    public static void main(String[] args) {
        // 后期将 userId 换成 Long 数据
        List<CommentBO> commentBOList = new ArrayList<>();
        commentBOList.add(new CommentBO(BLOG_ID, "YANG", null, "咋回事，四年奇遇"));
        commentBOList.add(new CommentBO(BLOG_ID, "WANG", null, "啥情况"));
        commentBOList.add(new CommentBO(BLOG_ID, "SONG", "YANG", "回来转一圈呗?"));
        commentBOList.add(new CommentBO(BLOG_ID, "SONG", "WANG", "雾霾来袭"));
        commentBOList.add(new CommentBO(BLOG_ID, "DY", null, "妈耶阔怕"));
        commentBOList.add(new CommentBO(BLOG_ID, "SONG", "WANG", "嗯哼"));
        commentBOList.add(new CommentBO(BLOG_ID, "TAO", null, "今年甚是严重呀"));
        commentBOList.add(new CommentBO(BLOG_ID, "SONG", "TAO", "是呀，南方应该好吧"));

        commentBOList.forEach(commentBO -> {
            if (StringUtils.isNoneBlank(commentBO.getReplyUserId())) {
                System.out.println(commentBO.getUserId() + " 回复 " + commentBO.getReplyUserId() + "：" + commentBO.getContent());
            } else {
                System.out.println(commentBO.getUserId() + "：" + commentBO.getContent());
            }
        });
    }
}
