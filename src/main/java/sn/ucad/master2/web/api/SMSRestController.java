package sn.ucad.master2.web.api;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping("/sms")
public class SMSRestController {

	Logger logger = Logger.getLogger(SMSRestController.class);

	@Value("${phoneNumber}")
	private String myTwilioPhoneNumber;

	@Autowired
	public SMSRestController(@Value("${twilioAccountSid}") String twilioAccountSid,
			@Value("${twilioAuthToken}") String twilioAuthToken) {
		Twilio.init(twilioAccountSid, twilioAuthToken);
	}

	public static class MessageSMS {
		
		public String number;
		public String message;
		
		@Override
		public String toString() {
			return "[number=" + number + ", message=" + message + "]";
		}
		
	}

	@PostMapping("/send")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void sendMessages(@RequestBody MessageSMS messageSMS) {

		Message message = Message.creator(new PhoneNumber(messageSMS.number), new PhoneNumber(myTwilioPhoneNumber),
				messageSMS.message).create();

		logger.info("SMS Sent - sid: " + message.getSid() + " " + messageSMS.toString());
	}
}