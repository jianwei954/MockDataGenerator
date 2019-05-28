package com.jw.mockdata.generator.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class AESOperator
{
    private String KEY = "!AA2Z@glabO*(-8L";
    private String VECTOR = "!WFPPFU_{H%M(S|a";
    private Cipher cipher = null;

    public AESOperator()
        throws Exception
    {
        this.cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }

    public boolean encryptInit()
        throws Exception
    {
        return encryptInit(this.KEY, this.VECTOR);
    }

    public boolean encryptInit(String key)
        throws Exception
    {
        return encryptInit(key, this.VECTOR);
    }

    public boolean encryptInit(String key, String vector)
        throws Exception
    {
        if (key == null) {
            return false;
        }
        if (key.length() != 16) {
            return false;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
        this.cipher.init(1, skeySpec, iv);
        return true;
    }

    public boolean decryptInit()
        throws Exception
    {
        return decryptInit(this.KEY, this.VECTOR);
    }

    public boolean decryptInit(String key)
        throws Exception
    {
        return decryptInit(key, this.VECTOR);
    }

    public boolean decryptInit(String key, String vector)
        throws Exception
    {
        if (key == null) {
            return false;
        }
        if (key.length() != 16) {
            return false;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
        this.cipher.init(2, skeySpec, iv);
        return true;
    }

    public String encrypt(String content)
        throws Exception
    {
        byte[] encrypted = this.cipher.doFinal(content.getBytes("UTF-8"));
        return DatatypeConverter.printBase64Binary(encrypted);
    }

    public String decrypt(String content)
        throws Exception
    {
        byte[] encrypted1 = DatatypeConverter.parseBase64Binary(content);
        byte[] original = this.cipher.doFinal(encrypted1);
        String originalString = new String(original, "UTF-8");
        return originalString;
    }

    public static void main(String[] args)
        throws Exception
    {
        AESOperator aESOperator = new AESOperator();
        aESOperator.encryptInit();
        String entrystr = aESOperator.encrypt("863318033494339");
        System.out.println(entrystr);
        aESOperator.decryptInit();
        System.out.println(aESOperator.decrypt("yAKG6UowdjA/d195oDurrw=="));
    }
}
