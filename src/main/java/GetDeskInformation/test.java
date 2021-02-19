package GetDeskInformation;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.DecimalFormat;

/**
 * @ProjectName: try
 * @Package: GetDeskInformation
 * @ClassName: test
 * @Author: zxcdr
 * @Description:获得计算机盘符信息
 * @Date: 2021/1/22 15:43
 * @Version: 1.0
 */
public class test {
    public static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";       if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }       return fileSizeString;
    }   /**
     * 获取硬盘的每个盘符
     */
    public static void driver(){       // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();       // 列出所有windows 磁盘
        File[] fs = File.listRoots();       // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            System.out.println("总大小" + FormetFileSize(fs[i].getTotalSpace()));
            System.out.println("剩余" + FormetFileSize(fs[i].getFreeSpace()));
        }
    }   public static void main(String[] args) {
        driver();
    }
}
