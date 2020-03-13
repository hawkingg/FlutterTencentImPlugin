package top.huic.tencent_im_plugin.enums;

import com.tencent.imsdk.TIMElem;
import com.tencent.imsdk.TIMElemType;

import top.huic.tencent_im_plugin.message.AbstractMessageNode;
import top.huic.tencent_im_plugin.message.CustomMessageNode;
import top.huic.tencent_im_plugin.message.ImageMessageNode;
import top.huic.tencent_im_plugin.message.SoundMessageNode;
import top.huic.tencent_im_plugin.message.TextMessageNode;
import top.huic.tencent_im_plugin.message.VideoMessageNode;

/**
 * 消息节点类型
 *
 * @author 蒋具宏
 */
public enum MessageNodeType {
    /**
     * 文本消息
     */
    Text(new TextMessageNode()),

    /**
     * 图片
     */
    Image(new ImageMessageNode()),

    /**
     * 语音
     */
    Sound(new SoundMessageNode()),

    /**
     * 视频
     */
    Video(new VideoMessageNode()),

    /**
     * 自定义
     */
    Custom(new CustomMessageNode());

    /**
     * 消息节点接口
     * 通过枚举的方法反向绑定接口，和业务强关联
     */
    private AbstractMessageNode messageNodeInterface;

    MessageNodeType(AbstractMessageNode messageNodeInterface) {
        this.messageNodeInterface = messageNodeInterface;
    }

    public AbstractMessageNode getMessageNodeInterface() {
        return messageNodeInterface;
    }

    /**
     * 根据腾讯云节点获得枚举对象
     *
     * @param elemType 腾讯云节点类型
     * @return 枚举对象
     */
    public static MessageNodeType getTypeByTIMElemType(TIMElemType elemType) {
        // 注: 此处之所以使用 switch，而不使用 valueOf ，是为了防止后期类型更改导致隐藏BUG
        switch (elemType) {
            case Text:
                return MessageNodeType.Text;
            case Image:
                return MessageNodeType.Image;
            case Sound:
                return MessageNodeType.Sound;
            case Custom:
                return MessageNodeType.Custom;
            case Video:
                return MessageNodeType.Video;
            default:
                throw new RuntimeException("The node：`" + elemType + "` is not implemented！");
        }
    }
}