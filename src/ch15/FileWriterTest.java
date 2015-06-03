package ch15;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by YouZeng on 2015-06-03.
 */
public class FileWriterTest {

    public static void main(String[] args) throws IOException {
        try(FileWriter writer = new FileWriter("newFile.txt")){
            writer.write("锦瑟-李商隐\r\n");
            writer.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
            writer.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
            writer.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
            writer.write("此情可待成追忆，只是当时已惘然。\r\n");
        }
    }
}
