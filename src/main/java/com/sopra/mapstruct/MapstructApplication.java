package com.sopra.mapstruct;

import com.sopra.mapstruct.dto.ProductsDto;
import com.sopra.mapstruct.dto.RolesDto;
import com.sopra.mapstruct.dto.UsersDto;
import com.sopra.mapstruct.service.IProductsService;
import com.sopra.mapstruct.service.IRolesService;
import com.sopra.mapstruct.service.IUsersService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class MapstructApplication implements CommandLineRunner {


	private IProductsService productsService;
	private IRolesService rolesService;
	private IUsersService usersService;

	public static void main(String[] args) {
		SpringApplication.run(MapstructApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		UsersDto usersDto = new UsersDto();
		usersDto.setId(1);
		usersDto.setFullName("Ngor SECK");

		usersService.save(usersDto);

		ProductsDto productsDto = new ProductsDto();
		productsDto.setRef("2324");
		productsDto.setName("milk");
		productsDto.setIdUser(1);

		productsService.save(productsDto);*/

		List<RolesDto> rolesDtosSave = new ArrayList<>();
		List<RolesDto> rolesDtosUpdate = new ArrayList<>();

		RolesDto rolesDto = new RolesDto();
		rolesDto.setId(1);
		rolesDto.setName("ROLE_USER");
		rolesDto = rolesService.save(rolesDto);
		rolesDtosSave.add(rolesDto);
		rolesDtosUpdate.add(rolesDto);

		rolesDto = new RolesDto();
		rolesDto.setId(2);
		rolesDto.setName("ROLE_ADMIN");
		rolesDto = rolesService.save(rolesDto);
		rolesDtosSave.add(rolesDto);

		rolesDto = new RolesDto();
		rolesDto.setId(3);
		rolesDto.setName("ROLE_TECH");
		rolesDto = rolesService.save(rolesDto);
		rolesDtosSave.add(rolesDto);
		rolesDtosUpdate.add(rolesDto);
		/**
		 * Insert a new user
		 */
		UsersDto usersDto = new UsersDto();
		usersDto.setId(1);
		usersDto.setFullName("Ngor SECK");
		usersDto.setRolesDtos(rolesDtosSave);
		UsersDto usersDto1 = usersService.save(usersDto);
		/**
		 * update users
		 */
		usersDto.setFullName("Khadim SECK");
		usersDto.setRolesDtos(rolesDtosUpdate);
		//usersService.update(usersDto);

		log.info("====================INFO USER==============");
		log.info(usersDto1.getFullName() + usersDto1.getRolesDtos());
		/**
		 * Insert a new products
		 */
		ProductsDto productsDto = new ProductsDto();
		productsDto.setRef("2324");
		productsDto.setName("milk");
		productsDto.setIdUser(1);

		productsService.save(productsDto);

		usersService.findAll().stream()
				.forEach(
						user-> user.getRolesDtos().stream()
								.forEach(role -> System.out.println(role.getName()))
				);
	}
}
