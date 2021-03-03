package com.jslsolucoes.metrosp.tic.api.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jslsolucoes.metrosp.tic.api.domain.Software;
import com.jslsolucoes.metrosp.tic.api.domain.SoftwareVersion;
import com.jslsolucoes.metrosp.tic.api.service.SoftwareService;

@RestController
@RequestMapping("api/v1/softwares")
public class SoftwareController {

	private final SoftwareService softwareService;

	@Autowired
	public SoftwareController(final SoftwareService softwareService) {
		this.softwareService = softwareService;
	}

	@GetMapping
	public List<SoftwareView> all() {
		return softwareService.all().stream().map(Software::versions).flatMap(Set::stream)
				.sorted(Comparator.comparing(SoftwareVersion::name).reversed())
				.map(SoftwareView::new)
				.collect(Collectors.toList());
	}
}
