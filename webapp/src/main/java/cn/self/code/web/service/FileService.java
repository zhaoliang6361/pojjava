package cn.self.code.web.service;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by zhaoliang on 2018/11/8.
 */
public class FileService {

    public static void main(String[] args){
        File file = new File("E:\\数据加工\\专利价制度\\result");
        File[] dirs = file.listFiles();
        int count = 0;
        for(File dir :dirs){
            if(dir.isDirectory()){
                File [] files = dir.listFiles();
                for(File f : files){
                    try {
                        List<String> list = Files.readLines(f, StandardCharsets.UTF_8);
                        for(String str : list){
                            if(StringUtils.isNotBlank(str)){
                                count++;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            int insertions = 100000;
            BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),insertions);
        }
        System.out.println(count);
    }
}
