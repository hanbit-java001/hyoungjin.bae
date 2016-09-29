package com.hanbit.hyoungjin.bae.core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanbit.hyoungjin.bae.core.dao.ScheduleDAO;
import com.hanbit.hyoungjin.bae.core.vo.ScheduleVO;

@Service
public class SchedulerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);

	@Autowired
	private ScheduleDAO scheduleDAO;

	public int addSchedule(ScheduleVO schedule) {
		LOGGER.debug("스케쥴추가");
		return scheduleDAO.insertSchedule(schedule);
	}

	public int modifySchedule(ScheduleVO schedule) {
		return scheduleDAO.updateSchedule(schedule);
	}

	public int removeSchedule(String scheduleId) {
		return scheduleDAO.deleteSchedule(scheduleId);
	}

	public List<ScheduleVO> listSchedules(String startDt, String endDt) {
		return scheduleDAO.selectSchedules(startDt, endDt);
	}

	public ScheduleVO getSchedule(String scheduleId) {
		return scheduleDAO.selectSchedule(scheduleId);
	}


	public String generateId(){
		String time = String.valueOf(System.currentTimeMillis());
		String threadId = String.valueOf(Thread.currentThread().getId());//이렇게만하면 자리수가 달라질 수 있다 9->10 갈때
		threadId = StringUtils.leftPad(threadId, 4, "0");
		String uniqueId = time + threadId;

		return uniqueId;
	}

	public int countSchedule(String startDt, String endDt){
		return scheduleDAO.countSchedule(startDt, endDt);
	}
}
