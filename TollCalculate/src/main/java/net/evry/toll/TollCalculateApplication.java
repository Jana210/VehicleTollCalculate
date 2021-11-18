package net.evry.toll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import net.evry.toll.entities.Holiday;
import net.evry.toll.entities.TollPrice;
import net.evry.toll.repository.HolidayRepo;
import net.evry.toll.repository.TollPriceRepo;

/**
 * Main application class for vehicle toll.
 * 
 * @author Janardhan
 *
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@ComponentScan(basePackages = { "net.evry.toll.*" })
@EnableJpaRepositories(basePackageClasses = { TollPriceRepo.class, HolidayRepo.class })
@EntityScan(basePackageClasses = { TollPrice.class, Holiday.class })
public class TollCalculateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollCalculateApplication.class, args);
	}
}
