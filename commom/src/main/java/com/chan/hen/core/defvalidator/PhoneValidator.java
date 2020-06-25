package com.chan.hen.core.defvalidator;

import java.lang.invoke.MethodHandles;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.chan.hen.util.HenUtil;

/**
 * Check that the character sequence is phone number.
 *
 * @author chanyu
 */
public class PhoneValidator implements ConstraintValidator<Phone, CharSequence> {

	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext constraintValidatorContext) {
		if ( value == null ) {
			return false;
		}
		return HenUtil.isPhoneLegal(value.toString());
	}
}
