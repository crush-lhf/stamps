package com.bysj.stamps.sys.shirocore;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by lihf
 * on 2017.12.19 location 邮政.
 */
public class ShiroUtis {

    private static  final String SALT="crush";
    private static final int HASHITERATIONS=3;
    public static void main(String[] args) {
        //所需加密的参数  即  密码
        String source = "123456";
        //[盐] 一般为用户名 或 随机数
        String salt = "Shiro";
        //加密次数
        int hashIterations = 3;

        //调用 org.apache.shiro.crypto.hash.Md5Hash.Md5Hash(Object source, Object salt, int hashIterations)构造方法实现MD5盐值加密
        Md5Hash mh = new Md5Hash(source, salt, hashIterations);
        //打印最终结果
        System.out.println(mh.toString());


        /*调用org.apache.shiro.crypto.hash.SimpleHash.SimpleHash(String algorithmName, Object source, Object salt, int hashIterations)
         * 构造方法实现盐值加密  String algorithmName 为加密算法 支持md5 base64 等*/
        SimpleHash sh = new SimpleHash("md5", source, salt, hashIterations);
        //打印最终结果
        System.out.println(sh.toString());
    }

    public static  String getSaltPwd(String password){
        return new SimpleHash("md5", password, SALT, HASHITERATIONS).toString();

    }
}
