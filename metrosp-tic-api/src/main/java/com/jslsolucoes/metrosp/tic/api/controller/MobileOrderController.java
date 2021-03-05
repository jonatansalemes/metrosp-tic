package com.jslsolucoes.metrosp.tic.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jslsolucoes.metrosp.tic.api.domain.MobileOrder;
import com.jslsolucoes.metrosp.tic.api.service.MobileOrderService;

@RestController
@RequestMapping("api/v1/mobile/orders")
public class MobileOrderController {

	private final MobileOrderService mobileOrderService;

	@Autowired
	public MobileOrderController(final MobileOrderService mobileOrderService) {
		this.mobileOrderService = mobileOrderService;
	}

	@GetMapping
	public List<MobileOrderView> all() {
		return mobileOrderService.all().stream().map(MobileOrderView::new).collect(Collectors.toList());
	}

	@PostMapping
	@Transactional(timeout = 30000)
	public ResponseEntity<MobileOrderView> createNewAppointment(
			@RequestBody @Valid MobileOrderCreateRequest mobileOrderCreateRequest) {
		MobileOrder ticket = mobileOrderService.createNewOne(mobileOrderCreateRequest.reason(),
				mobileOrderCreateRequest.idDepartment());
		return Responses.created(new MobileOrderView(ticket), "/{id}", ticket.id());
	}

	static class MobileOrderCreateRequest {

		@NotNull
		private final String reason;

		@NotNull
		private final Long idDepartment;

		@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
		public MobileOrderCreateRequest(@JsonProperty("reason") final String reason,
				@JsonProperty("idDepartment") final Long idDepartment) {
			this.reason = reason;
			this.idDepartment = idDepartment;
		}

		public String reason() {
			return reason;
		}

		public Long idDepartment() {
			return idDepartment;
		}

	}

}
