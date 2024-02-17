package com.mrizkisaputra;

import com.mrizkisaputra.model.entity.ApplicationRole;
import com.mrizkisaputra.model.entity.Role;
import com.mrizkisaputra.model.entity.User;
import com.mrizkisaputra.repositories.RoleRepository;
import com.mrizkisaputra.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@PropertySources({
		@PropertySource("classpath:/database.properties")
})
@SpringBootApplication
public class PelaporanParkirLiarApplication {

	public static void main(String[] args) {
		SpringApplication.run(PelaporanParkirLiarApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(
//			UserRepository userRepository,
//			RoleRepository roleRepository,
//			PasswordEncoder passwordEncoder
//	) {
//		return args -> {
//			Role roleUser = roleRepository.save(new Role(ApplicationRole.USER_PELAPOR));
//			Role rolePengawas = roleRepository.save(new Role(ApplicationRole.USER_PENGAWAS));
//
//			User user = new User("user", passwordEncoder.encode("user"), Set.of(roleUser));
//			User pengawas = new User("pengawas", passwordEncoder.encode("pengawas"), Set.of(rolePengawas));
//			userRepository.save(user);
//			userRepository.save(pengawas);
//		};
//	}

}
