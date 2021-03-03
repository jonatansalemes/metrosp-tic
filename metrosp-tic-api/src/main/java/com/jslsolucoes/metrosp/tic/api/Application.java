package com.jslsolucoes.metrosp.tic.api;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jslsolucoes.metrosp.tic.api.domain.Machine;
import com.jslsolucoes.metrosp.tic.api.domain.MachineInterface;
import com.jslsolucoes.metrosp.tic.api.domain.Software;
import com.jslsolucoes.metrosp.tic.api.domain.SoftwareVersion;
import com.jslsolucoes.metrosp.tic.api.domain.User;
import com.jslsolucoes.metrosp.tic.api.repo.MachineRepo;
import com.jslsolucoes.metrosp.tic.api.repo.SoftwareRepo;
import com.jslsolucoes.metrosp.tic.api.repo.UserRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(SoftwareRepo softwareRepo, MachineRepo machineRepo, UserRepo userRepo) {
		return (args) -> {
			User user = user();
			userRepo.save(user);
			softwareRepo.saveAll(softwares());
			machineRepo.saveAll(machines(user));
		};
	}

	private User user() {
		return new User("jonatan@jslsolucoes.com", "(11) 94970-3490", "Jonatan Lemes");
	}

	private List<Machine> machines(User user) {
		return IntStream.range(0, 9).boxed().map(index -> machine(index, user)).collect(Collectors.toList());
	}

	private Machine machine(Integer index, User user) {
		String uuid = index == 3 ? UUID.fromString("8a18cbcf-ae06-4bf5-8f2b-e575b98fb87f").toString()
				: UUID.randomUUID().toString();
		String hostname = "hostname0" + index;
		Machine machine = new Machine(uuid, hostname, user);
		return machine.setInterfaces(interfacesOf(machine, index));
	}

	private Set<MachineInterface> interfacesOf(Machine machine, Integer index) {
		String addresses = "10.92.0." + index;
		return Set.of(new MachineInterface(machine, addresses));
	}

	private List<Software> softwares() {
		Map<String, List<String>> softwares = Map.of("LibreOffice", List.of("7.1.0", "7.0.4"), "Chrome",
				List.of("88.0.x", "87.0.x"), "Módulo de segurança BB", List.of("18.9.0", "16.0.1"), "Gimp",
				List.of("2.9.3", "2.9.4", "2.9.2"));
		return softwares.entrySet().stream().map(this::software).collect(Collectors.toList());
	}

	private Software software(Entry<String, List<String>> entry) {
		String name = entry.getKey();
		List<String> versions = entry.getValue();
		Software software = new Software(name);
		return software.setVersions(versionsOf(software, versions));
	}

	private Set<SoftwareVersion> versionsOf(Software software, List<String> versions) {
		return versions.stream().map(version -> new SoftwareVersion(software, version)).collect(Collectors.toSet());
	}

}