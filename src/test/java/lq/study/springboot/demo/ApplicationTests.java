package lq.study.springboot.demo;

import lq.study.springboot.demo.bean.UserInfo;
import lq.study.springboot.demo.mqtt.MqttSender;
import lq.study.springboot.demo.rabbit.RabbitSender;
import lq.study.springboot.demo.service.RedisService;
import lq.study.springboot.demo.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试mybatis
	 */
	@Autowired
	private UserInfoService userInfoService;

	@Test
	public void testMybatis(){
		UserInfo userInfo = new UserInfo(null, "lq", UUID.randomUUID().toString());
		userInfoService.addUserInfo(userInfo);
	}

	/**
	 * 测试rabbitMQ
	 */
	@Autowired
	private RabbitSender rabbitSender;

	@Test
	public void testRabbitSender() throws Exception {
		UserInfo userInfo = new UserInfo(1, "liuqiang", UUID.randomUUID().toString());
		rabbitSender.send(userInfo.toString().getBytes(StandardCharsets.UTF_8));
	}


	/**
	 * 测试MQTT
	 */
	@Autowired
	private MqttSender mqttSender;

	@Test
	public void testMqttSender(){
		UserInfo userInfo = new UserInfo(3, "lqlqlq", UUID.randomUUID().toString());
		mqttSender.sendToMqtt(userInfo.toString(),"/topic/F1331901");
	}

	/**
	 * 测试redis
	 */
	@Autowired
	private RedisService redisService;

	@Test
	public void testRedis(){
		redisService.setValue("lq","liuqiang");

		String corePro = redisService.getValue("corePro");
		System.out.println(corePro);
	}

}

