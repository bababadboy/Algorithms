package com.gakki.basic.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * @author wangxb XD
 * @date 2019-09-22
 */
public class FileUtils {

    private static FileUtils instance = null;

    public static synchronized FileUtils getInstance() {
        if (instance == null){
            return new FileUtils();
        }
        return instance;
    }

    private FileUtils(){}

    private static String COPY_SUFFIX  = "-copy";
    private static String DOT  = ".";

    /**
     * 5530ms
     * 文件复制，默认在source目录下生成复制文件
     * @param source 源文件
     */
    public void copy(String source) throws IOException {
        int dotFirstPos = source.indexOf(DOT);

        String copyName;
        if (dotFirstPos == -1){
            copyName = source + COPY_SUFFIX;
        }else {
            String pref = source.substring(0,dotFirstPos);
            String suf = source.substring(dotFirstPos+1);
            copyName = pref + COPY_SUFFIX + DOT +suf;
        }
        copy(source,copyName);
    }

    /**
     * bio
     * 文件复制，默认复制到source相同目录下
     */
    public void copy(String source,String target) throws IOException {
        if (source ==null || target == null){
            throw new IllegalArgumentException();
        }

        File sourceFile = new File(source);
        File targetFile = new File(target);

        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(targetFile)){  // 此语法会帮你自动关闭流
            int chunk = 1024;
            byte[] data = new byte[chunk];   // 一次读取1024byte = 1 kb
            while (in.read(data,0,chunk) != -1){
                out.write(data);
            }
        }catch (IOException e) {
            throw e;
        }
    }


    /**
     * use Files工具类
     * 4285ms
     */
    public void fastcopy(String source,String target) throws IOException {
        if (source ==null || target == null){
            throw new IllegalArgumentException();
        }

        File sourceFile = new File(source);
        File targetFile = new File(target);

        Files.write(targetFile.toPath(),Files.readAllBytes(sourceFile.toPath()));
    }

    /**
     * nio
     * filechannel读取文件 4531ms
     */
    public void FileChannelCopy(String src,String tar) throws IOException{
        try(    // 自动关闭
        RandomAccessFile readFile = new RandomAccessFile(src,"rw");
        RandomAccessFile tarFile = new RandomAccessFile(tar,"rw");

        FileChannel readChannel = readFile.getChannel();
        FileChannel writeChannel = tarFile.getChannel();
        ) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = readChannel.read(byteBuffer);
            while (read != -1) {
                // 需要把position置位0(writeChannel从position开始写)
                byteBuffer.flip();

                writeChannel.write(byteBuffer);
                byteBuffer.clear();
                read = readChannel.read(byteBuffer);
            }
        }

    }

    /**
     * 大文件推荐 4287ms
     * 利用内存映射
     */
    public void memeoryCopy(String source,String target) throws IOException {
        try(
        RandomAccessFile readFile = new RandomAccessFile(source,"r");
        RandomAccessFile tarFile = new RandomAccessFile(target,"rw");

        FileChannel readChannel = readFile.getChannel();
        FileChannel writeChannel = tarFile.getChannel();
        ){
            ByteBuffer byteBuffer = readChannel.map(FileChannel.MapMode.READ_ONLY,0,readChannel.size());
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

    }

    public String generateFile() throws IOException {
        File file = new File("/Users/not-bad/Desktop","big_file_5g");

        byte[] data = new byte[]{'T','h','i','s',' ','i','s',' ','a',' ','b','i','g',' ','f','i','l','e','.','\n'};
        for (int i = 0; i < 250 * 1024 * 1024; i++) {
            Files.newOutputStream(file.toPath(),StandardOpenOption.APPEND);
        }
        return file.toString();
    }
}
