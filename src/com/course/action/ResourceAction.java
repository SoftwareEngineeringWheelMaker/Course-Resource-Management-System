package com.course.action;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.course.domain.Course;
import com.course.domain.Resource;
import com.course.domain.User;
import com.course.service.ResourceService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResourceAction extends ActionSupport {
	private File[] upload;
	private String[] uploadFileName;
	private String newFileName;
	private String[] uploadContentType;
	private String extension;
	private long fileSize;

	private ResourceService resourceService;
	// private Resource resource;
	private Course course;
	private User user;

	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
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

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
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

	public String upload() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String path = ServletActionContext.getServletContext().getRealPath("/Resource/upload");
		System.out.println(path);
		ActionContext act = ActionContext.getContext();
		if (upload != null) {
			File saveDir = new File(path);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			for (int i = 0; i < uploadFileName.length; i++) {
				Date d = new Date();
				extension = uploadFileName[i].substring(uploadFileName[i].lastIndexOf(".") + 1);// 后缀名
				newFileName = sdf.format(d) + "." + extension;// 文件存到服务器的新名称
				fileSize = new FileInputStream(upload[i]).available();// 文件大小
				// resource对象存入上传课程资源信息
				Resource resource = new Resource();
				resource.setRname(uploadFileName[i]);
				resource.setRnewname(newFileName);
				resource.setRfileext(extension);
				resource.setRtime(d);
				resource.setCourse(course);
				resource.setUser(user);
				// 保存上传课程资源信息
				resourceService.saveResource(resource);
				// System.out.println("----------");
				// System.out.println(resource.getRname());
				// System.out.println(resource.getRnewname());
				// System.out.println(resource.getRfileext());
				// System.out.println(resource.getRtime());
				// System.out.println(getUser().getId());
				// System.out.println("----------");

				// 资源文件存到服务器
				File saveFile = new File(saveDir, newFileName);
				try {
					FileUtils.copyFile(upload[i], saveFile);
					System.out.println("copy");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			act.put("message", "课程资源上传成功！");
			return "success";
		}
		act.put("message", "没有上传文件，请返回。");
		return "success";
	}
}
