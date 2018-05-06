package com.albenyuan.common.util;

import com.albenyuan.common.util.CloseableUtil;

import java.io.*;

/**
 * @Author Alben Yuan
 * @Date 2018-01-26 17:24
 */

public final class SerializationUtil {

    private SerializationUtil() {
    }

    /**
     * Serialize the given object to a byte array.
     *
     * @param object the object to serialize
     * @return an array of bytes representing the object in a portable fashion
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        byte[] bytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException ex) {
            throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(), ex);
        } finally {
            CloseableUtil.close(objectOutputStream, byteArrayOutputStream);
        }
        return bytes;
    }


    /**
     * Deserialize the byte array into an object.
     *
     * @param bytes a serialized object
     * @return the result of deserializing the bytes
     */
    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        Object object;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (IOException ex) {
            throw new IllegalArgumentException("Failed to deserialize object", ex);
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException("Failed to deserialize object type", ex);
        } finally {
            CloseableUtil.close(objectInputStream, byteArrayInputStream);
        }
        return object;
    }

}

