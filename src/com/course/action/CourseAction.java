package com.course.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.course.domain.Course;
import com.course.domain.User;
import com.course.service.CourseService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
	private File upload;
	private String uploadFileName;
	private String newFileName;
	private String uploadContentType;
	private String extension;
	private long fileSize;
	
	private CourseService courseService;
	private Course course;
	private User user;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getNewFileName() {
		return newFileName;
	}
	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String add() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String path = ServletActionContext.getServletContext().getRealPath("/Course/pic");
		System.out.println(path);
		ActionContext act = ActionContext.getContext();
		if(upload != null){
			File saveDir = new File(path);
			if(!saveDir.exists()){
				saveDir.mkdirs();
			}
			Date d = new Date();
			extension = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);// 后缀名
			newFileName = sdf.format(d) + "." + extension;// 文件存到服务器的新名称
			fileSize = new FileInputStream(upload).available();// 文件大小
		}
		course.setUser(user);
		if(upload != null)
			course.setCpic(newFileName);
		else
			course.setCpic(null);
		courseService.saveCourse(course);
		
		act.put("message", "课程添加成功！");
		return "success";
		
	}
}
