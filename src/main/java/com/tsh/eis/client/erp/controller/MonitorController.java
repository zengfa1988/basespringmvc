package com.tsh.eis.client.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 运维监控
 * @author zengfa
 *
 */
@Controller
@RequestMapping("/monitor")
public class MonitorController {

	@RequestMapping(value = "/monitor.do")
	@ResponseBody
	public Integer monitor() {
		return 200;
	}

}
