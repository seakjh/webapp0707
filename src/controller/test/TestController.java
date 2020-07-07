package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/a")
	public void test() {
		System.out.println("컨트롤러 동작 성공");
	}
}
