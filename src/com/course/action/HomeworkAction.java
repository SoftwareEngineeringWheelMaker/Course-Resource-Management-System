package com.course.action;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Hidden;

import com.course.domain.HandIn;
import com.course.domain.Homework;
import com.course.domain.User;
import com.course.service.HandInService;
import com.course.service.HomeworkService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HomeworkAction extends ActionSupport {
	private File upload;
	private String uploadFileName;
	private String newFileName;
	private String uploadContentType;
	private String extension;
	private long fileSize;

	private HomeworkService homeworkService;
	private Homework homework;
	private HandInService handInService;
	private HandIn handIn;
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

	public HomeworkService getHomeworkService() {
		return homeworkService;
	}

	public void setHomeworkService(HomeworkService homeworkService) {
		this.homeworkService = homeworkService;
	}

	public Homework getHomework() {
		return homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public HandInService getHandInService() {
		return handInService;
	}

	public void setHandInService(HandInService handInService) {
		this.handInService = handInService;
	}

	public HandIn getHandIn() {
		return handIn;
	}

	public void setHandIn(HandIn handIn) {
		this.handIn = handIn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String add() throws Exception {
		homework.setUser(user);
		homeworkService.saveHomework(homework);
		String message = "作业布置成功！";
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("message", message);
		return "success";
	}

	public String handin() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String path = ServletActionContext.getServletContext().getRealPath("/Homework/upload");
		System.out.println(path);
		ActionContext act = ActionContext.getContext();
		if(upload != null){
			File saveDir = new File(path);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			Date d = new Date();
			extension = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);// 后缀名
			newFileName = sdf.format(d) + "." + extension;// 文件存到服务器的新名称
			fileSize = new FileInputStream(upload).available();// 文件大小
			
			homework = homeworkService.getHomework(homework);
			//若作业提交时间在期限内
			if(d.before(homework.getHdeadline())){
				handIn = new HandIn();
				handIn.setHiname(uploadFileName);
				handIn.setHinewname(newFileName);
				handIn.setHifileext(extension);
				handIn.setHitime(d);
				handIn.setHomework(homework);
				handIn.setUser(user);
				handInService.saveHandIn(handIn);
				// 资源文件存到服务器
				File saveFile = new File(saveDir, newFileName);
				try {
					FileUtils.copyFile(upload, saveFile);
					System.out.println("copy");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				act.put("message", "作业提交成功！");
				return "success";
			}
			else{
				act.put("message", "作业已过期！");
				return "success";
			}
		}
		act.put("message", "没有上传作业，请返回。");
		return "success";
	}
}
