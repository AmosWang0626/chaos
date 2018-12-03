package cn.amos.common.comment.bo;

import lombok.Data;

import java.util.Date;

/**
 * PROJECT: chaos
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2018/12/3
 */
@Data
public class CommentBO {

    /**
     * 自增id
     */
    private Long id;
    /**
     * 博客id
     */
    private String blogId;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 回复用户id
     */
    private String replyUserId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date createTime;

    public CommentBO() {
    }

    public CommentBO(String blogId, String userId, String replyUserId, String content) {
        this.blogId = blogId;
        this.userId = userId;
        this.content = content;
        this.replyUserId = replyUserId;
        this.createTime = new Date();
    }
}
