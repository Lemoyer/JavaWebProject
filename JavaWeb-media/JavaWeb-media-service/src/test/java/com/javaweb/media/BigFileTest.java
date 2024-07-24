package com.javaweb.media;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigFileTest {
    @Test
    public void testChunk() throws IOException {
        File sourceFile = new File("C:\\Users\\liyuh\\Desktop\\homework.mp4");
        String chunkPath = "C:\\Users\\liyuh\\Desktop\\ChunkTest\\";
        File chunkFloder = new File(chunkPath);
        if (chunkFloder.exists()){
            chunkFloder.mkdirs();
        }
        long chunkSize = 1024 * 1024 *5;
        long chunkNum =(long)Math.ceil(sourceFile.length() * 1.0 / chunkSize);
        System.out.println("Chunk number: " + chunkNum);
        //缓冲区大小
        byte[] b = new byte[1024];
        //使用RandomAccessFile访问文件
        RandomAccessFile raf_read = new RandomAccessFile(sourceFile, "r");
        //分块
        for (int i = 0; i < chunkNum; i++) {
            //创建分块
            File file = new File(chunkPath+i);
            if (file.exists()){
                file.delete();
            }
            boolean newFile = file.createNewFile();
            if (newFile){
                RandomAccessFile raf_write = new RandomAccessFile(file, "rw");
                int len = -1;
                while ((len = raf_read.read(b)) != -1){
                    raf_write.write(b, 0, len);
                    if (file.length() > chunkSize){
                        break;
                    }
                }
                raf_write.close();
                System.out.println("完成分块"+i);

            }

        }
        raf_read.close();
    }
    @Test
    public void testMerge() throws IOException{
        //块文件目录
        File chunkFolder = new File("C:\\Users\\liyuh\\Desktop\\ChunkTest\\");
        File originalFile = new File("C:\\Users\\liyuh\\Desktop\\homework.mp4");
        File mergeFile = new File("C:\\Users\\liyuh\\Desktop\\homework_copy.mp4");
        if (mergeFile.exists()) {
            mergeFile.delete();
        }
        //创建新的合并文件
        mergeFile.createNewFile();
        //用于写文件
        RandomAccessFile raf_write = new RandomAccessFile(mergeFile, "rw");
        //指针指向文件顶端
        raf_write.seek(0);
        //缓冲区
        byte[] b = new byte[1024];
        //分块列表
        File[] fileArray  = chunkFolder.listFiles();
        List<File> fileList = Arrays.asList(fileArray);
        Collections.sort(fileList,new Comparator<File>(){

            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName());
            }
        });
        //合并文件
        for (File chunkFile : fileList) {
            RandomAccessFile raf_read = new RandomAccessFile(chunkFile, "rw");
            int len = -1;
            while ((len = raf_read.read(b)) != -1) {
                raf_write.write(b, 0, len);

            }
            raf_read.close();
        }
        raf_write.close();

        try(
                FileInputStream fileInputStream = new FileInputStream(originalFile);
                FileInputStream mergeFileStream = new FileInputStream(mergeFile);
                ){
            //取出原始文件的md5
            String originalMd5 = DigestUtils.md5DigestAsHex(fileInputStream);
            String mergeMd5 = DigestUtils.md5DigestAsHex(mergeFileStream);
            if (originalMd5.equals(mergeMd5)){
                System.out.println("合并文件成功");
            } else {
                System.out.println("合并文件失败");
            }

        }

    }
}
