package com.jiarwang.www;

import com.sun.deploy.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

public class RefreshUtil {
    public static void main(String[] args) throws IOException {
        String[] module_path = new String[]{
                "1_refresh/src/com/code/",
                "2_refresh/src/com/code/",
                "3_refresh/src/com/code/",
                "4_refresh/src/com/code/",
                "5_refresh/src/com/code/"
        };
        List<List<String>> names = new ArrayList<>();

        for (int i = 0; i < module_path.length; i++) {
            File module = new File("./" + module_path[i]);
            if (module.isDirectory()){
                List<File> list = Arrays.asList(module.listFiles());
                List<String> result = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).getName().startsWith("Q")){
                        String fileName = list.get(j).getName().replaceAll(".java", "");
                        Path path = list.get(j).toPath();

                        BasicFileAttributes fatr = Files.readAttributes(path,
                                BasicFileAttributes.class);
                        SimpleDateFormat formatter = new SimpleDateFormat("MMdd");
                        Date date = new Date();
                        date.setTime(fatr.creationTime().toMillis());
                        result.add(String.format("%s日题目：%s", formatter.format(date), fileName));
                    }
                }
                Collections.sort(result);
                names.add(result);
            }
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(String.format("------------------------------" + (i + 1) + "--------------------------合计: %d 道题目", names.get(i).size())+"-------------------------------------" +
                    "-----------------------------------------------------------");
            String pre = "";
            String pre_str = "";
            for (String s : names.get(i)) {
                if (!pre.equals(s.substring(0, 4))){
                    pre = s.substring(0, 4);
                    pre_str += "|-";
                }
                System.out.println(pre_str + s);
            }
//            System.out.println(sb.toString());
        }
    }
}
