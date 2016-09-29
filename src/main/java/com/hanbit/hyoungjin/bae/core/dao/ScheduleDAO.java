package com.hanbit.hyoungjin.bae.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanbit.hyoungjin.bae.core.service.SchedulerService;
import com.hanbit.hyoungjin.bae.core.vo.ScheduleVO;

@Repository
public class ScheduleDAO extends AbstractDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);

	@Autowired
	private SqlSession sqlSession;

	public int insertSchedule(ScheduleVO schedule) {
		LOGGER.debug("인서트 스케쥴");
		int result = sqlSession.insert("schedule.insertSchedule", schedule);
		return result;
	}

	public int updateSchedule(ScheduleVO schedule) {
		LOGGER.debug("업데이트 스케쥴");
		int result = sqlSession.update("schedule.updateSchedule", schedule);
		return result;
	}

	public int deleteSchedule(String scheduleId) {
		LOGGER.debug("딜리트 스케쥴");
		int result = sqlSession.delete("schedule.deleteSchedule",scheduleId);
		return result;
	}

	public List<ScheduleVO> selectSchedules(String startDt, String endDt) {
		Map params = new HashMap();
		params.put("startDt", startDt);
		params.put("endDt", endDt);

		List<ScheduleVO> result = sqlSession.selectList("schedule.selectSchedules", params);
		return result;
	}

	public ScheduleVO selectSchedule(String scheduleId) {
		ScheduleVO result = sqlSession.selectOne("schedule.selectSchedule", scheduleId);
		return result;
	}

	public int countSchedule(String startDt, String endDt){
		Map params = new HashMap();
		params.put("startDt", startDt);
		params.put("endDt", endDt);

		int result = sqlSession.selectOne("schedule.countSchedule", params);

		return result;
	}

}
