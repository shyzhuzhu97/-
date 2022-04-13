package com.edward.edu.utils;

import com.edward.edu.constant.EduConstant;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UploadUtils {
    //得到当前日期的String
    public static String getDateFolder() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateFolderName = format.format(date);//得到文件夹名称
        return dateFolderName;
    }
    public static String getCourseImgFolder() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateFolderName ="courseImg"+format.format(date);//得到文件夹名称
        return dateFolderName;
    }
    public static String getVideoFolder() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateFolderName ="video"+format.format(date);//得到文件夹名称
        return dateFolderName;
    }


    public static File getDateFolderRoot() { //类不自动加public 要手动加
        File folderPath = new File(EduConstant.IMGPATH); //根据图片服务器路径创建file对象
        String dateFolder = UploadUtils.getDateFolder();
        return new File(folderPath, dateFolder); //传入图片服务器路径、文件夹名称创建file对象
    }
    public static File getCourseImgFolderRoot() { //类不自动加public 要手动加
        File folderPath = new File(EduConstant.IMGPATH); //根据图片服务器路径创建file对象
        String dateFolder = UploadUtils.getCourseImgFolder();
        return new File(folderPath, dateFolder); //传入图片服务器路径、文件夹名称创建file对象
    }
    public static File getVideoFolderRoot() {
        File folderPath = new File(EduConstant.IMGPATH); //根据图片服务器路径创建file对象
        String dateFolder = UploadUtils.getVideoFolder();
        return new File(folderPath, dateFolder); //传入图片服务器路径、文件夹名称创建file对象
    }

    public static String getImgName(String originName) {
        String halfName = originName.substring(originName.lastIndexOf("."));//得到后缀名
        String name = UUID.randomUUID().toString();//生成随机名字
        return name + halfName;
    }



}
