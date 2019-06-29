package com.cskaoyan.membertest;


import org.junit.Test;

import java.io.File;

public class TestBySong2 {
    @Test
    public void fileTest(){
        File directory = new File("E://fileupload2");
        if (!directory.exists()){
            directory.mkdir();
        }

/*        //abc.txt
        //e:fileload/abc.txt
        String append = UUID.randomUUID().toString();
        String name = file.getOriginalFilename();
        append += name;
        File myfile = new File(directory, append);*/
    }
}
