import ImSDK

//
//  MessageEntity.swift
//  tencent_im_plugin
//
//  Created by 蒋具宏 on 2020/2/10.
//
public class MessageEntity : NSObject{
    /**
     * 消息ID
     */
    var id : String?;
    
    /**
     * 唯一ID
     */
    var uniqueId : UInt64?;
    
    /**
     * 对方是否已读
     */
    var peerReaded : Bool?;
    
    /**
     * 自己是否已读
     */
    var read : Bool?;
    
    /**
     * 当前登录用户是否是发送方
     */
    var `self` : Bool?;
    
    /**
     * 自定义整数
     */
    var customInt : Int32?;
    
    /**
     * 自定义值
     */
    var customStr : String?;
    
    /**
     * 消息时间戳
     */
    var timestamp : Date?;
    
    /**
     * 消息发送方
     */
    var sender : String?;
    
    /**
     * 会话ID
     */
    var sessionId : String?
    
    /**
     * 发送人->用户信息
     */
    private var userInfo : TIMUserProfile?;
    
    /**
     * 发送人->群成员信息
     */
    private var groupMemberInfo : TIMGroupMemberInfo?;
    
    /**
     * 节点内容
     */
    private var elemList : [TIMElem]?;
    
    /**
     * 消息状态
     */
    private var status : TIMMessageStatus?;
    
    /**
     * 会话实体
     */
    private var sessionEntity : SessionEntity?;
    
    override init() {
    }
    
    init(message : TIMMessage) {
        super.init();
        self.id = message.msgId();
        self.uniqueId = message.uniqueId();
        self.peerReaded = message.isPeerReaded();
        self.read = message.isReaded();
        self.`self` = message.isSelf();
        self.customInt = message.customInt();
        self.customStr = String(data: message.customData()!, encoding: String.Encoding.utf8);
        self.timestamp = message.timestamp();
        self.elemList = TencentImUtils.getArrrElement(message: message);
        self.groupMemberInfo = message.getSenderGroupMemberProfile();
        self.sender = message.sender();
        self.sessionId = message.getConversation().getReceiver();
        self.status = message.status();
    }
}