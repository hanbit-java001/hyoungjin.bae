package com.hanbit.hyoungjin.bae.web.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hanbit.hyoungjin.bae.core.service.FileService;
import com.hanbit.hyoungjin.bae.core.service.MemberService;
import com.hanbit.hyoungjin.bae.core.vo.FileVO;
import com.hanbit.hyoungjin.bae.core.vo.MemberVO;


@Controller
public class MemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private FileService fileService;

	@RequestMapping("/member/join")
	public String join() {

		return "member/join";
	}

	@RequestMapping(value="/api/member/join", method=RequestMethod.POST)
	@ResponseBody
	public Map doJoin(MultipartHttpServletRequest request) throws Exception {
//		public Map doJoin(@RequestParam("name") String name, @RequestPart("imgProfile") MultipartFile profile){
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fileId = "";

		Iterator<String> paramNames = request.getFileNames();

		if (paramNames.hasNext()) { //파일 여러개말고 한개만 저장할라꼬
			String paramName = paramNames.next();

			MultipartFile file = request.getFile(paramName);

			FileVO fileVO = new FileVO();
			fileVO.setContentType(file.getContentType());
			fileVO.setFileSize(file.getSize());
			fileVO.setFileName(file.getName());
			fileVO.setFileData(file.getBytes());
			// text/plain// application/json// text/html// text/xml	// image/jpg이렇게 파일마다 contentType가지고 있다.
		}

		try {
			MemberVO member = new MemberVO();
			member.setName(name);
			member.setEmail(email);
			member.setPassword(password);
			member.setProfileFileId(fileId);

			memberService.joinMember(member);
		}
		catch (Exception e) {
			if (StringUtils.isNotBlank(fileId)) {
				fileService.removeFile(fileId);		//가입하다 오류나면 파일지운다.
			}

			throw new RuntimeException(e.getMessage(), e);
		}

		Map result = new HashMap();
		result.put("name", name);

		return result;
	}

}
