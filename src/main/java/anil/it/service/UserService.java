package anil.it.service;

import java.util.*;

import anil.it.entity.City;
import anil.it.entity.State;
import anil.it.repository.CityRepo;
import anil.it.repository.StateRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import anil.it.binding.LoginForm;
import anil.it.binding.RegistrationForm;
import anil.it.binding.UpdatePasswordForm;
import anil.it.entity.Country;
import anil.it.entity.User;
import anil.it.repository.CountryRepo;
import anil.it.repository.UserRepo;
import anil.it.utils.EmailUtils;


@Service
public class UserService {
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmailUtils emailUtils;

	
	public User loginCheck(LoginForm loginForm) {
		
		return userRepo.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
		
	}
	
	
	public boolean registerUser(RegistrationForm registrationForm) {
		
		String dummyPassword = generatePwd(10);
		registrationForm.setPassword(dummyPassword);
		registrationForm.setPasswordUpdated("No");
		User user = new User();
		BeanUtils.copyProperties(registrationForm, user);
		User savedUser = userRepo.save(user);
		
		String body = "Hi Mr. " + registrationForm.getName() + " this is your temporary password :" + registrationForm.getPassword();
		
		if(savedUser.getUserId() != null) {
			boolean sent = emailUtils.sendEmail(fromMail, registrationForm.getEmail(), body);
			if(sent) {
				return true;
			}
		}
		return false;
		
	}
	
	private String generatePwd(Integer len) {
	    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random rnd = new Random();

	    StringBuilder sb = new StringBuilder(len);
	    for (int i = 0; i < len; i++) {
	        sb.append(AB.charAt(rnd.nextInt(AB.length())));
	    }
	    return sb.toString();
	}
	
	public boolean updatePassword(UpdatePasswordForm updatePasswordForm) {
		
		Optional<User> user = userRepo.findById(updatePasswordForm.getUserId());
		if(user.isPresent()) {
			User userFromDb = user.get();
			userFromDb.setPassword(updatePasswordForm.getNewPassword());
			userFromDb.setPasswordUpdated("Yes");
			userRepo.save(userFromDb);
			return true;
		}
		return false;	
	}

	public Map<Integer, String > getCountries(){
		List<Country> countries = countryRepo.findAll();
		Map<Integer, String> countryMap = new HashMap<>();
		countries.stream().forEach(country -> {
			countryMap.put(country.getCid(), country.getCountryName());
		});
		return countryMap;
	}

	public Map<Integer, String> getStates(Integer countryId){
		List<State> states = stateRepo.findByCid(countryId);
		Map<Integer, String> statesMap = new HashMap<>();
		states.stream().forEach(state -> {
			statesMap.put(state.getSid(), state.getStateName());
		});
		return statesMap;
	}

	public Map<Integer, String> getCities(Integer stateId){
		List<City> cities = cityRepo.findBySid(stateId);
		Map<Integer, String> cityMap = new HashMap<>();
		cities.stream().forEach(city -> {
			cityMap.put(city.getCityId(), city.getCityName());
		});
		return cityMap;
	}

}
