package co.za.tangent.util;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class LocalDateImpl implements LocalDateTI{

	@Override
	public LocalDate now() {
		return LocalDate.now();
	}

}
