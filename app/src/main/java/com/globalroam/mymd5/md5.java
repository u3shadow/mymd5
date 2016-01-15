package com.globalroam.mymd5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
    public class md5 {

        public static String encrption(String plainText) {

            String result = null;
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(plainText.getBytes());
                byte b[] = md.digest();
                int i;
                StringBuffer buf = new StringBuffer("");
                for (int offset = 0; offset < b.length; offset++) {
                    i = b[offset];
                    if (i < 0) {
                        i += 256;
                    }
                    if (i < 16) {
                        buf.append("0");
                    }
                    buf.append(Integer.toHexString(i));
                    result = buf.toString();
                }
                return buf.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return result;
        }

        public final static String strMD5(String _str) {
            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            try {
                byte[] strTemp = _str.getBytes();
                MessageDigest mdTemp = MessageDigest.getInstance("MD5");
                mdTemp.update(strTemp);
                byte[] md = mdTemp.digest();
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigits[byte0 & 0xf];
                }

                return new String(str);
            } catch (Exception e) {
                return null;
            }
    }
}
