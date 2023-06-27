package beautiful.phoebe.app.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user")
	public boolean addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/test")
	public boolean addUserTest(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping("/users")
	public List<User> getUsers() {
		return userService.getUsers();
	}
}
